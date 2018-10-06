package controller.game;

import model.map.GeographicalMap;
import model.player.Player;
import view.InitialView;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;

public class Game {
    private Status status;
    private GeographicalMap map;
    private HashMap<String, Player> players;
    private GameListener gameListener;

    public interface GameListener {
        void onGameFinished();
    }

    public Game(GameListener gameListener) {
        this.players = new HashMap<String, Player>();
        this.status = Status.INITIALIZING;
        this.map = null;
        this.gameListener = gameListener;
    }

    public void showInitView() {
        InitialView initialView = new InitialView(initialWindowListener);
        initialView.show();
    }

    private void initializeMap() {
        //TODO: Set up Map
        //1. App starts by user selection of a user-saved map file.
        //2. GeographicalMap is loaded as a connected graph, which is rendered effectively to the user to enable efficient play. 3
    }

    private void setUpUsers() {
        //TODO: Set up Users
        //3. User chooses the number of players, then all countries are randomly assigned to players. 1
        //4. Players are allocated a number of initial armies, depending on the number of players. 1
    }

    private void placeArmies() {
        //5. In round-robin fashion, the players place their given armies one by one on their own countries.
    }

    enum Status {
        INITIALIZING,
        PLAYING,
        STOP
    }

    Status getStatus() {
        return status;
    }

    private WindowListener initialWindowListener = new WindowListener() {
        public void windowOpened(WindowEvent e) {
        }

        public void windowClosing(WindowEvent e) {
            Game.this.status = Status.STOP;
            gameListener.onGameFinished();
        }

        public void windowClosed(WindowEvent e) {

        }

        public void windowIconified(WindowEvent e) {

        }

        public void windowDeiconified(WindowEvent e) {

        }

        public void windowActivated(WindowEvent e) {

        }

        public void windowDeactivated(WindowEvent e) {

        }
    };
}
