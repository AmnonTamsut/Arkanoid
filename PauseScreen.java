//ID:


import biuoop.DrawSurface;
import biuoop.KeyboardSensor;


/**
 * PauseScreen.
 * <p>
 */

public class PauseScreen implements Animation {
    private boolean stop;


    /**
     * PauseScreen.
     * <p>
     */

    public PauseScreen() {
        this.stop = false;
    }


    /**
     * PauseScreen.
     * <p>
     *
     * @param k -a KeyboardSensor.
     */

    public PauseScreen(KeyboardSensor k) {
        this.stop = false;
    }

    /**
     * in charge of doing 1 frame..
     *
     * @param d given DrawSurface.
     **/

    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }


    /**
     * Determines whether to stop the animation.
     *
     * @return boolean
     **/

    public boolean shouldStop() {
        return this.stop;
    }

    @Override
    public boolean shouldClose() {
        return false;
    }
}
