package org.dhilario.phzip;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;
import org.apache.lucene.queryparser.classic.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.dhilar.phzip.core.CountryCodes;
import io.dhilar.phzip.core.JsonProvinces;
import io.dhilar.phzip.core.Provinces;
import io.dhilar.phzip.core.model.City;
import io.dhilar.phzip.core.model.Location;
import io.dhilar.phzip.core.model.Province;
import io.dhilario.phzip.search.AbstractSearcher;
import io.dhilario.phzip.search.ProvinceScopeSearcher;


public class ProvinceScopeSearchTest {

    private AbstractSearcher<Province> provinceScopeSearcher;

    @BeforeEach
    public void setup() throws IOException {

        Provinces jsonProvinces = new JsonProvinces(CountryCodes.PH);
        provinceScopeSearcher = new ProvinceScopeSearcher(jsonProvinces);
    }

    @Test
    public void searchProvinceFirstTermOnly_OfTwoTerms() throws IOException, ParseException {

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
                () -> assertEquals("2", locations.get(0).getPhones().get(0)),
                () -> assertEquals(10019, locations.get(18).getId().intValue()),
                () -> assertEquals("Tondo South", locations.get(18).getName()),
                () -> assertEquals("1012", locations.get(18).getZipcode()),
                () -> assertEquals("2", locations.get(18).getPhones().get(0)));
    }

    @Test
    public void searchProvinceSecondTermOnly_OfTwoTerms() throws IOException, ParseException {

        List<Province> resultList = provinceScopeSearcher.search("Province");

        assertAll("search result",
                () -> assertEquals(2, resultList.size()),
                () -> assertEquals("Mountain Province", resultList.get(0).getName()),
                () -> assertEquals("Quezon Province", resultList.get(1).getName()));
    }

    @Test
    public void searchProvinceIncompletePhrase() throws IOException, ParseException {

        List<Province> resultList = provinceScopeSearcher.search("Quez");

        assertTrue(resultList.isEmpty(), "Incomplete phrase will not match.");
    }

    @Test
    public void searchProvinceAbbreviationOnly() throws IOException, ParseException {

        List<Province> resultList = provinceScopeSearcher.search("MM");

        assertAll("search result",
                () -> assertFalse(resultList.isEmpty()),
                () -> assertEquals("Metro Manila", resultList.get(0).getName()));
    }

    @Test
    public void searchProvinceAlternateOnly() throws IOException, ParseException {

        List<Province> resultList = provinceScopeSearcher.search("M.M.");

        assertAll("search result",
                () -> assertFalse(resultList.isEmpty()),
                () -> assertEquals("Metro Manila", resultList.get(0).getName()));
    }

    @Test
    public void searchCityFirstTermOnly_OfTwoTerms() throws IOException, ParseException {

        List<Province> resultList = provinceScopeSearcher.search("Caloocan"); // 2nd term: North and South

        assertAll("search result",
                () -> assertEquals(1, resultList.size()),
                () -> assertEquals("Metro Manila", resultList.get(0).getName()));

        List<City> cities = resultList.get(0).getCities();

        assertAll("cities",
                () -> assertEquals(1, cities.size()),
                () -> assertEquals("Caloocan North", cities.get(0).getName()),
                () -> assertEquals(10002, cities.get(0).getId().intValue()));

        List<Location> locations = cities.get(0).getLocation();

        assertAll("locations",
                () -> assertEquals(10, locations.size()),
                () -> assertEquals(10020, locations.get(0).getId().intValue()),
                () -> assertEquals("Amparo Subdivision", locations.get(0).getName()),
                () -> assertEquals("1425", locations.get(0).getZipcode()),
                () -> assertEquals("2", locations.get(0).getPhones().get(0)),
                () -> assertEquals(10029, locations.get(9).getId().intValue()),
                () -> assertEquals("Victory Heights", locations.get(9).getName()),
                () -> assertEquals("1427", locations.get(9).getZipcode()),
                () -> assertEquals("2", locations.get(9).getPhones().get(0)));

    }

    @Test
    public void searchCityAlternateOnly() throws IOException, ParseException {

        List<Province> resultList = provinceScopeSearcher.search("Kalookan");

        assertAll("search result",
                () -> assertEquals(1, resultList.size()),
                () -> assertEquals("Metro Manila", resultList.get(0).getName()));

        List<City> cities = resultList.get(0).getCities();

        assertAll("cities",
                () -> assertEquals(1, cities.size()),
                () -> assertEquals("Caloocan North", cities.get(0).getName()),
                () -> assertEquals(10002, cities.get(0).getId().intValue()));

        List<Location> locations = cities.get(0).getLocation();

        assertAll("locations",
                () -> assertEquals(10, locations.size()),
                () -> assertEquals(10020, locations.get(0).getId().intValue()),
                () -> assertEquals("Amparo Subdivision", locations.get(0).getName()),
                () -> assertEquals("1425", locations.get(0).getZipcode()),
                () -> assertEquals("2", locations.get(0).getPhones().get(0)),
                () -> assertEquals(10029, locations.get(9).getId().intValue()),
                () -> assertEquals("Victory Heights", locations.get(9).getName()),
                () -> assertEquals("1427", locations.get(9).getZipcode()),
                () -> assertEquals("2", locations.get(9).getPhones().get(0)));

    }

    @Test
    public void searchCityIncompletePhrase() throws IOException, ParseException {

        List<Province> resultList = provinceScopeSearcher.search("Calooc");

        assertTrue(resultList.isEmpty(), "Incomplete phrase will not match.");
    }

    @Test
    public void searchExactCityZipCode_OneHit() throws IOException, ParseException {

    	List<Province> resultList = provinceScopeSearcher.search("2815");

    	assertAll("search result",
                () -> assertEquals(1, resultList.size()),
                () -> assertEquals("Abra", resultList.get(0).getName()));

        List<City> cities = resultList.get(0).getCities();

        assertAll("cities",
                () -> assertEquals(1, cities.size()),
                () -> assertEquals(20, cities.get(0).getId().intValue()),
                () -> assertEquals("Boliney", cities.get(0).getName()),
                () -> assertEquals("2815", cities.get(0).getZipcode()));

    }

    @Test
    public void searchLocationFirstTermOnly_OfTwoTerms() throws IOException, ParseException {

    	List<Province> resultList = provinceScopeSearcher.search("Sampaloc"); // East or West

    	assertAll("search result",
                () -> assertEquals(2, resultList.size()),
                () -> assertEquals("Metro Manila", resultList.get(0).getName()),
                () -> assertEquals("Metro Manila", resultList.get(1).getName()));

        List<City> cities1 = resultList.get(0).getCities();
        List<City> cities2 = resultList.get(1).getCities();

        assertAll("cities1",
                () -> assertEquals(1, cities1.size()),
                () -> assertEquals("Manila", cities1.get(0).getName()),
                () -> assertEquals(10001, cities1.get(0).getId().intValue()));

        assertAll("cities2",
                () -> assertEquals(1, cities2.size()),
                () -> assertEquals("Manila", cities2.get(0).getName()),
                () -> assertEquals(10001, cities2.get(0).getId().intValue()));

        List<Location> locations1 = cities1.get(0).getLocation();
        List<Location> locations2 = cities2.get(0).getLocation();

        assertAll("locations1",
                () -> assertEquals(1, locations1.size()),
                () -> assertEquals(10009, locations1.get(0).getId().intValue()),
                () -> assertEquals("Sampaloc East", locations1.get(0).getName()),
                () -> assertEquals("1008", locations1.get(0).getZipcode()),
                () -> assertEquals("2", locations1.get(0).getPhones().get(0)));

        assertAll("locations2",
                () -> assertEquals(1, locations2.size()),
                () -> assertEquals(10010, locations2.get(0).getId().intValue()),
                () -> assertEquals("Sampaloc West", locations2.get(0).getName()),
                () -> assertEquals("1015", locations2.get(0).getZipcode()),
                () -> assertEquals("2", locations2.get(0).getPhones().get(0)));
    }

    @Test
    public void searchLocationSecondTermOnly_OfTwoTerms() throws IOException, ParseException {

    	List<Province> resultList = provinceScopeSearcher.search("Leprosarium");

    	assertAll("search result",
                () -> assertEquals(1, resultList.size()),
                () -> assertEquals("Metro Manila", resultList.get(0).getName()));

        List<City> cities = resultList.get(0).getCities();

        assertAll("cities",
                () -> assertEquals(1, cities.size()),
                () -> assertEquals("Caloocan North", cities.get(0).getName()),
                () -> assertEquals(10002, cities.get(0).getId().intValue()));

        List<Location> locations = cities.get(0).getLocation();

        assertAll("locations",
                () -> assertEquals(1, locations.size()),
                () -> assertEquals(10028, locations.get(0).getId().intValue()),
                () -> assertEquals("Tala Leprosarium", locations.get(0).getName()),
                () -> assertEquals("1427", locations.get(0).getZipcode()),
                () -> assertEquals("2", locations.get(0).getPhones().get(0)));
    }

    @Test
    public void searchExactLocationZipCode_OneHit() throws IOException, ParseException {

    	List<Province> resultList = provinceScopeSearcher.search("1016");

    	assertAll("search result",
                () -> assertEquals(1, resultList.size()),
                () -> assertEquals("Metro Manila", resultList.get(0).getName()));

        List<City> cities = resultList.get(0).getCities();

        assertAll("cities",
                () -> assertEquals(1, cities.size()),
                () -> assertEquals("Manila", cities.get(0).getName()),
                () -> assertEquals(10001, cities.get(0).getId().intValue()));

        List<Location> locations = cities.get(0).getLocation();

        assertAll("locations",
                () -> assertEquals(1, locations.size()),
                () -> assertEquals(10017, locations.get(0).getId().intValue()),
                () -> assertEquals("Sta. Mesa", locations.get(0).getName()),
                () -> assertEquals("1016", locations.get(0).getZipcode()),
                () -> assertEquals("2", locations.get(0).getPhones().get(0)));
    }

    @Test
    public void searchExactLocationZipCode_TwoHits() throws IOException, ParseException {

    	List<Province> resultList = provinceScopeSearcher.search("1427");

    	assertAll("search result",
                () -> assertEquals(2, resultList.size()),
                () -> assertEquals("Metro Manila", resultList.get(0).getName()),
                () -> assertEquals("Metro Manila", resultList.get(1).getName()));

        List<City> cities1 = resultList.get(0).getCities();
        List<City> cities2 = resultList.get(1).getCities();

        assertAll("cities1",
                () -> assertEquals(1, cities1.size()),
                () -> assertEquals("Caloocan North", cities1.get(0).getName()),
                () -> assertEquals(10002, cities1.get(0).getId().intValue()));

        assertAll("cities2",
                () -> assertEquals(1, cities2.size()),
                () -> assertEquals("Caloocan North", cities2.get(0).getName()),
                () -> assertEquals(10002, cities2.get(0).getId().intValue()));

        List<Location> locations1 = cities1.get(0).getLocation();
        List<Location> locations2 = cities2.get(0).getLocation();

        assertAll("locations",
                () -> assertEquals(1, locations1.size()),
                () -> assertEquals(10028, locations1.get(0).getId().intValue()),
                () -> assertEquals("Tala Leprosarium", locations1.get(0).getName()),
                () -> assertEquals("1427", locations1.get(0).getZipcode()),
                () -> assertEquals("2", locations1.get(0).getPhones().get(0)));

        assertAll("locations2",
                () -> assertEquals(1, locations2.size()),
                () -> assertEquals(10029, locations2.get(0).getId().intValue()),
                () -> assertEquals("Victory Heights", locations2.get(0).getName()),
                () -> assertEquals("1427", locations2.get(0).getZipcode()),
                () -> assertEquals("2", locations2.get(0).getPhones().get(0)));
    }
}