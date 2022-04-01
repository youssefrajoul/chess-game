package g59939.chesss;

import g59939.chess.controller.Controller;
import g59939.chess.model.Game;
import g59939.chess.model.Model;
import g59939.chess.view.TextView;

/**
 *
 * @author g59939
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Model game = new Game();
        Controller controller = new Controller(game, new TextView(game));
        controller.play();
    }
}