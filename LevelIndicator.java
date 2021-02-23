//ID:


import biuoop.DrawSurface;

import java.awt.Color;

/**
 * LevelIndicator.
 */

public class LevelIndicator implements Sprite {
    private LevelInformation levelInformation;

    /**
     * Constructor.
     *
     * @param l - a level info
     **/

    public LevelIndicator(LevelInformation l) {
        this.levelInformation = l;
    }

    @Override
    public void drawOn(DrawSurface d) {

        d.setColor(Color.BLACK);
        d.drawText(450, 20, "Level: " + levelInformation.levelName(), 15);

    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
