package g59939.chess.model;

/**
 * Represents the position of pieces
 * @author HONOR
 */
public class Position {
    private int row;
    private int column;

    /**
     * Constructor of the class with two parameters
     * @param row
     * @param column 
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Gets the row of the position
     * @return 
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column of the position
     * @return 
     */
    public int getColumn() {
        return column;
    }
}
