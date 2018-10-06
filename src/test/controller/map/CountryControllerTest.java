package controller.map;

import model.map.Country;
import model.map.GeographicalMap;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * @author Mina
 * this class is made to test CountryController
 */
public class CountryControllerTest {
    CountryController countryController;
    HashMap<String, Country> countries;

    @Before
    public void initial() {
        countryController = new CountryController();
        String mapFileName = "test.map";
        GeographicalMapController geographicalMapController = new GeographicalMapController();
        GeographicalMap geographicalMap = geographicalMapController.parseMapFile(geographicalMapController.getMapPath(mapFileName));
        countries = geographicalMap.getCountries();

    }


    /**
     * method for testing the find the country and information of it
     */
    @Test
    public void testFindCountryByName() {
        Country country = countryController.findCountryByName("Quail", countries);
        assertNotNull(country);
        assertEquals(2, country.getAdjacentCountries().size());
        Country countryNull = countryController.findCountryByName("nullTest", countries);
        assertNull(countryNull);

    }


}
