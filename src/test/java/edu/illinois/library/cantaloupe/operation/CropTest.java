package edu.illinois.library.cantaloupe.operation;

import edu.illinois.library.cantaloupe.image.Dimension;
import edu.illinois.library.cantaloupe.image.Orientation;
import edu.illinois.library.cantaloupe.image.Rectangle;
import edu.illinois.library.cantaloupe.image.ScaleConstraint;
import edu.illinois.library.cantaloupe.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class CropTest extends BaseTest {

    private static final double DELTA = 0.0000001;

    private Crop instance;

    @Before
    public void setUp() throws Exception {
        super.setUp();

        instance = new Crop();
        assertEquals(Crop.Unit.PIXELS, instance.getUnit());
        assertEquals(0, instance.getX(), DELTA);
        assertEquals(0, instance.getY(), DELTA);
        assertEquals(0, instance.getWidth(), DELTA);
        assertEquals(0, instance.getHeight(), DELTA);
    }

    @Test
    public void pixelsConstructor() {
        instance = new Crop(5, 10, 50, 80);
        assertEquals(Crop.Unit.PIXELS, instance.getUnit());
        assertEquals(5, instance.getX(), DELTA);
        assertEquals(10, instance.getY(), DELTA);
        assertEquals(50, instance.getWidth(), DELTA);
        assertEquals(80, instance.getHeight(), DELTA);
    }

    @Test
    public void percentConstructor() {
        instance = new Crop(0.02, 0.05, 0.5, 0.8);
        assertEquals(Crop.Unit.PERCENT, instance.getUnit());
        assertEquals(0.02, instance.getX(), DELTA);
        assertEquals(0.05, instance.getY(), DELTA);
        assertEquals(0.5, instance.getWidth(), DELTA);
        assertEquals(0.8, instance.getHeight(), DELTA);
    }

    @Test
    public void applyOrientationOf0() {
        final Dimension fullSize = new Dimension(500, 250);
        instance = new Crop(100, 50, 400, 200);
        instance.applyOrientation(Orientation.ROTATE_0, fullSize);
        assertEquals(100, instance.getX(), DELTA);
        assertEquals(50, instance.getY(), DELTA);
        assertEquals(400, instance.getWidth(), DELTA);
        assertEquals(200, instance.getHeight(), DELTA);
    }

    /**
     * The crop area rotates counter-clockwise over the image to a bottom-left
     * origin.
     */
    @Test
    public void applyOrientationOf90() {
        Dimension fullSize = new Dimension(500, 250);
        instance = new Crop(100, 50, 400, 200);
        instance.applyOrientation(Orientation.ROTATE_90, fullSize);
        assertEquals(50, instance.getX(), DELTA);
        assertEquals(0, instance.getY(), DELTA);
        assertEquals(200, instance.getWidth(), DELTA);
        assertEquals(150, instance.getHeight(), DELTA);

        fullSize = new Dimension(2000, 500);
        instance = new Crop(100, 100, 1900, 200);
        instance.applyOrientation(Orientation.ROTATE_90, fullSize);
        assertEquals(100, instance.getX(), DELTA);
        assertEquals(0, instance.getY(), DELTA);
        assertEquals(200, instance.getWidth(), DELTA);
        assertEquals(400, instance.getHeight(), DELTA);
    }

    @Test
    public void applyOrientationOf180() {
        Dimension fullSize = new Dimension(500, 250);
        instance = new Crop(100, 50, 400, 200);
        instance.applyOrientation(Orientation.ROTATE_180, fullSize);
        assertEquals(0, instance.getX(), DELTA);
        assertEquals(0, instance.getY(), DELTA);
        assertEquals(400, instance.getWidth(), DELTA);
        assertEquals(200, instance.getHeight(), DELTA);
    }

    /**
     * The crop area rotates clockwise over the image to a top-right origin.
     */
    @Test
    public void applyOrientationOf270() {
        Dimension fullSize = new Dimension(500, 250);
        instance = new Crop(100, 50, 400, 200);
        instance.applyOrientation(Orientation.ROTATE_270, fullSize);
        assertEquals(250, instance.getX(), DELTA);
        assertEquals(100, instance.getY(), DELTA);
        assertEquals(200, instance.getWidth(), DELTA);
        assertEquals(150, instance.getHeight(), DELTA);

        fullSize = new Dimension(2000, 500);
        instance = new Crop(100, 100, 1900, 200);
        instance.applyOrientation(Orientation.ROTATE_270, fullSize);
        assertEquals(1700, instance.getX(), DELTA);
        assertEquals(100, instance.getY(), DELTA);
        assertEquals(200, instance.getWidth(), DELTA);
        assertEquals(400, instance.getHeight(), DELTA);
    }

    @Test(expected = IllegalStateException.class)
    public void applyOrientationThrowsExceptionWhenFrozen() {
        instance.freeze();
        Dimension fullSize = new Dimension(500, 250);
        instance.applyOrientation(Orientation.ROTATE_90, fullSize);
    }

    @Test
    public void equalsWithEqualInstances() {
        Crop crop1 = new Crop(50, 50, 50, 50);
        Crop crop2 = new Crop(50, 50, 50, 50);
        assertEquals(crop1, crop2);

        crop1 = new Crop(50, 50, 50, 50,
                Orientation.ROTATE_90, new Dimension(300, 500));
        crop2 = new Crop(50, 50, 50, 50,
                Orientation.ROTATE_90, new Dimension(300, 500));
        assertEquals(crop1, crop2);

        crop1 = new Crop(0.1, 0.1, 0.1, 0.1);
        crop2 = new Crop(0.1, 0.1, 0.1, 0.1);
        assertEquals(crop1, crop2);
    }

    @Test
    public void equalsWithUnequalInstances() {
        Crop crop1 = new Crop(50, 50, 50, 50);
        Crop crop2 = new Crop(50, 51, 50, 50);
        assertNotEquals(crop1, crop2);

        crop1 = new Crop(50, 50, 50, 50,
                Orientation.ROTATE_90, new Dimension(300, 500));
        crop2 = new Crop(51, 50, 50, 50,
                Orientation.ROTATE_90, new Dimension(300, 500));
        assertNotEquals(crop1, crop2);

        crop1 = new Crop(0.1, 0.1, 0.1, 0.1);
        crop2 = new Crop(0.1, 0.1, 0.1, 0.2);
        assertNotEquals(crop1, crop2);
    }

    @Test
    public void getRectangle1WithFull() {
        final Dimension fullSize = new Dimension(300, 200);
        Crop crop = new Crop();
        crop.setFull(true);
        assertEquals(new Rectangle(0, 0, 300, 200),
                crop.getRectangle(fullSize));
    }

    @Test
    public void getRectangle1WithSquare() {
        final Dimension fullSize = new Dimension(300, 200);
        Crop crop = new Crop();
        crop.setShape(Crop.Shape.SQUARE);
        assertEquals(new Rectangle(50, 0, 200, 200),
                crop.getRectangle(fullSize));
    }

    @Test
    public void getRectangle1WithPixels() {
        final Dimension fullSize = new Dimension(300, 200);
        Crop crop = new Crop(20, 20, 50, 50);
        assertEquals(new Rectangle(20, 20, 50, 50),
                crop.getRectangle(fullSize));
    }

    @Test
    public void getRectangle1WithPercentage() {
        final Dimension fullSize = new Dimension(300, 200);
        Crop crop = new Crop(0.2, 0.2, 0.5, 0.5);
        crop.setUnit(Crop.Unit.PERCENT);
        assertEquals(new Rectangle(60, 40, 150, 100),
                crop.getRectangle(fullSize));
    }

    @Test
    public void getRectangle1DoesNotExceedFullSizeBounds() {
        final Dimension fullSize = new Dimension(300, 200);
        Crop crop = new Crop(200, 150, 100, 100);
        assertEquals(new Rectangle(200, 150, 100, 50),
                crop.getRectangle(fullSize));
    }

    @Test
    public void getRectangle2WithFull() {
        final Dimension fullSize = new Dimension(300, 200);
        final Crop crop = new Crop();
        crop.setFull(true);

        // scale constraint 1:1
        ScaleConstraint scaleConstraint = new ScaleConstraint(1, 1);
        assertEquals(new Rectangle(0, 0, 300, 200),
                crop.getRectangle(fullSize, scaleConstraint));

        // scale constraint 1:2
        scaleConstraint = new ScaleConstraint(1, 2);
        assertEquals(new Rectangle(0, 0, 300, 200),
                crop.getRectangle(fullSize, scaleConstraint));
    }

    @Test
    public void getRectangle2WithSquare() {
        final Dimension fullSize = new Dimension(300, 200);
        final Crop crop = new Crop();
        crop.setShape(Crop.Shape.SQUARE);

        // scale constraint 1:1
        ScaleConstraint scaleConstraint = new ScaleConstraint(1, 1);
        assertEquals(new Rectangle(50, 0, 200, 200),
                crop.getRectangle(fullSize, scaleConstraint));

        // scale constraint 1:2
        scaleConstraint = new ScaleConstraint(1, 2);
        assertEquals(new Rectangle(50, 0, 200, 200),
                crop.getRectangle(fullSize, scaleConstraint));
    }

    @Test
    public void getRectangle2WithPixels() {
        final Dimension fullSize = new Dimension(300, 200);
        Crop crop = new Crop(20, 20, 50, 50);

        // scale constraint 1:1
        ScaleConstraint scaleConstraint = new ScaleConstraint(1, 1);
        assertEquals(new Rectangle(20, 20, 50, 50),
                crop.getRectangle(fullSize, scaleConstraint));

        // scale constraint 1:2
        scaleConstraint = new ScaleConstraint(1, 2);
        assertEquals(new Rectangle(40, 40, 100, 100),
                crop.getRectangle(fullSize, scaleConstraint));
    }

    @Test
    public void getRectangle2WithPercentage() {
        final Dimension fullSize = new Dimension(300, 200);
        Crop crop = new Crop(0.2, 0.2, 0.5, 0.5);
        crop.setUnit(Crop.Unit.PERCENT);

        // scale constraint 1:1
        ScaleConstraint scaleConstraint = new ScaleConstraint(1, 1);
        assertEquals(new Rectangle(60, 40, 150, 100),
                crop.getRectangle(fullSize, scaleConstraint));

        // scale constraint 1:2
        scaleConstraint = new ScaleConstraint(1, 2);
        assertEquals(new Rectangle(60, 40, 150, 100),
                crop.getRectangle(fullSize, scaleConstraint));
    }

    @Test
    public void getRectangle2DoesNotExceedFullSizeBounds() {
        final Dimension fullSize = new Dimension(1000, 800);

        // scale constraint 1:1
        ScaleConstraint scaleConstraint = new ScaleConstraint(1, 1);
        Crop crop = new Crop(400, 400, 700, 500);
        assertEquals(new Rectangle(400, 400, 600, 400),
                crop.getRectangle(fullSize, scaleConstraint));

        // scale constraint 1:2
        scaleConstraint = new ScaleConstraint(1, 2);
        crop = new Crop(200, 200, 350, 250);
        assertEquals(new Rectangle(400, 400, 600, 400),
                crop.getRectangle(fullSize, scaleConstraint));
    }

    @Test
    public void getRectangle3WithFull() {
        final ReductionFactor rf = new ReductionFactor(2);
        final Dimension reducedSize = new Dimension(300, 200);
        final ScaleConstraint scaleConstraint = new ScaleConstraint(1, 2);
        Crop crop = new Crop();
        crop.setFull(true);
        assertEquals(new Rectangle(0, 0, 300, 200),
                crop.getRectangle(reducedSize, rf, scaleConstraint));
    }

    @Test
    public void getRectangle3WithSquare() {
        final ReductionFactor rf = new ReductionFactor(2);
        final Dimension reducedSize = new Dimension(300, 200);
        final ScaleConstraint scaleConstraint = new ScaleConstraint(1, 2);
        Crop crop = new Crop();
        crop.setShape(Crop.Shape.SQUARE);
        assertEquals(new Rectangle(50, 0, 200, 200),
                crop.getRectangle(reducedSize, rf, scaleConstraint));
    }

    @Test
    public void getRectangle3WithPixels() {
        final ReductionFactor rf = new ReductionFactor(2);
        final Dimension reducedSize = new Dimension(500, 500);
        final ScaleConstraint scaleConstraint = new ScaleConstraint(1, 4);
        final Crop crop = new Crop(100, 100, 200, 200);
        assertEquals(new Rectangle(100, 100, 200, 200),
                crop.getRectangle(reducedSize, rf, scaleConstraint));
    }

    @Test
    public void getRectangle3WithPixels2() {
        final ReductionFactor rf = new ReductionFactor();
        final Dimension reducedSize = new Dimension(2000, 2000);
        final ScaleConstraint scaleConstraint = new ScaleConstraint(1, 4);
        final Crop crop = new Crop(100, 100, 200, 200);
        assertEquals(new Rectangle(400, 400, 800, 800),
                crop.getRectangle(reducedSize, rf, scaleConstraint));
    }

    @Test
    public void getRectangle3WithPercentage() {
        final ReductionFactor rf = new ReductionFactor(2);
        final Dimension reducedSize = new Dimension(300, 200);
        final ScaleConstraint scaleConstraint = new ScaleConstraint(1, 2);
        Crop crop = new Crop(0.2, 0.2, 0.5, 0.5);
        crop.setUnit(Crop.Unit.PERCENT);

        assertEquals(new Rectangle(15, 10, 37.5, 25),
                crop.getRectangle(reducedSize, rf, scaleConstraint));
    }

    @Test
    public void getRectangle3DoesNotExceedFullSizeBounds() {
        final ReductionFactor rf = new ReductionFactor(2); // full: 1200x800
        final Dimension reducedSize = new Dimension(300, 200);
        final ScaleConstraint sc = new ScaleConstraint(1, 4); // 300x200
        Crop crop = new Crop(200, 150, 100, 100);
        assertEquals(new Rectangle(200, 150, 100, 50),
                crop.getRectangle(reducedSize, rf, sc));
    }

    @Test
    public void getResultingSizeWithFull() {
        Crop crop = new Crop();
        crop.setFull(true);

        Dimension fullSize = new Dimension(200, 200);

        // scale constraint 1:1
        ScaleConstraint scaleConstraint = new ScaleConstraint(1, 1);
        assertEquals(new Dimension(200, 200),
                crop.getResultingSize(fullSize, scaleConstraint));

        // scale constraint 1:2
        scaleConstraint = new ScaleConstraint(1, 2);
        assertEquals(new Dimension(200, 200),
                crop.getResultingSize(fullSize, scaleConstraint));
    }

    @Test
    public void getResultingSizeWithPixels() {
        Crop crop = new Crop(20, 20, 50, 50);

        Dimension fullSize = new Dimension(200, 200);

        // scale constraint 1:1
        ScaleConstraint scaleConstraint = new ScaleConstraint(1, 1);
        assertEquals(new Dimension(50, 50),
                crop.getResultingSize(fullSize, scaleConstraint));

        // scale constraint 1:2
        scaleConstraint = new ScaleConstraint(1, 2);
        assertEquals(new Dimension(100, 100),
                crop.getResultingSize(fullSize, scaleConstraint));
    }

    @Test
    public void getResultingSizeWithPercentage() {
        Crop crop = new Crop(0.2, 0.2, 0.5, 0.5);

        Dimension fullSize = new Dimension(200, 200);

        // scale constraint 1:1
        ScaleConstraint scaleConstraint = new ScaleConstraint(1, 1);
        assertEquals(new Dimension(100, 100),
                crop.getResultingSize(fullSize, scaleConstraint));

        // scale constraint 1:2
        scaleConstraint = new ScaleConstraint(1, 2);
        assertEquals(new Dimension(100, 100),
                crop.getResultingSize(fullSize, scaleConstraint));
    }

    @Test
    public void hasEffect() {
        // new instance
        Crop crop = new Crop();
        assertTrue(crop.hasEffect());
        // 100% crop
        crop = new Crop();
        crop.setUnit(Crop.Unit.PERCENT);
        crop.setWidth(1);
        crop.setHeight(1);
        assertFalse(crop.hasEffect());
        // <100% crop
        crop = new Crop();
        crop.setUnit(Crop.Unit.PERCENT);
        crop.setWidth(0.8);
        crop.setHeight(0.8);
        assertTrue(crop.hasEffect());
        // pixel crop
        crop = new Crop();
        crop.setWidth(50);
        crop.setHeight(50);
        assertTrue(crop.hasEffect());
    }

    @Test
    public void hasEffectWithArgumentsWithSquareShape() {
        Dimension fullSize = new Dimension(600, 400);
        OperationList opList = new OperationList();

        instance = new Crop();
        instance.setShape(Crop.Shape.SQUARE);
        assertTrue(instance.hasEffect(fullSize, opList));
    }

    @Test
    public void hasEffectWithArgumentsWithFullArea() {
        Dimension fullSize = new Dimension(600, 400);
        OperationList opList = new OperationList();

        instance.setWidth(600);
        instance.setHeight(400);
        assertFalse(instance.hasEffect(fullSize, opList));
    }

    @Test
    public void hasEffectWithArgumentsWithGreaterThanFullArea() {
        Dimension fullSize = new Dimension(600, 400);
        OperationList opList = new OperationList();

        instance.setWidth(800);
        instance.setHeight(600);
        assertFalse(instance.hasEffect(fullSize, opList));
    }

    @Test
    public void hasEffectWithArgumentsWithNonzeroOrigin() {
        Dimension fullSize = new Dimension(600, 400);
        OperationList opList = new OperationList();

        instance.setX(5);
        instance.setY(5);
        instance.setWidth(595);
        instance.setHeight(395);
        assertTrue(instance.hasEffect(fullSize, opList));

        instance.setWidth(600);
        instance.setHeight(400);
        assertTrue(instance.hasEffect(fullSize, opList));
    }

    @Test
    public void hasEffectWithArgumentsWithCropByPercent() {
        Dimension fullSize = new Dimension(600, 400);
        OperationList opList = new OperationList();

        instance.setUnit(Crop.Unit.PERCENT);
        instance.setX(0f);
        instance.setY(0f);
        instance.setWidth(1f);
        instance.setHeight(1f);
        assertFalse(instance.hasEffect(fullSize, opList));

        instance.setX(0f);
        instance.setY(0f);
        instance.setWidth(0.8f);
        instance.setHeight(0.8f);
        assertTrue(instance.hasEffect(fullSize, opList));

        instance.setX(0.1f);
        instance.setY(0.1f);
        instance.setWidth(1f);
        instance.setHeight(1f);
        assertTrue(instance.hasEffect(fullSize, opList));
    }

    @Test
    public void testHashCode() {
        assertEquals(instance.toString().hashCode(), instance.hashCode());
    }

    @Test
    public void setHeight() {
        float height = 50f;
        this.instance.setHeight(height);
        assertEquals(height, this.instance.getHeight(), DELTA);
    }

    @Test
    public void setHeightWithNegativeHeight() {
        try {
            this.instance.setHeight(-1f);
            fail("Expected exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Height must be a positive integer", e.getMessage());
        }
    }

    @Test
    public void setHeightWithZeroHeight() {
        try {
            instance.setHeight(0f);
            fail("Expected exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Height must be a positive integer", e.getMessage());
        }
    }

    @Test
    public void setHeightWithGreaterThan100PercentHeight() {
        try {
            instance.setUnit(Crop.Unit.PERCENT);
            instance.setHeight(1.2f);
            fail("Expected exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Height percentage must be <= 1", e.getMessage());
        }
    }

    @Test(expected = IllegalStateException.class)
    public void setHeightThrowsExceptionWhenInstanceIsFrozen() {
        instance.freeze();
        instance.setHeight(30f);
    }

    @Test(expected = IllegalStateException.class)
    public void setShapeThrowsExceptionWhenInstanceIsFrozen() {
        instance.freeze();
        instance.setShape(Crop.Shape.SQUARE);
    }

    @Test(expected = IllegalStateException.class)
    public void setUnitThrowsExceptionWhenInstanceIsFrozen() {
        instance.freeze();
        instance.setUnit(Crop.Unit.PIXELS);
    }

    @Test
    public void setWidth() {
        Float width = 50f;
        instance.setWidth(width);
        assertEquals(width, this.instance.getWidth(), DELTA);
    }

    @Test
    public void setWidthWithNegativeWidth() {
        try {
            instance.setWidth(-1f);
            fail("Expected exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Width must be a positive integer", e.getMessage());
        }
    }

    @Test
    public void setWidthWithZeroWidth() {
        try {
            instance.setWidth(0f);
            fail("Expected exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Width must be a positive integer", e.getMessage());
        }
    }

    @Test
    public void setWidthWithGreaterThan100PercentWidth() {
        try {
            instance.setUnit(Crop.Unit.PERCENT);
            instance.setWidth(1.2f);
            fail("Expected exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Width percentage must be <= 1", e.getMessage());
        }
    }

    @Test(expected = IllegalStateException.class)
    public void setWidthThrowsExceptionWhenInstanceIsFrozen() {
        instance.freeze();
        instance.setWidth(30f);
    }

    @Test
    public void setX() {
        float x = 50f;
        instance.setX(x);
        assertEquals(x, this.instance.getX(), DELTA);
    }

    @Test
    public void setXWithNegativeX() {
        try {
            instance.setX(-1f);
            fail("Expected exception");
        } catch (IllegalArgumentException e) {
            assertEquals("X must be positive", e.getMessage());
        }
    }

    @Test
    public void setXWithGreaterThan100PercentX() {
        try {
            instance.setUnit(Crop.Unit.PERCENT);
            instance.setX(1.2f);
            fail("Expected exception");
        } catch (IllegalArgumentException e) {
            assertEquals("X percentage must be <= 1", e.getMessage());
        }
    }

    @Test(expected = IllegalStateException.class)
    public void setXThrowsExceptionWhenInstanceIsFrozen() {
        instance.freeze();
        instance.setX(30f);
    }

    @Test
    public void setY() {
        float y = 50f;
        instance.setY(y);
        assertEquals(y, this.instance.getY(), DELTA);
    }

    @Test
    public void setYWithNegativeY() {
        try {
            instance.setY(-1f);
            fail("Expected exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Y must be positive", e.getMessage());
        }
    }

    @Test
    public void setYWithGreaterThan100PercentY() {
        try {
            instance.setUnit(Crop.Unit.PERCENT);
            instance.setY(1.2f);
            fail("Expected exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Y percentage must be <= 1", e.getMessage());
        }
    }

    @Test(expected = IllegalStateException.class)
    public void setYThrowsExceptionWhenInstanceIsFrozen() {
        instance.freeze();
        instance.setY(30f);
    }

    @Test
    public void testToMap() {
        final Crop crop = new Crop(25, 25, 50, 50);
        crop.setUnit(Crop.Unit.PIXELS);
        crop.setFull(false);

        Dimension fullSize = new Dimension(100, 100);
        ScaleConstraint scaleConstraint = new ScaleConstraint(1, 1);

        Map<String,Object> map = crop.toMap(fullSize, scaleConstraint);
        assertEquals(crop.getClass().getSimpleName(), map.get("class"));
        assertEquals(25, map.get("x"));
        assertEquals(25, map.get("y"));
        assertEquals(50, map.get("width"));
        assertEquals(50, map.get("height"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void toMapReturnsUnmodifiableMap() {
        Dimension fullSize = new Dimension(100, 100);
        ScaleConstraint scaleConstraint = new ScaleConstraint(1, 1);
        Map<String,Object> map = instance.toMap(fullSize, scaleConstraint);
        map.put("test", "test");
    }

    @Test
    public void testToString() {
        // full
        Crop crop = new Crop();
        crop.setFull(true);
        assertEquals("none", crop.toString());

        // square
        crop = new Crop();
        crop.setShape(Crop.Shape.SQUARE);
        assertEquals("square", crop.toString());

        // pixels
        crop = new Crop();
        crop.setWidth(50f);
        crop.setHeight(40f);
        assertEquals("0,0,50,40", crop.toString());

        // percent
        crop = new Crop();
        crop.setUnit(Crop.Unit.PERCENT);
        crop.setWidth(0.5f);
        crop.setHeight(0.4f);
        assertEquals("0%,0%,50%,40%", crop.toString());
    }

    @Test
    public void validateWithValidInstance() throws Exception {
        Dimension fullSize = new Dimension(1000, 1000);
        ScaleConstraint scaleConstraint = new ScaleConstraint(1, 1);
        instance.setWidth(100);
        instance.setHeight(100);
        instance.validate(fullSize, scaleConstraint);
    }

    @Test(expected = ValidationException.class)
    public void validateWithOutOfBoundsCropX() throws Exception {
        Dimension fullSize = new Dimension(1000, 1000);
        ScaleConstraint scaleConstraint = new ScaleConstraint(1, 1);
        Crop crop = new Crop(1001, 0, 5, 5);
        crop.validate(fullSize, scaleConstraint);
    }

    @Test(expected = ValidationException.class)
    public void validateWithOutOfBoundsCropY() throws Exception {
        Dimension fullSize = new Dimension(1000, 1000);
        ScaleConstraint scaleConstraint = new ScaleConstraint(1, 1);
        Crop crop = new Crop(0, 1001, 5, 5);
        crop.validate(fullSize, scaleConstraint);
    }

    @Test(expected = ValidationException.class)
    public void validateWithZeroDimensionCropX() throws Exception {
        Dimension fullSize = new Dimension(1000, 1000);
        ScaleConstraint scaleConstraint = new ScaleConstraint(1, 1);
        Crop crop = new Crop(1000, 0, 100, 100);
        crop.validate(fullSize, scaleConstraint);
    }

    @Test(expected = ValidationException.class)
    public void validateWithZeroDimensionCrop() throws Exception {
        Dimension fullSize = new Dimension(1000, 1000);
        ScaleConstraint scaleConstraint = new ScaleConstraint(1, 1);
        Crop crop = new Crop(0, 1000, 100, 100);
        crop.validate(fullSize, scaleConstraint);
    }

}
