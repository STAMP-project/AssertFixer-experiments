package edu.illinois.library.cantaloupe.image;

/**
 * <p>Rectangle on a 2D plane with origin and dimensions. Values are stored as
 * doubles, in contrast to {@link java.awt.Rectangle}.</p>
 *
 * <p>A negative origin is allowed. Zero-dimensions are allowed, but not
 * negative ones.</p>
 */
public final class Rectangle {

    private static final double DELTA = 0.00000001;

    private double x, y;
    private Dimension dimension = new Dimension(0, 0);

    public Rectangle(double x, double y, double width, double height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    public Rectangle(int x, int y, int width, int height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    /**
     * Copy constructor.
     */
    @SuppressWarnings("CopyConstructorMissesField")
    public Rectangle(Rectangle other) {
        this(other.x(), other.y(), other.width(), other.height());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof Rectangle) {
            Rectangle other = (Rectangle) obj;
            return (Math.abs(other.x() - x()) < DELTA &&
                    Math.abs(other.y() - y()) < DELTA &&
                    Math.abs(other.width() - width()) < DELTA &&
                    Math.abs(other.height() - height()) < DELTA);
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Long.hashCode(Double.hashCode(x()) + Double.hashCode(y()) +
                Double.hashCode(width()) + Double.hashCode(height()));
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double width() {
        return dimension.width();
    }

    public double height() {
        return dimension.height();
    }

    public int intX() {
        return (int) Math.round(x);
    }

    public int intY() {
        return (int) Math.round(y);
    }

    public int intWidth() {
        return dimension.intWidth();
    }

    public int intHeight() {
        return dimension.intHeight();
    }

    public boolean intersects(Rectangle other) {
        final double x2 = x() + width();
        final double y2 = y() + height();
        final double otherX2 = other.x() + other.width();
        final double otherY2 = other.y() + other.height();

        return other.x() < x2 && other.y() < y2 &&
                otherX2 > x() && otherY2 > y();
    }

    public boolean isEmpty() {
        return dimension.isEmpty();
    }

    public Dimension size() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setX(int x) {
        setX((double) x);
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setY(int y) {
        setY((double) y);
    }

    public void setWidth(double width) {
        this.dimension.setWidth(width);
    }

    public void setWidth(int width) {
        this.dimension.setWidth(width);
    }

    public void setHeight(double height) {
        this.dimension.setHeight(height);
    }

    public void setHeight(int height) {
        this.dimension.setHeight(height);
    }

    public java.awt.Rectangle toAWTRectangle() {
        return new java.awt.Rectangle(intX(), intY(), intWidth(), intHeight());
    }

    @Override
    public String toString() {
        return String.format("%f,%f/%fx%f", x(), y(), width(), height());
    }

}
