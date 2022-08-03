package g59939.chess.model.pieces;

import g59939.chess.model.Board;
import g59939.chess.model.Color;
import g59939.chess.model.Direction;
import g59939.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the King of chess game
 *
 * @author g59939
 */
public class King extends Piece {

    /**
     * constructor of the class
     *
     * @param color
     */
    public King(Color color) {
        super(color);
    }

    /**
     * Gets the list of possible moves for King
     *
     * @param position the current position of the King
     * @param board the chess game board
     * @return a list of all possible moves for King
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> possMovesList = new ArrayList<>();
        List<Position> list = List.of(
                position.next(Direction.N),
                position.next(Direction.NE),
                position.next(Direction.NW),
                position.next(Direction.E),
                position.next(Direction.W),
                position.next(Direction.S),
                position.next(Direction.SE),
                position.next(Direction.SW)
        );
        for (int i = 0; i < list.size(); i++) {
            if (board.contains(list.get(i)) && board.isFree(list.get(i))) {
                possMovesList.add(list.get(i));
            }
            if (board.contains(list.get(i)) && !board.isFree(list.get(i)) && getColor() != board.getPiece(list.get(i)).getColor()) {
                possMovesList.add(list.get(i));
            }
        }
        return possMovesList;
    }

}
