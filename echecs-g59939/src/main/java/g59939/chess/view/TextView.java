package g59939.chess.view;

import g59939.chess.model.Board;
import g59939.chess.model.Color;
import g59939.chess.model.Model;
import g59939.chess.model.Piece;
import g59939.chess.model.Player;
import g59939.chess.model.Position;
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
        System.out.println("Welcome to ESI Chess Game");
    }

    /**
     * Display the board of the Chess Game
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
                    System.out.print("PW");
                } else {
                    System.out.print("PB");
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
        System.out.println("The Winner is : " + model.getOppositePlayer().getColor());
    }

    /**
     * Display the current player
     */
    @Override
    public void displayPlayer() {
        System.out.println("Current player : " + model.getCurrentPlayer().getColor());
    }

    /**
     * Treats the input of the player (ask for positions)
     *
     * @return the Position that the player chose
     */
    @Override
    public Position askPosition() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('b', 1);
        map.put('c', 2);
        map.put('d', 3);
        map.put('e', 4);
        map.put('f', 5);
        map.put('g', 6);
        map.put('h', 7);
        System.out.println("Veuillez entrez une position valide.");
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez un chiffre (1-8):");
        int input1 = scan.nextInt() - 1;
        System.out.println("Entrez une lettre (a-h):");
        char input2 = scan.next().charAt(0);
        Position pos = new Position(input1, map.get(input2));
        return pos;
        /// to do // Lecture Robust
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
