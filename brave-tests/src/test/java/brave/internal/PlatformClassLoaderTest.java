package brave.internal;

import brave.test.util.ClassLoaders;
import java.net.InetSocketAddress;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlatformClassLoaderTest {
  @Test public void unloadable_afterGet() {
    assertRunIsUnloadable(GetPlatform.class);
  }

  static class GetPlatform implements Runnable {
    @Override public void run() {
      Platform platform = Platform.get();
      assertThat(platform.getClass()).isNotNull();
    }
  }

  @Test public void unloadable_afterGetLinkLocalIp() {
    assertRunIsUnloadable(GetPlatformLinkLocalIp.class);
  }

  static class GetPlatformLinkLocalIp implements Runnable {
    @Override public void run() {
      Platform platform = Platform.get();
      assertThat(platform.getClass()).isNotNull();
      platform.linkLocalIp();
    }
  }

  @Test public void unloadable_afterGetNextTraceIdHigh() {
    assertRunIsUnloadable(GetPlatformNextTraceIdHigh.class);
  }

  static class GetPlatformNextTraceIdHigh implements Runnable {
    @Override public void run() {
      Platform.get().nextTraceIdHigh();
    }
  }

  @Test public void unloadable_afterGetHostString() {
    assertRunIsUnloadable(GetPlatformHostString.class);
  }

  static class GetPlatformHostString implements Runnable {
    @Override public void run() {
      Platform.get().getHostString(InetSocketAddress.createUnresolved("1.2.3.4", 0));
    }
  }

  void assertRunIsUnloadable(Class<? extends Runnable> runnable) {
    ClassLoaders.assertRunIsUnloadable(getClass().getClassLoader(), runnable);
  }
}
