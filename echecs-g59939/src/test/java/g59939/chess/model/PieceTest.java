package g59939.chess.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author HONOR
 */
public class PieceTest {
    
    public PieceTest() {
    }
    
    /**
     * Test of getPossibleMoves method, of class Piece.
     */
    @Test
    public void testGetPossibleMoves() {
        System.out.println("getPossibleMoves Direction.N");
        Position position = new Position(4, 4);
        Board board = new Board();
        Piece piece = new Piece(Color.WHITE);
        Position newPosition1 = new Position(5, 4);
        board.setPiece(piece, position);
        List<Position> expResult = new ArrayList<>();
        expResult.add(newPosition1);
        List<Position> result = piece.getPossibleMoves(position, board);
        assertEquals(expResult, result);
    }
    
}
