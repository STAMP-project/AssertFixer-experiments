package controller.map;

import model.map.Continent;
import model.map.Country;
import model.map.GeographicalMap;
import view.MessagePanel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


/**
 * This class is made for methods of related to GeographicalMap
 *
 * @author Mina
 */
public class GeographicalMapController {

    /**
     * This method is made for  extracting info from mapFile and setting the country , continent and adjacent
     *
     * @param filePath
     * @return GeographicalMap
     */
    public GeographicalMap parseMapFile(String filePath) {
        GeographicalMap geographicalMap = new GeographicalMap();
        geographicalMap.setFilePath(filePath);
        File file = new File(filePath);
        parseMapInfo(file, geographicalMap);
        parseCountries(file, geographicalMap);
        //we have to parse Territories two times one for extract the countries , second for setting the adjuncies
        parseAdjucents(file, geographicalMap);
        parseContinents(file, geographicalMap);

        CheckConnectivityController checkConnectivityController=new CheckConnectivityController();
        geographicalMap.setConnected(checkConnectivityController.isGraphConnectedCountries(geographicalMap));
        geographicalMap.setConnected(checkConnectivityController.isGraphConnectedContinent(geographicalMap));

        geographicalMap.print();
        return geographicalMap;
    }

    /**
     * Parse the selected mapfile and extract and the Map info.
     *
     * @param fileOfMap       the  file of geographicalMap
     * @param geographicalMap call by refrence so we set the geographicalMap with details
     */
    private void parseMapInfo(File fileOfMap, GeographicalMap geographicalMap) {
        List<Continent> continentList = new ArrayList<Continent>();
        MessagePanel messagePanel = new MessagePanel();
        Scanner scanner = null;
        try {
            scanner = new Scanner(fileOfMap);
        } catch (FileNotFoundException e) {
            messagePanel.showErrorMessage(e.getMessage());
        }
        while (scanner.hasNext()) {
            String tmp = scanner.nextLine().trim();
            if (tmp.equalsIgnoreCase("[Map]")) {
                while (scanner.hasNextLine()) {
                    String mapInfo = scanner.nextLine().trim();
                    if (!mapInfo.equals("")
                            && mapInfo.contains("=")) {
                        String s = mapInfo.split("=")[0];
                        if ("author".equals(s)) {
                            geographicalMap.setAuthor(mapInfo.split("=")[1]);

                        } else if ("warn".equals(s)) {
                            geographicalMap.setWarn(!(mapInfo.split("=")[1]).equalsIgnoreCase("no"));

                        } else if ("image".equals(s)) {
                            geographicalMap.setImageName(mapInfo.split("=")[1]);

                        } else if ("wrap".equals(s)) {
                            geographicalMap.setWrap(!(mapInfo.split("=")[1]).equalsIgnoreCase("no"));

                        } else if ("scroll".equals(s)) {
                            geographicalMap.setScroll(mapInfo.split("=")[1]);

                        }

                    } else {
                        break;
                    }
                }
            }
        }

    }

    /**
     * Parse the selected mapfile and extract the continentList.
     *
     * @param fileOfMap       the  file of geographicalMap
     * @param geographicalMap
     */
    private void parseContinents(File fileOfMap, GeographicalMap geographicalMap) {
        HashMap<String, Continent> continents = new HashMap<String, Continent>();
        MessagePanel messagePanel = new MessagePanel();

        Scanner scanner = null;
        try {
            scanner = new Scanner(fileOfMap);
        } catch (FileNotFoundException e) {
            messagePanel.showErrorMessage(e.getMessage());
        }

        while (scanner.hasNext()) {
            String tmp = scanner.nextLine().trim();
            if (tmp.equalsIgnoreCase("[Continents]")) {
                while (scanner.hasNextLine()) {
                    String tmpC = scanner.nextLine().trim();
                    if (!tmpC.equals("") && tmpC.contains("=")) {
                        String continentName = tmpC.split("=")[0];
                        int continentControlValue = Integer.parseInt(tmpC.split("=")[1]);
                        HashMap<String, Country> countries = parseFileToFindCountriesByContinent(continentName, fileOfMap, geographicalMap);
                        Continent continent = new Continent(continentName, countries, continentControlValue);
                        continents.put(continent.getId(), continent);
                    } else {
                        break;
                    }
                }
            }
        }
        geographicalMap.setContinents(continents);


    }

    /**
     * THis method is made because for seting the field of countries in a continent ,we need to list of ccountries
     *
     * @param continentName
     * @param fileOfMap
     * @param geographicalMap
     * @return Hash map of country
     */
    private HashMap<String, Country> parseFileToFindCountriesByContinent(String continentName, File fileOfMap, GeographicalMap geographicalMap) {
        MessagePanel messagePanel = new MessagePanel();
        CountryController countryController = new CountryController();

        HashMap<String, Country> countries = new HashMap<String, Country>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(fileOfMap);
        } catch (FileNotFoundException e) {
            messagePanel.showErrorMessage(e.getMessage());
        }

        while (scanner.hasNext()) {
            String tmp = scanner.nextLine().trim();
            if (tmp.equalsIgnoreCase("[Territories]")) {
                while (scanner.hasNextLine()) {
                    String tmpC = scanner.nextLine().trim();
                    if (!tmpC.equals("") && tmpC.contains(",")) {
                        if (tmpC.split(",")[3].equalsIgnoreCase(continentName)) {

                            Country country = countryController.findCountryByName(tmpC.split(",")[0], geographicalMap.getCountries());
                            if (country != null)
                                countries.put(country.getId(), country);
                        }


                    }
                }
            }
        }

        return countries;
    }


    /**
     * This method is made for Parsing  the selected mapFile and extracting the countryList.
     *
     * @param fileOfMap       the  file of geographicalMap
     * @param geographicalMap
     */
    private void parseCountries(File fileOfMap, GeographicalMap geographicalMap) {
        MessagePanel messagePanel = new MessagePanel();

        HashMap<String, Country> countries = new HashMap<String, Country>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(fileOfMap);
        } catch (FileNotFoundException e) {
            messagePanel.showErrorMessage(e.getMessage());
        }

        while (scanner.hasNext()) {
            String tmp = scanner.nextLine().trim();
            if (tmp.equalsIgnoreCase("[Territories]")) {
                int order=0;
                while (scanner.hasNextLine()) {
                    String tmpC = scanner.nextLine().trim();
                    if (!tmpC.equals("") && tmpC.contains(",")) {
                        String countryName = tmpC.split(",")[0];
                        Country country = new Country(countryName);
                        country.setOrder(order++);
                        country.setLatitude(Integer.parseInt(tmpC.split(",")[1]));
                        country.setLongitude(Integer.parseInt(tmpC.split(",")[2]));
                        countries.put(country.getId(), country);

                    }
                }
            }
        }

        geographicalMap.setCountries(countries);


    }


    /**
     * this method is made for Parsing the selected mapFile and extract the adjacent of countries.
     *
     * @param fileOfMap       the  file of geographicalMap
     * @param geographicalMap
     */
    private void parseAdjucents(File fileOfMap, GeographicalMap geographicalMap) {
        CountryController countryController = new CountryController();
        MessagePanel messagePanel = new MessagePanel();

        HashMap<String, Country> countries = geographicalMap.getCountries();
        HashMap<String, Country> countriesEdited = new HashMap<String, Country>();//for set the adjacent in countries

        Scanner scanner = null;
        try {
            scanner = new Scanner(fileOfMap);
        } catch (FileNotFoundException e) {
            messagePanel.showErrorMessage(e.getMessage());
        }

        while (scanner.hasNext()) {
            String tmp = scanner.nextLine().trim();
            if (tmp.equalsIgnoreCase("[Territories]")) {
                while (scanner.hasNextLine()) {
                    String tmpC = scanner.nextLine().trim();
                    if (!tmpC.equals("") && tmpC.contains(",")) {
                        String[] countryInfo = tmpC.split(",");
                        String countryName = countryInfo[0];
                        Country country = countryController.findCountryByName(countryName, countries);
                        if (countryInfo.length > 4) {
                            List<Country> adjacencyList = new ArrayList<Country>();
                            for (int i = 4; i < countryInfo.length; i++) {
                                Country adjacency = countryController.findCountryByName(countryInfo[i], countries);
                                adjacencyList.add(adjacency);
                            }
                            country.setAdjacentCountries(adjacencyList);
                        }

                        countriesEdited.put(country.getId(), country);

                    }
                }
            }
        }

        geographicalMap.setCountries(countriesEdited);
    }

    /**
     * method for returning the directory of map
     *
     * @return String of the mapDirectory
     */
    private String getMapDirectory() {
        final String dir = System.getProperty("user.dir"); //getting the project current directory
        String mapDirectory = dir + "\\src\\main\\map\\";// set the directory for map files
        return mapDirectory;
    }

    /**
     * method for returning the directory of matrixFiles
     *
     * @return String of the matrixFileDirectory
     */
    public String getMatrixFileDirectory() {
        String matrixDirectory = getMapDirectory() + "matrix";// set the directory for map files
        return matrixDirectory;
    }

    /**
     * method for returning the directory of mapFiles
     *
     * @return String of the mapFileDirectory
     */
    public String getMapFileDirectory() {
        String mapDirectory = getMapDirectory()  + "file";// set the directory for map files
        return mapDirectory;
    }

    /**
     * method for returning the directory of imageFiles
     *
     * @return String of the imageFileDirectory
     */
    public String getImageFileDirectory() {
        String imageDirectory = getMapDirectory()  + "image";// set the directory for image files
        return imageDirectory;
    }

    /**
     * method for returning the absolute path of mapFiles
     *
     * @return String of the mapFileDirectory
     */
    public String getMapPath(String fileName) {
        String mapPath = getMapFileDirectory() + "\\" + fileName;
        return mapPath;
    }


}
