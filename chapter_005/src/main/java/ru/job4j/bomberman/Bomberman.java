package ru.job4j.bomberman;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Bomberman {
    final int boardX = 5;
    final int boardY = 5;
    private final ReentrantLock[][] board = new ReentrantLock[boardX][boardY];

    public Bomberman() {
        for (int i = 0; i < boardX; i++) {
            for (int j = 0; j < boardY; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
    }

    Runnable player = () -> {
        final Player player1 = new Player(0, 0);
        while (true) {
            try {
                board[player1.x][player1.y].tryLock(500, TimeUnit.MILLISECONDS);

                if (player1.x > boardX) {
                    player1.x++;
                } else if (player1.x == boardX) {
                    player1.x = 0;
                    player1.y++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    };
}
