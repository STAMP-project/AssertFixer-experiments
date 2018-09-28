/*
 * Copyright (c) 2018 Dann Ryan Hilario
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package io.dhilar.phzip.core;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import io.dhilar.phzip.core.model.Country;
import io.dhilar.phzip.core.model.State;

/**
 * JSON persistence implementation of {@code States}.
 */
public class JsonStates extends AbstractPhZip implements States {

  /**
   * Deserialize state data from JSON file and loads into unmodifiable list.
   *
   * @param countryCode the country code of the states to fetch.
   */
  public JsonStates(final CountryCodes countryCode) {
    super(countryCode);
  }

  /**
   * Use this constructor if you already have the {@code Country} object to avoid repeating
   * deserialization of JSON data.
   *
   * @param country the country of the states to fetch.
   */
  public JsonStates(final Country country) {
    super(country);
  }

  @Override
  public final List<State> getAllStates(final SortDirection dir) {

    List<State> sortedStates = getCountryFromJson().getStates();

    if (sortedStates == null || sortedStates.isEmpty()) {
      throw new NoStateFoundException("No state/s found for country '"
          + getCountryFromJson().getName() + "' try searching for province or region.");
    }

    Comparator<State> ascendingComparator =
        (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName());
    Comparator<State> descendingComparator =
        (p1, p2) -> p2.getName().compareToIgnoreCase(p1.getName());

    if (dir == SortDirection.ASC) {

      sortedStates.sort(ascendingComparator);

    } else if (dir == SortDirection.DESC) {

      sortedStates.sort(descendingComparator);

    } else {
      throw new UnsupportedOperationException();
    }

    return Collections.unmodifiableList(sortedStates);
  }

  @Override
  public final State getStateById(final Integer id) {

    List<State> states = getCountryFromJson().getStates();

    if (states == null || states.isEmpty()) {
      throw new NoStateFoundException("No state/s found for country '"
          + getCountryFromJson().getName() + "' try searching for province or region.");
    }

    return getCountryFromJson().getStates()
        .get(getCountryFromJson().getStates().indexOf(new State(id)));
  }

  @Override
  public final Country getCountry() {
    return super.getCountryFromJson();
  }
}
