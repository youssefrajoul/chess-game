package g59939.chess.model.pieces;

import g59939.chess.model.Board;
import g59939.chess.model.Color;
import g59939.chess.model.Direction;
import g59939.chess.model.Position;
import java.util.*;

/**
 * Represents the pawn
 * @author g59939
 */
public class Pawn extends Piece {

    /**
     * constructor of the sub-Class
     * @param color 
     */
    public Pawn(Color color) {
        super(color);
    }

    /**
     * Gets the list of possible Moves for Pawns
     *
     * @param position the current position
     * @param board the board of chess game
     * @return List of possible moves for a pawn
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> possibleMoves;
        possibleMoves = new ArrayList<>();

        whitePiecePossMoves(possibleMoves, position, board);

        blackPiecePossMoves(possibleMoves, position, board);

        return possibleMoves;
    }

    /**
     * Sub-Method to get only white possible vertical moves
     *
     * @param possibleMoves List of possible moves
     * @param position represents the current position of the pawn
     * @param board the board of chess game
     */
    private void whitePiecePossMoves(List<Position> possibleMoves, Position position, Board board) {
        if (board.getPiece(position).getColor() == Color.WHITE && board.contains(position.next(Direction.N))) {
            // Vertical Moves
            if (board.isFree(position.next(Direction.N))) {
                possibleMoves.add(position.next(Direction.N));
                if (board.contains(position.next(Direction.N).next(Direction.N))) {
                    if (board.isFree(position.next(Direction.N).next(Direction.N)) && position.getRow() == board.getInitialPawnRow(board.getPiece(position).getColor())) {
                        possibleMoves.add(position.next(Direction.N).next(Direction.N));
                    }
                }
            }
            // Diagonal Movess
            if (board.contains(position.next(Direction.NE))) {
                possAttackMoves(possibleMoves, position, board, Direction.NE, Color.WHITE);
            }
            if (board.contains(position.next(Direction.NW))) {
                possAttackMoves(possibleMoves, position, board, Direction.NW, Color.WHITE);
            }
        }
    }

    /**
     * Sub-Method to get only black possible vertical moves
     *
     * @param possibleMoves List of possible moves
     * @param position represents the current position of the pawn
     * @param board the board of chess game
     */
    private void blackPiecePossMoves(List<Position> possibleMoves, Position position, Board board) {
        if (board.getPiece(position).getColor() == Color.BLACK && board.contains(position.next(Direction.S))) {
            // Vertical Moves
            if (board.isFree(position.next(Direction.S))) {
                possibleMoves.add(position.next(Direction.S));
                if (board.contains(position.next(Direction.S).next(Direction.S))) {
                    if (board.isFree(position.next(Direction.S).next(Direction.S)) && position.getRow() == board.getInitialPawnRow(board.getPiece(position).getColor())) {
                        possibleMoves.add(position.next(Direction.S).next(Direction.S));
                    }
                }
            }
            // Diagonal Moves
            if (board.contains(position.next(Direction.SE))) {
                possAttackMoves(possibleMoves, position, board, Direction.SE, Color.BLACK);
            }
            if (board.contains(position.next(Direction.SW))) {
                possAttackMoves(possibleMoves, position, board, Direction.SW, Color.BLACK);
            }
        }
    }

    /**
     * Sub-Method to get only the possible attacking Moves (diagonal)
     *
     * @param possibleMoves List of possible moves
     * @param position represents the current position of the pawn
     * @param board the board of chess game
     * @param direction represents the direction of the next move
     */
    private void possAttackMoves(List<Position> possAttackMoves, Position position, Board board, Direction direction, Color color) {
        if (!board.isFree(position.next(direction)) && board.containsOppositeColor(position.next(direction), color)) {
            possAttackMoves.add(position.next(direction));
        }
    }

    /**
     * Gets the list of possible capturing moves for the pawn
     * @param position represents the current position of the pawn
     * @param board the board of chess game
     * @return list of positions where the pawn can capture the opponents pieces
     */
    @Override
    public List<Position> getCapturePositions(Position position, Board board) {
        List<Position> possibleCapturesList = new ArrayList<>();
        if (board.getPiece(position).getColor() == Color.WHITE && board.contains(position.next(Direction.N))) {
            // Diagonal Movess
            if (board.contains(position.next(Direction.NE))) {
                possAttackMoves(possibleCapturesList, position, board, Direction.NE, Color.WHITE);
            }
            if (board.contains(position.next(Direction.NW))) {
                possAttackMoves(possibleCapturesList, position, board, Direction.NW, Color.WHITE);
            }
        }
        if (board.getPiece(position).getColor() == Color.BLACK && board.contains(position.next(Direction.S))) {
            // Diagonal Moves
            if (board.contains(position.next(Direction.SE))) {
                possAttackMoves(possibleCapturesList, position, board, Direction.SE, Color.BLACK);
            }
            if (board.contains(position.next(Direction.SW))) {
                possAttackMoves(possibleCapturesList, position, board, Direction.SW, Color.BLACK);
            }
        }
        return possibleCapturesList;
    }
}
