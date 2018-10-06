package controller.map;

import model.map.Continent;
import model.map.Country;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * @author Mina
 * This class is made for methods of related to continent
 */
public class ContinentController {


    /**
     *
     * This method is made for finding the Continent between the hashMaps of continent By name
     * @param name
     * @param continents
     * @return Continent
     */
    public Continent findContinentByName(String name, HashMap<String, Continent> continents) {
        Iterator it = continents.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry= (Map.Entry) it.next();
            Continent continent= (Continent) entry.getValue();
            if (continent.getName().equalsIgnoreCase(name)) {
                return continent;
            }
        }

        return null;
    }


}
