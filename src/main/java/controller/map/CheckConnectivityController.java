package controller.map;

import model.map.Continent;
import model.map.Country;
import model.map.GeographicalMap;

import java.io.*;
import java.util.*;

/**
 * @author Mina
 * This class is made for methods of Checking the connectivity of maps
 */
public class CheckConnectivityController {


    /**
     * this method is made to check if all countries are connected or not
     *
     * @param geographicalMap
     * @return Boolean true means it is connected and false means it isn't connected
     */
    public Boolean isGraphConnectedCountries(GeographicalMap geographicalMap) {
        String fileName = "MatrixFile.txt";
        createMatrixFile(geographicalMap, fileName);
        int[][] matrixArray = createMatrixArray(fileName);
        return isGraphConnected(matrixArray);
    }


    /**
     * this method is made to check if all countries in  Continents are connected or not
     *
     * @param geographicalMap
     * @return Boolean true means it is connected and false means it isn't connected
     */
    public Boolean isGraphConnectedContinent(GeographicalMap geographicalMap) {
        String fileName = "MatrixFileContinent.txt";
        Iterator it = geographicalMap.getContinents().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Continent continent = (Continent) entry.getValue();
            createMatrixFileContinent(continent, fileName);
            int[][] matrixArray = createMatrixArray(fileName);
            if (!isGraphConnected(matrixArray)) {
                return Boolean.FALSE;//if one of the continent is unconnected there is no need to check others so we can return false
            }
        }
        return Boolean.TRUE;
    }


    /**
     * creating the matrix for checking the connectivity of graph
     *
     * @param geographicalMap
     */
    public void createMatrixFile(GeographicalMap geographicalMap, String fileName) {
        try {
            GeographicalMapController geographicalMapController = new GeographicalMapController();
            File matrixFile = new File(geographicalMapController.getMatrixFileDirectory() + "\\" + fileName);
            BufferedWriter matrixFileWriter = new BufferedWriter(new FileWriter(matrixFile));

            Iterator it = geographicalMap.getCountries().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Country country = (Country) entry.getValue();
                String line = String.valueOf(country.getOrder());
                if (country.getAdjacentCountries() != null)
                    for (Country c : country.getAdjacentCountries()) {
                        line += "," + String.valueOf(c.getOrder());
                    }
                line += System.getProperty("line.separator");
                matrixFileWriter.write(line);
            }
            matrixFileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * creating the matrix for checking the connectivity of graph in one continent
     *
     * @param continent
     */
    public void createMatrixFileContinent(Continent continent, String fileName) {
        try {
            GeographicalMapController geographicalMapController = new GeographicalMapController();
            File matrixFile = new File(geographicalMapController.getMatrixFileDirectory() + "\\" + fileName);
            BufferedWriter matrixFileWriter = new BufferedWriter(new FileWriter(matrixFile));


            Iterator it = continent.getCountries().entrySet().iterator();
            int continentOrder = 0;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Country country = (Country) entry.getValue();
                country.setContinentOrder(continentOrder++);

            }
            it = continent.getCountries().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Country country = (Country) entry.getValue();
                String line = String.valueOf(country.getContinentOrder());
                if (country.getAdjacentCountries() != null)
                    for (Country c : country.getAdjacentCountries()) {
                        if (continent.getCountries().get(c.getId()) != null)// we want to set the adjucent countries in this continent
                            line += "," + String.valueOf(c.getContinentOrder());
                    }
                line += System.getProperty("line.separator");
                matrixFileWriter.write(line);
            }
            matrixFileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public int[][] createMatrixArray(String fileName) {
        GeographicalMapController geographicalMapController = new GeographicalMapController();
        File matrixFile = new File(geographicalMapController.getMatrixFileDirectory() + "\\" + fileName);
        int n = 0;//the number of lines of file
        List<List<String>> dataList = new ArrayList<List<String>>();

        try {
            Scanner inputStream = new Scanner(matrixFile);
            while (inputStream.hasNext()) {
                String line = inputStream.next();
                String[] values = line.split(",");
                dataList.add(Arrays.asList(values));
                n++;
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        int[][] matrixArray = new int[n][n];
        for (List<String> data : dataList) {
            int id = Integer.valueOf(data.get(0));
            for (int i = 1; i < data.size(); i++) {
                matrixArray[id][Integer.valueOf(data.get(i))] = 1;
            }
        }
        return matrixArray;
    }


    /**
     * This method is made for checking the  connectivity of the Graph.
     *
     * @param matrix matrix of adjacencies
     * @return if connected return true else return false
     */
    public Boolean isGraphConnected(int[][] matrix) {

        Boolean isConnected = Boolean.FALSE;

        int length = matrix.length;
        int[] connectedArray = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (connectedArray[i] == 0 && matrix[i][j] == 1) {
                    connectedArray[i] = 1;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            if (connectedArray[i] == 1) {
                isConnected = Boolean.TRUE;
            } else {
                isConnected = Boolean.FALSE;
                break;
            }
        }
        return isConnected;

    }
}
