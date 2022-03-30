package g59939.chess.model;

/**
 * This Class treats direction of chess Objects
 * @author g59939
 */
public enum Direction {
    NW(1, -1), N(1, 0), NE(1, 1), W(0, -1), E(0, 1), SW(-1, -1), S(-1, 0), SE(-1, 1);

    private final int deltaRow;
    private final int deltaColumn;

    /**
     * This method is used as a constructor of the Direction Class to initialize
     * attributes (deltaRow, deltaColumn)
     *
     * @param deltaR this is the first parameter which represents the row
     * movements
     * @param deltaC this is the second parameter which represents the column
     * movements
     */
    Direction(int deltaR, int deltaC) {
        this.deltaRow = deltaR;
        this.deltaColumn = deltaC;
    }

    /**
     * this method gets the row movement(direction) of the pawn
     *
     * @return deltaRow the movement in the row
     */
    public int getDeltaRow() {
        return deltaRow;
    }

    /**
     * this method gets the column movement(direction) of the pawn
     *
     * @return deltaRow the movement in the column
     */
    public int getDeltaColumn() {
        return deltaColumn;
    }
}
