


import java.util.ArrayList;
import java.util.List;

/**
 * Ass5Game - Creates & runs the game.
 */
public class Ass6Game {

    /**
     * Our main method. Creates a new game, initializes & runs it.
     *
     * @param args The command line arguments.
     **/
    public static void main(String[] args) {
        List<LevelInformation> list = new ArrayList<>();
        LevelInformation levelInformation1 = new Level1();
        LevelInformation levelInformation2 = new Level2();
        LevelInformation levelInformation3 = new Level3();
        LevelInformation levelInformation4 = new Level4();

        //adding levels as per user request
        if (args.length != 0) {

            for (String s : args) {
                if (s.equals("1")) {
                    list.add(levelInformation1);
                }
                if (s.equals("2")) {
                    list.add(levelInformation2);
                }
                if (s.equals("3")) {
                    list.add(levelInformation3);
                }
                if (s.equals("4")) {
                    list.add(levelInformation4);
                }
            }
        } else {
            list.add(levelInformation1);
            list.add(levelInformation2);
            list.add(levelInformation3);
            list.add(levelInformation4);
        }
        GameFlow gameFlow = new GameFlow();
        gameFlow.runLevels(list);
    }
}
