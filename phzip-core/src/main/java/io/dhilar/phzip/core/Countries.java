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

/**
 * Defines accessors for getting details of a {@code Country}.
 */
public interface Countries {

  /**
   * Returns Id of the country.
   *
   * @return The Id of {@code Country}.
   */
  Integer getId();

  /**
   * Returns name of the country.
   *
   * @return The name of {@code Country}
   */
  String getName();

  /**
   * Returns the abbreviation for the country.
   *
   * @return The abbreviation of {@code Country}
   */
  String getAbbreviation();

  /**
   * Returns the alternate names of the country.
   *
   * @return List of alternate names of the {@code Country}
   */
  List<String> getAlt();

  /**
   * Returns the country.
   *
   * @return The {@code Country}
   */
  Country getCountry();
}
