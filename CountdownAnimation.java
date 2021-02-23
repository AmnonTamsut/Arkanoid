//ID:

import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

/**
 * CountdownAnimation.
 *
 **/
public class CountdownAnimation implements Animation {
    private double pauseTime;
    private int counterFrom;
    private SpriteCollection currGameScreen;
    private boolean shouldStop;
    private LevelInformation levelInformation;


    /**
     * CountdownAnimation Constructor.
     *
     * @param numOfSeconds - number of sec.
     * @param countFrom    - count from sec.
     * @param gameScreen - cuurent game screen.
     * @param newLevelInformation - current level info.
     **/

    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen,
                              LevelInformation newLevelInformation) {
        this.pauseTime = numOfSeconds;
        this.counterFrom = countFrom;
        this.currGameScreen = gameScreen;
        this.shouldStop = false;
        levelInformation = newLevelInformation;
    }

    /**
     * doOneFrame.
     * <p>
     * in charge of a single frame
     *
     * @param d - a given DrawSurface
     */
    public void doOneFrame(DrawSurface d) {
        biuoop.Sleeper sleeper = new Sleeper();

        long tStart = System.currentTimeMillis();

        currGameScreen.drawAllOn(d);
        if (!shouldStop) {
            d.setColor(Color.BLACK);
            d.drawText(100, 200, "Get Ready...", 50);
            d.drawText(150, 260, "The level will begin in...", 50);
            d.drawText(60, 580, "Level Name: " + levelInformation.levelName(), 30);

            d.drawText(300, 450, "" + this.counterFrom + "...", 200);

            this.counterFrom--;
            if (this.counterFrom == -1) {
                this.shouldStop = true;
            }
        }
        long usedTime = System.currentTimeMillis() - tStart;
        long milliSecondLeftToSleep = 1000 - usedTime;
        if (milliSecondLeftToSleep > 0) {
            sleeper.sleepFor(milliSecondLeftToSleep);
        }
    }

    /**
     * shouldStop.
     * <p>
     * in charge of if to stop or not
     *
     * @return  boolean
     */

    public boolean shouldStop() {
        return shouldStop;
    }

    @Override
    public boolean shouldClose() {
        return false;
    }
}
