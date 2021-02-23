


/**
 * Collidable interface.
 */

public interface Collidable {

    /**
     * getCollisionRectangle.
     * <p>
     * Return the "collision shape" of the object.
     *
     * @return Rectangle
     */
    Rectangle getCollisionRectangle();

    /**
     * getCollisionRectangle.
     * <p>
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     *
     * @param hitter          - a given ball
     * @param collisionPoint  -  a given  colcollisionPoint
     * @param currentVelocity - a given velocity
     * @return Velocity
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

}
