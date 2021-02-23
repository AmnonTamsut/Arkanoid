


/**
 * BallRemover.
 * <p>
 * removes balls from game & counts them
 * <p>
 * implements HitListener
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * BallRemover.
     * <p>
     * constructor
     *
     * @param gameLevel    - a given game
     * @param removedBalls - a counter for removed balls
     */
    public BallRemover(GameLevel gameLevel, Counter removedBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = removedBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        this.remainingBalls.decrease(1);
    }
}
