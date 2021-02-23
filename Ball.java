

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.List;

/**
 * Ball creation and print class.
 * The class creates a ball and determines its validity.
 * It is implemented by using logic statements and GUI to print the ball.
 */
public class Ball implements Sprite {
    private GameEnvironment e;
    private Point center;
    private int radius;
    private int paddleW = 101;
    private Color color;
    private Velocity v;
    private int screenLen = 600;
    private int screenWid = 800;
    private int startX;
    private int startY;
    private Line trajectory;


    /**
     * constructor for a ball by coordinates, radius and color.
     *
     * @param center - center point
     * @param r      - radius
     * @param color  - desired color.
     */
    public Ball(Point center, int r, Color color) {
        this.radius = r;
        this.center = center;
        this.color = color;
        startX = 0;
        startY = 0;
    }

    /**
     * constructor for a ball by coordinates, radius and color.
     *
     * @param x     - x value
     * @param y     - y value
     * @param r     - radius
     * @param color - desired color.
     */
    public Ball(double x, double y, int r, Color color) {
        this.center = new Point(x, y);
        this.radius = r;
        this.color = color;
        startX = 0;
        startY = 0;
    }


    /**
     * constructor for a ball by coordinates, radius, color and starting point.
     *
     * @param x      - x value.
     * @param y      = y value.
     * @param r      - radius.
     * @param color  - desired color.
     * @param startX - x starting point
     * @param startY - y starting point.
     */
    public Ball(double x, double y, int r, Color color, int startX, int startY) {
        this.center = new Point(x, y);
        this.radius = r;
        this.color = color;
        this.startX = startX;
        this.startY = startY;
    }

    /**
     * getRadius.
     *
     * @return int - the radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * getX.
     *
     * @return int - the x value
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * getY.
     *
     * @return int - the y value
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * getSize.
     *
     * @return int - the radius
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * getX.
     *
     * @return Point - the centre point
     */

    public Point getCenter() {
        return center;
    }

    /**
     * getColor.
     *
     * @return color - the balls color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * getGameEnvironment.
     *
     * @return GameEnvironment - this game env
     */

    public GameEnvironment getGameEnvironment() {
        return this.e;
    }


    /**
     * setGameEnvironment.
     *
     * @param newE - a given GameEnvironment
     */
    public void setGameEnvironment(GameEnvironment newE) {
        this.e = newE;
        Block screen = new Block(new Rectangle(new Point(0, 0), screenWid, screenLen), color);
        this.e.getCollidables().add(0, screen);
    }

    /**
     * setScreenLen.
     *
     * @param newScreenLen - the screen length
     */
    public void setScreenLen(int newScreenLen) {
        this.screenLen = newScreenLen;
    }

    /**
     * setPaddleW.
     *
     * @param newPaddleW - the paddle width
     */

    public void setPaddleW(int newPaddleW) {
        this.paddleW = newPaddleW;
    }

    /**
     * setScreenWid.
     *
     * @param newScreenWid - the screen width
     */
    public void setScreenWid(int newScreenWid) {
        this.screenWid = newScreenWid;
    }


    /**
     * getScreenLen.
     *
     * @return int - the screen length
     */
    public int getScreenLen() {
        return screenLen;
    }

    /**
     * getScreenWid.
     *
     * @return int - the screen width
     */
    public int getScreenWid() {
        return screenWid;
    }


    /**
     * setVelocity.
     *
     * @param newV - a given velocity
     */
    public void setVelocity(Velocity newV) {
        this.v = newV;
    }

    /**
     * setVelocity.
     *
     * @param dx - the delta of x - axis
     * @param dy - the delta of y - axis
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }


    /**
     * getVelocity.
     *
     * @return Velocity - the balls v
     */

    public Velocity getVelocity() {
        return this.v;
    }


    /**
     * drawOn.
     * <p>
     * draw the ball on the given DrawSurface
     *
     * @param surface - a given draw surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        surface.fillCircle((int) center.getX(), (int) center.getY(), radius);
        surface.setColor(Color.GRAY);

        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
    }


    /**
     * velocityHitUpdate.
     *
     * @param c        - the collidable
     * @param colPoint - the collision point
     */
    public void velocityHitUpdate(Collidable c, Point colPoint) {

        double rectLeftX = c.getCollisionRectangle().getUpperLeft().getX();
        double rectRightX = c.getCollisionRectangle().getUpperLeft().getX() + c.getCollisionRectangle().getWidth();
        double rectTopY = c.getCollisionRectangle().getUpperLeft().getY();
        double rectBottomY = c.getCollisionRectangle().getUpperLeft().getY() + c.getCollisionRectangle().getHeight();
        double speed = Math.sqrt(this.v.getDx() * this.v.getDx() + this.v.getDy() * this.v.getDy());
        boolean l = false, r = false, u = false, d = false, hit = false;


        if (Math.abs(Math.round(this.getCenter().getX()) - Math.round(colPoint.getX())) < 25
                && Math.abs(Math.round(this.getCenter().getY()) - Math.round(colPoint.getY())) < 25) {

            //left & right side hit
            if (c.getCollisionRectangle().getWidth() != screenWid
                    || c.getCollisionRectangle().getHeight() != screenLen) {
                if (colPoint.getX() == rectLeftX) {
                    if (colPoint.getY() < rectBottomY && colPoint.getY() > rectTopY) {
                        l = true;
                    }
                }

                if (Math.round(colPoint.getX()) == Math.round(rectRightX)) {
                    if (Math.round(colPoint.getY()) < Math.round(rectBottomY)
                            && Math.round(colPoint.getY()) > Math.round(rectTopY)) {
                        r = true;
                    }
                }

                //up & bottom side hit
                if (Math.round(colPoint.getY() - rectTopY) < 5) {
                    if (Math.round(colPoint.getX()) <= Math.round(rectRightX)
                            && Math.round(colPoint.getX()) >= Math.round(rectLeftX)) {
                        u = true;
                    }
                }
                if (Math.round(colPoint.getY()) == Math.round(rectBottomY)) {
                    if (Math.round(colPoint.getX()) <= Math.round(rectRightX)
                            && Math.round(colPoint.getX()) >= Math.round(rectLeftX)) {
                        d = true;
                    }
                }

                if (l) {
                    if (Math.round(this.center.getX() + this.radius + v.getDx()) >= Math.round(rectLeftX)) {
                        hit = true;
                        v.setDx(v.getDx() * (-1));
                    }
                }

                if (r) {
                    if (Math.round(this.center.getX() - this.radius + v.getDx()) <= Math.round(rectRightX)) {
                        hit = true;
                        v.setDx(v.getDx() * (-1));
                    }
                }
                if (u) {
                    //if this rect is the paddle
                    if (c.getCollisionRectangle().getWidth() == e.getPaddle().getWidth()) {
                        double startOfPaddle, endOfPaddle, hittingX;
                        startOfPaddle = c.getCollisionRectangle().getUpperLeft().getX();
                        double part = c.getCollisionRectangle().getWidth() / 5;
                        hittingX = this.center.getX() + this.radius + v.getDy();
                        double dx, dy;
                        //case1
                        if (Math.round(hittingX) >= Math.round(startOfPaddle)
                                && Math.round(hittingX) <= Math.round(startOfPaddle + part)) {
                            if (Math.round(this.center.getY() + this.radius + v.getDy()) >= Math.round(rectTopY)) {
                                hit = true;
                                this.v = Velocity.fromAngleAndSpeed(210 * Math.PI / 180, speed);

                            }
                        }
                        //case2
                        if (Math.round(hittingX) >= Math.round(startOfPaddle + part)
                                && Math.round(hittingX) <= Math.round(startOfPaddle + 2 * part)) {
                            if (Math.round(this.center.getY() + this.radius + v.getDy()) >= Math.round(rectTopY)) {
                                hit = true;
                                this.v = Velocity.fromAngleAndSpeed(240 * Math.PI / 180, speed);

                            }

                        }
                        //case3
                        if (Math.round(hittingX) >= Math.round(startOfPaddle + 2 * part)
                                && Math.round(hittingX) <= Math.round(startOfPaddle + 3 * part)) {
                            if (Math.round(this.center.getY() + this.radius + v.getDy()) >= Math.round(rectTopY)) {
                                hit = true;
                                v.setDy(v.getDy() * (-1));
                            }
                        }
                        //case4
                        if (Math.round(hittingX) >= Math.round(startOfPaddle + 3 * part)
                                && Math.round(hittingX) <= Math.round(startOfPaddle + 4 * part)) {
                            if (Math.round(this.center.getY() + this.radius + v.getDy()) >= Math.round(rectTopY)) {
                                hit = true;
                                this.v = Velocity.fromAngleAndSpeed(300 * Math.PI / 180, speed);

                            }

                        }
                        //case5
                        if (Math.round(hittingX) >= Math.round(startOfPaddle + 4 * part)
                                && Math.round(hittingX) <= Math.round(startOfPaddle + 5 * part)) {
                            if (Math.round(this.center.getY() + this.radius + v.getDy()) >= Math.round(rectTopY)) {
                                hit = true;
                                this.v = Velocity.fromAngleAndSpeed(330 * Math.PI / 180, speed);

                            }

                        }


                    } else {
                        if (Math.round(this.center.getY() + this.radius + v.getDy()) >= Math.round(rectTopY)) {
                            hit = true;
                            v.setDy(v.getDy() * (-1));
                        }
                    }
                }
                if (d) {
                    if (Math.round(this.center.getY() - this.radius + v.getDy()) <= Math.round(rectBottomY)) {
                        hit = true;
                        v.setDy(v.getDy() * (-1));
                    }
                }
            } else {
                if (Math.round(this.center.getX() + this.v.getDx() - startX + this.radius) > this.screenWid
                        || Math.round(this.center.getX() + this.v.getDx() - startX - this.radius) < 0) {
                    hit = true;
                    this.setVelocity((-1) * this.v.getDx(), this.v.getDy());

                }

                //Changing course to -dy when balls' next move is to step out of the screen
                if (Math.round(this.center.getY() + this.v.getDy() - startY + this.radius) > screenLen
                        || Math.round(this.center.getY() + this.v.getDy() - startY - this.radius) < 0) {
                    hit = true;
                    this.setVelocity(this.v.getDx(), (-1) * this.v.getDy());
                }
            }
        }
        if (hit) {
            c.hit(this, colPoint, this.v);
        }
        this.center = this.getVelocity().applyToPoint(this.center);

    }


    /**
     * moveOneStep.
     * <p>
     * Determines what will be the next move according to screen bounds
     */
    public void moveOneStep() {
        //calculate if there is a collision, if there is activate hit on block

        this.trajectory = new Line(this.getCenter(), edgeIntersection(this.getCenter(), this.getVelocity()));
        CollisionInfo c = e.getClosestCollision(this.trajectory);
        // Rectangle rect = c.collisionObject().getCollisionRectangle();
        velocityHitUpdate(c.collisionObject(), c.collisionPoint());
    }


    /**
     * edgeIntersection.
     *
     * @param p    - a given point
     * @param newV - a given velocity
     * @return Point - the intersected point
     */
    public Point edgeIntersection(Point p, Velocity newV) {
        Line l = new Line(p, new Point(p.getX() + newV.getDx() * screenWid, p.getY() + newV.getDy() * screenLen));
        Rectangle r = new Rectangle(new Point(0, 0), screenWid, screenLen);
        List<Point> points = r.intersectionPoints(l);
        return points.get(0);
    }


    /**
     * drawAnimation.
     *
     * @param dx    - a given delta x
     * @param dy    - a given delta y
     * @param start - the start
     */
    public static void drawAnimation(Point start, double dx, double dy) {
    }


    @Override
    public void timePassed() {
        moveOneStep();
    }

    @Override
    public void addToGame(GameLevel g) {

        g.addSprite(this);
    }


    /**
     * removeFromGame.
     * <p>
     * removes a ball from the game
     *
     * @param gameLevel - a given game
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }
}



