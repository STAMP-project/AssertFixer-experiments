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

import java.util.Comparator;
import java.util.List;

import io.dhilar.phzip.core.model.City;
import io.dhilar.phzip.core.model.Country;
import io.dhilar.phzip.core.model.Province;
import io.dhilar.phzip.core.model.SecondLevelDivision;
import io.dhilar.phzip.core.model.State;

/**
 * JSON persistence implementation of {@code Cities}.
 */
public class JsonCities extends AbstractPhZip implements Cities {

  /**
   * Deserialize data from JSON file and loads into unmodifiable list.
   *
   * @param countryCode
   *          the country code of the provinces to fetch.
   */
  public JsonCities(final CountryCodes countryCode) {
    super(countryCode);
  }

  /**
   * Use this constructor if you already have the {@code Country} object to avoid repeating
   * deserialization of JSON data.
   *
   * @param country
   *          the country of the cities to fetch.
   */
  public JsonCities(final Country country) {
    super(country);
  }

  @Override
  public final List<City> getAllCities(
      final SecondLevelDivision secondLevelDivisionToSearch,
      final SortDirection sortDirection) {

    SecondLevelDivision secondLevelDivision = null;

    if (secondLevelDivisionToSearch instanceof Province) {
      secondLevelDivision = getCountryFromJson().getProvinces().stream()
          .filter(p -> p.equals(secondLevelDivisionToSearch)).findFirst()
          .orElseThrow(
              () -> new ProvinceNotFoundException("Province not found."));
    } else if (secondLevelDivisionToSearch instanceof State) {
      secondLevelDivision = getCountryFromJson().getStates().stream()
          .filter(p -> p.equals(secondLevelDivisionToSearch)).findFirst()
          .orElseThrow(() -> new StateNotFoundException("State not found."));
    }

    Comparator<? super City> comparator = null;
    if (sortDirection == SortDirection.ASC) {
      comparator = (c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName());
    } else {
      comparator = (c1, c2) -> c2.getName().compareToIgnoreCase(c1.getName());
    }

    secondLevelDivision.getCities().sort(comparator);

    return secondLevelDivision.getCities();
  }

  @Override
  public final List<City> getAllCities(final Integer id,
      final SortDirection sortDirection) {

    SecondLevelDivision secondLevelDivision = null;

    if (getCountryFromJson().getProvinces() != null) {
      secondLevelDivision = new Province(id);
    } else if (getCountryFromJson().getStates() != null) {
      secondLevelDivision = new State(id);
    }

    return getAllCities(secondLevelDivision, sortDirection);
  }

  @Override
  public final City getCity(final Integer id) {
    List<? extends SecondLevelDivision> secondLevelDivisions = null;

    if (getCountryFromJson().getProvinces() != null) {
      secondLevelDivisions = getCountryFromJson().getProvinces();
    } else if (getCountryFromJson().getStates() != null) {
      secondLevelDivisions = getCountryFromJson().getStates();
    }

    for (SecondLevelDivision s : secondLevelDivisions) {
      if (s.getCities() == null) {
        continue;
      }
      City city = s.getCities().stream().filter(c -> c.getId().equals(id))
          .findFirst().orElse(null);
      if (city != null) {
        return city;
      }
    }
    return null;
  }

  @Override
  public final City getCity(final Integer secondLevelDivisionId,
      final Integer cityId) {

    SecondLevelDivision secondLevelDivision = null;

    if (getCountryFromJson().getProvinces() != null) {
      secondLevelDivision = getCountryFromJson().getProvinces().stream()
          .filter(p -> p.equals(new Province(secondLevelDivisionId)))
          .findFirst().orElseThrow(
              () -> new ProvinceNotFoundException("Province not found."));
    } else if (getCountryFromJson().getStates() != null) {
      secondLevelDivision = getCountryFromJson().getStates().stream()
          .filter(p -> p.equals(new State(secondLevelDivisionId))).findFirst()
          .orElseThrow(() -> new StateNotFoundException("State not found."));
    }

    List<City> citiesOfDivision = secondLevelDivision.getCities();

    for (City c : citiesOfDivision) {
      if (c.getId().equals(cityId)) {
        return c;
      }
    }
    return null;
  }

  @Override
  public final Country getCountry() {
    return super.getCountryFromJson();
  }
}
