package controller.map;


import model.map.GeographicalMap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Mina
 * this class is made to test CheckConnectivityController
 */
public class CheckConnectivityControllerTest {

    ContinentController continentController;
    CheckConnectivityController checkConnectivityController;


    @Before
    public void initial() {
        continentController = new ContinentController();
        checkConnectivityController = new CheckConnectivityController();
    }


    /**
     * method for testing the connectivity of Maps
     */
    @Test
    public void testIsGraphConnected() {
        GeographicalMapController geographicalMapController = new GeographicalMapController();
        String mapFileName = "test.map";
        GeographicalMap geographicalMap = geographicalMapController.parseMapFile(geographicalMapController.getMapPath(mapFileName));
        Boolean isConnected = checkConnectivityController.isGraphConnectedCountries(geographicalMap);
        Boolean isConnectedContinent = checkConnectivityController.isGraphConnectedContinent(geographicalMap);
        assertNotNull(isConnected);
        assertNotNull(isConnectedContinent);
        assertTrue(isConnected);
        assertTrue(isConnectedContinent);



         mapFileName = "unconnectedContinent.map";
        geographicalMap = geographicalMapController.parseMapFile(geographicalMapController.getMapPath(mapFileName));
        isConnected = checkConnectivityController.isGraphConnectedCountries(geographicalMap);
        isConnectedContinent = checkConnectivityController.isGraphConnectedContinent(geographicalMap);
        assertNotNull(isConnected);
        assertNotNull(isConnectedContinent);
        assertTrue(isConnected);
        assertFalse(isConnectedContinent);



         mapFileName = "unconnectedCountry.map";
        geographicalMap = geographicalMapController.parseMapFile(geographicalMapController.getMapPath(mapFileName));
        isConnected = checkConnectivityController.isGraphConnectedCountries(geographicalMap);
        isConnectedContinent = checkConnectivityController.isGraphConnectedContinent(geographicalMap);
        assertNotNull(isConnected);
        assertNotNull(isConnectedContinent);
        assertFalse(isConnected);
        assertFalse(isConnectedContinent);

    }


}
