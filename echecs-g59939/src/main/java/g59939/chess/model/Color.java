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
