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

    public Position next(Direction dir) {
        Position nouvellePostion = new Position(this.row + dir.getDeltaRow(), this.column + dir.getDeltaColumn());
        return nouvellePostion;
    }
}
