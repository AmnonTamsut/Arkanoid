

/**
 * Velocity class
 * The class calculates the delta in the x & y axis or by angle and speed and determines the velocity by it.
 * It is implemented by simple calculations.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * Velocity constructor.
     *
     * @param dx - the delta of x value
     * @param dy - the delta of y value.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * gets dx - the delta of x.
     *
     * @return double - dx value.
     */
    public double getDx() {
        return dx;
    }

    /**
     * gets dy - the delta of y.
     *
     * @return double - dy value.
     */
    public double getDy() {
        return dy;
    }

    /**
     * sets dx.
     *
     * @param newDx - a given delta x.
     */
    public void setDx(double newDx) {
        this.dx = newDx;
    }

    /**
     * sets dy.
     *
     * @param newDy - a given delta
     */
    public void setDy(double newDy) {
        this.dy = newDy;
    }

    /**
     * Converts angle and speed to velocity in regards of the X & Y axis.
     * You can read more about the calculation here: http://tiny.cc/VxVy
     *
     * @param angle - a given angle
     * @param speed - a given speed
     * @return Velocity - the calculated velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.cos(angle);
        double dy = speed * Math.sin(angle);
        return new Velocity(dx, dy);
    }


    /**
     * Take a point with position (x,y) and return a new point.
     * with position (x+dx, y+dy)
     *
     * @param p - the points that should be applied.
     * @return Point
     */
    public Point applyToPoint(Point p) {
        return new Point(this.dx + p.getX(), this.dy + p.getY());
    }
}
