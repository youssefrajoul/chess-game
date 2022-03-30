package g59939.chess.model;

/**
 *
 * @author g59939
 */
public class Piece {
    private final Color color;
    
    /**
     * Constructor to initialize the attribute of this class
     * @param color 
     */
    public Piece(Color color) {
        this.color = color;
    }
    
    /**
     * This getter method returns the pawn's color
     * @return 
     */
    public Color getColor() {
        return color;
    }
}
