package controller;

import controller.game.Game;

public class App {

    public static void main(String[] args) {
        Game game = new Game(gameListener);
        game.showInitView();
    }

    private static Game.GameListener gameListener = new Game.GameListener() {
        public void onGameFinished() {
            System.exit(0);
        }
    };
}
