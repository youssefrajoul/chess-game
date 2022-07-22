package g59939.chess.model;

/**
 * Represents the position of pieces
 *
 * @author g59939
 */
public class Position {

    private int row;
    private int column;

    /**
     * Constructor of the class with two parameters
     *
     * @param row
     * @param column
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Gets the row of the position
     *
     * @return
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column of the position
     *
     * @return
     */
    public int getColumn() {
        return column;
    }

    /**
     * Gets the next position of the piece
     * @param dir object of type direction that gives the direction of the next position
     * @return an object with new row & column coordinates
     */
    public Position next(Direction dir) {
        Position nextPos = new Position(getRow() + dir.getDeltaRow(), getColumn() + dir.getDeltaColumn());
        return nextPos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.row;
        hash = 71 * hash + this.column;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }

}
