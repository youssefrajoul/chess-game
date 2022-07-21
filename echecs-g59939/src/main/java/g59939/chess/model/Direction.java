package g59939.chess.model;

/**
 * Represents the direction where to move the pieces
 * @author HONOR
 */
public enum Direction {
    NW(1,-1),
    N(1,-1),
    NE(1,-1),
    W(1,-1),
    E(1,-1),
    SW(1,-1),
    S(1,-1),
    SE(1,-1);
    
    private int deltaRow;
    private int deltaColumn;

    /**
     * Constructor of the class with two parameters
     * @param deltaR
     * @param deltaC 
     */
    private Direction(int deltaR, int deltaC) {
        this.deltaRow = deltaR;
        this.deltaColumn = deltaC;
    }

    /**
     * Gets the row of the next position
     * @return 
     */
    public int getDeltaRow() {
        return deltaRow;
    }

    /**
     * Gets the column of the next position
     * @return 
     */
    public int getDeltaColumn() {
        return deltaColumn;
    }
    
    
}
