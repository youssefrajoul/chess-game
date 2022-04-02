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
        //Vertical
        if (color == Color.WHITE) {
            if (board.contains(position.next(Direction.N))) {
                if (board.isFree(position.next(Direction.N))) {
                    ListOfMoves.add(position.next(Direction.N));
                    if (position.getRow() == 1) {
                        if (board.isFree(position.next(Direction.N).next(Direction.N))) {
                            ListOfMoves.add(position.next(Direction.N).next(Direction.N));
                        }
                    }
                }
            }
        } else {
            if (board.contains(position.next(Direction.S))) {
                if (board.isFree(position.next(Direction.S))) {
                    ListOfMoves.add(position.next(Direction.S));
                    if (position.getRow() == 6) {
                        if (board.isFree(position.next(Direction.S).next(Direction.S))) {
                            ListOfMoves.add(position.next(Direction.S).next(Direction.S));
                        }
                    }
                }
            }

        }

        //Diagonal
        if (color == Color.WHITE) {
            if (board.contains(position.next(Direction.N))) {
                switch (position.getColumn()) {
                    case 0 -> {
                        if (board.containsOppositeColor(position.next(Direction.NE), color)) {
                            ListOfMoves.add(position.next(Direction.NE));
                        }
                    }
                    case 7 -> {
                        if (board.containsOppositeColor(position.next(Direction.NW), color)) {
                            ListOfMoves.add(position.next(Direction.NW));
                        }
                    }
                    default -> {
                        if (board.containsOppositeColor(position.next(Direction.NW), color)) {
                            ListOfMoves.add(position.next(Direction.NW));
                        }
                        if (board.containsOppositeColor(position.next(Direction.NE), color)) {
                            ListOfMoves.add(position.next(Direction.NE));
                        }
                    }
                }
            }

        } else {
            if (board.contains(position.next(Direction.S))) {
                switch (position.getColumn()) {
                    case 0 -> {
                        if (board.containsOppositeColor(position.next(Direction.SE), color)) {
                            ListOfMoves.add(position.next(Direction.SE));
                        }
                    }
                    case 7 -> {
                        if (board.containsOppositeColor(position.next(Direction.SW), color)) {
                            ListOfMoves.add(position.next(Direction.SW));
                        }
                    }
                    default -> {
                        if (board.containsOppositeColor(position.next(Direction.SW), color)) {
                            ListOfMoves.add(position.next(Direction.SW));
                        }
                        if (board.containsOppositeColor(position.next(Direction.SE), color)) {
                            ListOfMoves.add(position.next(Direction.SE));
                        }
                    }
                }
            }

        }
        
        return ListOfMoves;
    }

}
