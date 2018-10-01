package org.dimyriy.vfs.impl.misc;

import org.dimyriy.vfs.impl.guards.Assertions;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public class PositiveLongRange {
  private final long lowerBoundClosed;
  private final long upperBoundOpen;

  public PositiveLongRange(final long lowerBoundClosed, final long upperBoundOpen) {
    Assertions.positiveRangeBoundariesAreCorrect(lowerBoundClosed, upperBoundOpen);
    this.lowerBoundClosed = lowerBoundClosed;
    this.upperBoundOpen = upperBoundOpen;
  }

  public long getLowerBoundClosed() {
    return lowerBoundClosed;
  }

  public long getUpperBoundOpen() {
    return upperBoundOpen;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (!(o instanceof PositiveLongRange)) return false;

    final PositiveLongRange that = (PositiveLongRange) o;

    if (lowerBoundClosed != that.lowerBoundClosed) return false;
    return upperBoundOpen == that.upperBoundOpen;
  }

  @Override
  public int hashCode() {
    int result = (int) (lowerBoundClosed ^ (lowerBoundClosed >>> 32));
    result = 31 * result + (int) (upperBoundOpen ^ (upperBoundOpen >>> 32));
    return result;
  }

  public boolean isValueInRange(final long value) {
    return value >= lowerBoundClosed && value < upperBoundOpen;
  }

  public boolean isBothValuesInRange(final long value1, final long value2) {
    return isValueInRange(value1) && isValueInRange(value2);
  }
}
