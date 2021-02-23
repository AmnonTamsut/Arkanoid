

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * SpriteCollection - a list of Sprites.
 * <p>
 * a class that manages & creates a list of sprites - printable objects
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * SpriteCollection - Constructor.
     * <p>
     * creates array list of sprites.
     */
    public SpriteCollection() {
        sprites = new ArrayList<Sprite>();
    }

    /**
     * addSprite - adds a sprite to the list.
     *
     * @param s - a given sprite
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }


    /**
     * notifyAllTimePassed - call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> copy = new ArrayList<>(sprites);
        for (Sprite s : copy) {
            s.timePassed();
        }
    }


    /**
     * notifyAllTimePassed - call drawOn(d) on all sprites.
     *
     * @param d - a given DrawSurface
     */
    public void drawAllOn(DrawSurface d) {
        List<Sprite> copy = new ArrayList<>(sprites);

        for (Sprite s : copy) {
                s.drawOn(d);
            }

    }


    /**
     * getSprites.
     * <p>
     *
     * @return List<Sprite> - a sprite list
     */

    public List<Sprite> getSprites() {
        return sprites;
    }
}
