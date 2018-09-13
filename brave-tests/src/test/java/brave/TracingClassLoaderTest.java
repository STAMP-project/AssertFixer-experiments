package brave;

import org.junit.Test;

import static brave.test.util.ClassLoaders.assertRunIsUnloadable;

public class TracingClassLoaderTest {

  @Test public void unloadable_afterClose() {
    assertRunIsUnloadable(ClosesTracing.class, getClass().getClassLoader());
  }

  static class ClosesTracing implements Runnable {
    @Override public void run() {
      try (Tracing tracing = Tracing.newBuilder().build()) {
      }
    }
  }

  @Test public void unloadable_afterBasicUsage() {
    assertRunIsUnloadable(BasicUsage.class, getClass().getClassLoader());
  }

  static class BasicUsage implements Runnable {
    @Override public void run() {
      try (Tracing tracing = Tracing.newBuilder().build()) {
        tracing.tracer().newTrace().start().finish();
      }
    }
  }
}
