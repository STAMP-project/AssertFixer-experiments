package controller.map;

import model.map.Continent;
import model.map.Country;
import model.map.GeographicalMap;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Mina
 * for testing the methods of class of GeographicalMapController
 */
public class GeographicalMapControllerTest {
    GeographicalMapController geographicalMapController;
    String mapFileName;
    String mapPath;
    File fileOfMap;
    GeographicalMap geographicalMap;
    CountryController countryController;
    ContinentController continentController;

    @Before
    public void initial() {
        geographicalMapController = new GeographicalMapController();
        mapFileName = "test.map";
        mapPath = geographicalMapController.getMapPath(mapFileName);
        fileOfMap = new File(mapPath);
        geographicalMap = new GeographicalMap();
        countryController = new CountryController();
        continentController = new ContinentController();
    }

    /**
     * method for testing the pars of file Completely
     */
    @Test
    public void testParseMapFile() {
        GeographicalMap geographicalMap = geographicalMapController.parseMapFile(mapPath);
        Country country = countryController.findCountryByName("Cockpit02", geographicalMap.getCountries());
        Continent continent = continentController.findContinentByName("Cockpit", geographicalMap.getContinents());

        // for testing parseMapInfo
        assertEquals("Dustwhirl", geographicalMap.getAuthor());// for testing parseMapInfo
        assertEquals(Boolean.TRUE, geographicalMap.getWarn());// for testing parseMapInfo
        assertEquals(Boolean.FALSE, geographicalMap.getWrap());// for testing parseMapInfo
        assertEquals("Aden.bmp", geographicalMap.getImageName());// for testing parseMapInfo
        assertEquals("none", geographicalMap.getScroll());

        // for testing parseCountries
        assertEquals(99, geographicalMap.getCountries().size());
        assertNotNull(country);
        assertEquals("Cockpit02", country.getName());
        assertEquals(375, country.getLongitude());
        assertEquals(658, country.getLatitude());

        // for testing parseAdjucents
        assertEquals(4, country.getAdjacentCountries().size());

        //for testing the parse continents
        assertNotNull(continent);
        assertEquals(5, continent.getControlValue());
        assertEquals("Cockpit", continent.getName());
        assertEquals(8, geographicalMap.getContinents().size());

        //for testing the  parseFileToFindCountriesByContinent
        assertEquals(9, continent.getCountries().size());
    }


    /**
     * method for testing the pars of file info
     */
    @Test
    public void testGetMapFileDirectory() {
        String mapFileDirectory = geographicalMapController.getMapFileDirectory();
        assertNotNull(mapFileDirectory);
        assertEquals(System.getProperty("user.dir") + "\\src\\main\\map\\file", mapFileDirectory);
    }

    /**
     * method for testing the getting the map path
     */
    @Test
    public void testGetMapPath() {
        String mapPath = geographicalMapController.getMapPath(mapFileName);
        assertEquals(System.getProperty("user.dir") + "\\src\\main\\map\\file\\" + mapFileName, mapPath);

    }


}
