

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * Game - manages & handles the arknoid game.
 * It creates GUI, Blocks, Ball and in charge of the design.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Paddle paddle;
    private KeyboardSensor keyboardSensor;
    private biuoop.GUI gui;
    private Counter blockCounter;
    private BlockRemover blockRemover;
    private BallRemover ballRemover;
    private Counter ballCounter;
    private ScoreTrackingListener scoreTrackingListener;
    private Counter scoreTrackCounter;
    private ScoreIndicator scoreIndicator;
    private AnimationRunner runner;
    private boolean running;
    private LevelInformation li;
    private LevelIndicator levelIndicator;


    /**
     * GameLevel
     * <p>
     * contructor.
     *
     * @param lInfo                - levelinfo
     * @param newGui               - a GUI
     * @param newScoreTrackCounter -score counter
     */
    public GameLevel(LevelInformation lInfo, biuoop.GUI newGui, Counter newScoreTrackCounter) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.gui = newGui;
        this.keyboardSensor = this.gui.getKeyboardSensor();
        blockCounter = new Counter();
        blockRemover = new BlockRemover(this, blockCounter);
        ballCounter = new Counter();
        ballRemover = new BallRemover(this, ballCounter);
        scoreTrackCounter = newScoreTrackCounter;
        scoreTrackingListener = new ScoreTrackingListener(scoreTrackCounter);
        scoreIndicator = new ScoreIndicator(scoreTrackingListener);


        runner = new AnimationRunner(this.gui, 60);
        li = lInfo;
        levelIndicator = new LevelIndicator(li);
    }

    /**
     * getBlockCounter.
     *
     * @return Counter - num of remaining blocks
     */

    public Counter getBlockCounter() {
        return blockCounter;
    }

    /**
     * getBallCounter.
     *
     * @return Counter - num of remaining balls
     */

    public Counter getBallCounter() {
        return ballCounter;
    }


    /**
     * Adds paddle.
     *
     * @param newPaddle - a given paddle
     */
    public void addPaddle(Paddle newPaddle) {
        this.paddle = newPaddle;
    }

    /**
     * Adds Collidable.
     *
     * @param c - a given Collidable
     */
    public void addCollidable(Collidable c) {

        this.environment.addCollidable(c);
    }

    /**
     * Adds Sprite.
     *
     * @param s - a given sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * initializes the game.
     * <p>
     * Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     */
    public void initialize() {
        li.initialize(this, this.blockRemover, this.scoreTrackingListener, this.blockCounter, this.ballCounter);

        Paddle newPaddle = new Paddle(this.keyboardSensor, 50, 50);
        this.environment.setPaddle(newPaddle);
        newPaddle.setStartP(li.paddleStartingPoint());
        newPaddle.setPaddleSpeed(li.paddleSpeed());
        newPaddle.setWidth(li.paddleWidth());
        newPaddle.setColor(li.paddleColor());
        newPaddle.addToGame(this);


        //side barriers
        Rectangle rectangle = new Rectangle(new Point(0, 0), 800, 50);
        Block block1 = new Block(rectangle, Color.GRAY);
        Rectangle rectangle2 = new Rectangle(new Point(0, 0), 50, 600);
        Block block2 = new Block(rectangle2, Color.GRAY);
        Rectangle rectangle3 = new Rectangle(new Point(750, 0), 50, 600);
        Block block3 = new Block(rectangle3, Color.GRAY);
        Rectangle rectangle4 = new Rectangle(new Point(0, 599), 800, 50);
        DeathBlock block4 = new DeathBlock(rectangle4, new Color(238, 238, 238));
        block4.addHitListener(ballRemover);
        Block[] blocks = new Block[] {block1, block2, block3, block4};
        for (Block block : blocks) {
            block.addToGame(this);
        }


        scoreIndicator.addToGame(this);
        levelIndicator.addToGame(this);

    }


    /**
     * removeCollidable.
     *
     * @param c - the collidable to be removed
     */
    public void removeCollidable(Collidable c) {
        this.environment.getCollidables().remove(c);
    }


    /**
     * removeSprite.
     *
     * @param s - the Sprite to be removed
     */
    public void removeSprite(Sprite s) {
        this.sprites.getSprites().remove(s);
    }

    /**
     * Runs the game.
     * <p>
     * Runs the game - defines FPS & creates gui and the animation
     */
    public void run() {
        this.li.run();
        this.createBallsOnTopOfPaddle();
        this.runner.run(new CountdownAnimation(2, 3, this.sprites, li));
        this.running = true;
        this.runner.run(this);
//       gui.close();
//        return;
    }

    /**
     * shouldStop.
     * <p>
     * determines if the game should stop
     *
     * @return bollean
     */
    public boolean shouldStop() {
        return !this.running;
    }

    @Override
    public boolean shouldClose() {
        return false;
    }

    /**
     * doOneFrame.
     * <p>
     * in charge of a single frame
     *
     * @param d - a given DrawSurface
     */
    public void doOneFrame(DrawSurface d) {
        if (blockCounter.getValue() == 0 || ballCounter.getValue() == 0) {
            this.running = false;
        }

        if (blockCounter.getValue() == 0 && ballCounter.getValue() != 0) {
            scoreTrackCounter.increase(100);
        }
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();


        PauseScreen a1 = new PauseScreen();
        Animation a2k = new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY, a1, false);
        if (this.keyboardSensor.isPressed("p")) {
            runner.run(a2k);
        }
    }

    /**
     * finalLevel.
     * <p>
     * in chrage of the final leve.
     *
     * @param d - a given drawsurface.
     */

    public void finalLevel(DrawSurface d) {

        Animation a1 = new FinalScreen(scoreTrackCounter, ballCounter, blockCounter, li); // also an Animation
        Animation a1k = new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY, a1, true);
        runner.run(a1k);
    }

    /**
     * createBallsOnTopOfPaddle.
     * <p>
     * creates the level ball/s
     */
    public void createBallsOnTopOfPaddle() {
        for (Ball b : li.getBallsinfo()) {
            b.setGameEnvironment(this.environment);
            b.addToGame(this);
            // ballCounter.increase(1);
        }

        //        Random rand = new Random();
//        Ball ball = new Ball(new Point(302, 400), 3, Color.BLACK);
//        Ball ball2 = new Ball(new Point(360, 400), 3, Color.BLUE);
//        Ball ball3 = new Ball(new Point(500, 400), 3, Color.red);
//
//        double speed = 10;
//        double speed3 = 10;
//        double angle = rand.nextDouble();
//        Velocity v = Velocity.fromAngleAndSpeed(90 * Math.PI / 180 + 0.01, speed);
//        Velocity v2 = Velocity.fromAngleAndSpeed(90 * Math.PI / 180 + 0.01, speed);
//        Velocity v3 = Velocity.fromAngleAndSpeed(60 * Math.PI / 180 + 0.01, speed);
//
//        ball.setVelocity(v);
//        ball.setGameEnvironment(this.environment);
//        ball.addToGame(this);
//        ball2.setVelocity(v2);
//        ball2.setGameEnvironment(this.environment);
//        ball2.addToGame(this);
//        ball3.setVelocity(v3);
//        ball3.setGameEnvironment(this.environment);
//        ball3.addToGame(this);
//        ballCounter.increase(3);
    }
}
