package g59939.chess.view;

import g59939.chess.model.Position;

/**
 *
 * @author g59939
 */
public interface View {

    /**
     * Display a Title & a welcome message to the players
     */
    public void displayTitle();

    /**
     * Display the chess board
     */
    public void displayBoard();

    /**
     * Display the winner
     */
    public void displayWinner();

    /**
     * Display a message telling the Current player to play
     */
    public void displayPlayer();

    /**
     * Ask a valid position(in board) to the current player
     *
     * @return
     */
    public Position askPosition();

    /**
     * Display Error message passed as parameter
     */
    public void displayError(String message);

}
