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

import java.util.List;

import io.dhilar.phzip.core.model.City;
import io.dhilar.phzip.core.model.Country;
import io.dhilar.phzip.core.model.Location;
import io.dhilar.phzip.core.model.SecondLevelDivision;

/**
 * Defines accessors for getting details of a {@code Locations}.
 */
public interface Locations {

  /**
   * Returns list of locations of {@code Province} or {@code State} and {@code City}
   * sorted by {@code SortDirection}.
   *
   * @param secondLevelDivision the locations of this {@code Province} or {@code State}
   * @param city the locations of this city
   * @param sortDirection is either {@code ASC} or {@code DESC}
   * @return The list of {@code Location} of the passed {@code Province} or {@code State}
   *         and {@code City}
   * @throws ProvinceNotFoundException if {@code Province} not found
   * @throws StateNotFoundException if {@code State} not found
   */
  List<Location> getAllLocations(SecondLevelDivision secondLevelDivision, City city,
      SortDirection sortDirection) throws ProvinceNotFoundException, StateNotFoundException;
  
  /**
   * Returns list of locations of {@code Province} or {@code State} and {@code City}
   * sorted by {@code SortDirection}.
   *
   * @param secondLevelDivisionId the locations of this {@code Province} Id or {@code State} Id
   * @param cityId the locations of this city Id
   * @param sortDirection is either {@code ASC} or {@code DESC}
   * @return The list of {@code Location} of the passed {@code Province} or {@code State}
   *         and {@code City} Ids
   * @throws ProvinceNotFoundException if {@code Province} not found
   * @throws StateNotFoundException if {@code State} not found
   */
  List<Location> getAllLocations(Integer secondLevelDivisionId, Integer cityId,
      SortDirection sortDirection) throws ProvinceNotFoundException, StateNotFoundException;
  
  /**
   * Returns a location base on its location id, city id, and province/state id.
   *
   * @param secondLevelDivisionId {@code Province} or {@code State} id of the {@code Location}
   *        being searched
   * @param cityId Id of the {@code City} of the {@code Location} being searched
   * @param locationId the {@code Location} id
   * @return The {@code Location} base on its Id, city, and province/state or null if none found.
   */
  Location getLocation(Integer secondLevelDivisionId, Integer cityId, Integer locationId);

  /**
   * Returns the country this location belongs to.
   *
   * @return The {@code Country} of this location.
   */
  Country getCountry();
}
