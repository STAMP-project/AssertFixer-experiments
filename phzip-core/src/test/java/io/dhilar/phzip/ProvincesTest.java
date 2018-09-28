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

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.dhilar.phzip.core.CountryCodes;
import io.dhilar.phzip.core.JsonProvinces;
import io.dhilar.phzip.core.NoProvinceFoundException;
import io.dhilar.phzip.core.Provinces;
import io.dhilar.phzip.core.SortDirection;
import io.dhilar.phzip.core.model.Province;


public class ProvincesTest {

  private Provinces jsonProvince;

  @BeforeEach
  public void setup() throws IOException {

    jsonProvince = new JsonProvinces(CountryCodes.PH);
  }

  @Test
  @DisplayName("Returned list of provinces are unmodifiable")
  public void getAllProvinces_UnmodifiableList() throws IOException {

    assertThrows(UnsupportedOperationException.class, () -> {
      List<Province> provinces = jsonProvince.getAllProvinces(SortDirection.ASC, true);
      provinces.add(new Province());
    });
  }

  @Test
  public void getAllProvinces_Ascending_CapitalFirst_True() throws IOException {

    List<Province> provinces = jsonProvince.getAllProvinces(SortDirection.ASC, true);

    assertAll("provinces", () -> assertEquals(81, provinces.size()),
        () -> assertEquals(new Integer(10001), provinces.get(0).getId()),
        () -> assertEquals("Metro Manila", provinces.get(0).getName()),
        () -> assertEquals("MM", provinces.get(0).getAbbreviation()),
        () -> assertEquals("Manila", provinces.get(0).getAlt().get(0)),
        () -> assertEquals("M.M.", provinces.get(0).getAlt().get(1)),
        () -> assertEquals("Abra", provinces.get(1).getName()),
        () -> assertEquals("Zamboanga Sibugay", provinces.get(80).getName()));
  }

  @Test
  public void getAllProvinces_Ascending_CapitalFirst_False() throws IOException {

    List<Province> provinces = jsonProvince.getAllProvinces(SortDirection.ASC, false);

    assertAll("provinces", () -> assertEquals(81, provinces.size()),
        () -> assertEquals("Abra", provinces.get(0).getName()),
        () -> assertEquals("Agusan del Norte", provinces.get(1).getName()),
        () -> assertEquals("Zamboanga Sibugay", provinces.get(80).getName()));
  }

  @Test
  public void getAllProvinces_Descending_CapitalFirst_True() throws IOException {

    List<Province> provinces = jsonProvince.getAllProvinces(SortDirection.DESC, true);

    assertAll("provinces", () -> assertEquals(81, provinces.size()),
        () -> assertEquals("Metro Manila", provinces.get(0).getName()),
        () -> assertEquals("Zamboanga Sibugay", provinces.get(1).getName()),
        () -> assertEquals("Abra", provinces.get(80).getName()));
  }

  @Test
  public void getAllProvinces_Descending_CapitalFirst_False() throws IOException {

    List<Province> provinces = jsonProvince.getAllProvinces(SortDirection.DESC, false);

    assertAll("provinces", () -> assertEquals(81, provinces.size()),
        () -> assertEquals("Zamboanga Sibugay", provinces.get(0).getName()),
        () -> assertEquals("Abra", provinces.get(79).getName()),
        () -> assertEquals("Metro Manila", provinces.get(80).getName()));
  }

  @Test
  public void getAllProvinces_StateNotSupported() throws IOException {

    assertThrows(NoProvinceFoundException.class, () -> {
      jsonProvince = new JsonProvinces(CountryCodes.US);
      jsonProvince.getAllProvinces(SortDirection.ASC, true);
    });
  }

  @Test
  public void getProvinceById() throws IOException {

    Province province = jsonProvince.getProvinceById(10062);

    assertEquals(new Integer(10062), province.getId());
    assertEquals("Quezon Province", province.getName());
    assertEquals("Quezon", province.getAlt().get(0));
  }

  @Test
  public void getProvinceById_StateNotSupported() throws IOException {

    assertThrows(NoProvinceFoundException.class, () -> {
      jsonProvince = new JsonProvinces(CountryCodes.US);
      jsonProvince.getProvinceById(10062);
    });
  }
}
