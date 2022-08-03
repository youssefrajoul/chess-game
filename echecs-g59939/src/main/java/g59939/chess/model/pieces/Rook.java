package g59939.chess.model.pieces;

import g59939.chess.model.Board;
import g59939.chess.model.Color;
import g59939.chess.model.Position;
import java.util.List;

/**
 * Represents the Rook of the chess game
 *
 * @author g59939
 */
public class Rook extends Piece {

    /**
     * Constructor of the Class
     *
     * @param color
     */
    public Rook(Color color) {
        super(color);
    }

    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
