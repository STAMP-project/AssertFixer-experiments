
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_MemoryStats_Stats extends MemoryStats.Stats {

  private final Long activeFile;
  private final Long totalActiveFile;
  private final Long inactiveFile;
  private final Long totalInactiveFile;
  private final Long cache;
  private final Long totalCache;
  private final Long activeAnon;
  private final Long totalActiveAnon;
  private final Long inactiveAnon;
  private final Long totalInactiveAnon;
  private final BigInteger hierarchicalMemoryLimit;
  private final Long mappedFile;
  private final Long totalMappedFile;
  private final Long pgmajfault;
  private final Long totalPgmajfault;
  private final Long pgpgin;
  private final Long totalPgpgin;
  private final Long pgpgout;
  private final Long totalPgpgout;
  private final Long pgfault;
  private final Long totalPgfault;
  private final Long rss;
  private final Long totalRss;
  private final Long rssHuge;
  private final Long totalRssHuge;
  private final Long unevictable;
  private final Long totalUnevictable;
  private final Long totalWriteback;
  private final Long writeback;

  AutoValue_MemoryStats_Stats(
      Long activeFile,
      Long totalActiveFile,
      Long inactiveFile,
      Long totalInactiveFile,
      Long cache,
      Long totalCache,
      Long activeAnon,
      Long totalActiveAnon,
      Long inactiveAnon,
      Long totalInactiveAnon,
      BigInteger hierarchicalMemoryLimit,
      Long mappedFile,
      Long totalMappedFile,
      Long pgmajfault,
      Long totalPgmajfault,
      Long pgpgin,
      Long totalPgpgin,
      Long pgpgout,
      Long totalPgpgout,
      Long pgfault,
      Long totalPgfault,
      Long rss,
      Long totalRss,
      Long rssHuge,
      Long totalRssHuge,
      Long unevictable,
      Long totalUnevictable,
      @Nullable Long totalWriteback,
      @Nullable Long writeback) {
    if (activeFile == null) {
      throw new NullPointerException("Null activeFile");
    }
    this.activeFile = activeFile;
    if (totalActiveFile == null) {
      throw new NullPointerException("Null totalActiveFile");
    }
    this.totalActiveFile = totalActiveFile;
    if (inactiveFile == null) {
      throw new NullPointerException("Null inactiveFile");
    }
    this.inactiveFile = inactiveFile;
    if (totalInactiveFile == null) {
      throw new NullPointerException("Null totalInactiveFile");
    }
    this.totalInactiveFile = totalInactiveFile;
    if (cache == null) {
      throw new NullPointerException("Null cache");
    }
    this.cache = cache;
    if (totalCache == null) {
      throw new NullPointerException("Null totalCache");
    }
    this.totalCache = totalCache;
    if (activeAnon == null) {
      throw new NullPointerException("Null activeAnon");
    }
    this.activeAnon = activeAnon;
    if (totalActiveAnon == null) {
      throw new NullPointerException("Null totalActiveAnon");
    }
    this.totalActiveAnon = totalActiveAnon;
    if (inactiveAnon == null) {
      throw new NullPointerException("Null inactiveAnon");
    }
    this.inactiveAnon = inactiveAnon;
    if (totalInactiveAnon == null) {
      throw new NullPointerException("Null totalInactiveAnon");
    }
    this.totalInactiveAnon = totalInactiveAnon;
    if (hierarchicalMemoryLimit == null) {
      throw new NullPointerException("Null hierarchicalMemoryLimit");
    }
    this.hierarchicalMemoryLimit = hierarchicalMemoryLimit;
    if (mappedFile == null) {
      throw new NullPointerException("Null mappedFile");
    }
    this.mappedFile = mappedFile;
    if (totalMappedFile == null) {
      throw new NullPointerException("Null totalMappedFile");
    }
    this.totalMappedFile = totalMappedFile;
    if (pgmajfault == null) {
      throw new NullPointerException("Null pgmajfault");
    }
    this.pgmajfault = pgmajfault;
    if (totalPgmajfault == null) {
      throw new NullPointerException("Null totalPgmajfault");
    }
    this.totalPgmajfault = totalPgmajfault;
    if (pgpgin == null) {
      throw new NullPointerException("Null pgpgin");
    }
    this.pgpgin = pgpgin;
    if (totalPgpgin == null) {
      throw new NullPointerException("Null totalPgpgin");
    }
    this.totalPgpgin = totalPgpgin;
    if (pgpgout == null) {
      throw new NullPointerException("Null pgpgout");
    }
    this.pgpgout = pgpgout;
    if (totalPgpgout == null) {
      throw new NullPointerException("Null totalPgpgout");
    }
    this.totalPgpgout = totalPgpgout;
    if (pgfault == null) {
      throw new NullPointerException("Null pgfault");
    }
    this.pgfault = pgfault;
    if (totalPgfault == null) {
      throw new NullPointerException("Null totalPgfault");
    }
    this.totalPgfault = totalPgfault;
    if (rss == null) {
      throw new NullPointerException("Null rss");
    }
    this.rss = rss;
    if (totalRss == null) {
      throw new NullPointerException("Null totalRss");
    }
    this.totalRss = totalRss;
    if (rssHuge == null) {
      throw new NullPointerException("Null rssHuge");
    }
    this.rssHuge = rssHuge;
    if (totalRssHuge == null) {
      throw new NullPointerException("Null totalRssHuge");
    }
    this.totalRssHuge = totalRssHuge;
    if (unevictable == null) {
      throw new NullPointerException("Null unevictable");
    }
    this.unevictable = unevictable;
    if (totalUnevictable == null) {
      throw new NullPointerException("Null totalUnevictable");
    }
    this.totalUnevictable = totalUnevictable;
    this.totalWriteback = totalWriteback;
    this.writeback = writeback;
  }

  @JsonProperty(value = "active_file")
  @Override
  public Long activeFile() {
    return activeFile;
  }

  @JsonProperty(value = "total_active_file")
  @Override
  public Long totalActiveFile() {
    return totalActiveFile;
  }

  @JsonProperty(value = "inactive_file")
  @Override
  public Long inactiveFile() {
    return inactiveFile;
  }

  @JsonProperty(value = "total_inactive_file")
  @Override
  public Long totalInactiveFile() {
    return totalInactiveFile;
  }

  @JsonProperty(value = "cache")
  @Override
  public Long cache() {
    return cache;
  }

  @JsonProperty(value = "total_cache")
  @Override
  public Long totalCache() {
    return totalCache;
  }

  @JsonProperty(value = "active_anon")
  @Override
  public Long activeAnon() {
    return activeAnon;
  }

  @JsonProperty(value = "total_active_anon")
  @Override
  public Long totalActiveAnon() {
    return totalActiveAnon;
  }

  @JsonProperty(value = "inactive_anon")
  @Override
  public Long inactiveAnon() {
    return inactiveAnon;
  }

  @JsonProperty(value = "total_inactive_anon")
  @Override
  public Long totalInactiveAnon() {
    return totalInactiveAnon;
  }

  @JsonProperty(value = "hierarchical_memory_limit")
  @Override
  public BigInteger hierarchicalMemoryLimit() {
    return hierarchicalMemoryLimit;
  }

  @JsonProperty(value = "mapped_file")
  @Override
  public Long mappedFile() {
    return mappedFile;
  }

  @JsonProperty(value = "total_mapped_file")
  @Override
  public Long totalMappedFile() {
    return totalMappedFile;
  }

  @JsonProperty(value = "pgmajfault")
  @Override
  public Long pgmajfault() {
    return pgmajfault;
  }

  @JsonProperty(value = "total_pgmajfault")
  @Override
  public Long totalPgmajfault() {
    return totalPgmajfault;
  }

  @JsonProperty(value = "pgpgin")
  @Override
  public Long pgpgin() {
    return pgpgin;
  }

  @JsonProperty(value = "total_pgpgin")
  @Override
  public Long totalPgpgin() {
    return totalPgpgin;
  }

  @JsonProperty(value = "pgpgout")
  @Override
  public Long pgpgout() {
    return pgpgout;
  }

  @JsonProperty(value = "total_pgpgout")
  @Override
  public Long totalPgpgout() {
    return totalPgpgout;
  }

  @JsonProperty(value = "pgfault")
  @Override
  public Long pgfault() {
    return pgfault;
  }

  @JsonProperty(value = "total_pgfault")
  @Override
  public Long totalPgfault() {
    return totalPgfault;
  }

  @JsonProperty(value = "rss")
  @Override
  public Long rss() {
    return rss;
  }

  @JsonProperty(value = "total_rss")
  @Override
  public Long totalRss() {
    return totalRss;
  }

  @JsonProperty(value = "rss_huge")
  @Override
  public Long rssHuge() {
    return rssHuge;
  }

  @JsonProperty(value = "total_rss_huge")
  @Override
  public Long totalRssHuge() {
    return totalRssHuge;
  }

  @JsonProperty(value = "unevictable")
  @Override
  public Long unevictable() {
    return unevictable;
  }

  @JsonProperty(value = "total_unevictable")
  @Override
  public Long totalUnevictable() {
    return totalUnevictable;
  }

  @Nullable
  @JsonProperty(value = "total_writeback")
  @Override
  public Long totalWriteback() {
    return totalWriteback;
  }

  @Nullable
  @JsonProperty(value = "writeback")
  @Override
  public Long writeback() {
    return writeback;
  }

  @Override
  public String toString() {
    return "Stats{"
        + "activeFile=" + activeFile + ", "
        + "totalActiveFile=" + totalActiveFile + ", "
        + "inactiveFile=" + inactiveFile + ", "
        + "totalInactiveFile=" + totalInactiveFile + ", "
        + "cache=" + cache + ", "
        + "totalCache=" + totalCache + ", "
        + "activeAnon=" + activeAnon + ", "
        + "totalActiveAnon=" + totalActiveAnon + ", "
        + "inactiveAnon=" + inactiveAnon + ", "
        + "totalInactiveAnon=" + totalInactiveAnon + ", "
        + "hierarchicalMemoryLimit=" + hierarchicalMemoryLimit + ", "
        + "mappedFile=" + mappedFile + ", "
        + "totalMappedFile=" + totalMappedFile + ", "
        + "pgmajfault=" + pgmajfault + ", "
        + "totalPgmajfault=" + totalPgmajfault + ", "
        + "pgpgin=" + pgpgin + ", "
        + "totalPgpgin=" + totalPgpgin + ", "
        + "pgpgout=" + pgpgout + ", "
        + "totalPgpgout=" + totalPgpgout + ", "
        + "pgfault=" + pgfault + ", "
        + "totalPgfault=" + totalPgfault + ", "
        + "rss=" + rss + ", "
        + "totalRss=" + totalRss + ", "
        + "rssHuge=" + rssHuge + ", "
        + "totalRssHuge=" + totalRssHuge + ", "
        + "unevictable=" + unevictable + ", "
        + "totalUnevictable=" + totalUnevictable + ", "
        + "totalWriteback=" + totalWriteback + ", "
        + "writeback=" + writeback
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof MemoryStats.Stats) {
      MemoryStats.Stats that = (MemoryStats.Stats) o;
      return (this.activeFile.equals(that.activeFile()))
           && (this.totalActiveFile.equals(that.totalActiveFile()))
           && (this.inactiveFile.equals(that.inactiveFile()))
           && (this.totalInactiveFile.equals(that.totalInactiveFile()))
           && (this.cache.equals(that.cache()))
           && (this.totalCache.equals(that.totalCache()))
           && (this.activeAnon.equals(that.activeAnon()))
           && (this.totalActiveAnon.equals(that.totalActiveAnon()))
           && (this.inactiveAnon.equals(that.inactiveAnon()))
           && (this.totalInactiveAnon.equals(that.totalInactiveAnon()))
           && (this.hierarchicalMemoryLimit.equals(that.hierarchicalMemoryLimit()))
           && (this.mappedFile.equals(that.mappedFile()))
           && (this.totalMappedFile.equals(that.totalMappedFile()))
           && (this.pgmajfault.equals(that.pgmajfault()))
           && (this.totalPgmajfault.equals(that.totalPgmajfault()))
           && (this.pgpgin.equals(that.pgpgin()))
           && (this.totalPgpgin.equals(that.totalPgpgin()))
           && (this.pgpgout.equals(that.pgpgout()))
           && (this.totalPgpgout.equals(that.totalPgpgout()))
           && (this.pgfault.equals(that.pgfault()))
           && (this.totalPgfault.equals(that.totalPgfault()))
           && (this.rss.equals(that.rss()))
           && (this.totalRss.equals(that.totalRss()))
           && (this.rssHuge.equals(that.rssHuge()))
           && (this.totalRssHuge.equals(that.totalRssHuge()))
           && (this.unevictable.equals(that.unevictable()))
           && (this.totalUnevictable.equals(that.totalUnevictable()))
           && ((this.totalWriteback == null) ? (that.totalWriteback() == null) : this.totalWriteback.equals(that.totalWriteback()))
           && ((this.writeback == null) ? (that.writeback() == null) : this.writeback.equals(that.writeback()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.activeFile.hashCode();
    h *= 1000003;
    h ^= this.totalActiveFile.hashCode();
    h *= 1000003;
    h ^= this.inactiveFile.hashCode();
    h *= 1000003;
    h ^= this.totalInactiveFile.hashCode();
    h *= 1000003;
    h ^= this.cache.hashCode();
    h *= 1000003;
    h ^= this.totalCache.hashCode();
    h *= 1000003;
    h ^= this.activeAnon.hashCode();
    h *= 1000003;
    h ^= this.totalActiveAnon.hashCode();
    h *= 1000003;
    h ^= this.inactiveAnon.hashCode();
    h *= 1000003;
    h ^= this.totalInactiveAnon.hashCode();
    h *= 1000003;
    h ^= this.hierarchicalMemoryLimit.hashCode();
    h *= 1000003;
    h ^= this.mappedFile.hashCode();
    h *= 1000003;
    h ^= this.totalMappedFile.hashCode();
    h *= 1000003;
    h ^= this.pgmajfault.hashCode();
    h *= 1000003;
    h ^= this.totalPgmajfault.hashCode();
    h *= 1000003;
    h ^= this.pgpgin.hashCode();
    h *= 1000003;
    h ^= this.totalPgpgin.hashCode();
    h *= 1000003;
    h ^= this.pgpgout.hashCode();
    h *= 1000003;
    h ^= this.totalPgpgout.hashCode();
    h *= 1000003;
    h ^= this.pgfault.hashCode();
    h *= 1000003;
    h ^= this.totalPgfault.hashCode();
    h *= 1000003;
    h ^= this.rss.hashCode();
    h *= 1000003;
    h ^= this.totalRss.hashCode();
    h *= 1000003;
    h ^= this.rssHuge.hashCode();
    h *= 1000003;
    h ^= this.totalRssHuge.hashCode();
    h *= 1000003;
    h ^= this.unevictable.hashCode();
    h *= 1000003;
    h ^= this.totalUnevictable.hashCode();
    h *= 1000003;
    h ^= (totalWriteback == null) ? 0 : this.totalWriteback.hashCode();
    h *= 1000003;
    h ^= (writeback == null) ? 0 : this.writeback.hashCode();
    return h;
  }

}
