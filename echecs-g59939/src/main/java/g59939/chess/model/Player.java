package g59939.chess.model;

/**
 *
 * @author g59939
 */
public class Player {
    
    private Color color;
    
    /**
     * Constructor to initialize the attribute of this class
     * @param color 
     */
    public Player(Color color) {
        this.color = color;
    }
    
    /**
     * This getter method returns the player's color
     * @return 
     */
    public Color getColor() {
        return color;
    }
    
}
