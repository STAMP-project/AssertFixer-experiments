# Examples

Phzip core examples.

## Get all U.S. States

```java
import io.dhilar.phzip.core.CountryCodes;
import io.dhilar.phzip.core.JsonStates;
import io.dhilar.phzip.core.SortDirection;
import io.dhilar.phzip.core.States;
import io.dhilar.phzip.core.model.State;

public class StatesExample {
  @Test
  public void getAllStates_Ascending() throws IOException {

    List<State> states = jsonStates.getAllStates(SortDirection.ASC);

    assertAll("states", () -> assertEquals(55, states.size()),
        () -> assertEquals(new Integer(10001), states.get(1).getId()),
        () -> assertEquals("Arizona", states.get(1).getName()),
        () -> assertEquals("AZ", states.get(1).getAbbreviation()),
        () -> assertEquals("District of Columbia", states.get(7).getName()),
        () -> assertEquals("Washington DC", states.get(7).getAlt().get(0)),
        () -> assertEquals("Washington D.C.", states.get(7).getAlt().get(1)),
        () -> assertEquals("Wyoming", states.get(54).getName()));
  }
}
```

## Get States by ID

```java
import io.dhilar.phzip.core.CountryCodes;
import io.dhilar.phzip.core.JsonStates;
import io.dhilar.phzip.core.States;
import io.dhilar.phzip.core.model.State;

public class StatesExample {
@Test
  public void getStateById() throws IOException {

    State state = jsonStates.getStateById(10006);

    assertEquals(new Integer(10006), state.getId());
    assertEquals("District of Columbia", state.getName());
    assertEquals("Washington DC", state.getAlt().get(0));
  }
}
```

## Get all Provinces
```java
import io.dhilar.phzip.core.CountryCodes;
import io.dhilar.phzip.core.JsonProvinces;
import io.dhilar.phzip.core.Provinces;
import io.dhilar.phzip.core.model.Province;

public class ProvincesExample {
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
}
```

## Get Province by ID
```java
import io.dhilar.phzip.core.CountryCodes;
import io.dhilar.phzip.core.JsonProvinces;
import io.dhilar.phzip.core.Provinces;
import io.dhilar.phzip.core.model.Province;

public class ProvincesExample {
@Test
  public void getProvinceById() throws IOException {

    Province province = jsonProvince.getProvinceById(10062);

    assertEquals(new Integer(10062), province.getId());
    assertEquals("Quezon Province", province.getName());
    assertEquals("Quezon", province.getAlt().get(0));
  }
}
```

## Get Cities By Province/State
```java
import io.dhilar.phzip.core.Cities;
import io.dhilar.phzip.core.CountryCodes;
import io.dhilar.phzip.core.JsonCities;
import io.dhilar.phzip.core.SortDirection;
import io.dhilar.phzip.core.model.City;
import io.dhilar.phzip.core.model.Location;
import io.dhilar.phzip.core.model.Province;

public class CitiesExample {

  private Cities jsonCitiesForProvince;
  private Cities jsonCitiesForState;

  @BeforeEach
  public void setup() throws IOException {
    jsonCitiesForProvince = new JsonCities(CountryCodes.PH);
    jsonCitiesForState = new JsonCities(CountryCodes.US);
  }
  
  @Test
  public void getAllCitiesOfProvince_AscendingOrder() throws IOException {

    List<City> city = jsonCitiesForProvince.getAllCities(new Province(10001), SortDirection.ASC);
    assertNotNull(city);
    assertAll("city", () -> assertEquals(new Integer(10002), city.get(0).getId()),
        () -> assertEquals("Caloocan North", city.get(0).getName()),
        () -> assertEquals("Kalookan North", city.get(0).getAlt().get(0)),
        () -> assertEquals("Manila", city.get(1).getName()));

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
  }
}
```

## Get Cities By ID
```java
import io.dhilar.phzip.core.Cities;
import io.dhilar.phzip.core.CountryCodes;
import io.dhilar.phzip.core.JsonCities;
import io.dhilar.phzip.core.model.City;

public class CitiesExample {

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
}
```

## Get Locations By Province/State
```java
import io.dhilar.phzip.core.CountryCodes;
import io.dhilar.phzip.core.JsonLocations;
import io.dhilar.phzip.core.Locations;
import io.dhilar.phzip.core.SortDirection;
import io.dhilar.phzip.core.model.City;
import io.dhilar.phzip.core.model.Location;
import io.dhilar.phzip.core.model.Province;
import io.dhilar.phzip.core.model.State;

public class LocationExample {
  
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
        () -> assertEquals(10001, locations.get(0).getId().intValue()),
        () -> assertEquals("Binondo", locations.get(0).getName()),
        () -> assertEquals("1006", locations.get(0).getZipcode()),
        () -> assertEquals("2", locations.get(0).getPhones().get(0)),
        () -> assertEquals(10002, locations.get(1).getId().intValue()),
        () -> assertEquals("Intramuros", locations.get(1).getName()),
        () -> assertEquals("1002", locations.get(1).getZipcode()),
        () -> assertEquals("2", locations.get(1).getPhones().get(0)),
        () -> assertEquals(10003, locations.get(2).getId().intValue()),
        () -> assertEquals("Malate", locations.get(2).getName()),
        () -> assertEquals("1004", locations.get(2).getZipcode()),
        () -> assertEquals("2", locations.get(2).getPhones().get(0)));
  }
  
  @Test
  public void getAllLocationsOfStateAndCity_AscendingOrder() throws IOException {
    List<Location> locations =
        jsonLocationsForState.getAllLocations(new State(10001), new City(10001), SortDirection.ASC);
    assertNotNull(locations);
    assertAll("locations", () -> assertEquals(3, locations.size()),
        () -> assertEquals(1000, locations.get(0).getId().intValue()),
        () -> assertNull(locations.get(0).getName()),
        () -> assertEquals("85001", locations.get(0).getZipcode()),
        () -> assertEquals("602", locations.get(0).getPhones().get(0)),
        () -> assertEquals(1001, locations.get(1).getId().intValue()),
        () -> assertNull(locations.get(1).getName()),
        () -> assertEquals("85002", locations.get(1).getZipcode()),
        () -> assertEquals("602", locations.get(1).getPhones().get(0)),
        () -> assertEquals(1002, locations.get(2).getId().intValue()),
        () -> assertNull(locations.get(2).getName()),
        () -> assertEquals("85003", locations.get(2).getZipcode()),
        () -> assertEquals("480", locations.get(2).getPhones().get(0)),
        () -> assertEquals("623", locations.get(2).getPhones().get(1)),
        () -> assertEquals("602", locations.get(2).getPhones().get(2)),
        () -> assertEquals("928", locations.get(2).getPhones().get(3)));
  }
}
```

## Get Locations By Id
```java
import io.dhilar.phzip.core.CountryCodes;
import io.dhilar.phzip.core.JsonLocations;
import io.dhilar.phzip.core.Locations;
import io.dhilar.phzip.core.SortDirection;
import io.dhilar.phzip.core.model.City;
import io.dhilar.phzip.core.model.Location;
import io.dhilar.phzip.core.model.Province;
import io.dhilar.phzip.core.model.State;

public class LocationExample {
  
  private Locations jsonLocationsForProvince;
  private Locations jsonLocationsForState;

  @BeforeEach
  public void setup() throws IOException {
    jsonLocationsForProvince = new JsonLocations(CountryCodes.PH);
    jsonLocationsForState = new JsonLocations(CountryCodes.US);
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
```