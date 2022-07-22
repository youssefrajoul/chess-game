package g59939.chess.model;

/**
 * Represents the Pieces of the game (Pawn, Queen, Rook ...)
 * @author g59939
 */
public class Piece {
    private Color color;

    /**
     * constructor of the class
     * @param color a parameter of type Color
     */
    public Piece(Color color) {
        this.color = color;
    }

    /**
     * Gets the color of the piece
     * @return 
     */
    public Color getColor() {
        return color;
    }
}
