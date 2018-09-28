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
import io.dhilar.phzip.core.model.Location;
import io.dhilar.phzip.core.model.Province;
import io.dhilar.phzip.core.model.SecondLevelDivision;
import io.dhilar.phzip.core.model.State;

/**
 * JSON persistence implementation of {@code Locations}.
 */
public class JsonLocations extends AbstractPhZip implements Locations {

  /**
   * Deserialize data from JSON file and loads into unmodifiable list.
   *
   * @param countryCode
   *          the country code of the locations to fetch.
   */
  public JsonLocations(final CountryCodes countryCode) {
    super(countryCode);
  }

  /**
   * Use this constructor if you already have the {@code Country} object to avoid repeating
   * deserialization of JSON data.
   *
   * @param country
   *          the country of the locations to fetch.
   */
  public JsonLocations(final Country country) {
    super(country);
  }

  @Override
  public List<Location> getAllLocations(SecondLevelDivision secondLevelDivision,
      City city, SortDirection sortDirection)
      throws ProvinceNotFoundException, StateNotFoundException {

    SecondLevelDivision division = null;

    if (secondLevelDivision instanceof Province) {
      Provinces provinces = new JsonProvinces(getCountry());
      division = provinces.getProvinceById(secondLevelDivision.getId());
    } else if (secondLevelDivision instanceof State) {
      States states = new JsonStates(getCountry());
      division = states.getStateById(secondLevelDivision.getId());
    }

    Cities cities = new JsonCities(getCountry());
    City cityOfLocation = cities.getCity(division.getId(), city.getId());

    Comparator<? super Location> comparator = null;
    if (sortDirection == SortDirection.ASC) {
      comparator = (l1, l2) -> {
        // if name is null then sort by zip code.
        if (l1.getName() != null && l2.getName() != null) {
          return l1.getName().compareToIgnoreCase(l2.getName());
        } else {
          return Integer.valueOf(l1.getZipcode()).compareTo(Integer.valueOf(l2.getZipcode()));
        }
      };
    } else {
      comparator = (l1, l2) -> {
        // if name is null then sort by zip code.
        if (l1.getName() != null && l2.getName() != null) {
          return l2.getName().compareToIgnoreCase(l1.getName());
        } else {
          return Integer.valueOf(l2.getZipcode()).compareTo(Integer.valueOf(l1.getZipcode()));
        }
      };
    }

    cityOfLocation.getLocation().sort(comparator);

    return cityOfLocation.getLocation();
  }
  
  @Override
  public List<Location> getAllLocations(Integer secondLevelDivisionId,
      Integer cityId, SortDirection sortDirection)
      throws ProvinceNotFoundException, StateNotFoundException {
    
    if (getCountryFromJson().getProvinces() != null) {
      return getAllLocations(new Province(secondLevelDivisionId), new City(cityId), sortDirection);
    } else if (getCountryFromJson().getStates() != null) {
      return getAllLocations(new State(secondLevelDivisionId), new City(cityId), sortDirection);
    }
    
    return null;
  }
  
  @Override
  public Location getLocation(Integer secondLevelDivisionId, Integer cityId,
      Integer locationId) {
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

    City cityOfLocation = null;
    
    for (City c : secondLevelDivision.getCities()) {
      if (c.getId().equals(cityId)) {
        cityOfLocation = c;
        break;
      }
    }
    
    for (Location l : cityOfLocation.getLocation()) {
      if (l.getId().equals(locationId)) {
        return l;
      }
    }
    
    return null;
  }

  @Override
  public final Country getCountry() {
    return super.getCountryFromJson();
  }
}
