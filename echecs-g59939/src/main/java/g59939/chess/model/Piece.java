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

    /**
     * Gets the list of possible Moves
     *
     * @param position Object of type Position
     * @param board Object of type Board
     * @return List of type Position
     */
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> possibleMoves;
        possibleMoves = new ArrayList<>();

        whitePiecePossMoves(possibleMoves, position, board);

        blackPiecePossMoves(possibleMoves, position, board);

        return possibleMoves;
    }

    /**
     * Sub-Method to got only white possible moves
     *
     * @param possibleMoves List of type position
     * @param position object Position
     * @param board Object Board
     */
    private void whitePiecePossMoves(List<Position> possibleMoves, Position position, Board board) {
        if (board.getPiece(position).getColor() == Color.WHITE && board.contains(position.next(Direction.N))) {
            // Vertical Moves
            if (board.isFree(position.next(Direction.N))) {
                possibleMoves.add(position.next(Direction.N));
                if (board.isFree(position.next(Direction.N).next(Direction.N)) && position.getRow() == board.getInitialPawnRow(board.getPiece(position).getColor())) {
                    possibleMoves.add(position.next(Direction.N).next(Direction.N));
                }
            }
            if (board.contains(position.next(Direction.NE))) {
                possAttackMoves(possibleMoves, position, board, Direction.NE, Color.WHITE);
            }
            if (board.contains(position.next(Direction.NW))) {
                possAttackMoves(possibleMoves, position, board, Direction.NW, Color.WHITE);
            }
        }
    }

    private void blackPiecePossMoves(List<Position> possibleMoves, Position position, Board board) {
        if (board.getPiece(position).getColor() == Color.BLACK && board.contains(position.next(Direction.S))) {
            // Vertical Moves
            if (board.isFree(position.next(Direction.S))) {
                possibleMoves.add(position.next(Direction.S));
                if (board.isFree(position.next(Direction.S).next(Direction.S)) && position.getRow() == board.getInitialPawnRow(board.getPiece(position).getColor())) {
                    possibleMoves.add(position.next(Direction.S).next(Direction.S));
                }
            }
            if (board.contains(position.next(Direction.SE))) {
                possAttackMoves(possibleMoves, position, board, Direction.SE, Color.BLACK);
            }
            if (board.contains(position.next(Direction.SW))) {
                possAttackMoves(possibleMoves, position, board, Direction.SW, Color.BLACK);
            }
        }
    }

    /**
     * Sub-Method to get only the possible attacking Moves
     *
     * @param possibleMoves List of type position
     * @param position object Position
     * @param board Object Board
     * @param direction object Direction
     */
    private void possAttackMoves(List<Position> possibleMoves, Position position, Board board, Direction direction, Color color) {
        if (!board.isFree(position.next(direction)) && board.containsOppositeColor(position.next(direction), color)) {
            possibleMoves.add(position.next(direction));
        }
    }
}
