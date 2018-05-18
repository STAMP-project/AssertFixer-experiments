import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {

    Circle c = new Circle();

    @Test
    public void setRadius() throws Exception{
        Circle c = new Circle();
        c.setRadius(25.0);
        double result1 = Math.round(100d * c.getFerence())/100d;
        assertEquals("157.08", Double.toString(result1));
        double result2 = Math.round(100d * c.getArea())/100d;
        assertEquals("1963.5", Double.toString(result2));
    }

    @Test
    public void setFerence() {
        Circle c = new Circle();
        c.setFerence(1000);
        double result1 = Math.round(100d * c.getRadius())/100d;
        assertEquals("159.15", Double.toString(result1));
        double result2 = Math.round(100d * c.getArea())/100d;
        assertEquals("79577.47", Double.toString(result2));
    }

    @Test
    public void setArea() {
        Circle c = new Circle();
        c.setArea(10000);
        double result1 = Math.round(100d * c.getRadius())/100d;
        assertEquals("56.42", Double.toString(result1));
        double result2 = Math.round(100d * c.getFerence())/100d;
        assertEquals("6366.2", Double.toString(result2));
    }
}