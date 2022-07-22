package g59939.chess.model;

/**
 * Represents one square of the chess board
 *
 * @author g59939
 */
public class Square {

    private Piece piece;

    /**
     * constructor of the class
     *
     * @param piece
     */
    public Square(Piece piece) {
        this.piece = piece;
    }

    /**
     * Gets the piece in the square
     *
     * @return
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Sets the piece in the square
     *
     * @param piece Object of type piece
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * Gets the square has a piece or not
     *
     * @return
     */
    public boolean isFree() {
        return piece == null;
    }
}
