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
import io.dhilar.phzip.core.model.SecondLevelDivision;

/**
 * Defines accessors for getting details of a {@code City}.
 */
public interface Cities {

  /**
   * Returns list of cities of {@code Province} sorted by {@code SortDirection}.
   *
   * @param secondLevelDivision the cities of this province or state.
   * @param sortDirection is either {@code ASC} or {@code DESC}.
   * @return The list of {@code City} of the passed {@code Province}.
   * @throws ProvinceNotFoundException if {@code Province} not found.
   * @throws StateNotFoundException if {@code State} ID not found.
   */
  List<City> getAllCities(SecondLevelDivision secondLevelDivision, SortDirection sortDirection)
      throws ProvinceNotFoundException, StateNotFoundException;

  /**
   * Returns list of cities of {@code Province} ID sorted by {@code SortDirection}.
   *
   * @param id the {@code Province} or {@code State} ID.
   * @param sortDirection is either {@code ASC} or {@code DESC}.
   * @return The list of {@code City} of the passed {@code Province} or {@code State} ID.
   * @throws ProvinceNotFoundException if {@code Province} ID not found.
   * @throws StateNotFoundException if {@code State} ID not found.
   */
  List<City> getAllCities(Integer id, SortDirection sortDirection)
      throws ProvinceNotFoundException, StateNotFoundException;

  /**
   * Returns a city base on its id.
   *
   * @param id of the {@code City}.
   * @return The {@code City} of the Id or null if none found.
   */
  City getCity(Integer id);
  
  /**
   * Returns a city base on its id.
   *
   * @param secondLevelDivisionId {@code Province} or {@code State} id of the {@code City}
   *        being searched.
   * @param cityId of the {@code City}.
   * @return The {@code City} of the Id or null if none found.
   */
  City getCity(Integer secondLevelDivisionId, Integer cityId);

  /**
   * Returns the country this city belongs to.
   *
   * @return The {@code Country} of this city.
   */
  Country getCountry();
}
