package controller.map;

import model.map.Country;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This class is made for methods of related to Country
 * @author Mina
 */
public class CountryController {

    /**
     * This method is made for finding the Country between the hashMaps of Country By name
     * @param name
     * @param countries
     * @return Country
     */
    public Country findCountryByName(String name, HashMap<String, Country> countries) {
        Iterator it = countries.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry= (Map.Entry) it.next();
            Country country= (Country) entry.getValue();
            if (country.getName().equalsIgnoreCase(name)) {
                return country;
            }
        }

        return null;
    }


}
