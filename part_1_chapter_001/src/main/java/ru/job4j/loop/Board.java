package ru.job4j.loop;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Рисование шахматной доски в псевдографике.
 */
public class Board {
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        int i = 0; //горизонталь
        int j = 0; //вертикаль
        for (j = 0; j < height; j++) {
            for (i = 0; i < width; i++) {
                // условие проверки, что писать пробел или X
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод на новую строку.
            screen.append(ln);
        }
        return screen.toString();
    }
}