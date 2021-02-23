


import biuoop.DrawSurface;

import java.awt.Color;
import java.awt.Polygon;
import java.util.Random;


/**
 * Background - in charge of the background.
 **/
public class Background implements Sprite {
    private int leveNum;


    /**
     * Constructor.
     *
     * @param newLeveNum level indicator.
     **/

    public Background(int newLeveNum) {
        leveNum = newLeveNum;
    }

    @Override
    public void drawOn(DrawSurface d) {
        if (leveNum == 1) {
            this.levelOne(d);
        }
        if (leveNum == 2) {
            this.levelTwo(d);
        }
        if (leveNum == 3) {
            this.levelThree(d);
        }
        if (leveNum == 4) {
            this.levelFour(d);
        }
    }


    @Override
    public void timePassed() {

    }


    /**
     * levelOne.
     *
     * @param d a given DrawSurface.
     **/

    public void levelOne(DrawSurface d) {

        Random rand = new Random();
        float r;
        float g;
        float black;
        Color randomColor;

        int x = 365;
        int y = 265;


        for (int k = 0; k < 8; k++) {
            for (int i = 0; i < 8; i++) {

                int t = i * 20;
                r = rand.nextFloat();
                g = rand.nextFloat();
                black = 0;


                r = rand.nextFloat();
                g = rand.nextFloat();
                black = 0;
                //   black = rand.nextFloat();
                randomColor = new Color(r, g, black);
                d.setColor(randomColor);

                d.drawLine(x + t, y + 20 + t, x - 20 - t, y + 20 + t);
                r = rand.nextFloat();
                g = rand.nextFloat();
                black = 0;
                //black = rand.nextFloat();
                randomColor = new Color(r, g, black);
                d.setColor(randomColor);

                d.drawLine(x - 20 - t, y + 20 + t, x - 20 - t, y - 20 - t);
                r = rand.nextFloat();
                g = rand.nextFloat();
                black = 0;
                //black = rand.nextFloat();
                randomColor = new Color(r, g, black);
                d.setColor(randomColor);

                d.drawLine(x - 20 - t, y - 20 - t, x + 20 + t, y - 20 - t);
                r = rand.nextFloat();
                g = rand.nextFloat();
                black = 0;
                //black = rand.nextFloat();
                randomColor = new Color(r, g, black);
                d.setColor(randomColor);

                d.drawLine(x + 20 + t, y - 20 - t, x + 20 + t, y + 20 + t);

                x--;
                y--;

                for (i = 0; i < 8; i++) {

                    t = i * 20;
                    r = rand.nextFloat();
                    g = rand.nextFloat();
                    black = rand.nextFloat();
                    randomColor = new Color(r, g, black);
                    d.setColor(randomColor);
                    d.drawLine(x + t, y + t, x + t, y + 20 + t);
                    r = rand.nextFloat();
                    g = rand.nextFloat();
                    black = rand.nextFloat();
                    randomColor = new Color(r, g, black);
                    d.setColor(randomColor);

                    d.drawLine(x + t, y + 20 + t, x - 20 - t, y + 20 + t);
                    r = rand.nextFloat();
                    g = rand.nextFloat();
                    black = rand.nextFloat();
                    randomColor = new Color(r, g, black);
                    d.setColor(randomColor);

                    d.drawLine(x - 20 - t, y + 20 + t, x - 20 - t, y - 20 - t);
                    r = rand.nextFloat();
                    g = rand.nextFloat();
                    black = rand.nextFloat();
                    randomColor = new Color(r, g, black);
                    d.setColor(randomColor);

                    d.drawLine(x - 20 - t, y - 20 - t, x + 20 + t, y - 20 - t);
                    r = rand.nextFloat();
                    g = rand.nextFloat();
                    black = rand.nextFloat();
                    randomColor = new Color(r, g, black);
                    d.setColor(randomColor);

                    d.drawLine(x + 20 + t, y - 20 - t, x + 20 + t, y + 20 + t);

                }
            }

        }
    }

    /**
     * levelTwo.
     *
     * @param d a given DrawSurface.
     **/
    public void levelTwo(DrawSurface d) {
        int x = 550, y = 150, height = 50, width = 50;
        this.drawHeart(d, 530, 130, 150, 150, Color.red);
        this.drawHeart(d, 530, 420, 150, 150, Color.pink);
        this.drawHeart(d, 180, 130, 150, 150, Color.YELLOW);
        this.drawHeart(d, 180, 420, 150, 150, Color.green);


    }

    /**
     * levelThree.
     *
     * @param d a given DrawSurface.
     **/
    public void levelThree(DrawSurface d) {
        Random rand = new Random();
        float r;
        float g;
        float black;
        Color randomColor;

        r = rand.nextFloat();
        g = rand.nextFloat();
        black = rand.nextFloat();
        randomColor = new Color(r, g, black);

        d.setColor(new Color(86, 125, 70));
        d.fillRectangle(0, 0, 800, 600);
        int rad;
        for (int i = 1; i < 50; i++) {
            d.setColor(new Color(r, g, black));

            rad = 200;
            d.drawCircle(400, 300, rad);
            d.setColor(Color.white);
            d.drawCircle(550, 250, 10);
            d.fillCircle(550, 250, 10);
            d.drawCircle(350, 250, 10);
            d.fillCircle(350, 250, 10);
            d.drawLine(430, 300, 430, 350);
            d.drawLine(520, 400, 350, 400);
        }
    }


    /**
     * levelFour.
     *
     * @param d a given DrawSurface.
     **/
    public void levelFour(DrawSurface d) {

        int x = 50, y = 50, h = 10, w = 10;
        d.setColor(new Color(0, 153, 153));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.pink);
        d.drawCircle(130, 430, 100);
        d.fillCircle(130, 430, 100);
        d.drawCircle(130, 130, 100);
        d.fillCircle(130, 130, 100);


    }


    /**
     * drawHeart.
     *
     * @param d      a given DrawSurface.
     * @param x      - start x
     * @param y      - start y
     * @param height - height
     * @param width - width
     * @param color - color
     **/
    public void drawHeart(DrawSurface d, int x, int y, int height, int width, Color color) {

        for (int i = 0; i < 20; i++) {
            d.setColor(color);
            int[] triangleX = {
                    x - 2 * width / 18,
                    x + width + 2 * width / 18,
                    (x - 2 * width / 18 + x + width + 2 * width / 18) / 2};
            int[] triangleY = {
                    y + height - 2 * height / 3,
                    y + height - 2 * height / 3,
                    y + height};
            d.fillOval(
                    x - width / 12,
                    y,
                    width / 2 + width / 6,
                    height / 2);
            d.fillOval(
                    x + width / 2 - width / 12,
                    y,
                    width / 2 + width / 6,
                    height / 2);
            Polygon p = new Polygon(triangleX, triangleY, triangleX.length);
            d.fillPolygon(p);
        }


    }


    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
