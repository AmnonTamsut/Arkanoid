//ID:


import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * KeyPressStoppableAnimation.
 *
 */

public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isFinal = false;
    private boolean alreadyPressed = true;


    /**
     * KeyPressStoppableAnimation.
     * <p>
     * @param isFinalOther - is it final level.
     * @param newAnimation  - a animation.
     * @param newKey - the press key.
     * @param newSensor - a sensor.
     *
     */

    public KeyPressStoppableAnimation(KeyboardSensor newSensor, String newKey,
                                      Animation newAnimation, boolean isFinalOther) {
        sensor = newSensor;
        key = newKey;
        animation = newAnimation;
        stop = false;
        isFinal = isFinalOther;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.sensor.isPressed(key)) {
            if (!alreadyPressed) {
                this.stop = true;
            }
        } else {
            alreadyPressed = false;
            animation.doOneFrame(d);
        }

    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }

    @Override
    public boolean shouldClose() {
        if (isFinal) {
            return this.stop;
        }
        return false;
    }


}
