package lan.dk.podcastserver.assertion;

import org.assertj.core.internal.cglib.proxy.Enhancer;

import org.assertj.core.api.ErrorCollector;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;

/**
 * Entry point for assertions of different data types. Each method in this class is a static factory for the
 * type-specific assertion objects.
 */
public class JUnitSoftAssertions implements TestRule {

  /** Collects error messages of all AssertionErrors thrown by the proxied method. */
  protected final ErrorCollector collector = new ErrorCollector();

  /** Creates a new </code>{@link JUnitSoftAssertions}</code>. */
  public JUnitSoftAssertions() {
    super();
  }

  /**
   * TestRule implementation that verifies that no proxied assertion methods have failed.
   */
  public Statement apply(final Statement base, Description description) {
    return new Statement() {
      @Override
      public void evaluate() throws Throwable {
        base.evaluate();
        MultipleFailureException.assertEmpty(collector.errors());
      }
    };
  }
  
  @SuppressWarnings("unchecked")
  protected <T, V> V proxy(Class<V> assertClass, Class<T> actualClass, T actual) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(assertClass);
    enhancer.setCallback(collector);
    return (V) enhancer.create(new Class[] { actualClass }, new Object[] { actual });
  }

  /**
   * Creates a new "soft" instance of <code>{@link lan.dk.podcastserver.business.stats.StatsPodcastTypeAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public lan.dk.podcastserver.business.stats.StatsPodcastTypeAssert assertThat(lan.dk.podcastserver.business.stats.StatsPodcastType actual) {
    return proxy(lan.dk.podcastserver.business.stats.StatsPodcastTypeAssert.class, lan.dk.podcastserver.business.stats.StatsPodcastType.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link lan.dk.podcastserver.entity.CoverAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public lan.dk.podcastserver.entity.CoverAssert assertThat(lan.dk.podcastserver.entity.Cover actual) {
    return proxy(lan.dk.podcastserver.entity.CoverAssert.class, lan.dk.podcastserver.entity.Cover.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link lan.dk.podcastserver.entity.ItemAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public lan.dk.podcastserver.entity.ItemAssert assertThat(lan.dk.podcastserver.entity.Item actual) {
    return proxy(lan.dk.podcastserver.entity.ItemAssert.class, lan.dk.podcastserver.entity.Item.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link lan.dk.podcastserver.entity.PodcastAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public lan.dk.podcastserver.entity.PodcastAssert assertThat(lan.dk.podcastserver.entity.Podcast actual) {
    return proxy(lan.dk.podcastserver.entity.PodcastAssert.class, lan.dk.podcastserver.entity.Podcast.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link lan.dk.podcastserver.entity.StatusAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public lan.dk.podcastserver.entity.StatusAssert assertThat(lan.dk.podcastserver.entity.Status actual) {
    return proxy(lan.dk.podcastserver.entity.StatusAssert.class, lan.dk.podcastserver.entity.Status.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link lan.dk.podcastserver.entity.TagAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public lan.dk.podcastserver.entity.TagAssert assertThat(lan.dk.podcastserver.entity.Tag actual) {
    return proxy(lan.dk.podcastserver.entity.TagAssert.class, lan.dk.podcastserver.entity.Tag.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link lan.dk.podcastserver.entity.WatchListAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public lan.dk.podcastserver.entity.WatchListAssert assertThat(lan.dk.podcastserver.entity.WatchList actual) {
    return proxy(lan.dk.podcastserver.entity.WatchListAssert.class, lan.dk.podcastserver.entity.WatchList.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link lan.dk.podcastserver.service.properties.ApiAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public lan.dk.podcastserver.service.properties.ApiAssert assertThat(lan.dk.podcastserver.service.properties.Api actual) {
    return proxy(lan.dk.podcastserver.service.properties.ApiAssert.class, lan.dk.podcastserver.service.properties.Api.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link lan.dk.podcastserver.service.properties.BackupAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public lan.dk.podcastserver.service.properties.BackupAssert assertThat(lan.dk.podcastserver.service.properties.Backup actual) {
    return proxy(lan.dk.podcastserver.service.properties.BackupAssert.class, lan.dk.podcastserver.service.properties.Backup.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link lan.dk.podcastserver.service.properties.ExternalToolsAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public lan.dk.podcastserver.service.properties.ExternalToolsAssert assertThat(lan.dk.podcastserver.service.properties.ExternalTools actual) {
    return proxy(lan.dk.podcastserver.service.properties.ExternalToolsAssert.class, lan.dk.podcastserver.service.properties.ExternalTools.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link lan.dk.podcastserver.service.properties.PodcastServerParametersAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public lan.dk.podcastserver.service.properties.PodcastServerParametersAssert assertThat(lan.dk.podcastserver.service.properties.PodcastServerParameters actual) {
    return proxy(lan.dk.podcastserver.service.properties.PodcastServerParametersAssert.class, lan.dk.podcastserver.service.properties.PodcastServerParameters.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link lan.dk.podcastserver.utils.form.MovingItemInQueueFormAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public lan.dk.podcastserver.utils.form.MovingItemInQueueFormAssert assertThat(lan.dk.podcastserver.utils.form.MovingItemInQueueForm actual) {
    return proxy(lan.dk.podcastserver.utils.form.MovingItemInQueueFormAssert.class, lan.dk.podcastserver.utils.form.MovingItemInQueueForm.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.springframework.data.domain.PageAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.springframework.data.domain.PageAssert assertThat(org.springframework.data.domain.Page actual) {
    return proxy(org.springframework.data.domain.PageAssert.class, org.springframework.data.domain.Page.class, actual);
  }

}
