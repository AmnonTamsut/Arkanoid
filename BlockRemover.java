

/**
 * BlockRemover.
 * <p>
 * Creates & runs the game.
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;


    /**
     * BlockRemover.
     * <p>
     * constructor
     *
     * @param gameLevel     - a given game
     * @param removedBlocks - a counter for removed balls
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }


    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(gameLevel);
        remainingBlocks.decrease(1);
    }
}