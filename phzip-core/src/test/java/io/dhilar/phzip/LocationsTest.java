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

import io.dhilar.phzip.core.CountryCodes;
import io.dhilar.phzip.core.JsonLocations;
import io.dhilar.phzip.core.Locations;
import io.dhilar.phzip.core.ProvinceNotFoundException;
import io.dhilar.phzip.core.SortDirection;
import io.dhilar.phzip.core.StateNotFoundException;
import io.dhilar.phzip.core.model.City;
import io.dhilar.phzip.core.model.Location;
import io.dhilar.phzip.core.model.Province;
import io.dhilar.phzip.core.model.State;


public class LocationsTest {

  private Locations jsonLocationsForProvince;
  private Locations jsonLocationsForState;

  @BeforeEach
  public void setup() throws IOException {
    jsonLocationsForProvince = new JsonLocations(CountryCodes.PH);
    jsonLocationsForState = new JsonLocations(CountryCodes.US);
  }

  @Test
  public void getAllLocationsOfProvinceAndCity_AscendingOrder() throws IOException {
    List<Location> locations = jsonLocationsForProvince.getAllLocations(new Province(10001),
        new City(10001), SortDirection.ASC);
    assertNotNull(locations);
    assertAll("locations", () -> assertEquals(19, locations.size()),
        () -> assertEquals(new Integer(10001), locations.get(0).getId()),
        () -> assertEquals("Binondo", locations.get(0).getName()),
        () -> assertEquals("1006", locations.get(0).getZipcode()),
        () -> assertEquals("2", locations.get(0).getPhones().get(0)),
        () -> assertEquals(new Integer(10002), locations.get(1).getId()),
        () -> assertEquals("Intramuros", locations.get(1).getName()),
        () -> assertEquals("1002", locations.get(1).getZipcode()),
        () -> assertEquals("2", locations.get(1).getPhones().get(0)),
        () -> assertEquals(new Integer(10003), locations.get(2).getId()),
        () -> assertEquals("Malate", locations.get(2).getName()),
        () -> assertEquals("1004", locations.get(2).getZipcode()),
        () -> assertEquals("2", locations.get(2).getPhones().get(0)));
  }
  
  @Test
  public void getAllLocationsOfProvinceIdAndCityId_AscendingOrder() throws IOException {
    List<Location> locations = jsonLocationsForProvince.getAllLocations(10001,
        10001, SortDirection.ASC);
    assertNotNull(locations);
    assertAll("locations", () -> assertEquals(19, locations.size()),
        () -> assertEquals(new Integer(10001), locations.get(0).getId()),
        () -> assertEquals("Binondo", locations.get(0).getName()),
        () -> assertEquals("1006", locations.get(0).getZipcode()),
        () -> assertEquals("2", locations.get(0).getPhones().get(0)),
        () -> assertEquals(new Integer(10002), locations.get(1).getId()),
        () -> assertEquals("Intramuros", locations.get(1).getName()),
        () -> assertEquals("1002", locations.get(1).getZipcode()),
        () -> assertEquals("2", locations.get(1).getPhones().get(0)),
        () -> assertEquals(new Integer(10003), locations.get(2).getId()),
        () -> assertEquals("Malate", locations.get(2).getName()),
        () -> assertEquals("1004", locations.get(2).getZipcode()),
        () -> assertEquals("2", locations.get(2).getPhones().get(0)));
  }

  @Test
  public void getAllLocationsOfProvinceAndCity_DescendingOrder() throws IOException {
    List<Location> locations = jsonLocationsForProvince.getAllLocations(new Province(10001),
        new City(10001), SortDirection.DESC);
    assertNotNull(locations);
    assertAll("locations", () -> assertEquals(19, locations.size()),
        () -> assertEquals(new Integer(10019), locations.get(0).getId()),
        () -> assertEquals("Tondo South", locations.get(0).getName()),
        () -> assertEquals("1012", locations.get(0).getZipcode()),
        () -> assertEquals("2", locations.get(0).getPhones().get(0)),
        () -> assertEquals(new Integer(10018), locations.get(1).getId()),
        () -> assertEquals("Tondo North", locations.get(1).getName()),
        () -> assertEquals("1013", locations.get(1).getZipcode()),
        () -> assertEquals("2", locations.get(1).getPhones().get(0)),
        () -> assertEquals(new Integer(10017), locations.get(2).getId()),
        () -> assertEquals("Sta. Mesa", locations.get(2).getName()),
        () -> assertEquals("1016", locations.get(2).getZipcode()),
        () -> assertEquals("2", locations.get(2).getPhones().get(0)));
  }
  
  @Test
  public void getAllLocationsOfProvinceIdAndCityId_DescendingOrder() throws IOException {
    List<Location> locations = jsonLocationsForProvince.getAllLocations(10001,
        10001, SortDirection.DESC);
    assertNotNull(locations);
    assertAll("locations", () -> assertEquals(19, locations.size()),
        () -> assertEquals(new Integer(10019), locations.get(0).getId()),
        () -> assertEquals("Tondo South", locations.get(0).getName()),
        () -> assertEquals("1012", locations.get(0).getZipcode()),
        () -> assertEquals("2", locations.get(0).getPhones().get(0)),
        () -> assertEquals(new Integer(10018), locations.get(1).getId()),
        () -> assertEquals("Tondo North", locations.get(1).getName()),
        () -> assertEquals("1013", locations.get(1).getZipcode()),
        () -> assertEquals("2", locations.get(1).getPhones().get(0)),
        () -> assertEquals(new Integer(10017), locations.get(2).getId()),
        () -> assertEquals("Sta. Mesa", locations.get(2).getName()),
        () -> assertEquals("1016", locations.get(2).getZipcode()),
        () -> assertEquals("2", locations.get(2).getPhones().get(0)));
  }

  @Test
  public void getAllLocationsOfStateAndCity_AscendingOrder() throws IOException {
    List<Location> locations =
        jsonLocationsForState.getAllLocations(new State(10001), new City(10001), SortDirection.ASC);
    assertNotNull(locations);
    assertAll("locations", () -> assertEquals(3, locations.size()),
        () -> assertEquals(new Integer(1000), locations.get(0).getId()),
        () -> assertNull(locations.get(0).getName()),
        () -> assertEquals("85001", locations.get(0).getZipcode()),
        () -> assertEquals("602", locations.get(0).getPhones().get(0)),
        () -> assertEquals(new Integer(1001), locations.get(1).getId()),
        () -> assertNull(locations.get(1).getName()),
        () -> assertEquals("85002", locations.get(1).getZipcode()),
        () -> assertEquals("602", locations.get(1).getPhones().get(0)),
        () -> assertEquals(new Integer(1002), locations.get(2).getId()),
        () -> assertNull(locations.get(2).getName()),
        () -> assertEquals("85003", locations.get(2).getZipcode()),
        () -> assertEquals("480", locations.get(2).getPhones().get(0)),
        () -> assertEquals("623", locations.get(2).getPhones().get(1)),
        () -> assertEquals("602", locations.get(2).getPhones().get(2)),
        () -> assertEquals("928", locations.get(2).getPhones().get(3)));
  }
  
  @Test
  public void getAllLocationsOfStateIdAndCityId_AscendingOrder() throws IOException {
    List<Location> locations =
        jsonLocationsForState.getAllLocations(10001, 10001, SortDirection.ASC);
    assertNotNull(locations);
    assertAll("locations", () -> assertEquals(3, locations.size()),
        () -> assertEquals(new Integer(1000), locations.get(0).getId()),
        () -> assertNull(locations.get(0).getName()),
        () -> assertEquals("85001", locations.get(0).getZipcode()),
        () -> assertEquals("602", locations.get(0).getPhones().get(0)),
        () -> assertEquals(new Integer(1001), locations.get(1).getId()),
        () -> assertNull(locations.get(1).getName()),
        () -> assertEquals("85002", locations.get(1).getZipcode()),
        () -> assertEquals("602", locations.get(1).getPhones().get(0)),
        () -> assertEquals(new Integer(1002), locations.get(2).getId()),
        () -> assertNull(locations.get(2).getName()),
        () -> assertEquals("85003", locations.get(2).getZipcode()),
        () -> assertEquals("480", locations.get(2).getPhones().get(0)),
        () -> assertEquals("623", locations.get(2).getPhones().get(1)),
        () -> assertEquals("602", locations.get(2).getPhones().get(2)),
        () -> assertEquals("928", locations.get(2).getPhones().get(3)));
  }

  @Test
  public void getAllLocationsOfStateAndCity_DescendingOrder() throws IOException {
    List<Location> locations =
        jsonLocationsForState.getAllLocations(new State(10001), new City(10001), SortDirection.DESC);
    assertNotNull(locations);
    assertAll("locations", () -> assertEquals(3, locations.size()),
        () -> assertEquals(new Integer(1002), locations.get(0).getId()),
        () -> assertNull(locations.get(0).getName()),
        () -> assertEquals("85003", locations.get(0).getZipcode()),
        () -> assertEquals("480", locations.get(0).getPhones().get(0)),
        () -> assertEquals("623", locations.get(0).getPhones().get(1)),
        () -> assertEquals("602", locations.get(0).getPhones().get(2)),
        () -> assertEquals("928", locations.get(0).getPhones().get(3)),
        () -> assertEquals(new Integer(1001), locations.get(1).getId()),
        () -> assertNull(locations.get(1).getName()),
        () -> assertEquals("85002", locations.get(1).getZipcode()),
        () -> assertEquals("602", locations.get(1).getPhones().get(0)),
        () -> assertEquals(new Integer(1000), locations.get(2).getId()),
        () -> assertNull(locations.get(2).getName()),
        () -> assertEquals("85001", locations.get(2).getZipcode()),
        () -> assertEquals("602", locations.get(2).getPhones().get(0)));
  }
  
  @Test
  public void getAllLocationsOfStateIdAndCityId_DescendingOrder() throws IOException {
    List<Location> locations =
        jsonLocationsForState.getAllLocations(10001, 10001, SortDirection.DESC);
    assertNotNull(locations);
    assertAll("locations", () -> assertEquals(3, locations.size()),
        () -> assertEquals(new Integer(1002), locations.get(0).getId()),
        () -> assertNull(locations.get(0).getName()),
        () -> assertEquals("85003", locations.get(0).getZipcode()),
        () -> assertEquals("480", locations.get(0).getPhones().get(0)),
        () -> assertEquals("623", locations.get(0).getPhones().get(1)),
        () -> assertEquals("602", locations.get(0).getPhones().get(2)),
        () -> assertEquals("928", locations.get(0).getPhones().get(3)),
        () -> assertEquals(new Integer(1001), locations.get(1).getId()),
        () -> assertNull(locations.get(1).getName()),
        () -> assertEquals("85002", locations.get(1).getZipcode()),
        () -> assertEquals("602", locations.get(1).getPhones().get(0)),
        () -> assertEquals(new Integer(1000), locations.get(2).getId()),
        () -> assertNull(locations.get(2).getName()),
        () -> assertEquals("85001", locations.get(2).getZipcode()),
        () -> assertEquals("602", locations.get(2).getPhones().get(0)));
  }
  
  @Test
  public void getLocationByProvinceIdAndCityIdAndLocationId() throws IOException {
    Location location = jsonLocationsForProvince.getLocation(10001, 10001, 10002);
    assertNotNull(location);
    assertEquals("Intramuros", location.getName());
    assertEquals("1002", location.getZipcode());
    assertEquals("2", location.getPhones().get(0));
  }
  
  @Test
  public void getLocationByStateIdAndCityIdAndLocationId() throws IOException {
    Location location = jsonLocationsForState.getLocation(10001, 10001, 1002);
    assertNotNull(location);
    assertNull(location.getName());
    assertEquals("85003", location.getZipcode());
    assertEquals("480", location.getPhones().get(0));
    assertEquals("623", location.getPhones().get(1));
    assertEquals("602", location.getPhones().get(2));
    assertEquals("928", location.getPhones().get(3));
  }
  
  @Test
  public void getLocationByProvinceIdAndCityIdAndLocationId_ProvinceNotFound() throws IOException {
    Throwable exception = assertThrows(ProvinceNotFoundException.class, () -> {
      jsonLocationsForProvince.getLocation(0, 10001, 10002);
    });
    assertEquals(exception.getMessage(), "Province not found.");
  }

  @Test
  public void getCityByStateIdAndCityIdAndLocationId_StateNotFound() throws IOException {
    Throwable exception = assertThrows(StateNotFoundException.class, () -> {
      jsonLocationsForState.getLocation(0, 10001, 10002);
    });
    assertEquals(exception.getMessage(), "State not found.");
  }
}
