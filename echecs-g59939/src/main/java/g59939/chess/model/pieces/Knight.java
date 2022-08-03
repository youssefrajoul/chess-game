package g59939.chess.model.pieces;

import g59939.chess.model.Board;
import g59939.chess.model.Color;
import g59939.chess.model.Direction;
import g59939.chess.model.Position;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Represents the knight of the chess game
 * @author g59939
 */
public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
    }

    /**
     * Gets the list of possible moves for knight
     *
     * @param position the current position of the knight
     * @param board the chess game board
     * @return a list of all possible moves for knight
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> possMovesList = new ArrayList<>();

        HashMap<Integer, Position> map = new HashMap<>();
        map.put(0, position.next(Direction.NE).next(Direction.N));
        map.put(1, position.next(Direction.NE).next(Direction.E));
        map.put(2, position.next(Direction.NW).next(Direction.N));
        map.put(3, position.next(Direction.NW).next(Direction.W));
        map.put(4, position.next(Direction.SE).next(Direction.S));
        map.put(5, position.next(Direction.SE).next(Direction.E));
        map.put(6, position.next(Direction.SW).next(Direction.S));
        map.put(7, position.next(Direction.SW).next(Direction.W));
        for (int i = 0; i < map.size(); i++) {
            if (board.contains(map.get(i)) && board.isFree(map.get(i))) {
                possMovesList.add(map.get(i));
            }
            if (board.contains(map.get(i)) && !board.isFree(map.get(i)) && getColor() != board.getPiece(map.get(i)).getColor()) {
                possMovesList.add(map.get(i));
            }
        }
        return possMovesList;
    }
}
