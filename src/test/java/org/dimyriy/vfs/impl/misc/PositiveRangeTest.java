package org.dimyriy.vfs.impl.misc;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
class PositiveRangeTest {

  @Test
  void longRangeIsValueInRange_ReturnsFalse_WhenValueOutsideOfRange() {
    AssertionsForClassTypes.assertThat(new PositiveLongRange(0L, 15L).isValueInRange(20L)).isFalse();
  }

  @Test
  void longRangeIsValueInRange_ReturnsFalse_WhenValueEqualToUpperBound() {
    AssertionsForClassTypes.assertThat(new PositiveLongRange(0L, 15L).isValueInRange(15L)).isFalse();
  }

  @Test
  void longRangeIsValueInRange_ReturnsTrue_WhenValueIsInRange() {
    AssertionsForClassTypes.assertThat(new PositiveLongRange(0L, 15L).isValueInRange(14L)).isTrue();
  }

  @Test
  void longRangeIsGetLowerBound_ReturnsCorrectValue() {
    AssertionsForClassTypes.assertThat(new PositiveLongRange(0L, 15L).getLowerBoundClosed()).isEqualTo(0L);
  }

  @Test
  void longRangeIsGetUpperBound_ReturnsCorrectValue() {
    AssertionsForClassTypes.assertThat(new PositiveLongRange(0L, 15L).getUpperBoundOpen()).isEqualTo(15L);
  }
}