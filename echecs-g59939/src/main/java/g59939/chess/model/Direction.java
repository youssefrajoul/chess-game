package g59939.chess.model;

/**
 * Represents the direction where to move the pieces
 *
 * @author g59939
 */
public enum Direction {
    NW(1, -1),
    N(1, 0),
    NE(1, 1),
    W(0, -1),
    E(0, 1),
    SW(-1, -1),
    S(-1, 0),
    SE(-1, 1);

    private int deltaRow;
    private int deltaColumn;

    /**
     * Constructor of the class with two parameters
     *
     * @param deltaR
     * @param deltaC
     */
    private Direction(int deltaR, int deltaC) {
        this.deltaRow = deltaR;
        this.deltaColumn = deltaC;
    }

    /**
     * Gets the row of the next position
     *
     * @return
     */
    public int getDeltaRow() {
        return deltaRow;
    }

    /**
     * Gets the column of the next position
     *
     * @return
     */
    public int getDeltaColumn() {
        return deltaColumn;
    }

}
