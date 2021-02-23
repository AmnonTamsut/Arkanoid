//ID:


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Level1.
 */

public class Level1 implements LevelInformation {
    private Background b1;

    /**
     * Constructor.
     **/

    public Level1() {
        b1 = new Background(1);
    }

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new ArrayList<>();
        double speed = 10;
        l.add(Velocity.fromAngleAndSpeed(90 * Math.PI / 180 + 0.01, speed));
        return l;
    }

    @Override
    public int paddleSpeed() {
        return 30;
    }

    @Override
    public int paddleWidth() {
        return 101;
    }

    @Override
    public Point paddleStartingPoint() {
        return new Point(300, 528);
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return this.b1;
    }

    @Override
    public List<Block> blocks() {
        List<Block> b = new ArrayList<>();

        b.add(new Block(new Rectangle(new Point(350, 250), 30, 30), Color.red));

        return b;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }

    @Override
    public void initialize(GameLevel gameLevel, BlockRemover blockRemover, ScoreTrackingListener scoreTrackingListener,
                           Counter blockCounter, Counter ballCounter) {
        for (Block block : this.blocks()) {
            block.addToGame(gameLevel);
            block.addHitListener(blockRemover);
            blockCounter.increase(1);
            block.addHitListener(scoreTrackingListener);
            ballCounter.increase(this.numberOfBalls());
        }
    }

    @Override
    public List<Ball> getBallsinfo() {

        List<Ball> l = new ArrayList<>();
        Ball ball = new Ball(new Point(365, 430), 3, Color.BLUE);
        l.add(ball);


        double speed = 10;
        Velocity v = Velocity.fromAngleAndSpeed(270 * Math.PI / 180 + 0.01, speed);


        ball.setVelocity(v);

        return l;

    }

    @Override
    public void run() {


    }

    @Override
    public Color paddleColor() {
        return Color.gray;
    }
}
