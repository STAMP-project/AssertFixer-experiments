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
import io.dhilar.phzip.core.model.Province;

/**
 * JSON persistence implementation of {@code Provinces}.
 */
public class JsonProvinces extends AbstractPhZip implements Provinces {

  /**
   * Deserialize province data from JSON file and loads into unmodifiable list.
   *
   * @param countryCode the country code of the provinces to fetch.
   */
  public JsonProvinces(final CountryCodes countryCode) {
    super(countryCode);
  }

  /**
   * Use this constructor if you already have the {@code Country} object to avoid repeating
   * deserialization of JSON data.
   *
   * @param country the country of the provinces to fetch.
   */
  public JsonProvinces(final Country country) {
    super(country);
  }

  @Override
  public final List<Province> getAllProvinces(final SortDirection dir, final Boolean capitalFirst) {

    List<Province> sortedProvinces = getCountryFromJson().getProvinces();

    Comparator<Province> ascendingComparator =
        (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName());
    Comparator<Province> descendingComparator =
        (p1, p2) -> p2.getName().compareToIgnoreCase(p1.getName());

    if (dir == SortDirection.ASC && !capitalFirst.booleanValue()) {

      sortedProvinces.sort(ascendingComparator);

    } else if (dir == SortDirection.DESC && capitalFirst.booleanValue()) {

      // default data has capital as its first entry.
      Province capital = sortedProvinces.remove(0);
      sortedProvinces.sort(descendingComparator);
      sortedProvinces.add(0, capital);

    } else if (dir == SortDirection.DESC && !capitalFirst.booleanValue()) {

      // default data has capital as its first entry.
      Province capital = sortedProvinces.remove(0);
      sortedProvinces.sort(descendingComparator);
      sortedProvinces.add(sortedProvinces.size(), capital);

    } else if (dir != SortDirection.ASC && !capitalFirst.booleanValue()) {

      throw new UnsupportedOperationException();
    }

    if (sortedProvinces == null) {
      throw new NoProvinceFoundException("No province/s found for country '"
          + getCountryFromJson().getName() + "' try searching for state or region.");
    }

    return Collections.unmodifiableList(sortedProvinces);
  }

  @Override
  public final Province getProvinceById(final Integer id) {

    List<Province> provinces = getCountryFromJson().getProvinces();

    if (provinces == null) {
      throw new NoProvinceFoundException("No province/s found for country '"
          + getCountryFromJson().getName() + "' try searching for state or region.");
    }

    return provinces.get(provinces.indexOf(new Province(id)));
  }

  @Override
  public final Country getCountry() {
    return super.getCountryFromJson();
  }
}
