package g59939.chess.model;

import g59939.chess.model.pieces.Piece;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the board of the chess game
 *
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
     *
     * @param pos Object of type position
     * @return true if the position is within the board or false otherwise
     */
    public boolean contains(Position pos) {
        return (pos.getRow() <= 7 && pos.getRow() >= 0 && pos.getColumn() <= 7 && pos.getColumn() >= 0);
    }

    /**
     * Sets a chess piece in the position passed in parameters
     *
     * @param piece object of type Piece
     * @param position object of type Position, Where to put the piece
     */
    public void setPiece(Piece piece, Position position) {
        try {
            if (!contains(position)) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {

        }
        tableau[position.getRow()][position.getColumn()].setPiece(piece);
    }

    /**
     * Gets the piece that is in the position passed in parameters
     *
     * @param pos object of type Position that we want to get the piece from
     * @return Object Piece that we want to get
     */
    public Piece getPiece(Position pos) {
        try {
            if (!contains(pos)) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {

        }
        return tableau[pos.getRow()][pos.getColumn()].getPiece();
    }

    /**
     * Gets the Initial Pawn rows for bor both players
     *
     * @param color Object of type Color
     * @return the number of the line 1 for white pawns or 6 for the black pawns
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
     *
     * @param pos Object of type Position that we want to remove the piece from
     */
    public void dropPiece(Position pos) {
        try {
            if (!contains(pos)) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {

        }
        tableau[pos.getRow()][pos.getColumn()].setPiece(null);
    }

    /**
     * Checks if the position passed in parameters is free or not
     *
     * @param pos Object of type Position representing the piece on the board
     * @return True if the position is free or False if not
     */
    public boolean isFree(Position pos) {
        try {
            if (!contains(pos)) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {

        }
        return tableau[pos.getRow()][pos.getColumn()].isFree();
    }

    /**
     * Checks if the position passed in parameters has the opposite
     * Color(Player)
     *
     * @param pos Object of type Position represents the position in the board
     * @param col Object of type Color represents the color of the piece
     * @return True if the position has a different color player or False
     * otherwise
     */
    public boolean containsOppositeColor(Position pos, Color col) {
        try {
            if (!contains(pos)) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {

        }
        if (isFree(pos)) {
            return false;
        } else {
            return (tableau[pos.getRow()][pos.getColumn()].getPiece().getColor() == col.opposite());
        }
    }

    /**
     * Gets the list of the positions occupied by the player object passed in
     * parameters
     *
     * @param player object of type Player that we want to get all of his
     * positions in the board
     * @return List of positions occupied by a player
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

    /**
     *  Gets the position of the piece in parameter
     * @param piece the piece that we want to get its position
     * @return the position of the piece in the board
     */
    public Position getPiecePosition(Piece piece) {
        Position pos = null;
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                if (!isFree(new Position(i, j))) {
                    if (tableau[i][j].getPiece() == piece) {
                        pos = new Position(i, j);
                    }
                }
            }
        }
        return pos;
    }

}
