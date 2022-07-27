package g59939.chess.main;

import g59939.chess.model.Game;
import g59939.chess.model.Model;
import g59939.chess.model.controller.Controller;
import g59939.chess.view.TextView;

/**
 *
 * @author HONOR
 */
public class Main {
    public static void main(String[] args) {
        Model game = new Game();
        Controller controller = new Controller(game, new TextView(game));
        controller.play();
    }
}