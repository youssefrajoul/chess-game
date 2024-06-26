package g59939.chess.model.pieces;

import g59939.chess.model.Board;
import g59939.chess.model.Color;
import g59939.chess.model.Direction;
import g59939.chess.model.Position;
import java.util.*;

/**
 * Represents the Pieces of the game (Pawn, Queen, Rook ...)
 *
 * @author g59939
 */
public abstract class Piece {

    private Color color;
    private boolean hasMoved;

    /**
     * constructor of the class
     *
     * @param color a parameter of type Color
     */
    public Piece(Color color) {
        this.color = color;
        this.hasMoved = false;
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
     *
     * @return
     */
    public boolean isHasMoved() {
        return hasMoved;
    }

    /**
     * Gets the list of possible Moves
     *
     * @param position Object of type Position
     * @param board Object of type Board
     * @return List of type Position
     */
    public abstract List<Position> getPossibleMoves(Position position, Board board);

    /**
     * Gets the positions where the piece can capture opponents pieces
     *
     * @param position the current position of the piece
     * @param board the board of the chess game
     * @return a list of Positions
     */
    public List<Position> getCapturePositions(Position position, Board board) {
//        List<Position> listPossibleMoves = getPossibleMoves(position, board);
//        List<Position> listCapturePositions = new ArrayList<>();
//        Iterator<Position> iterator = listPossibleMoves.iterator();
//        while (iterator.hasNext()) {
//            Position possiblePosition = iterator.next();
//            if (board.containsOppositeColor(possiblePosition, board.getPiece(position).getColor())) {
//                listCapturePositions.add(possiblePosition);
//            }
//        }
//        listCapturePositions.retainAll(listPossibleMoves);
        return getPossibleMoves(position, board);
    }

    /**
     * Gets the next possible Position of the Piece in all directions
     *
     * @param numOfSteps the order of the position starting with 0 (nearest
     * position)
     * @param direction of the movement
     * @param position the current position of the queen
     * @return a possible next position for the queen
     */
    protected Position nextPosition(int numOfSteps, Direction direction, Position position) {
        List<Position> listNextPositions = List.of(
                position.next(direction),
                position.next(direction).next(direction),
                position.next(direction).next(direction).next(direction),
                position.next(direction).next(direction).next(direction).next(direction),
                position.next(direction).next(direction).next(direction).next(direction).next(direction),
                position.next(direction).next(direction).next(direction).next(direction).next(direction).next(direction),
                position.next(direction).next(direction).next(direction).next(direction).next(direction).next(direction).next(direction),
                position.next(direction).next(direction).next(direction).next(direction).next(direction).next(direction).next(direction).next(direction)
        );
        return listNextPositions.get(numOfSteps);
    }
    
    public void move(){
        hasMoved = true;
    }
}
