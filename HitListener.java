

/**
 * HitListener.
 */
public interface HitListener {

    /**
     * hitEvent.
     * <p>
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit - a given block
     * @param hitter   - a given ball
     */
    void hitEvent(Block beingHit, Ball hitter);
}
