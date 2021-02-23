//ID:


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Level1.
 */

public class Level3 implements LevelInformation {
    private Background b3;
    private List<Ball> l = new ArrayList<>();
    private List<Velocity> vList = new ArrayList<>();
    private boolean beenHere = false;

    /**
     * Constructor.
     **/

    public Level3() {
        b3 = new Background(3);
        this.getBallsinfo().get(0).setPaddleW(this.paddleWidth());
    }


    @Override
    public int paddleSpeed() {
        return 20;
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
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        return this.b3;
    }

    @Override
    public List<Block> blocks() {
        Random rand = new Random();
        List<Block> b = new ArrayList<>();


        double xRect = 688, yRect = 100, yJump = 1;

        for (int i = 12; i > 0; i--) {
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float black = rand.nextFloat();
            Color randomColor = new Color(r, g, black);
            for (int j = 0; j < i; j++) {
                Block block = new Block(new Rectangle(new Point(xRect - 37 * j, yRect), 35,
                        15), randomColor);
                b.add(block);
            }
            yRect = yRect + 15;
            if (i == 7) {
                i = 0;
            }
        }
        return b;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 40;
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
            Ball ball = new Ball(new Point(300, 375), 3, Color.black);
            Ball ball2 = new Ball(new Point(503, 375), 3, Color.black);

            l.add(ball);
            l.add(ball2);


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
        return Color.white;
    }
}
