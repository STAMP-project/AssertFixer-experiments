package controller.map;

import model.map.Continent;
import model.map.GeographicalMap;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * @author Mina
 * this class is made to test ContinentController
 */
public class ContinentControllerTest {
    ContinentController continentController;
    HashMap<String, Continent> continents;

    @Before
    public void initial() {
        continentController = new ContinentController();
        GeographicalMapController geographicalMapController = new GeographicalMapController();
        String mapFileDirectory = geographicalMapController.getMapFileDirectory();
        String mapFileName = "test.map";
        GeographicalMap geographicalMap = geographicalMapController.parseMapFile(geographicalMapController.getMapPath(mapFileName));
        continents = geographicalMap.getContinents();

    }


    /**
     * method for testing the find the country and information of it
     */
    @Test
    public void testFindContinentByName() {
        Continent continent = continentController.findContinentByName("Queensbasin", continents);
        assertNotNull(continent);
        assertEquals(5, continent.getControlValue());
        assertEquals(9, continent.getCountries().size());

        Continent continentNull = continentController.findContinentByName("TestNull", continents);
        assertNull(continentNull);

    }


}
