//ID:


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Level4.
 */

public class Level4 implements LevelInformation {
    private Background b4;
    private List<Ball> l = new ArrayList<>();
    private List<Velocity> vList = new ArrayList<>();
    private boolean beenHere = false;
    private List<Block> b = new ArrayList<>();

    /**
     * Constructor.
     **/
    public Level4() {
        b4 = new Background(4);
        this.getBallsinfo().get(0).setPaddleW(this.paddleWidth());
    }


    @Override
    public int paddleSpeed() {
        return 30;
    }

    @Override
    public Point paddleStartingPoint() {
        return new Point(350, 528);
    }

    @Override
    public int paddleWidth() {
        return 101;
    }

    @Override
    public String levelName() {
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        return this.b4;
    }

    @Override
    public List<Block> blocks() {
        Random rand = new Random();

        int x = 51, y = 100;

        for (int i = 0; i < 6; i++) {
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float black = rand.nextFloat();
            Color randomColor = new Color(r, g, black);

            for (int j = 0; j < 14; j++) {
                Block block = new Block(new Rectangle(new Point(x, y), 48,
                        30), randomColor);
                b.add(block);
                x = x + 50;
            }
            x = 51;
            y = y + 32;
        }
        return b;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }

    @Override
    public void initialize(GameLevel gameLevel, BlockRemover blockRemover, ScoreTrackingListener scoreTrackingListener,
                           Counter blockCounter, Counter ballCounter) {
        for (Block block : this.blocks()) {
            block.addToGame(gameLevel);
            block.addHitListener(blockRemover);
            blockCounter.increase(1);
            block.addHitListener(scoreTrackingListener);

        }
        ballCounter.increase(this.numberOfBalls());
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        double speed = 10;
        for (int i = 0; i < l.size(); i++) {
            vList.add(Velocity.fromAngleAndSpeed(270 * Math.PI / 180 + 0.01, speed));
        }
        return vList;
    }


    @Override
    public int numberOfBalls() {
        return l.size();
    }


    @Override
    public List<Ball> getBallsinfo() {

        if (!beenHere) {
            beenHere = true;
            Ball ball = new Ball(new Point(310, 445), 3, Color.black);
            Ball ball2 = new Ball(new Point(410, 445), 3, Color.black);
            Ball ball3 = new Ball(new Point(360, 420), 3, Color.black);

            l.add(ball);
            l.add(ball2);
            l.add(ball3);

            for (int i = 0; i < l.size(); i++) {
                l.get(i).setVelocity(this.initialBallVelocities().get(i));
            }

        }
        return l;

    }

    @Override
    public void run() {
    }

    @Override
    public Color paddleColor() {
        return Color.black;
    }
}
