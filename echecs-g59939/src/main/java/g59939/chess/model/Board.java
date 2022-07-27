package g59939.chess.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the board of the chess game
 * @author g59939
 */
public class Board {

    private final Square tableau[][];

    /**
     * Constructor of the Class initialize an array of 64 cases
     */
    public Board() {
        tableau = new Square[8][8];
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                tableau[i][j] = new Square(null);
            }
        }
    }

    /**
     * Gets if the position is within the board or not
     * @param pos Object of type position
     * @return true if the position is within the board or false otherwise
     */
    public boolean contains(Position pos) {
        return (pos.getRow() <= 7 && pos.getRow() >= 0 && pos.getColumn() <= 7 && pos.getColumn() >= 0);
    }

    /**
     * Sets a chess piece in the position passed in parameters
     * @param piece object of type Piece
     * @param position object of type Position
     */
    public void setPiece(Piece piece, Position position) {
        tableau[position.getRow()][position.getColumn()].setPiece(piece);
    }

    /**
     * Gets the piece that is in the position passed in parameters
     * @param pos object of type Position
     * @return Object Piece
     */
    public Piece getPiece(Position pos) {
        return tableau[pos.getRow()][pos.getColumn()].getPiece();
    }

    /**
     * Gets the Initial Pawn rows for bor both players
     * @param color Object of type Color
     * @return the number of the line
     */
    public int getInitialPawnRow(Color color) {
        if (color == Color.WHITE) {
            return 1;
        } else {
            return 6;
        }
    }

    /**
     * Removes the piece from the position passed in parameters
     * @param pos Object of type Position
     */
    public void dropPiece(Position pos) {
        tableau[pos.getRow()][pos.getColumn()].setPiece(null);
    }

    /**
     * Checks if the position passed in parameters is free or not
     * @param pos Object of type Position
     * @return True if the position is free or False if not
     */
    public boolean isFree(Position pos) {
        return tableau[pos.getRow()][pos.getColumn()].isFree();
    }

    /**
     * Checks if the position passed in parameters has the opposite Color(Player)
     * @param pos Object of type Position
     * @param col Object of type Color
     * @return True if the position has a different color player or False otherwise
     */
    public boolean containsOppositeColor(Position pos, Color col) {
        if (isFree(pos)) {
            return false;
        } else {
            return (tableau[pos.getRow()][pos.getColumn()].getPiece().getColor() == col.opposite());
        }
    }

    /**
     * Gets the list of the positions occupied by the player object passed in parameters
     * @param player object of type Player
     * @return List of positions
     */
    public List<Position> getPositionsOccupiedBy(Player player) {
        List<Position> list = new ArrayList<>();
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                if (!isFree(new Position(i, j))) {
                    if (tableau[i][j].getPiece().getColor() == player.getColor()) {
                        Position pos = new Position(i, j);
                        list.add(pos);
                    }
                }
            }
        }
        return list;
    }

}
