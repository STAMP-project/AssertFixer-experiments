package ru.job4j.condition;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Рассчет расстояния между двумя точками в системе координат.
 */
public class Point {
    private int x;
    private int y;

    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point that) {
        Point a = this;
        Point b = that;
        int x1 = a.x;
        int y1 = a.y;
        int x2 = b.x;
        int y2 = b.y;
        double result = Math.sqrt(
                Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)
        );
        return result;
    }

    public static void main(String[] args) {
        Point a = new Point(8, 4);
        Point b = new Point(22, 10);
        a.distanceTo(b);
    }
}