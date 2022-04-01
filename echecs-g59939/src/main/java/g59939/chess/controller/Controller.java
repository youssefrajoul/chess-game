package g59939.chess.controller;

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

    public void play() {
        boolean gameIsOver = false;

        view.displayTitle();
        model.start();

        while (!gameIsOver) {
            view.displayBoard();
            view.displayPlayer();
            System.out.println("Position de depart est ?");
            Position oldPos = view.askPosition();
            System.out.println("Position d'arrivee est ?");
            Position newPos = view.askPosition();
            model.movePiecePosition(oldPos, newPos);
            gameIsOver = model.isGameOver();
            if (gameIsOver) {
                view.displayWinner();
            }
        }

    }
}
