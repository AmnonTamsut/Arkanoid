//ID:


import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * FinalScreen - in charge of the summary screen.
 **/
public class FinalScreen implements Animation {
    private Counter score;
    private KeyboardSensor keyboard;
    private Counter ballCounter;
    private Counter blockCounter;
    private boolean stop;
    private LevelInformation levelInformation;


    /**
     * Constructor.
     *
     * @param scoreC              score counter.
     * @param ballC               - ball counter.
     * @param blockC              - block counter.
     * @param newLevelInformation - this level info.
     **/

    public FinalScreen(Counter scoreC, Counter ballC, Counter blockC,
                       LevelInformation newLevelInformation) {
        score = scoreC;
        this.stop = false;
        this.ballCounter = ballC;
        this.blockCounter = blockC;

        levelInformation = newLevelInformation;
    }

    @Override
    public void doOneFrame(DrawSurface d) {


        if (ballCounter.getValue() == 0) {
            d.setColor(Color.red);
            if (levelInformation.levelName().equals("Direct Hit")) {
                d.drawText(10, (d.getHeight() / 2) - 10, "Game Over. Your score is " + score.getValue() + ".", 32);
                d.drawText(60, 580, "Last level played: Direct Hit", 15);
            }
            if (levelInformation.levelName().equals("Wide Easy")) {
                d.drawText(10, (d.getHeight() / 2) - 10, "Game Over. Your score is " + score.getValue() + ".", 32);
                d.drawText(60, 580, "Last level played: Wide Easy", 15);
            }
            if (levelInformation.levelName().equals("Green 3")) {
                d.drawText(10, (d.getHeight() / 2) - 10, "Game Over. Your score is " + score.getValue() + ".", 32);
                d.drawText(60, 580, "Last level played: Green 3", 15);
            }

            if (levelInformation.levelName().equals("Final Four")) {
                d.drawText(10, (d.getHeight() / 2) - 10, "Game Over. Your score is " + score.getValue() + ".", 32);
                d.drawText(60, 580, "Last level played: Final Four", 15);
            }

        }
        if (blockCounter.getValue() == 0) {
            d.setColor(Color.blue);

            if (levelInformation.levelName().equals("Direct Hit")) {
                d.drawText(10, (d.getHeight() / 2) - 10, "You Win!. Your score is " + score.getValue() + ".", 32);
                d.drawText(60, 580, "Last level played: Direct Hit", 15);
            }
            if (levelInformation.levelName().equals("Wide Easy")) {
                d.drawText(10, (d.getHeight() / 2) - 10, "You Win!. Your score is " + score.getValue() + ".", 32);
                d.drawText(60, 580, "Last level played: Wide Easy", 15);
            }
            if (levelInformation.levelName().equals("Green 3")) {
                d.drawText(10, (d.getHeight() / 2) - 10, "You Win!. Your score is " + score.getValue() + ".", 32);
                d.drawText(60, 580, "Last level played: Green 3", 15);
            }

            if (levelInformation.levelName().equals("Final Four")) {
                d.drawText(10, (d.getHeight() / 2) - 10, "You Win!. Your score is " + score.getValue() + ".", 32);
                d.drawText(60, 580, "Last level played: Final Four", 15);
            }

        }

//        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
//             this.stop = true;
//
//        }
    }


    @Override
    public boolean shouldStop() {
        return this.stop;

    }

    @Override
    public boolean shouldClose() {
        return this.stop;
    }
}
