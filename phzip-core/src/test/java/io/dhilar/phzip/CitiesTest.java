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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.dhilar.phzip.core.Cities;
import io.dhilar.phzip.core.CountryCodes;
import io.dhilar.phzip.core.JsonCities;
import io.dhilar.phzip.core.ProvinceNotFoundException;
import io.dhilar.phzip.core.SortDirection;
import io.dhilar.phzip.core.StateNotFoundException;
import io.dhilar.phzip.core.model.City;
import io.dhilar.phzip.core.model.Location;
import io.dhilar.phzip.core.model.Province;
import io.dhilar.phzip.core.model.State;


public class CitiesTest {

  private Cities jsonCitiesForProvince;
  private Cities jsonCitiesForState;

  @BeforeEach
  public void setup() throws IOException {
    jsonCitiesForProvince = new JsonCities(CountryCodes.PH);
    jsonCitiesForState = new JsonCities(CountryCodes.US);
  }

  @Test
  public void getCityById_ForProvince() throws IOException {
    City city = jsonCitiesForProvince.getCity(20);
    assertNotNull(city);
    assertEquals("Boliney", city.getName());
  }

  @Test
  public void getCityById_ForState() throws IOException {
    City city = jsonCitiesForState.getCity(10003);
    assertNotNull(city);
    assertEquals("Desert Hills", city.getName());
  }

  @Test
  public void getCityById_NotFound_ForProvince() throws IOException {
    City city = jsonCitiesForProvince.getCity(0);
    assertNull(city);
  }

  @Test
  public void getCityById_NotFound_ForState() throws IOException {
    City city = jsonCitiesForState.getCity(0);
    assertNull(city);
  }

  @Test
  public void getCityByProvinceIdAndCityId() throws IOException {
    City city = jsonCitiesForProvince.getCity(10001, 10002);
    assertNotNull(city);
    assertEquals("Caloocan North", city.getName());
  }

  @Test
  public void getCityByStateIdAndCityId() throws IOException {
    City city = jsonCitiesForState.getCity(10001, 10002);
    assertNotNull(city);
    assertEquals("Anthem", city.getName());
  }

  @Test
  public void getCityByProvinceIdAndCityId_ProvinceNotFound() throws IOException {
    Throwable exception = assertThrows(ProvinceNotFoundException.class, () -> {
      jsonCitiesForProvince.getCity(0, 10002);
    });
    assertEquals(exception.getMessage(), "Province not found.");
  }

  @Test
  public void getCityByStateIdAndCityId_StateNotFound() throws IOException {
    Throwable exception = assertThrows(StateNotFoundException.class, () -> {
      jsonCitiesForState.getCity(0, 10002);
    });
    assertEquals(exception.getMessage(), "State not found.");
  }

  @Test
  public void getAllCitiesOfProvince_AscendingOrder() throws IOException {

    List<City> city = jsonCitiesForProvince.getAllCities(new Province(10001), SortDirection.ASC);
    assertNotNull(city);
    assertAll("city", () -> assertEquals(new Integer(10002), city.get(0).getId()),
        () -> assertEquals("Caloocan North", city.get(0).getName()),
        () -> assertEquals("Kalookan North", city.get(0).getAlt().get(0)),
        () -> assertEquals("Caloocan South", city.get(1).getName()));

    List<Location> zipCodes = city.get(0).getLocation();

    assertAll("zip codes", () -> assertEquals(new Integer(10020), zipCodes.get(0).getId()),
        () -> assertEquals("Amparo Subdivision", zipCodes.get(0).getName()),
        () -> assertEquals("2", zipCodes.get(0).getPhones().get(0)),
        () -> assertEquals("1425", zipCodes.get(0).getZipcode()),
        () -> assertEquals(new Integer(10021), zipCodes.get(1).getId()),
        () -> assertEquals("Bagong Silang", zipCodes.get(1).getName()),
        () -> assertEquals("2", zipCodes.get(1).getPhones().get(0)),
        () -> assertEquals("1428", zipCodes.get(1).getZipcode()));
  }

  @Test
  public void getAllCitiesOfState_AscendingOrder() throws IOException {

    List<City> city = jsonCitiesForState.getAllCities(new State(10001), SortDirection.ASC);
    assertNotNull(city);
    assertAll("city",
        () -> assertEquals(new Integer(10002), city.get(0).getId()),
        () -> assertEquals("Anthem", city.get(0).getName()),
        () -> assertEquals(new Integer(10003), city.get(1).getId()),
        () -> assertEquals("Desert Hills", city.get(1).getName()),
        () -> assertEquals(new Integer(10001), city.get(2).getId()),
        () -> assertEquals("Phoenix", city.get(2).getName()));

    // TODO: Zip codes of location.
  }

  @Test
  public void getAllCitiesByProvince_DescendingOrder() throws IOException {

    List<City> city = jsonCitiesForProvince.getAllCities(new Province(10001), SortDirection.DESC);
    assertAll("city", () -> assertNotNull(city),
        () -> assertEquals("Manila", city.get(0).getName()),
        () -> assertEquals("Las Pinas", city.get(1).getName()));
  }

  @Test
  public void getAllCitiesByState_DescendingOrder() throws IOException {

    List<City> city = jsonCitiesForState.getAllCities(new State(10001), SortDirection.DESC);
    assertAll("city", () -> assertNotNull(city),
        () -> assertEquals("Phoenix", city.get(0).getName()),
        () -> assertEquals("Desert Hills", city.get(1).getName()),
        () -> assertEquals("Anthem", city.get(2).getName()));
  }

  @Test
  public void getAllCitiesByProvince_ProvinceNotFound() throws IOException {

    Throwable exception = assertThrows(ProvinceNotFoundException.class, () -> {
      jsonCitiesForProvince.getAllCities(new Province(0), SortDirection.ASC);
    });
    assertEquals(exception.getMessage(), "Province not found.");
  }

  @Test
  public void getAllCitiesByState_StateNotFound() throws IOException {

    Throwable exception = assertThrows(StateNotFoundException.class, () -> {
      jsonCitiesForState.getAllCities(new State(0), SortDirection.ASC);
    });
    assertEquals(exception.getMessage(), "State not found.");
  }

  @Test
  public void getAllCitiesByProvinceId_AscendingOrder() throws IOException {

    List<City> city = jsonCitiesForProvince.getAllCities(10001, SortDirection.ASC);
    assertNotNull(city);
    assertAll("city", () -> assertNotNull(city),
        () -> assertEquals("Caloocan North", city.get(0).getName()),
        () -> assertEquals("Caloocan South", city.get(1).getName()));
  }

  @Test
  public void getAllCitiesByStateId_AscendingOrder() throws IOException {

    List<City> city = jsonCitiesForState.getAllCities(10001, SortDirection.ASC);
    assertNotNull(city);
    assertAll("city", () -> assertNotNull(city),
        () -> assertEquals("Anthem", city.get(0).getName()),
        () -> assertEquals("Desert Hills", city.get(1).getName()),
        () -> assertEquals("Phoenix", city.get(2).getName()));
  }

  @Test
  public void getAllCitiesByProvinceId_DescendingOrder() throws IOException {

    List<City> city = jsonCitiesForProvince.getAllCities(10001, SortDirection.DESC);
    assertNotNull(city);
    assertAll("city", () -> assertNotNull(city),
        () -> assertEquals("Manila", city.get(0).getName()),
        () -> assertEquals("Las Pinas", city.get(1).getName()));
  }

  @Test
  public void getAllCitiesByStateId_DescendingOrder() throws IOException {

    List<City> city = jsonCitiesForState.getAllCities(10001, SortDirection.DESC);
    assertNotNull(city);
    assertAll("city", () -> assertNotNull(city),
        () -> assertEquals("Phoenix", city.get(0).getName()),
        () -> assertEquals("Desert Hills", city.get(1).getName()),
        () -> assertEquals("Anthem", city.get(2).getName()));
  }

  @Test
  public void getAllCitiesByProvinceId_ProvinceNotFound() throws IOException {

    Throwable exception = assertThrows(ProvinceNotFoundException.class, () -> {
      jsonCitiesForProvince.getAllCities(0, SortDirection.ASC);
    });
    assertEquals(exception.getMessage(), "Province not found.");
  }

  @Test
  public void getAllCitiesByStateId_StateNotFound() throws IOException {

    Throwable exception = assertThrows(StateNotFoundException.class, () -> {
      jsonCitiesForState.getAllCities(0, SortDirection.ASC);
    });
    assertEquals(exception.getMessage(), "State not found.");
  }
}
