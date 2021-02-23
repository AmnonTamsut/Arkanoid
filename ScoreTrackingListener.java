

/**
 * ScoreTrackingListener.
 * <p>
 * implements HitListener
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * ScoreTrackingListener.
     * <p>
     * Add hl as a listener to hit events.
     *
     * @param scoreCounter - a given Counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * hitEvent.
     * <p>
     * increases counter when hit
     *
     * @param beingHit - a given Block
     * @param hitter   - a given ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }

    /**
     * getCurrentScore.
     * <p>
     * retreives current score
     *
     * @return Counter - a counter
     */
    public Counter getCurrentScore() {
        return currentScore;
    }
}
