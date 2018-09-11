package brave.test.util;

import java.lang.ref.WeakReference;
import org.junit.Test;

import static brave.test.util.ClassLoaders.assertRunIsUnloadable;
import static org.assertj.core.api.Assertions.assertThat;

public class ClassLoadersTest {
  static class Foo {
  }

  @Test public void createdNonDelegating_cantSeeCurrentClasspath() throws Exception {
    Foo foo = new Foo(); // load the class

    ClassLoader loader =
        ClassLoaders.reloadClassNamePrefix(getClass().getClassLoader(), getClass().getName());
    assertThat(loader.loadClass(Foo.class.getName()))
        .isNotSameAs(foo.getClass());
  }

  static class PresentThreadLocalWithSystemType implements Runnable {
    ThreadLocal<String> local = new ThreadLocal<>();

    @Override public void run() {
      local.set("foo");
    }
  }

  @Test public void assertRunIsUnloadable_threadLocalWithSystemClassIsUnloadable() {
    assertRunIsUnloadable(getClass().getClassLoader(), PresentThreadLocalWithSystemType.class);
  }

  static class AbsentThreadLocalWithApplicationType implements Runnable {
    ThreadLocal<ClassLoadersTest> local = new ThreadLocal<>();

    @Override public void run() {
    }
  }

  @Test public void assertRunIsUnloadable_absentThreadLocalWithOurClassIsUnloadable() {
    assertRunIsUnloadable(getClass().getClassLoader(), AbsentThreadLocalWithApplicationType.class);
  }

  static class PresentThreadLocalWithApplicationType implements Runnable {
    ThreadLocal<ClassLoadersTest> local = new ThreadLocal<>();

    @Override public void run() {
      local.set(new ClassLoadersTest());
    }
  }

  @Test(expected = AssertionError.class)
  public void assertRunIsUnloadable_threadLocalWithOurClassIsntUnloadable() {
    assertRunIsUnloadable(getClass().getClassLoader(), PresentThreadLocalWithApplicationType.class);
  }

  static class PresentThreadLocalWithWeakRefToApplicationType implements Runnable {
    ThreadLocal<WeakReference<ClassLoadersTest>> local = new ThreadLocal<>();

    @Override public void run() {
      local.set(new WeakReference<>(new ClassLoadersTest()));
    }
  }

  @Test public void assertRunIsUnloadable_threadLocalWithWeakRefToOurClassIsUnloadable() {
    assertRunIsUnloadable(getClass().getClassLoader(),
        PresentThreadLocalWithWeakRefToApplicationType.class);
  }
}
