package g59939.chess.model.pieces;

import g59939.chess.model.Board;
import g59939.chess.model.Color;
import g59939.chess.model.Position;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author HONOR
 */
public class PieceTest {

    Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    void getPossibleMoves_white_knight_generic_pos() {
        Position position = new Position(3, 3);
        Knight knight = new Knight(Color.WHITE);
        board.setPiece(knight, position);

        List<Position> expected = List.of(
                new Position(5, 4),
                new Position(5, 2),
                new Position(4, 1),
                new Position(4, 5),
                new Position(2, 1),
                new Position(2, 5),
                new Position(1, 2),
                new Position(1, 4)
        );

        List<Position> positions = knight.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expected, positions
        );
    }

    @Test
    void getPossibleMoves_white_knight_near_edge() {
        Position position = new Position(1, 3);
        Knight knight = new Knight(Color.WHITE);
        board.setPiece(knight, position);

        List<Position> expected = List.of(
                new Position(3, 4),
                new Position(3, 2),
                new Position(2, 1),
                new Position(2, 5),
                new Position(0, 1),
                new Position(0, 5)
        );

        List<Position> positions = knight.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    void getPossibleMoves_white_knight_near_edge_with_opponent() {
        Position position = new Position(1, 3);
        Knight white_knight = new Knight(Color.WHITE);
        board.setPiece(white_knight, position);

        board.setPiece(new Pawn(Color.BLACK), new Position(3, 4));

        List<Position> expected = List.of(
                new Position(3, 4),
                new Position(3, 2),
                new Position(2, 1),
                new Position(2, 5),
                new Position(0, 1),
                new Position(0, 5)
        );

        List<Position> positions = white_knight.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    void getPossibleMoves_white_knight_near_edge_with_ownPiece() {
        Position position = new Position(1, 3);
        Knight white_knight = new Knight(Color.WHITE);
        board.setPiece(white_knight, position);

        board.setPiece(new Pawn(Color.WHITE), new Position(3, 4));

        List<Position> expected = List.of(
                new Position(3, 2),
                new Position(2, 1),
                new Position(2, 5),
                new Position(0, 1),
                new Position(0, 5)
        );

        List<Position> positions = white_knight.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    private void assertEqualsIgnoringOrder(List<Position> expected, List<Position> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(expected.containsAll(actual));
    }

}
