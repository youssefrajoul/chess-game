package g59939.chess.view;

import g59939.chess.model.Board;
import g59939.chess.model.Color;
import g59939.chess.model.Model;
import g59939.chess.model.pieces.Piece;
import g59939.chess.model.Player;
import g59939.chess.model.Position;
import g59939.chess.model.pieces.Bishop;
import g59939.chess.model.pieces.King;
import g59939.chess.model.pieces.Knight;
import g59939.chess.model.pieces.Pawn;
import g59939.chess.model.pieces.Queen;
import g59939.chess.model.pieces.Rook;
import java.util.*;

/**
 * Treats inputs and outputs
 *
 * @author g59939
 */
public class TextView implements View {

    private Model model;

    /**
     * Constructor of the Class
     *
     * @param model
     */
    public TextView(Model model) {
        this.model = model;
    }

    /**
     * Display the title of the Chess Game
     */
    @Override
    public void displayTitle() {
        System.out.println("Welcome to ESI Chess Game (g59939)");
    }

    /**
     * Display the board & pieces of the Chess Game
     */
    @Override
    public void displayBoard() {
        for (int i = 7; i >= 0; i--) {
            System.out.println("   -------------------------");
            System.out.print(i + 1);
            System.out.print("  ");
            for (int j = 0; j < 8; j++) {
                System.out.print("|");
                Position position = new Position(i, j);
                if (model.getPiece(position) == null) {
                    System.out.print("  ");
                } else if (model.getPiece(position).getColor() == Color.WHITE) {
                    if (model.getPiece(position) instanceof Rook) {
                        System.out.print("RW");
                    }
                    if (model.getPiece(position) instanceof Knight) {
                        System.out.print("KW");
                    }
                    if (model.getPiece(position) instanceof Bishop) {
                        System.out.print("BW");
                    }
                    if (model.getPiece(position) instanceof Queen) {
                        System.out.print("QW");
                    }
                    if (model.getPiece(position) instanceof King) {
                        System.out.print("+W");
                    }
                    if (model.getPiece(position) instanceof Pawn) {
                        System.out.print("PW");
                    }
                } else if (model.getPiece(position).getColor() == Color.BLACK) {
                    if (model.getPiece(position) instanceof Rook) {
                        System.out.print("RB");
                    }
                    if (model.getPiece(position) instanceof Knight) {
                        System.out.print("KB");
                    }
                    if (model.getPiece(position) instanceof Bishop) {
                        System.out.print("BB");
                    }
                    if (model.getPiece(position) instanceof Queen) {
                        System.out.print("QB");
                    }
                    if (model.getPiece(position) instanceof King) {
                        System.out.print("+B");
                    }
                    if (model.getPiece(position) instanceof Pawn) {
                        System.out.print("PB");
                    }
                }
            }
            System.out.println("|");
        }
        System.out.println("   -------------------------");
        System.out.println("     a  b  c  d  e  f  g  h");
    }

    /**
     * Display the Winner of the Game
     */
    @Override
    public void displayWinner() {
        System.out.println("*** Game Over ***");
        System.out.println("The Winner is : " + model.getCurrentPlayer().getColor());
    }

    /**
     * Display that the opponent is in check
     */
    @Override
    public void displayCheck() {
        System.out.println("You're in check !!! Move your King now");
    }

    /**
     * Display that the opponent is in checkMate and announce the winner
     */
    @Override
    public void displayMat() {
        System.out.println("CheckMate !!! The winner is : " + model.getCurrentPlayer().getColor());
    }

    /**
     * Display that the game is draw
     */
    @Override
    public void displayStaleMat() {
        System.out.println("StaleMate !!! Draw");
    }

    /**
     * Display the current player
     */
    @Override
    public void displayPlayer() {
        System.out.println(model.getState());
        System.out.println("Current player : " + model.getCurrentPlayer().getColor());
    }

    /**
     * Treats the input of the player (ask for positions)
     *
     * @return the Position that the player chose
     */
    @Override
    public Position askPosition() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 0);
        map.put("b", 1);
        map.put("c", 2);
        map.put("d", 3);
        map.put("e", 4);
        map.put("f", 5);
        map.put("g", 6);
        map.put("h", 7);
        System.out.println("Move a Piece");
        Scanner scan = new Scanner(System.in);
        System.out.println("Pick a Row line (1-8):");
        while (!scan.hasNextInt()) {
            scan.next();
            displayError("You must chose a num between 1 & 8");
            System.out.println("Pick a Row line (1-8):");
        }
        int input1 = scan.nextInt() - 1;
        System.out.println("Pick a column line (a-h):");
        String input2 = scan.next();
        while (!map.containsKey(input2) || input2.length() > 1) {
            displayError("You must chose a letter between a & h");
            System.out.println("Pick a column line (a-h):");
            input2 = scan.next();
        }

        Position pos = new Position(input1, map.get(input2));
        return pos;
    }

    /**
     * Display the Error messages
     *
     * @param message message text
     */
    @Override
    public void displayError(String message) {
        System.out.println("Error: " + message);
    }

}
