//ID:

/**
 * HitNotifier.
 */
public interface HitNotifier {

    /**
     * addHitListener.
     * <p>
     * Add hl as a listener to hit events.
     *
     * @param hl - a given HitListener
     */
    void addHitListener(HitListener hl);

    /**
     * addHitListener.
     * <p>
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl - a given HitListener
     */

    void removeHitListener(HitListener hl);
}
