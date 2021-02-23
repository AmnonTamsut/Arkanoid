//ID:

import biuoop.DrawSurface;

/**
 * Animation. An interface
 *
 **/
public interface Animation {

    /**
     * in charge of doing 1 frame..
     *
     * @param d given DrawSurface.
     **/
    void doOneFrame(DrawSurface d);

    /**
     * Determines whether to stop the animation.
     *
     * @return boolean
     **/

    boolean shouldStop();

    /**
     * Determines whether to Close the animation.
     *
     * @return boolean
     **/
    boolean shouldClose();
}
