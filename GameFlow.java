//ID:


import java.util.List;

/**
 * GameFlow - in chrage of the game flow levels.
 */

public class GameFlow {


    /**
     * runLevels.
     *
     * @param levels a given list of levels.
     **/

    public void runLevels(List<LevelInformation> levels) {
        biuoop.GUI gui = new biuoop.GUI("Arknoid", 800, 600);
        Counter score = new Counter();
        int index = 0;
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, gui, score);
            level.addSprite(levelInfo.getBackground());
            level.initialize();

            while (level.getBallCounter().getValue() != 0 && level.getBlockCounter().getValue() != 0) {
                level.run();
            }
            if (index == levels.size() - 1 || level.getBallCounter().getValue() == 0) {
                level.finalLevel(gui.getDrawSurface());
            }
            index++;
        }
    }
}
