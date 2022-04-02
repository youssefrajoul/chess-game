package g59939.chess.view;

import g59939.chess.model.Color;
import g59939.chess.model.Model;
import g59939.chess.model.Position;
import java.util.List;
import java.util.Scanner;

/**
 * This Class treats Text inputs and outputs (messages and keyboard input)
 * @author g59939
 */
public class TextView implements View {

    private final Model model;
    int timer;

    public TextView(Model model) {
        this.model = model;
    }

    /**
     * Method to Display the title when game start
     */
    @Override
    public void displayTitle() {
        System.out.println("""
                           \u001b[33m        JEU D'ECHECS     
                                     BIENVENUE    \u001b[m""");
    }

    /**
     * Method Display the whole board of chess game
     */
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

    /**
     * Method display the winner
     */
    @Override
    public void displayWinner() {
        System.out.print("\n");
        System.out.println("Le gagnant est :" + model.getOppositePlayer());
        System.out.println("Le Perdant est :" + model.getCurrentPlayer());
    }

    /**
     * Method to display the Current Player
     */
    @Override
    public void displayPlayer() {
        System.out.print("\n");
        System.out.println("JOUEUR " + model.getCurrentPlayer()+ " est invité à jouer : ");
        System.out.print("\n");
    }

    /**
     * Method ask player to input positions
     * @return 
     */
    @Override
    public Position askPosition() {
        
        if (timer == 0) {
            System.out.println("Position de depart est ?");
            timer = 1;
        } else {
            System.out.println("Position d'arrivee est ?");
            timer = 0;
        }
        String position = scanKeyboard("{Veuillez entrer une position (1-8 | a-h). Exemple : 2b ou 6d):");
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
            displayError("INVALIDE : Entrez une position valide. Exemple: 3c");
            position = scanKeyboard("Nouvelle position : ");
        }
        int row = rangeOfNumbers.indexOf(position.substring(0, 1));
        int column = rangeOfLetters.indexOf(position.substring(1, 2));
        return new Position(row, column);
    }

    /**
     * Method to display error when player set wrong position
     * @param message 
     */
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
