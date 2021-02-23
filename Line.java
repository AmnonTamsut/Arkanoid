

import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Line.
 */
public class Line {
    private Point start;
    private Point end;
    private double dX;
    private double dY;
    private double slope;


    /**
     * constructor for a line by point start, point end.
     *
     * @param start - starting point
     * @param end   - ending point
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.dX = this.start.getX() - this.end.getX();
        this.dY = this.start.getY() - this.end.getY();
        this.slope = this.dY / this.dX;
    }

    /**
     * constructor for a line by point start, point end.
     *
     * @param x1 - starting x val of point
     * @param y1 - starting y val of point
     * @param x2 - end x val of point
     * @param y2 - end y val of point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        this.dX = this.start.getX() - this.end.getX();
        this.dY = this.start.getY() - this.end.getY();
        this.slope = this.dY / this.dX;
    }

    /**
     * finds the length of a line.
     *
     * @return double - the length
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * finds the middle point of a line.
     *
     * @return Point - the middle point
     */
    public Point middle() {
        return new Point((this.start().getX() + this.end().getX()) / 2, (this.start().getY() + this.end().getY()) / 2);
    }

    /**
     * finds the starting point of a line.
     *
     * @return Point - the starting point
     */
    public Point start() {
        return this.start;
    }

    /**
     * finds the length of a line.
     *
     * @return Point - the end point
     */
    public Point end() {
        return this.end;
    }


    /**
     * finds if lines are in range.
     *
     * @param line1 - first line
     * @param line2 - second line
     * @param point - a given point
     * @return 'true' if the lines & point are ion range, 'false' otherwise.
     */
    public boolean inRange(Line line1, Line line2, Point point) {
        if (point == null) {
            return false;
        }
        double x1StartCompare = line1.start.getX();
        double x1EndCompare = line1.end.getX();
        double y1StartCompare = line1.start.getY();
        double y1EndCompare = line1.end.getY();
        double x2StartCompare = line2.start.getX();
        double x2EndCompare = line2.end.getX();
        double y2StartCompare = line2.start.getY();
        double y2EndCompare = line2.end.getY();

        //Setting min and max for comparison
        double minX1 = min(x1StartCompare, x1EndCompare);
        double minY1 = min(y1StartCompare, y1EndCompare);
        double maxX1 = max(x1StartCompare, x1EndCompare);
        double maxY1 = max(y1StartCompare, y1EndCompare);
        double minX2 = min(x2StartCompare, x2EndCompare);
        double minY2 = min(y2StartCompare, y2EndCompare);
        double maxX2 = max(x2StartCompare, x2EndCompare);
        double maxY2 = max(y2StartCompare, y2EndCompare);

        //Logic requirement for when the line is in range
        if ((Math.round(minX1) <= Math.round(point.getX()) && Math.round(maxX1) >= Math.round(point.getX()))
                && (Math.round(minY1) <= Math.round(point.getY()) && Math.round(maxY1) >= Math.round(point.getY()))) {
            if ((Math.round(minX2) <= Math.round(point.getX()) && Math.round(maxX2) >= Math.round(point.getX()))
                    && (Math.round(minY2) <= Math.round(point.getY())
                    && Math.round(maxY2) >= Math.round(point.getY()))) {
                return true;
            }
        }
        return false;
    }

    /**
     * finds if lines intersects.
     *
     * @param other - a given line
     * @return 'true' if lines intersect, 'false' otherwise.
     */
    public boolean isIntersecting(Line other) {
        Point p1 = intersectionWith(other);
        return inRange(this, other, p1);
    }

    /**
     * finds the intersected point(s).
     *
     * @param other - other line
     * @return 'Point' - if lines intersect it returns the intersecting point, null otherwise.
     * You can further read about the math behind it here: http://tiny.cc/lineIP
     */
    // Returns the intersection point if the lines intersect,
    // and null otherwise.
    //
    public Point intersectionWith(Line other) {
        double x0 = this.start.getX();
        double y0 = this.start.getY();
        double m0 = this.slope;
        double x1 = other.start.getX();
        double y1 = other.start.getY();
        double m1 = other.slope;
        double x;
        double y;

        //When the slopes are equal - the lines can't intersect
        if (m0 == m1) {
            return null;
        }

        if (Double.isInfinite(m0)) {
            x = x0;
            y = m1 * (x - x1) + y1;
        } else if (Double.isInfinite(m1)) {
            x = x1;
            y = m0 * (x - x0) + y0;
        } else {
            //Finding X,Y intersection by the formula y=mx+n
            x = ((((m0 * x0) - (m1 * x1)) + y1) - y0) / (m0 - m1);
            y = m0 * (x - x0) + y0;
        }
        return new Point(x, y);
    }

    /**
     * finds if 2 lines are equal.
     *
     * @param other - other line.
     * @return 'true' if lines are equal - false otherwise.
     */
    public boolean equals(Line other) {

        /* if isIntersecting or the distances are not equal that means the lines are not equal. */
        if (isIntersecting(other) || other.start.distance(other.end) != this.start.distance(this.end)) {
            return false;
        }

        double x0 = this.start.getX();
        double y0 = this.start.getY();
        double m0 = this.slope;
        double x1 = other.start.getX();
        double y1 = other.start.getY();
        double m1 = other.slope;
        return -m0 * x0 + y0 == -m1 * x1 + y1;
    }


    /**
     * finds the closest Intersection To the Start Of a Line.
     *
     * @param rect - a Rectangle.
     * @return Point - the desired point.
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        double delta;
        double deltaPrev;
        Point p;
        List<Point> newList = rect.intersectionPoints(this);

        //making sure list isn't empty
        if (newList.size() == 0) {
            return null;
        }

        deltaPrev = this.start.distance(newList.get(0));
        p = newList.get(0);

        //loop meant to find the smallest delta between start
        for (Point point : newList) {

            delta = this.start.distance(point);

            //updating p
            if (deltaPrev > delta) {
                p = point;
                deltaPrev = delta;
            }
        }
        return p;
    }

}
