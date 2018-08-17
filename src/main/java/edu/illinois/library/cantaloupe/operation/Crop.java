package edu.illinois.library.cantaloupe.operation;

import edu.illinois.library.cantaloupe.image.Orientation;
import edu.illinois.library.cantaloupe.util.StringUtil;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Encapsulates a cropping operation.</p>
 *
 * <p>Note that {@link #isFull()} should be assumed to take precedence over all
 * other properties.</p>
 */
public class Crop implements Operation {

    public enum Shape {
        ARBITRARY, SQUARE
    }

    public enum Unit {
        PERCENT, PIXELS
    }

    private static final double DELTA = 0.000001f;

    private double height = 0.0f;
    private boolean isFrozen = false;
    private boolean isFull = false;
    private Shape shape = Shape.ARBITRARY;
    private Unit unit = Unit.PIXELS;
    private double width = 0.0f;
    private double x = 0.0f;
    private double y = 0.0f;

    private void checkFrozen() {
        if (isFrozen) {
            throw new IllegalStateException("Instance is frozen.");
        }
    }

    @Override
    public void freeze() {
        isFrozen = true;
    }

    /**
     * @param rect Rectangle to imitate.
     * @return Crop instance analogous to the given rectangle.
     */
    public static Crop fromRectangle(Rectangle rect) {
        Crop crop = new Crop();
        crop.setX(rect.x);
        crop.setY(rect.y);
        crop.setWidth(rect.width);
        crop.setHeight(rect.height);
        return crop;
    }

    /**
     * No-op constructor.
     */
    public Crop() {}

    public Crop(int x, int y, int width, int height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    public Crop(int x, int y, int width, int height,
                Orientation orientation, Dimension fullSize) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        applyOrientation(orientation, fullSize);
    }

    public Crop(double x, double y, double width, double height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    /**
     * Modifies the coordinates of the instance to adapt to an image that is
     * to be treated as rotated. (As in e.g. the case of an EXIF Orientation
     * tag describing the rotation of un-rotated image data.)
     *
     * @param orientation Orientation of the image. If <code>null</code>, the
     *                    invocation will be a no-op.
     * @param fullSize    Dimensions of the un-rotated image.
     * @throws IllegalStateException If the instance is frozen.
     */
    public void applyOrientation(Orientation orientation, Dimension fullSize) {
        checkFrozen();
        if (orientation == null) {
            return;
        }
        if (!hasEffect() || getWidth() < 1 || getHeight() < 1) {
            return;
        }
        switch (orientation) {
            case ROTATE_90:
                double originalX = getX();
                setX(getY());
                double y = fullSize.height - originalX - getWidth();
                setY(y >= 0 ? y : 0);
                // Swap width and height
                double originalW = getWidth();
                setWidth(getHeight());
                setHeight(Math.min(fullSize.height - originalX, originalW));
                break;
            case ROTATE_180:
                setX(fullSize.width - getX() - getWidth());
                setY(fullSize.height - getY() - getHeight());
                break;
            case ROTATE_270:
                double originalY = getY();
                setY(getX());
                setX(fullSize.width - originalY - getHeight());
                // Swap width and height
                originalW = getWidth();
                setWidth(getHeight());
                double height = (originalW <= fullSize.height - getY()) ?
                        originalW : fullSize.height - getY();
                setHeight(height);
                break;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Crop) {
            return obj.toString().equals(toString());
        }
        return super.equals(obj);
    }

    /**
     * @return The height of the operation. If {@link #getUnit()} returns
     *         {@link Unit#PERCENT}, this will be a percentage of the full
     *         image height between 0 and 1.
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param fullSize Full-sized image dimensions.
     * @return Crop coordinates relative to the given full-sized image
     *         dimensions.
     */
    public Rectangle getRectangle(Dimension fullSize) {
        return getRectangle(fullSize, new ReductionFactor());
    }

    /**
     * @param imageSize Size of the input image, which may have been reduced.
     * @param rf Factor by which the image has been reduced.
     * @return Crop coordinates relative to the given full-sized image
     *         dimensions.
     * @throws IllegalArgumentException if {@literal imageSize} is {@literal
     *         null}.
     */
    public Rectangle getRectangle(Dimension imageSize, ReductionFactor rf) {
        if (imageSize == null) {
            throw new IllegalArgumentException("imageSize is null");
        }
        final double scale = rf.getScale();
        final double regionX = getX() * scale;
        final double regionY = getY() * scale;
        final double regionWidth = getWidth() * scale;
        final double regionHeight = getHeight() * scale;

        int x, y, requestedWidth, requestedHeight, croppedWidth,
                croppedHeight;
        if (this.isFull()) {
            x = 0;
            y = 0;
            requestedWidth = imageSize.width;
            requestedHeight = imageSize.height;
        } else if (this.getShape().equals(Crop.Shape.SQUARE)) {
            final int shortestSide =
                    Math.min(imageSize.width, imageSize.height);
            x = (imageSize.width - shortestSide) / 2;
            y = (imageSize.height - shortestSide) / 2;
            requestedWidth = requestedHeight = shortestSide;
        } else if (this.getUnit().equals(Crop.Unit.PERCENT)) {
            x = (int) Math.round(regionX * imageSize.width);
            y = (int) Math.round(regionY * imageSize.height);
            requestedWidth = (int) Math.round(regionWidth  * imageSize.width);
            requestedHeight = (int) Math.round(regionHeight * imageSize.height);
        } else {
            x = (int) Math.round(regionX);
            y = (int) Math.round(regionY);
            requestedWidth = (int) Math.round(regionWidth);
            requestedHeight = (int) Math.round(regionHeight);
        }
        // Confine width and height to the image bounds.
        croppedWidth = (x + requestedWidth > imageSize.width) ?
                imageSize.width - x : requestedWidth;
        croppedHeight = (y + requestedHeight > imageSize.height) ?
                imageSize.height - y : requestedHeight;
        return new Rectangle(x, y, croppedWidth, croppedHeight);
    }

    @Override
    public Dimension getResultingSize(Dimension fullSize) {
        return getRectangle(fullSize).getSize();
    }

    public Shape getShape() {
        return shape;
    }

    public Unit getUnit() {
        return unit;
    }

    /**
     * @return The width of the operation. If {@link #getUnit()} returns
     *         {@link Unit#PERCENT}, this will be a percentage of the full
     *         image width between 0 and 1.
     */
    public double getWidth() {
        return width;
    }

    /**
     * @return The left bounding coordinate of the operation. If
     * {@link #getUnit()} returns {@link Unit#PERCENT}, this will be a
     * percentage of the full image width between 0 and 1.
     */
    public double getX() {
        return x;
    }

    /**
     * @return The top bounding coordinate of the operation. If
     *         {@link #getUnit()} returns {@link Unit#PERCENT}, this will be a
     *         percentage of the full image height between 0 and 1.
     */
    public double getY() {
        return y;
    }

    /**
     * @return Whether the crop specifies the full source area, i.e. whether it
     *         is effectively a no-op.
     */
    public boolean isFull() {
        return isFull;
    }

    /**
     * This method may produce false positives. {@link #hasEffect(Dimension,
     * OperationList)} should be used instead where possible.
     *
     * @return Whether the crop is effectively a no-op.
     */
    @Override
    public boolean hasEffect() {
        if (isFull()) {
            return false;
        } else if (Unit.PERCENT.equals(getUnit()) &&
                Math.abs(getWidth() - 1f) < DELTA &&
                Math.abs(getHeight() - 1f) < DELTA) {
            return false;
        }
        return true;
    }

    /**
     * @param fullSize
     * @param opList
     * @return Whether the crop is effectively a no-op.
     */
    @Override
    public boolean hasEffect(Dimension fullSize, OperationList opList) {
        if (!hasEffect() && !Unit.PERCENT.equals(getUnit())) {
            return false;
        } else if (Shape.SQUARE.equals(getShape()) &&
                fullSize.width != fullSize.height) {
            return true;
        } else if (Unit.PIXELS.equals(getUnit())) {
            if (getX() > 0 || getY() > 0) {
                return true;
            } else if ((Math.abs(fullSize.width - getWidth()) > DELTA || Math.abs(fullSize.height - getHeight()) > DELTA) &&
                    (getWidth() < fullSize.width || getHeight() < fullSize.height)) {
                return true;
            }
        } else if (Unit.PERCENT.equals(getUnit())) {
            return getX() > DELTA || getY() > DELTA ||
                    Math.abs((getWidth() * fullSize.width) -
                            (getX() * fullSize.width) - fullSize.width) > DELTA ||
                    Math.abs((getHeight() * fullSize.height) -
                            (getY() * fullSize.height) - fullSize.height) > DELTA;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public void setFull(boolean isFull) {
        this.isFull = isFull;
    }

    /**
     * @param height Height to set.
     * @throws IllegalArgumentException if the given height is invalid.
     * @throws IllegalStateException    if the instance is frozen.
     */
    public void setHeight(double height) {
        checkFrozen();
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be a positive integer");
        }
        if (Unit.PERCENT.equals(getUnit()) && height > 1) {
            throw new IllegalArgumentException("Height percentage must be <= 1");
        }
        this.height = height;
    }

    /**
     * @param shape Shape to set.
     * @throws IllegalStateException If the instance is frozen.
     */
    public void setShape(Shape shape) {
        checkFrozen();
        this.shape = shape;
    }

    /**
     * @param unit Unit to set.
     * @throws IllegalStateException If the instance is frozen.
     */
    public void setUnit(Unit unit) {
        checkFrozen();
        this.unit = unit;
    }

    /**
     * @param width Width to set.
     * @throws IllegalArgumentException if the given width is invalid.
     * @throws IllegalStateException    if the instance is frozen.
     */
    public void setWidth(double width) {
        checkFrozen();
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be a positive integer");
        }
        if (Unit.PERCENT.equals(getUnit()) && width > 1) {
            throw new IllegalArgumentException("Width percentage must be <= 1");
        }
        this.width = width;
    }

    /**
     * @param x X coordinate to set.
     * @throws IllegalArgumentException If the given X coordinate is invalid.
     * @throws IllegalStateException If the instance is frozen.
     */
    public void setX(double x) {
        checkFrozen();
        if (x < 0) {
            throw new IllegalArgumentException("X must be positive");
        }
        if (Unit.PERCENT.equals(getUnit()) && x > 1) {
            throw new IllegalArgumentException("X percentage must be <= 1");
        }
        this.x = x;
    }

    /**
     * @param y Y coordinate to set.
     * @throws IllegalArgumentException If the given Y coordinate is invalid.
     * @throws IllegalStateException If the instance is frozen.
     */
    public void setY(double y) {
        checkFrozen();
        if (y < 0) {
            throw new IllegalArgumentException("Y must be positive");
        }
        if (Unit.PERCENT.equals(getUnit()) && y > 1) {
            throw new IllegalArgumentException("Y percentage must be <= 1");
        }
        this.y = y;
    }

    /**
     * @param fullSize Full size of the source image on which the operation
     *                 is being applied.
     * @return Map with <code>operation</code>, <code>x</code>, <code>y</code>,
     *         <code>width</code>, and <code>height</code> keys and integer
     *         values corresponding to the absolute crop coordinates.
     */
    @Override
    public Map<String,Object> toMap(Dimension fullSize) {
        final Rectangle rect = getRectangle(fullSize);
        final Map<String,Object> map = new HashMap<>();
        map.put("class", getClass().getSimpleName());
        map.put("x", rect.x);
        map.put("y", rect.y);
        map.put("width", rect.width);
        map.put("height", rect.height);
        return Collections.unmodifiableMap(map);
    }

    /**
     * <p>Returns a string representation of the instance, guaranteed to
     * uniquely represent the instance. The format is:</p>
     *
     * <dl>
     *     <dt>No-op</dt>
     *     <dd>none</dd>
     *     <dt>Square</dt>
     *     <dd>square</dd>
     *     <dt>Percent</dt>
     *     <dd>x%,y%,w%,h%</dd>
     *     <dt>Pixels</dt>
     *     <dd>x,y,w,h</dd>
     * </dl>
     *
     * @return String representation of the instance.
     */
    @Override
    public String toString() {
        String str = "";
        if (hasEffect()) {
            String x, y, width, height;
            if (this.getShape().equals(Shape.SQUARE)) {
                str+= "square";
            } else {
                if (this.getUnit().equals(Unit.PERCENT)) {
                    x = StringUtil.removeTrailingZeroes(getX() * 100) + "%";
                    y = StringUtil.removeTrailingZeroes(getY() * 100) + "%";
                    width = StringUtil.removeTrailingZeroes(getWidth() * 100) + "%";
                    height = StringUtil.removeTrailingZeroes(getHeight() * 100) + "%";
                } else {
                    x = Long.toString(Math.round(getX()));
                    y = Long.toString(Math.round(getY()));
                    width = StringUtil.removeTrailingZeroes(getWidth());
                    height = StringUtil.removeTrailingZeroes(getHeight());
                }
                str += String.format("%s,%s,%s,%s", x, y, width, height);
            }
        } else {
            str += "none";
        }
        return str;
    }

    /**
     * Checks the crop intersection and dimensions.
     *
     * {@inheritDoc}
     */
    @Override
    public void validate(Dimension fullSize) {
        if (!isFull()) {
            Dimension resultingSize = getResultingSize(fullSize);
            if (resultingSize.width < 1 || resultingSize.height < 1) {
                throw new IllegalArgumentException(
                        "Crop area is outside the bounds of the source image.");
            }
        }
    }

}
