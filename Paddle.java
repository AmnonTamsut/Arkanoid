

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * Manages & handles the paddle - a user controlled block.
 * <p>
 * Paddle implements Sprite, Collidable
 */
public class Paddle implements Sprite, Collidable {
    private Block paddle;
    private biuoop.KeyboardSensor keyboard;
    private int leftLim;
    private int rightLim;
    private int paddleSpeed;
    private int width = 101;
    private int height = 20;
    private Color color;


    private Point startP = new Point(300, 528);


    /**
     * Paddle - constructor.
     *
     * @param keyboardSensor - biuoop class that detects the strokes on the keyboard
     * @param leftLim        - the limit on the left
     * @param rightLim       - the limit on the right
     */
    public Paddle(biuoop.KeyboardSensor keyboardSensor, int leftLim, int rightLim) {
        paddle = new Block(new Rectangle(startP, width, height), Color.BLACK);
        this.keyboard = keyboardSensor;
        this.rightLim = rightLim;
        this.leftLim = leftLim;
    }


    /**
     * setColor.
     * <p>
     *
     * @param newColor - a color.
     *
     */

    public void setColor(Color newColor) {
        this.color = newColor;
        paddle = new Block(new Rectangle(startP, width, height), newColor);
    }

    /**
     * getWidth.
     * <p>
     *
     * @return  int - width.
     *
     */

    public int getWidth() {
        return width;
    }


    /**
     * getHeight.
     * <p>
     *
     * @return  int - height.
     *
     */

    public int getHeight() {
        return height;
    }

    /**
     * setWidth.
     * <p>
     *
     * @param newWidth -width.
     *
     */

    public void setWidth(int newWidth) {
        this.width = newWidth;
        paddle = new Block(new Rectangle(startP, newWidth, height), Color.BLACK);
    }

    /**
     * setHeight.
     * <p>
     *
     * @param newHeight -height.
     *
     */

    public void setHeight(int newHeight) {
        this.height = newHeight;
        paddle = new Block(new Rectangle(startP, width, newHeight), Color.BLACK);
    }

    /**
     * Sets setStartP.
     *
     * @param newStartP - a given point
     */
    public void setStartP(Point newStartP) {
        this.startP = newStartP;
    }

    /**
     * Sets setPaddleSpeed.
     *
     * @param newPaddleSpeed - a delta of the paddle
     */

    public void setPaddleSpeed(int newPaddleSpeed) {
        this.paddleSpeed = newPaddleSpeed;
    }


    /**
     * Sets keyboard.
     *
     * @param newKeyboard - a given biuoop.KeyboardSensor
     */
    public void setKeyboard(KeyboardSensor newKeyboard) {
        this.keyboard = newKeyboard;
    }

    /**
     * moveLeft - in charge of moving the paddle to the left.
     */
    public void moveLeft() {
        double delta = this.paddleSpeed;
        double x = paddle.getCollisionRectangle().getUpperLeft().getX() - delta;
        double y = paddle.getCollisionRectangle().getUpperLeft().getY();
        boolean flag = false;
        if (x > 50) {
            paddle.getCollisionRectangle().setUpperLeft(new Point(x, y));
            flag = true;
        }
        if (!flag) {
            if (paddle.getCollisionRectangle().getUpperLeft().getX() > 50) {
                paddle.getCollisionRectangle().setUpperLeft(new Point(50, y));
            }
        }
    }

    /**
     * moveRight - in charge of moving the paddle to the right.
     */
    public void moveRight() {
        double delta = this.paddleSpeed;
        double x = paddle.getCollisionRectangle().getUpperLeft().getX() + delta;
        double y = paddle.getCollisionRectangle().getUpperLeft().getY();
        boolean flag = false;
        if (x <= 750 - width) {
            paddle.getCollisionRectangle().setUpperLeft(new Point(x, y));
            flag = true;
        }
        if (!flag) {
            if (paddle.getCollisionRectangle().getUpperLeft().getX() < 750 - width) {
                paddle.getCollisionRectangle().setUpperLeft(new Point(750 - width, y));
            }
        }
    }


    /**
     * timePassed - lets others know that the keyboard have been pressed & time has passed.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }

        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }

    }


    /**
     * drawOn - draws a given DrawSurface.
     *
     * @param d - a given DrawSurface
     */
    public void drawOn(DrawSurface d) {
        this.paddle.drawOn(d);
    }

    /**
     * addToGame - adding the paddle to the game.
     *
     * @param g - a given game
     */
    public void addToGame(GameLevel g) {
        g.addPaddle(this);
        g.addSprite(this);
        g.addCollidable(this);
        paddle.addToGame(g);
    }

    /**
     * getCollisionRectangle - Gets the paddle as a collidables object.
     *
     * @return Rectangle - the paddle
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle.getCollisionRectangle();
    }

    /**
     * hit - updates & handles the velocity changes upon hit.
     *
     * @param hitter          - a given ball
     * @param collisionPoint  - a given collisionPoint
     * @param currentVelocity - the current velocity
     * @return Velocity - the updates velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {

        return this.paddle.hit(hitter, collisionPoint, currentVelocity);
    }
}
