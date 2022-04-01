package g59939.chess.model;

/**
 * This Class treats the player's color
 * @author g59939
 */
public enum Color {
    WHITE, BLACK;

    /**
     * this method returns the opposite of the current color
     *
     * @return WHITE or BLACK
     */
    public Color opposite() {
        if (this == Color.WHITE) {
            return BLACK;
        }

        return WHITE;

    }
}
