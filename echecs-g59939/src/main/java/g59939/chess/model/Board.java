package g59939.chess.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This Class treats/creates the board of chess game
 * @author g59939
 */
public class Board {

    private final Square allSquares[][];
    public final int INITIAL_POSITION_BLACK = 6;
    public final int INITIAL_POSITION_WHITE = 1;
    public final int ROW_COLUMN_SEVEN = 7;
    public final int ROW_COLUMN_ZERO = 0;

    /**
     * this constructor creates a 2D Object.array(Board) and initialize every
     * square to null value (there is no piece).
     */
    public Board() {
        allSquares = new Square[8][8];
        for (int i = 0; i < allSquares.length; i++) {
            for (int j = 0; j < allSquares.length; j++) {
                allSquares[i][j] = new Square(null);
            }
        }
    }

    /**
     * This function check if the Object position is inside the board
     * @param position of the Object
     * @return true if the position is inside the board or false if it isn't
     */
    public boolean contains(Position position) {
        int row = position.getRow();
        int column = position.getColumn();
        return column <= ROW_COLUMN_SEVEN && column >= ROW_COLUMN_ZERO && row <= ROW_COLUMN_SEVEN && row >= ROW_COLUMN_ZERO;
    }
    
    /**
     * This function treats piece's position when chess game start
     * @param color of the player
     * @return either the row 6 "above" or 1 "bottom"
     */
    public int getInitialPawnRow(Color color) {
        if (color == Color.BLACK) {
            return INITIAL_POSITION_BLACK;
        } else {
            return INITIAL_POSITION_WHITE;
        }
    }
    
    /**
     * This function put piece's Objects on the board
     * @param piece
     * @param position 
     */
    public void setPiece(Piece piece, Position position) {
        while (position == null) {
            displayError("Vous devez entrer une position valide");
            position = scanKeyboard("Nouvelle position : ");
        }
        int row = position.getRow();
        int column = position.getColumn();
        allSquares[row][column].setPiece(piece);
    }
    
    /**
     * This function get the piece in the position passed as parameter
     * @param position
     * @return piece
     */
    public Piece getPiece(Position position) {
        if (!contains(position)) {
            throw new IllegalArgumentException("can't get piece because position is out board");
        }
        int row = position.getRow();
        int column = position.getColumn();

        return allSquares[row][column].getPiece();
    }
    
    /**
     * This function delete the piece which it's position is passed as a parameter
     * @param position 
     */
    public void dropPiece(Position position) {
        if (!contains(position)) {
            throw new IllegalArgumentException("can't drop piece because position is out board");
        }
        int row = position.getRow();
        int column = position.getColumn();
        allSquares[row][column].setPiece(null);
    }
    
    /**
     * This function checks if a position is Free or not
     * @param position
     * @return either true or false
     */
    public boolean isFree(Position position) {
        if (!contains(position)) {
            throw new IllegalArgumentException("can't treat isFree because position is out board");
        }
        int row = position.getRow();
        int column = position.getColumn();
        return allSquares[row][column].isFree();
    }
    
    /**
     * This function checks if the position passed as a first-parameter has a piece with different color 
     * from the one passed as a second-parameter
     * @param position
     * @param color
     * @return true if they are different or false if they aren't
     */
    public boolean containsOppositeColor(Position position, Color color) {
        if (!contains(position)) {
            throw new IllegalArgumentException("can't containsOppositeColor because position is out board");
        }
        if (isFree(position)) {
            return false;
        }
        int row = position.getRow();
        int column = position.getColumn();
        return allSquares[row][column].getPiece().getColor() != color;
    }
    
    /**
     * This function fill a List with the positions occupied by a player passed as a parameter
     * @param player
     * @return List of player's positions
     */
    public List<Position> getPositionOccupiedBy(Player player) {
        List<Position> ListOfPositions = new ArrayList<>();
        for (int i = 0; i < allSquares.length; i++) {
            for (int j = 0; j < allSquares.length; j++) {
                if (!allSquares[i][j].isFree()) {
                    if (allSquares[i][j].getPiece().getColor() == player.getColor()) {
                        Position pos = new Position(i, j);
                        ListOfPositions.add(pos);
                    }
                }
            }
        }
        return ListOfPositions;
    }
}