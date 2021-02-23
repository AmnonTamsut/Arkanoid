

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * A block is a shape or object that can interfere with the players move or game
 * <p>
 * it implements Collidable as it has Collidable objects & Sprite as it manages them as a printable objects.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle block;
    private Color color;
    private List<HitListener> hitListeners = new ArrayList<>();

    /**
     * Block.
     * <p>
     * constructor
     *
     * @param block - a given block
     * @param color - a given color
     */
    public Block(Rectangle block, Color color) {
        this.block = block;
        this.color = color;
    }


    /**
     * retrieves the Collision rectangle.
     *
     * @return Rectangle
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.block;
    }

    /**
     * getColor.
     *
     * @return Color
     */
    public Color getColor() {
        return color;
    }

    /**
     * draws on a given surface.
     *
     * @param surface - a given surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);

        surface.fillRectangle((int) this.block.getUpperLeft().getX(), (int) this.block.getUpperLeft().getY(),
                (int) this.block.getWidth(), (int) this.block.getHeight());
        surface.setColor(Color.GRAY);

        surface.drawRectangle((int) this.block.getUpperLeft().getX(), (int) this.block.getUpperLeft().getY(),
                (int) this.block.getWidth(), (int) this.block.getHeight());
    }

    /**
     * finds if 2 lines are equal.
     *
     * @param hitter          - the hitter ball.
     * @param collisionPoint  - point of collision, currentVelocity - current velocity whilst the object hits the point.
     * @param currentVelocity - the current V.
     * @return Velocity - the modified velocity post collision.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        return currentVelocity;
    }

    @Override
    public void timePassed() {
    }

    /**
     * adds block to a given game.
     *
     * @param g - a given game
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * removeFromGame.
     *
     * @param gameLevel - a given game
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    /**
     * notifyHit.
     *
     * @param hitter - a hitter ball
     */
    private void notifyHit(Ball hitter) {
        // Making a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notifying all listeners about a hit event
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);

    }
}
