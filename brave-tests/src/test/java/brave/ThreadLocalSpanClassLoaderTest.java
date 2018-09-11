package brave;

import brave.propagation.ThreadLocalSpan;
import org.junit.Test;
import zipkin2.reporter.Reporter;

import static brave.test.util.ClassLoaders.assertRunIsUnloadable;

public class ThreadLocalSpanClassLoaderTest {

  @Test public void noop_unloadable() {
    assertRunIsUnloadable(getClass().getClassLoader(), CurrentTracerUnassigned.class);
  }

  static class CurrentTracerUnassigned implements Runnable {
    @Override public void run() {
      ThreadLocalSpan.CURRENT_TRACER.next();
    }
  }

  @Test public void nextAndRemove_unloadable() {
    assertRunIsUnloadable(getClass().getClassLoader(), CurrentTracerRemovesSpan.class);
  }

  static class CurrentTracerRemovesSpan implements Runnable {
    @Override public void run() {
      try (Tracing tracing = Tracing.newBuilder().build()) {
        ThreadLocalSpan.CURRENT_TRACER.next();
        ThreadLocalSpan.CURRENT_TRACER.remove();
      }
    }
  }

  /**
   * TODO: While it is an instrumentation bug to not complete a thread-local span, we should be
   * tolerant, for example considering weak references or similar.
   */
  @Test(expected = AssertionError.class) public void unfinishedSpan_preventsUnloading() {
    assertRunIsUnloadable(getClass().getClassLoader(), CurrentTracerDoesntFinishSpan.class);
  }

  static class CurrentTracerDoesntFinishSpan implements Runnable {
    @Override public void run() {
      try (Tracing tracing = Tracing.newBuilder().spanReporter(Reporter.NOOP).build()) {
        ThreadLocalSpan.CURRENT_TRACER.next();
      }
    }
  }
}
