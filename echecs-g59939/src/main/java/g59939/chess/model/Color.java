package g59939.chess.model;

/**
 * Represents the color of the player
 *
 * @author g59939
 */
public enum Color {
    WHITE, BLACK;

    /**
     * Gets the opposite of the current color
     *
     * @return
     */
    public Color opposite() {
        if (this == Color.WHITE) {
            return BLACK;
        } else {
            return WHITE;
        }
    }
}
