

import java.util.ArrayList;
import java.util.List;

/**
 * Rectangle class
 * This class defines a rectangle and finds intersection points with other line.
 * It is implemented by using Lines, ArrayList.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;


    /**
     * setUpperLeft -Sets the upper left point of the rectangle.
     *
     * @param newUpperLeft - a given point
     */
    public void setUpperLeft(Point newUpperLeft) {
        this.upperLeft = newUpperLeft;
    }


    /**
     * Rectangle - constructor.
     *
     * @param upperLeft - a given point
     * @param width     - the width of the Rectangle
     * @param height    - the height of the Rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }


    /**
     * intersectionPoints - Gets the paddle as a collidables object.
     *
     * @param line - the line in question of intersecting with the Rectangle
     * @return List<Point> - a (possibly empty) list of intersected points
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> newList = new ArrayList<>();
        double x = upperLeft.getX();
        double y = upperLeft.getY();

        Line l1 = new Line(x, y, x, y + this.height);
        Line l2 = new Line(x, y, x + this.width, y);
        Line l3 = new Line(x + this.width, y, x + this.width, y + this.height);
        Line l4 = new Line(x, y + this.height, x + this.width, y + this.height);

        if (line.isIntersecting(l1)) {
            newList.add(line.intersectionWith(l1));
        }
        if (line.isIntersecting(l2)) {
            newList.add(line.intersectionWith(l2));
        }
        if (line.isIntersecting(l3)) {
            newList.add(line.intersectionWith(l3));
        }
        if (line.isIntersecting(l4)) {
            newList.add(line.intersectionWith(l4));
        }
        return newList;
    }

    /**
     * getWidth - Gets the width of the Rectangle.
     *
     * @return double
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * getHeight - Gets the Height of the Rectangle.
     *
     * @return double
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * getUpperLeft - Returns the upper left point.
     *
     * @return Point
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}
