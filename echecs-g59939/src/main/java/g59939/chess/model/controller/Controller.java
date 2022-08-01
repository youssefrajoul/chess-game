package g59939.chess.model.controller;

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
        boolean gameIsOver = false;
        view.displayTitle();
        model.start();
        while (!gameIsOver) {
            view.displayBoard();
            view.displayPlayer();
            Position oldPos = view.askPosition();
            Position newPos = view.askPosition();
            model.movePiecePosition(oldPos, newPos);
            gameIsOver = model.isGameOver();
            if (gameIsOver) {
                view.displayWinner();
            }
        }
    }

}
