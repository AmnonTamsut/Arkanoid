

/**
 * Class Point.
 * The class support basic stack operations - push, top, pop, and size.
 */
public class Point {

    private double x;
    private double y;

    /**
     * Constructs a point.
     *
     * @param newX - x value.
     * @param newY - y value point coordinates.
     */
    public Point(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }

    /**
     * calculates the distance between 2 points.
     *
     * @param other - other point.
     * @return double - the distance between 2 points.
     */
    public double distance(Point other) {
        return Math.sqrt(((this.x - other.x) * (this.x - other.x)) + ((this.y - other.y) * (this.y - other.y)));

    }

    /**
     * finds if 2 points are equal.
     *
     * @param other - other point.
     * @return 'true' points are equal, 'false' otherwise.
     */
    public boolean equals(Point other) {
        return getY() == other.y && getX() == other.x;
    }

    /**
     * gets x value of a point.
     *
     * @return double - x value of a point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * gets y value of a point.
     *
     * @return double - y value of a point.
     */
    public double getY() {
        return this.y;
    }
}
