/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g59939.chess.model;

/**
 *
 * @author g59939
 */
public class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    /**
     * this method gets the row of the position
     * @return row fo the position
     */
    public int getRow() {
        return row;
    }
    
    /**
     * this method gets the column of the position
     * @return column of the position
     */
    public int getColumn() {
        return column;
    }
}
