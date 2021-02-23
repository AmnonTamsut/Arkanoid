

/**
 * defines & updates the collisionInfo.
 * <p>
 * CollisionInfo meant to inform others about a collision point and more info about the object itself
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;


    /**
     * CollisionInfo constructor.
     *
     * @param collisionPoint  - a given point in which we will collide into ,
     * @param collisionObject - the object on which we collide onto.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * retrieves the Collision point.
     *
     * @return Point
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * retrieves the Collision object.
     *
     * @return Point
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}
