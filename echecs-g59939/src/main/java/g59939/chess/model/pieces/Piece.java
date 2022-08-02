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
    public abstract List<Position> getPossibleMoves(Position position, Board board);

    /**
     * 
     * @param position
     * @param board
     * @return 
     */
    public List<Position> getCapturePositions(Position position, Board board) {
        List<Position> listPossibleMoves = getPossibleMoves(position, board);
        List<Position> listCapturePositions = new ArrayList<>();
        Iterator<Position> iterator = listPossibleMoves.iterator();
        while (iterator.hasNext()) { 
            Position possiblePosition = iterator.next();
            if (board.containsOppositeColor(possiblePosition, board.getPiece(position).getColor())) {
                listCapturePositions.add(possiblePosition);
            }
        }
        return listCapturePositions;
    }
}
