package g59939.chess.model;

/**
 * This Class treats the 64 square of chess game
 * @author g59939
 */
public class Square {
    
    private Piece piece;

    /**
     * Constructor to initialize the attribute of this class
     * @param piece 
     */
    public Square(Piece piece) {
        this.piece = piece;
    }

    /**
     * this getter returns the piece inside that Square
     * @return 
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * This setter method sets the attribute piece of the square Class
     * @param piece 
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
    /**
     * this method checks if the square is free or not
     * @return true if it's free(no piece). or false when it isn't
     */
    public boolean isFree() {
        return this.piece == null;
    }
}