package g59939.chess.model;

/**
 * This Class treats current and next position of chess Objects
 * @author g59939
 */
public class Position {
    //attributes
    private final int row;
    private final int column;

    /**
     * This method is used as a constructor of the position Class
     *
     * @param row of the position
     * @param column of the position
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * this method gets the row of the position
     *
     * @return row fo the position
     */
    public int getRow() {
        return row;
    }

    /**
     * this method gets the column of the position
     *
     * @return column of the position
     */
    public int getColumn() {
        return column;
    }
    
    /**
     * this method generates the new position by using Direction Class
     * @param dir
     * @return 
     */
    public Position next(Direction dir) {
        int nextRow = dir.getDeltaRow()+this.row;
        int nextColumn = dir.getDeltaColumn()+this.column;
        
        Position nextPos = new Position((nextRow),(nextColumn));
        return nextPos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
