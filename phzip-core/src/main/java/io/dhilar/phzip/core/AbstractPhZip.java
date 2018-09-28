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

import java.io.InputStreamReader;
import java.io.Reader;
import com.google.gson.Gson;
import io.dhilar.phzip.core.model.Country;

/**
 * This class handles deserialization of json file into {@code Country}.
 */
public class AbstractPhZip {

  /**
   * The country object from deserialized JSON file.
   */
  private Country country;

  /**
   * Deserialize data from JSON file and loads into unmodifiable list.
   *
   * @param countryCode the country code to fetch.
   */
  public AbstractPhZip(final CountryCodes countryCode) {
    super();

    ClassLoader classLoader = this.getClass().getClassLoader();

    // Initial versions supports only PH.
    Reader reader =
        new InputStreamReader(classLoader.getResourceAsStream(countryCode.getDataFilename()));

    Gson gson = new Gson();
    Country countryFromJson = gson.fromJson(reader, Country.class);

    this.country = countryFromJson;
  }

  /**
   * Use this constructor if you already have the {@code Country} object to avoid repeating
   * deserialization of JSON data.
   *
   * @param theCountry the country to fetch.
   */
  public AbstractPhZip(final Country theCountry) {
    this.country = theCountry;
  }

  /**
   * Gets country deserialized from JSON country file.
   *
   * @return The {@code Country} from the deserialized JSON country file.
   */
  final Country getCountryFromJson() {
    return country;
  }
}
