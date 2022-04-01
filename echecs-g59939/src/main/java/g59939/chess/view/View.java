package g59939.chess.view;

import g59939.chess.model.Position;

/**
 * This Interface treats Display and user interface
 * @author g59939
 */
public interface View {

    /**
     *  Display a Title & a welcome message to the players
     */
    public void displayTitle();

    /**
     *  Display a Title & a welcome message to the players
     */
    public void displayBoard();

    /**
     *  Display the winner
     */
    public void displayWinner();

    /**
     *  Display a message telling the Current player to play
     */
    public void displayPlayer();

    /**
     * Ask position(in board) to the current player
     */
    public Position askPosition();

    /**
     *  Display Error message passed as parameter
     */
    public void displayError(String message);

}
