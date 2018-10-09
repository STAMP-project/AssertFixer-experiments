package controller;

import org.junit.Before;
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.*;


/**
 *
 * This class is verify the purpose of {@link SelectPlayerController}
 *
 * @author Mahedi Hassan
 */
public class SelectPlayerControllerTest {


    private String fileDir;
    private SelectPlayerController selectPlayerController;

    /**
     *
     * Initializing the file regarding the required parameter for {@link Test}
     */
    @Before
    public void init(){
        selectPlayerController = new SelectPlayerController();
        fileDir = selectPlayerController.getFileLocation();
    }


    /**
     *
     * This method tests the correctness of the numberOfPlayers
     */

    @Test
    public void getNumberOfPlayersTest(){
        File gameHistoryFile = new File(fileDir);

        assertNotNull(fileDir);
        assertNotNull(gameHistoryFile);
        assertNotNull(selectPlayerController.getNumberOfPlayers(gameHistoryFile));
        assertTrue(selectPlayerController.getNumberOfPlayers(gameHistoryFile).length > 0); //It checks if the returned array is empty
    }
}
