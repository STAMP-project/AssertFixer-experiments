package lan.dk.podcastserver.assertion;

/**
 * Entry point for BDD assertions of different data types. Each method in this class is a static factory for the
 * type-specific assertion objects.
 */
public class BddAssertions {

  /**
   * Creates a new instance of <code>{@link lan.dk.podcastserver.business.stats.StatsPodcastTypeAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static lan.dk.podcastserver.business.stats.StatsPodcastTypeAssert then(lan.dk.podcastserver.business.stats.StatsPodcastType actual) {
    return new lan.dk.podcastserver.business.stats.StatsPodcastTypeAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link lan.dk.podcastserver.entity.CoverAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static lan.dk.podcastserver.entity.CoverAssert then(lan.dk.podcastserver.entity.Cover actual) {
    return new lan.dk.podcastserver.entity.CoverAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link lan.dk.podcastserver.entity.ItemAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static lan.dk.podcastserver.entity.ItemAssert then(lan.dk.podcastserver.entity.Item actual) {
    return new lan.dk.podcastserver.entity.ItemAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link lan.dk.podcastserver.entity.PodcastAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static lan.dk.podcastserver.entity.PodcastAssert then(lan.dk.podcastserver.entity.Podcast actual) {
    return new lan.dk.podcastserver.entity.PodcastAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link lan.dk.podcastserver.entity.StatusAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static lan.dk.podcastserver.entity.StatusAssert then(lan.dk.podcastserver.entity.Status actual) {
    return new lan.dk.podcastserver.entity.StatusAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link lan.dk.podcastserver.entity.TagAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static lan.dk.podcastserver.entity.TagAssert then(lan.dk.podcastserver.entity.Tag actual) {
    return new lan.dk.podcastserver.entity.TagAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link lan.dk.podcastserver.entity.WatchListAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static lan.dk.podcastserver.entity.WatchListAssert then(lan.dk.podcastserver.entity.WatchList actual) {
    return new lan.dk.podcastserver.entity.WatchListAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link lan.dk.podcastserver.service.properties.ApiAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static lan.dk.podcastserver.service.properties.ApiAssert then(lan.dk.podcastserver.service.properties.Api actual) {
    return new lan.dk.podcastserver.service.properties.ApiAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link lan.dk.podcastserver.service.properties.BackupAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static lan.dk.podcastserver.service.properties.BackupAssert then(lan.dk.podcastserver.service.properties.Backup actual) {
    return new lan.dk.podcastserver.service.properties.BackupAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link lan.dk.podcastserver.service.properties.ExternalToolsAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static lan.dk.podcastserver.service.properties.ExternalToolsAssert then(lan.dk.podcastserver.service.properties.ExternalTools actual) {
    return new lan.dk.podcastserver.service.properties.ExternalToolsAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link lan.dk.podcastserver.service.properties.PodcastServerParametersAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static lan.dk.podcastserver.service.properties.PodcastServerParametersAssert then(lan.dk.podcastserver.service.properties.PodcastServerParameters actual) {
    return new lan.dk.podcastserver.service.properties.PodcastServerParametersAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link lan.dk.podcastserver.utils.form.MovingItemInQueueFormAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static lan.dk.podcastserver.utils.form.MovingItemInQueueFormAssert then(lan.dk.podcastserver.utils.form.MovingItemInQueueForm actual) {
    return new lan.dk.podcastserver.utils.form.MovingItemInQueueFormAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.springframework.data.domain.PageAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.springframework.data.domain.PageAssert then(org.springframework.data.domain.Page actual) {
    return new org.springframework.data.domain.PageAssert(actual);
  }

  /**
   * Creates a new <code>{@link BddAssertions}</code>.
   */
  protected BddAssertions() {
    // empty
  }
}
