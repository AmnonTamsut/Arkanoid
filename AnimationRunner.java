//Id:

import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * AnimationRunner - runs the animation.
 */

public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;

    /**
     * Constructor.
     *
     * @param newGui a given GUI.
     * @param fPs    - framespersec.
     **/

    public AnimationRunner(GUI newGui, int fPs) {
        this.gui = newGui;
        this.framesPerSecond = fPs;
    }


    /**
     * run.
     *
     * @param animation a given animation.
     **/

    public void run(Animation animation) {
        biuoop.Sleeper sleeper = new biuoop.Sleeper();

        int millisecondsPerFrame = 1000 / framesPerSecond;

        while (!animation.shouldStop()) {

            long startTime = System.currentTimeMillis(); // timing

            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);

            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
        if (animation.shouldClose()) {
            gui.close();
        }
    }
}
