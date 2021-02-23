//ID:


import java.awt.Color;
import java.util.List;

/**
 * LevelInformation.
 * <p>
 */

public interface LevelInformation {

    /**
     * numberOfBalls.
     * <p>
     *
     * @return int
     */

    int numberOfBalls();

    /**
     * initialBallVelocities.
     * <p>
     * The initial velocity of each ball
     * Note that initialBallVelocities().size() == numberOfBalls()
     *
     * @return List v
     */
    List<Velocity> initialBallVelocities();

    /**
     * paddleSpeed.
     * <p>
     *
     * @return int
     */
    int paddleSpeed();

    /**
     * paddleWidth.
     * <p>
     *
     * @return int
     */

    int paddleWidth();

    /**
     * paddleStartingPoint.
     * <p>
     *
     * @return Point
     */

    Point paddleStartingPoint();

    /**
     * levelName.
     * <p>
     * the level name will be displayed at the top of the screen.
     *
     * @return String
     */

    String levelName();

    /**
     * getBackground.
     * <p>
     * Returns a sprite with the background of the level
     *
     * @return Sprite
     */

    Sprite getBackground();


    /**
     * blocks.
     * <p>
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return List
     */

    List<Block> blocks();

    /**
     * blocks.
     * <p>
     *
     * @return int
     */

    int numberOfBlocksToRemove();

    /**
     * initializes the game.
     * <p>
     * Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     *
     * @param ballCounter - ball counter.
     * @param blockCounter  - block counter.
     * @param blockRemover - -block remover.
     * @param gameLevel - game level.
     * @param scoreTrackingListener - score track listener.
     */
    void initialize(GameLevel gameLevel, BlockRemover blockRemover, ScoreTrackingListener scoreTrackingListener,
                    Counter blockCounter, Counter ballCounter);

    /**
     * getBallsinfo.
     * <p>
     *
     * @return List of balls
     */
    List<Ball> getBallsinfo();

    /**
     * Runs the game.
     * <p>
     * Runs the game - defines FPS & creates gui and the animation
     */
    void run();

    /**
     * paddleColor.
     * <p>
     *
     * @return Color
     */
    Color paddleColor();
}
