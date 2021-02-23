//ID:


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Level1.
 */

public class Level2 implements LevelInformation {

    private Background b2;
    private List<Ball> l = new ArrayList<>();
    private List<Velocity> vList = new ArrayList<>();
    private boolean beenHere = false;

    /**
     * Constructor.
     **/

    public Level2() {
        b2 = new Background(2);
        this.getBallsinfo().get(0).setPaddleW(this.paddleWidth());
    }


    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public Point paddleStartingPoint() {
        return new Point(150, 538);
    }

    @Override
    public int paddleWidth() {
        return 500;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return this.b2;
    }

    @Override
    public List<Block> blocks() {
        Random rand = new Random();
        List<Block> b = new ArrayList<>();

        int x = 50;
        int y = 200;
        for (int i = 0; i < 10; i++) {
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float black = 0;
            Color randomColor = new Color(r, g, black);

            b.add(new Block(new Rectangle(new Point(x, y), 70, 25), randomColor));
            x = x + 70;
        }
        return b;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 10;
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
            Ball ball = new Ball(new Point(300, 450), 3, Color.WHITE);
            Ball ball2 = new Ball(new Point(325, 375), 3, Color.WHITE);
            Ball ball3 = new Ball(new Point(350, 325), 3, Color.WHITE);
            Ball ball4 = new Ball(new Point(375, 305), 3, Color.WHITE);
            Ball ball5 = new Ball(new Point(400, 295), 3, Color.WHITE);
            Ball ball6 = new Ball(new Point(450, 295), 3, Color.WHITE);
            Ball ball7 = new Ball(new Point(475, 305), 3, Color.WHITE);
            Ball ball8 = new Ball(new Point(500, 325), 3, Color.WHITE);
            Ball ball9 = new Ball(new Point(525, 375), 3, Color.WHITE);
            Ball ball10 = new Ball(new Point(550, 450), 3, Color.WHITE);
            l.add(ball);
            l.add(ball2);
            l.add(ball3);
            l.add(ball4);
            l.add(ball5);
            l.add(ball6);
            l.add(ball7);
            l.add(ball8);
            l.add(ball9);
            l.add(ball10);

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
        return Color.orange;
    }
}
