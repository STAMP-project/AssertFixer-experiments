package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * This class provides the directory for game_history.txt and
 * calculates the value for player selection dropdown.
 *
 * @author Mahedi Hassan
 */

public class SelectPlayerController {

    /**
     *
     * This method calculates the number of items should be for the drop-drop of select players
     * It reads the game_history.txt file to measure the items
     *
     * @param playerFile takes file for game_history.txt
     * @return the items for select players drop-down
     */
    public String[] getNumberOfPlayers(File playerFile){
        Scanner scanner = null;
        int numberOfPlayers = 0;
        int totalCountry = 0;
        try {
            scanner = new Scanner(playerFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()){

            String tmpInfo = scanner.nextLine().trim();
            String[] tmpInfoAry = tmpInfo.split(" ");
            if (tmpInfoAry[0].contains("total_country")){
                totalCountry = Integer.parseInt(tmpInfoAry[1]);
            }
            if (tmpInfoAry[0].equals("user")){
                numberOfPlayers ++;
            }
        }
        if(numberOfPlayers == 0 && totalCountry >= 6){
            return new String[] {"2", "3", "4", "5", "6"};
        }
        else if (numberOfPlayers == 0 && totalCountry < 6){
            String[] tmpPlayers = new String[totalCountry - 1];
            for (int i = 0; i < tmpPlayers.length; i++){
                tmpPlayers [i] = i + 2 + "";
            }
            return tmpPlayers;
        }
        else {
            String[] tmpPlayers = new String[numberOfPlayers - 1];
            for (int i = 0; i < tmpPlayers.length; i++){
                tmpPlayers [i] = i + 2 + "";
            }
            return tmpPlayers;
        }
    }


    /**
     *
     * This method plays role to retrieve the file location of the Game History
     *
     * @return the directory of the game_history.txt file
     */
    public String getFileLocation(){
        String directory = System.getProperty("user.dir");
        return directory + "\\src\\main\\history\\file\\game_history.txt";
    }
}
