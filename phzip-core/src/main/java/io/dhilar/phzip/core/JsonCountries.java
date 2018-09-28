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
 * JSON persistence implementation of {@code Countries}.
 */
public class JsonCountries extends AbstractPhZip implements Countries {

  /**
   * Deserialize province data from JSON file and loads into unmodifiable list.
   *
   * @param countryCode the country code of the country to fetch.
   */
  public JsonCountries(final CountryCodes countryCode) {
    super(countryCode);
  }

  /**
   * Use this constructor if you already have the {@code Country} object to avoid repeating
   * deserialization of JSON data.
   *
   * @param country the country to fetch.
   */
  public JsonCountries(final Country country) {
    super(country);
  }

  @Override
  public final Integer getId() {

    return getCountryFromJson().getId();
  }

  @Override
  public final String getName() {

    return getCountryFromJson().getName();
  }

  @Override
  public final String getAbbreviation() {

    return getCountryFromJson().getAbbreviation();
  }

  @Override
  public final List<String> getAlt() {

    return getCountryFromJson().getAlt();
  }

  @Override
  public final Country getCountry() {
    return super.getCountryFromJson();
  }
}
