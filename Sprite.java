

import biuoop.DrawSurface;


/**
 * Sprite.
 */
public interface Sprite {

    /**
     * drawOn.
     * <p>
     * draw the sprite to the screen
     *
     * @param d - a given DrawSurface
     */
    void drawOn(DrawSurface d);

    /**
     * timePassed.
     * <p>
     * notify the sprite that time has passed
     */
    void timePassed();

    /**
     * addToGame.
     * <p>
     * adds to a given game
     *
     * @param g - a given game
     */
    void addToGame(GameLevel g);

}
