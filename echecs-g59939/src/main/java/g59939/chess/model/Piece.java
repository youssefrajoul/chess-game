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

    private void whitePiecePossMoves(List<Position> possMovesList, Position position, Board board) {
        if (board.getPiece(position).getColor() == Color.WHITE && board.contains(position.next(Direction.N))) {
            if (board.isFree(position.next(Direction.N))) {
                possMovesList.add(position.next(Direction.N));
                if (board.isFree(position.next(Direction.N).next(Direction.N)) && position.getRow() == board.getInitialPawnRow(board.getPiece(position).getColor())) {
                    possMovesList.add(position.next(Direction.N).next(Direction.N));
                }
            }
            if (!board.isFree(position.next(Direction.NE)) && board.containsOppositeColor(position.next(Direction.NE), Color.WHITE)) {
                possMovesList.add(position.next(Direction.NE));
            }
            if (!board.isFree(position.next(Direction.NW)) && board.containsOppositeColor(position.next(Direction.NW), Color.WHITE)) {
                possMovesList.add(position.next(Direction.NW));
            }
        }
    }

    private void blackPiecePossMoves(List<Position> possMovesList, Position position, Board board) {
        if (board.getPiece(position).getColor() == Color.BLACK && board.contains(position.next(Direction.S))) {
            if (board.isFree(position.next(Direction.S))) {
                possMovesList.add(position.next(Direction.S));
                if (board.isFree(position.next(Direction.S).next(Direction.S)) && position.getRow() == board.getInitialPawnRow(board.getPiece(position).getColor())) {
                    possMovesList.add(position.next(Direction.S).next(Direction.S));
                }
            }
            if (!board.isFree(position.next(Direction.SE)) && board.containsOppositeColor(position.next(Direction.SE), Color.BLACK)) {
                possMovesList.add(position.next(Direction.SE));
            }
            if (!board.isFree(position.next(Direction.SW)) && board.containsOppositeColor(position.next(Direction.SW), Color.BLACK)) {
                possMovesList.add(position.next(Direction.SW));
            }
        }
    }

    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> possMovesList;
        possMovesList = new ArrayList<>();

        whitePiecePossMoves(possMovesList, position, board);
        ///////////////////////
        blackPiecePossMoves(possMovesList, position, board);
        
        return possMovesList;
    }
}
