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

    private List<Position> twoMovesForward(List<Position> ListOfMoves, Position position, Board board) {
        if (color == Color.BLACK) {
            //------------------------------------------
            if (board.isFree(position.next(Direction.S)) && board.isFree(position.next(Direction.S).next(Direction.S))) {
                ListOfMoves.add(position.next(Direction.S));
                ListOfMoves.add(position.next(Direction.S).next(Direction.S));
            } else {
                ListOfMoves.add(position.next(Direction.S));
            }

            //------------------------------------------
        } else {
            if (board.isFree(position.next(Direction.N)) && board.isFree(position.next(Direction.N).next(Direction.N))) {
                ListOfMoves.add(position.next(Direction.N));
                ListOfMoves.add(position.next(Direction.N).next(Direction.N));
            } else {
                ListOfMoves.add(position.next(Direction.N));
            }
        }
        return ListOfMoves;
    }

    private List<Position> oneMoveForward(List<Position> ListOfMoves, Position position, Board board) {
        if (color == Color.BLACK) {
            //------------------------------------------
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

    private void OpenentDetectedMoves(List<Position> ListOfMoves, Position position, Board board) {
        if (color == Color.WHITE) {
            blackOpenentDetectedMoves(ListOfMoves, position, board);
        } else {
            whiteOpenentDetected(ListOfMoves, position, board);
        }
    }

    private List<Position> blackOpenentDetectedMoves(List<Position> ListOfMoves, Position position, Board board) {
        if (board.containsOppositeColor(position.next(Direction.NW), color)&& board.containsOppositeColor(position.next(Direction.NE), color)) {
            ListOfMoves.add(position.next(Direction.NW));
            ListOfMoves.add(position.next(Direction.NE));
        } else if (board.containsOppositeColor(position.next(Direction.NW), color)) {
            ListOfMoves.add(position.next(Direction.NW));
        } else if (board.containsOppositeColor(position.next(Direction.NE), color)) {
            ListOfMoves.add(position.next(Direction.NE));
        }
        return ListOfMoves;
    }

    private List<Position> whiteOpenentDetected(List<Position> ListOfMoves, Position position, Board board) {
        if (board.containsOppositeColor(position.next(Direction.SW), color)&& board.containsOppositeColor(position.next(Direction.SE), color)) {
            ListOfMoves.add(position.next(Direction.SW));
            ListOfMoves.add(position.next(Direction.SE));
        } else if (board.containsOppositeColor(position.next(Direction.SW), color)) {
            ListOfMoves.add(position.next(Direction.SW));
        } else if (board.containsOppositeColor(position.next(Direction.SE), color)) {
            ListOfMoves.add(position.next(Direction.SE));
        }
        return ListOfMoves;
    }

}
