//ID:

import biuoop.DrawSurface;

import java.awt.Color;


/**
 * ScoreIndicator.
 * <p>
 * implements Sprite
 */

public class ScoreIndicator implements Sprite {
    private ScoreTrackingListener s;

    /**
     * ScoreIndicator.
     * <p>
     * constructor
     *
     * @param s - a given ScoreTrackingListener
     */
    public ScoreIndicator(ScoreTrackingListener s) {
        this.s = s;
    }


    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.GRAY);
        d.drawRectangle(0, 0, 800, 20);
        d.setColor(Color.BLACK);
        d.drawText(340, 20, "Score: " + s.getCurrentScore().getValue(), 15);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }


}
