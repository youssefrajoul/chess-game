package g59939.chess.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g59939
 */
public class Piece {

    private final Color color;

    /**
     * Constructor to initialize the attribute of this class
     *
     * @param color
     */
    public Piece(Color color) {
        this.color = color;
    }

    /**
     * This getter method returns the pawn's color
     *
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     * This Method gets possible moves of the Piece in all Conditions
     *
     * @param position position of the piece
     * @param board the chessGame board 64*64 square.
     * @return List of possible moves to make.
     */
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> ListOfMoves = new ArrayList<>();
        if (position.getRow() == board.getInitialPawnRow(color)) {
            twoMovesForward(ListOfMoves, position, board);
            OpenentDetectedMoves(ListOfMoves, position, board);
        } else {
            oneMoveForward(ListOfMoves, position, board);
            OpenentDetectedMoves(ListOfMoves, position, board);
        }

        return ListOfMoves;
    }

    /**
     * Sub Method of the method getPossibleMoves : it treats the moves of the
     * pawn when this one didn't move yet
     *
     * @param ListOfMoves
     * @param position
     * @param board
     * @return List of possible moves to make in these circumstances
     */
    private List<Position> twoMovesForward(List<Position> ListOfMoves, Position position, Board board) {
        if (color == Color.BLACK) {
            //if else condition to test if the next Position is Free or not.
            if (board.isFree(position.next(Direction.S)) && board.isFree(position.next(Direction.S).next(Direction.S))) {
                ListOfMoves.add(position.next(Direction.S));
                ListOfMoves.add(position.next(Direction.S).next(Direction.S));
            } else if (board.isFree(position.next(Direction.S))) {
                ListOfMoves.add(position.next(Direction.S));
            }
            //------------------------------------------
        } else {
            if (board.isFree(position.next(Direction.N)) && board.isFree(position.next(Direction.N).next(Direction.N))) {
                ListOfMoves.add(position.next(Direction.N));
                ListOfMoves.add(position.next(Direction.N).next(Direction.N));
            } else if (board.isFree(position.next(Direction.N))) {
                ListOfMoves.add(position.next(Direction.N));
            }
        }
        return ListOfMoves;
    }

    /**
     * Sub Method of the method getPossibleMoves : it treats the moves of the
     * pawn when this one already moved
     *
     * @param ListOfMoves
     * @param position
     * @param board
     * @return List of possible moves to make in these circumstances
     */
    private List<Position> oneMoveForward(List<Position> ListOfMoves, Position position, Board board) {
        if (color == Color.BLACK) {
            //if else condition to test if the next Position is Free or not.
            if (board.isFree(position.next(Direction.S))) {
                ListOfMoves.add(position.next(Direction.S));
            }
            //------------------------------------------
        } else {
            if (board.isFree(position.next(Direction.N))) {
                ListOfMoves.add(position.next(Direction.N));
            }
        }
        return ListOfMoves;
    }

    /**
     * Sub Method of the method getPossibleMoves : it detects if a position is
     * occupied by an Opponent
     *
     * @param ListOfMoves
     * @param position
     * @param board
     */
    private void OpenentDetectedMoves(List<Position> ListOfMoves, Position position, Board board) {
        if (color == Color.WHITE) {
            blackOpenentDetectedMoves(ListOfMoves, position, board);
        } else {
            whiteOpenentDetected(ListOfMoves, position, board);
        }
    }

    /**
     * Sub Method of the method OpenentDetectedMoves : it detects if a position
     * is occupied by an Black Opponent
     *
     * @param ListOfMoves
     * @param position
     * @param board
     * @return List of possible moves to make in these circumstances
     */
    private List<Position> blackOpenentDetectedMoves(List<Position> ListOfMoves, Position position, Board board) {
        //if else condition to vertical and diagonal moves if Opponent is there
        if (board.containsOppositeColor(position.next(Direction.N), color)) {
            ListOfMoves.clear();
        } else {
            if (board.containsOppositeColor(position.next(Direction.NW), color) && board.containsOppositeColor(position.next(Direction.NE), color)) {
                ListOfMoves.add(position.next(Direction.NW));
                ListOfMoves.add(position.next(Direction.NE));
            } else if (board.containsOppositeColor(position.next(Direction.NW), color)) {
                ListOfMoves.add(position.next(Direction.NW));
            } else if (board.containsOppositeColor(position.next(Direction.NE), color)) {
                ListOfMoves.add(position.next(Direction.NE));
            }
        }
        return ListOfMoves;
    }

    /**
     * Sub Method of the method OpenentDetectedMoves : it detects if a position
     * is occupied by an White Opponent
     *
     * @param ListOfMoves
     * @param position
     * @param board
     * @return List of possible moves to make in these circumstances
     */
    private List<Position> whiteOpenentDetected(List<Position> ListOfMoves, Position position, Board board) {
        //if else condition to vertical and diagonal moves if Opponent is there
        if (board.containsOppositeColor(position.next(Direction.S), color)) {
            ListOfMoves.clear();
        } else {
            if (board.containsOppositeColor(position.next(Direction.SW), color) && board.containsOppositeColor(position.next(Direction.SE), color)) {
                ListOfMoves.add(position.next(Direction.SW));
                ListOfMoves.add(position.next(Direction.SE));
            } else if (board.containsOppositeColor(position.next(Direction.SW), color)) {
                ListOfMoves.add(position.next(Direction.SW));
            } else if (board.containsOppositeColor(position.next(Direction.SE), color)) {
                ListOfMoves.add(position.next(Direction.SE));
            }
        }
        return ListOfMoves;
    }

}
