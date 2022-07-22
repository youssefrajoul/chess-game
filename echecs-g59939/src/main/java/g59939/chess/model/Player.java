package g59939.chess.model;

/**
 * Represents the player in the game
 *
 * @author g59939
 */
public class Player {

    private final Color color;

    /**
     * Constructor of the class
     *
     * @param color one parameter of type Color
     */
    public Player(Color color) {
        this.color = color;
    }

    /**
     * Gets the color of the player
     *
     * @return
     */
    public Color getColor() {
        return color;
    }
}
