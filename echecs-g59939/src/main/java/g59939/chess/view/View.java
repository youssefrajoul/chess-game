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
     * Display that the opponent is in check
     */
    public void displayCheck();

    /**
     * Display that the opponent is in checkMate and announce the winner
     */
    public void displayMat();
    
    /**
     * Display that the opponent is the winner
     */
    public void displayQuit();

    /**
     * Display that the game is draw
     */
    public void displayStaleMat();

    /**
     * Display a message telling the Current player to play
     */
    public void displayPlayer();

    /**
     * Asks if the player wants to quit the game
     */
    public void quitGame();
    
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
