package ru.job4j.loop;

/**
 * Шахматная доска
 *
 * @author Sergey Petrov (sergey45684745@gmail.com)
 * @version $Id$
 * @since 0.1
 *
 */

public class Board {
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (((i % 2 == 0) && (j % 2 == 0))
                        || ((i % 2 != 0) && (j % 2 != 0))) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}