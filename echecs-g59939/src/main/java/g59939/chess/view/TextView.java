package g59939.chess.view;

import g59939.chess.model.Board;
import g59939.chess.model.Color;
import g59939.chess.model.Model;
import g59939.chess.model.Piece;
import g59939.chess.model.Player;
import g59939.chess.model.Position;
import java.util.*;

/**
 *
 * @author g59939
 */
public class TextView implements View {

    private Model model;

    public TextView(Model model) {
        this.model = model;
    }

    @Override
    public void displayTitle() {
        System.out.println("Welcome to ESI Chess Game");
    }

    @Override
    public void displayBoard() {
        for (int i = 7; i >= 0; i--) {
            System.out.println("  --------------------------------");
            System.out.print(i);
            System.out.print("  ");
            for (int j = 0; j < 8; j++) {
                System.out.println("|");
                Position position = new Position(i, j);
                if (model.getPiece(position) == null) {
                    System.out.print("  ");
                } else if (model.getPiece(position).getColor() == Color.WHITE) {
                    System.out.print("PW");
                } else {
                    System.out.print("PB");
                }
            }
            System.out.println("|");
        }
    }

    @Override
    public void displayWinner() {
        
    }

    @Override
    public void displayPlayer() {

    }

    @Override
    public Position askPosition() {

    }

    @Override
    public void displayError(String message) {

    }

}
