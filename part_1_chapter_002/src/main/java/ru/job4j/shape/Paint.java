package  ru.job4j.shape;

/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Выводит на экран фигуру.
 */
public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}