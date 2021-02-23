

import java.util.ArrayList;
import java.util.List;


/**
 * GameEnvironment class - sets game environment.
 * <p>
 * implemented by a list of collidables
 */
public class GameEnvironment {
    private List<Collidable> collidables = new ArrayList<>();
    private Paddle paddle;

    /**
     * retrieves the list contains all the collidables.
     *
     * @return List of collidables
     */
    public List<Collidable> getCollidables() {
        return collidables;
    }


    /**
     * setPaddle.
     *
     * @param newPaddle a paddle
     */

    public void setPaddle(Paddle newPaddle) {
        this.paddle = newPaddle;
    }

    /**
     * getPaddle.
     *
     * @return Paddle a paddle.
     */

    public Paddle getPaddle() {
        return paddle;
    }

    /**
     * adds a given collidable to the list.
     *
     * @param c - a given collidable
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }


    /**
     * getClosestCollision - retrieves the closest collisionInfo
     * <p>
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory - a given line
     * @return CollisionInfo
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Collidable> copy = new ArrayList<>(collidables);
        CollisionInfo k = null;
        Point p;
        double x;
        double y;
        Point temp = trajectory.closestIntersectionToStartOfLine(collidables.get(0).getCollisionRectangle());
        double xPrev;
        xPrev = temp.getX();
        double yPrev = trajectory.closestIntersectionToStartOfLine(collidables.get(0).getCollisionRectangle()).getY();
        k = new CollisionInfo(trajectory.closestIntersectionToStartOfLine(collidables.get(0).getCollisionRectangle()),
                collidables.get(0));
        Rectangle r;
        double currDist = 0, newDist = 0;
        for (Collidable c : copy) {
            r = c.getCollisionRectangle();
            Point closest = trajectory.closestIntersectionToStartOfLine(r);
            if (closest != null) {
                x = closest.getX();
                y = closest.getY();
                newDist = trajectory.start().distance(new Point(x, y));
                currDist = trajectory.start().distance(new Point(xPrev, yPrev));
                if (newDist < currDist) {
                    k = new CollisionInfo(trajectory.closestIntersectionToStartOfLine(r), c);
                    xPrev = x;
                    yPrev = y;
                }

            }


        }
        return k;
    }

}
