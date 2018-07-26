package ru.job4j.shape;

/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * @version 1
 * @since 16/06/2018
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("    *    ");
        pic.append("   ***   ");
        pic.append("  *****  ");
        pic.append(" ******* ");
        pic.append("*********");
        return pic.toString();
    }
}