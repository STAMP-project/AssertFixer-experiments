package brave.test.util;

import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import static org.assertj.core.api.Assertions.assertThat;

public final class ClassLoaders {

  /** Runs the type in a new classloader that recreates brave classes */
  public static void assertRunIsUnloadable(ClassLoader parent, Class<? extends Runnable> runnable) {
    WeakReference<ClassLoader> loader;
    try {
      loader = invokeRunFromNewClassLoader(parent, runnable);
    } catch (Exception e) {
      throw new AssertionError(e);
    }

    blockOnGC();

    assertThat(loader.get())
        .withFailMessage(runnable + " includes state that couldn't be garbage collected")
        .isNull();
  }

  static void blockOnGC() {
    System.gc();
    try {
      Thread.sleep(200L);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new AssertionError(e);
    }
  }

  static WeakReference<ClassLoader> invokeRunFromNewClassLoader(ClassLoader parent,
      Class<? extends Runnable> runnable) throws Exception {

    // Catch bugs by checking to ensure this is setup correctly
    assertThat(runnable)
        .withFailMessage(runnable + " should be a static member class")
        .satisfies(c -> {
          assertThat(c.isLocalClass()).isFalse();
          assertThat(Modifier.isPublic(c.getModifiers())).isFalse();
        });

    ClassLoader loader = ClassLoaders.reloadClassNamePrefix(parent, "brave");

    Class<?> classToTest = loader.loadClass(runnable.getName());
    // ensure the classes are indeed different
    assertThat(classToTest).isNotSameAs(runnable);

    Constructor<?> ctor = classToTest.getDeclaredConstructor();
    ctor.setAccessible(true);

    Method run = Runnable.class.getMethod("run");
    run.setAccessible(true);

    run.invoke(ctor.newInstance());

    return new WeakReference<>(loader);
  }

  /**
   * Creates a new classloader that reloads types matching the given prefix. This is used to test
   * behavior such a leaked type in a thread local.
   *
   * <p>This works by using a bridge loader over the normal system one. The bridge loader always
   * loads new classes when they are prefixed by brave types.
   *
   * <p>This approach is the same as what's used in Android's {@code tests.util.ClassLoaderBuilder}
   * See https://android.googlesource.com/platform/libcore/+/master/support/src/test/java/tests/util/ClassLoaderBuilder.java
   */
  static ClassLoader reloadClassNamePrefix(ClassLoader parent, String prefix) {
    ClassLoader bridge = new ClassLoader(parent) {
      @Override
      protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        if (name.startsWith(prefix)) throw new ClassNotFoundException("reloading type: " + name);
        return super.loadClass(name, resolve);
      }
    };
    try {
      return new URLClassLoader(classpathToUrls(), bridge);
    } catch (MalformedURLException e) {
      throw new IllegalStateException("Couldn't read the current system classpath", e);
    }
  }

  static URL[] classpathToUrls() throws MalformedURLException {
    String[] classpath = System.getProperty("java.class.path").split(File.pathSeparator, -1);
    URL[] result = new URL[classpath.length];
    for (int i = 0; i < classpath.length; i++) {
      result[i] = new File(classpath[i]).toURI().toURL();
    }
    return result;
  }
}
