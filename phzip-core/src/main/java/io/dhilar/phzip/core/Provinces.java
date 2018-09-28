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
import io.dhilar.phzip.core.model.Country;
import io.dhilar.phzip.core.model.Province;

/**
 * Defines accessors for getting details of a {@code Province}.
 */
public interface Provinces {

  /**
   * Returns list of provinces sorted by {@code SortDirection}. If capital first is {@code true}
   * then capital is shown first.
   *
   * @param sortDir is either {@code ASC} or {@code DESC}.
   * @param capitalFirst if {@code true} then capital is shown first.
   * @return The list of {@code Province}.
   */
  List<Province> getAllProvinces(SortDirection sortDir, Boolean capitalFirst);

  /**
   * Returns a province base on its id.
   *
   * @param id of the {@code Province}.
   * @return The {@code Province} of the Id.
   */
  Province getProvinceById(Integer id);

  /**
   * Returns the country this province belongs to.
   *
   * @return The {@code Country} of this province.
   */
  Country getCountry();
}
