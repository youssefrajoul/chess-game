package g59939.chess.view;

import g59939.chess.model.Color;
import g59939.chess.model.Model;
import g59939.chess.model.Position;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author g59939
 */
public class TextView implements View {

    private final Model model;

    public TextView(Model model) {
        this.model = model;
    }

    @Override
    public void displayTitle() {
        System.out.println("""
                           \u001b[33m-----------JEU D'ECHECS-----------
                                    ----BIENVENUE----\u001b[m""");
    }

    @Override
    public void displayBoard() {
        String Columns = "    a  b  c  d  e  f  g  h";
        System.out.println("  ------------------------");
        for (int i = 7; i >= 0; i--) {
            System.out.print(i + 1 + " |");
            for (int j = 0; j <= 7; j++) {
                Position position = new Position(i, j);
                if (model.getPiece(position) == null) {
                    System.out.print("  |");
                    if (j == 7) {
                        System.out.print("\n");
                    }
                }
                if (model.getPiece(position) != null && model.getPiece(position).getColor() == Color.WHITE) {
                    System.out.print("PB|");
                    if (j == 7) {
                        System.out.print("\n");
                    }
                }
                if (model.getPiece(position) != null && model.getPiece(position).getColor() == Color.BLACK) {
                    System.out.print("PN|");
                    if (j == 7) {
                        System.out.print("\n");
                    }
                }
            }
        }
        System.out.println(Columns);
    }

    @Override
    public void displayWinner() {
        System.out.print("\n");
        System.out.println("Le gagnant est :" + model.getOppositePlayer());
        System.out.println("Le Perdant est :" + model.getCurrentPlayer());
    }

    @Override
    public void displayPlayer() {
        System.out.print("\n");
        System.out.println("JOUEUR " + model.getCurrentPlayer()+ " est invite a jouer : ");
        System.out.print("\n");
    }

    @Override
    public Position askPosition() {
        String position = scanKeyboard("Veuillez entrer une position (1-8 ; a-h). Exemple : 2a ou 6d");
        List<String> rangeOfNumbers = List.of("1", "2", "3", "4", "5", "6", "7", "8");
        List<String> rangeOfLetters = List.of("a", "b", "c", "d", "e", "f", "g", "h");

        while (!rangeOfNumbers.contains(position.substring(0, 1))) {
            displayError("Veuillez entrer un chiffre entre 1-8 !!!");
            position = scanKeyboard("Nouvelle position : ");
        }
        while (!rangeOfLetters.contains(position.substring(1, 2))) {
            displayError("Veuillez entrer une lettre entre a-h ?");
            position = scanKeyboard("Nouvelle position : ");
        }
        while (position == null) {
            displayError("Vous devez entrer une position valide");
            position = scanKeyboard("Nouvelle position : ");
        }
        while (position.length() != 2) {
            displayError("INVALIDE : Entrez une position valide. Exemple: 3f");
            position = scanKeyboard("Nouvelle position : ");
        }
        int row = rangeOfNumbers.indexOf(position.substring(0, 1));
        int col = rangeOfLetters.indexOf(position.substring(1, 2));
        return new Position(row, col);
    }

    @Override
    public void displayError(String message) {
        System.out.println("!!!!ERREUR!!!! : " + message);
    }

    /**
     * This Method is used to get user input
     * @param message
     * @return user input
     */
    private String scanKeyboard(String message) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(message);
        String inputData = keyboard.nextLine();
        return inputData;
    }
}
