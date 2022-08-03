package g59939.chess.model.pieces;

import g59939.chess.model.Board;
import g59939.chess.model.Color;
import g59939.chess.model.Direction;
import g59939.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Rook of the chess game
 *
 * @author HONOR
 */
public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color);
    }

    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> possMovesList = new ArrayList<>();
        List<Direction> listOfDirections = List.of(
                (Direction.NE),
                (Direction.NW),
                (Direction.SE),
                (Direction.SW)
        );
        for (int i = 0; i < listOfDirections.size(); i++) {
            for (int j = 0; j < listOfDirections.size(); j++) {
                if (board.contains(nextPosition(j, listOfDirections.get(i), position))
                        && board.isFree(nextPosition(j, listOfDirections.get(i), position))) {
                    possMovesList.add(nextPosition(j, listOfDirections.get(i), position));
                } else if (board.contains(nextPosition(j, listOfDirections.get(i), position))
                        && !board.isFree(nextPosition(j, listOfDirections.get(i), position))
                        && board.getPiece(nextPosition(j, listOfDirections.get(i), position)).getColor() != getColor()) {
                    possMovesList.add(nextPosition(j, listOfDirections.get(i), position));
                    break;
                } else if (board.contains(nextPosition(j, listOfDirections.get(i), position))
                        && !board.isFree(nextPosition(j, listOfDirections.get(i), position))
                        && board.getPiece(nextPosition(j, listOfDirections.get(i), position)).getColor() == getColor()) {
                    break;
                }

            }
        }
        return possMovesList;
    }

}
