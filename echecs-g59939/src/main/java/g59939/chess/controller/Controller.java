package g59939.chess.controller;

import g59939.chess.model.GameState;
import g59939.chess.model.Model;
import g59939.chess.model.Position;
import g59939.chess.view.View;

/**
 *
 * @author g59939
 */
public class Controller {

    private View view;
    private Model model;

    public Controller(Model model, View view) {
        this.view = view;
        this.model = model;
    }

    /**
     * Treats and manage the hall chess game
     */
    public void play() {
        GameState state = GameState.PLAY;
        view.displayTitle();
        model.start();
        while (state == GameState.PLAY) {
            view.displayBoard();
            view.displayPlayer();
            Position oldPos = view.askPosition();
            Position newPos = view.askPosition();
            model.movePiecePosition(oldPos, newPos);
            state = model.getState();
            if (null != state) switch (state) {
                case CHECK_MATE -> {
                    view.displayBoard();
                    view.displayWinner();
                }
                case STALE_MATE -> {
                    System.out.println("*** Game Over ***");
                    System.out.println("Draw for this match");
                }
                case CHECK -> System.out.println(model.getOppositePlayer() + " King is in check");
                default -> {
                }
            }
        }
    }

}
