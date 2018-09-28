# Examples

Phzip search examples.

## Province Scope Search

```java
import io.dhilar.phzip.core.CountryCodes;
import io.dhilar.phzip.core.JsonProvinces;
import io.dhilar.phzip.core.Provinces;
import io.dhilar.phzip.core.model.City;
import io.dhilar.phzip.core.model.Location;
import io.dhilar.phzip.core.model.Province;
import io.dhilario.phzip.search.ProvinceScopeSearcher;

public class ProvinceScopeSearchExample {
    @Test
    public void searchProvinceFirstTermOnly_OfTwoTerms() throws IOException, ParseException {

        Provinces jsonProvinces = new JsonProvinces(CountryCodes.PH);

        ProvinceScopeSearcher provinceScopeSearcher = new ProvinceScopeSearcher(jsonProvinces);
        List<Province> resultList = provinceScopeSearcher.search("Metro");

        assertAll("search result",
                () -> assertEquals(1, resultList.size()),
                () -> assertEquals("Metro Manila", resultList.get(0).getName()));

        List<City> cities = resultList.get(0).getCities();

        assertAll("cities",
                () -> assertEquals(2, cities.size()),
                () -> assertEquals("Manila", cities.get(0).getName()),
                () -> assertEquals(10001, cities.get(0).getId().intValue()),
                () -> assertEquals("Caloocan North", cities.get(1).getName()),
                () -> assertEquals(10002, cities.get(1).getId().intValue()));

        List<Location> locations = cities.get(0).getLocation();

        assertAll("locations",
                () -> assertEquals(19, locations.size()),
                () -> assertEquals(10001, locations.get(0).getId().intValue()),
                () -> assertEquals("Binondo", locations.get(0).getName()),
                () -> assertEquals("1006", locations.get(0).getZipcode()),
                () -> assertEquals("2", locations.get(0).getPhone()),
                () -> assertEquals(10019, locations.get(18).getId().intValue()),
                () -> assertEquals("Tondo South", locations.get(18).getName()),
                () -> assertEquals("1012", locations.get(18).getZipcode()),
                () -> assertEquals("2", locations.get(18).getPhone()));
    }
}
```