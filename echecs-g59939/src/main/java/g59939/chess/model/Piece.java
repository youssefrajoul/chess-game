package g59939.chess.model;

import java.util.*;

/**
 * Represents the Pieces of the game (Pawn, Queen, Rook ...)
 *
 * @author g59939
 */
public class Piece {

    private Color color;

    /**
     * constructor of the class
     *
     * @param color a parameter of type Color
     */
    public Piece(Color color) {
        this.color = color;
    }

    /**
     * Gets the color of the piece
     *
     * @return
     */
    public Color getColor() {
        return color;
    }

    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> possMovesList;
        possMovesList = new ArrayList<>();
        if (board.getPiece(position).getColor() == Color.WHITE) {
            if (board.isFree(position.next(Direction.N))) {
                possMovesList.add(position.next(Direction.N));
                if (board.isFree(position.next(Direction.N).next(Direction.N)) && position.getRow() == 1) {
                    possMovesList.add(position.next(Direction.N));
                }
            }
        }
        if (board.getPiece(position).getColor() == Color.BLACK) {
            if (board.isFree(position.next(Direction.S))) {
                possMovesList.add(position.next(Direction.S));
                if (board.isFree(position.next(Direction.N).next(Direction.N)) && board.getInitialPawnRow(board.getPiece(position).getColor()) == 6) {
                    possMovesList.add(position.next(Direction.N));
                }
            }
        }
        return possMovesList;
    }
}
