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

package io.dhilar.phzip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.dhilar.phzip.core.Countries;
import io.dhilar.phzip.core.CountryCodes;
import io.dhilar.phzip.core.JsonCountries;


public class CountriesTest {

  private Countries jsonCountries;

  @BeforeEach
  public void setup() throws IOException {

    jsonCountries = new JsonCountries(CountryCodes.PH);
  }

  @Test
  public void getId() throws IOException {

    Integer countryId = jsonCountries.getId();

    assertEquals(new Integer(1001), countryId);
  }

  @Test
  public void getName() throws IOException {

    String countryName = jsonCountries.getName();

    assertEquals("Philippines", countryName);
  }

  @Test
  public void getAbbreviation() throws IOException {

    String abbreviatedName = jsonCountries.getAbbreviation();

    assertEquals("PH", abbreviatedName);
  }

  @Test
  public void getAlt() throws IOException {

    List<String> altNames = jsonCountries.getAlt();

    assertEquals("Phils", altNames.get(0));
  }
}
