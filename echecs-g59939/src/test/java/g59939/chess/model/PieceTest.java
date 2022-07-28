package g59939.chess.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author HONOR
 */
public class PieceTest {

    Board board;

    public PieceTest() {
    }

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testGetPossibleMovesPDirectionN() {
        System.out.println("getPossibleMoves DirectionN");
        Piece piece = new Piece(Color.WHITE);
        Position position = new Position(2, 4);
        board.setPiece(piece, position);

        List<Position> expected = List.of(new Position(3, 4));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPtest67() {
        System.out.println("getPossibleMoves test67");
        Piece piece = new Piece(Color.WHITE);
        Position position = new Position(6, 1);
        board.setPiece(piece, position);

        List<Position> expected = List.of(new Position(7, 1));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPDirectionNN() {
        System.out.println("getPossibleMoves DirectionNN");
        Piece piece = new Piece(Color.WHITE);
        Position position = new Position(1, 1);
        board.setPiece(piece, position);

        List<Position> expected = List.of(new Position(2, 1), new Position(3, 1));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPDirectionNE() {
        System.out.println("getPossibleMoves DirectionNE");
        Piece piece = new Piece(Color.WHITE);
        Position position = new Position(1, 4);
        Piece opponent1 = new Piece(Color.BLACK);
        Position opponentPosition1 = new Position(2, 5);
        board.setPiece(piece, position);
        board.setPiece(opponent1, opponentPosition1);

        List<Position> expected = List.of(new Position(2, 4), new Position(3, 4), new Position(2, 5));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPDirectionNENW() {
        System.out.println("getPossibleMoves DirectionNENW");
        Piece piece = new Piece(Color.WHITE);
        Position position = new Position(1, 4);
        Piece opponent1 = new Piece(Color.BLACK);
        Position opponentPosition1 = new Position(2, 5);
        Piece opponent2 = new Piece(Color.BLACK);
        Position opponentPosition2 = new Position(2, 4);
        Piece opponent3 = new Piece(Color.BLACK);
        Position opponentPosition3 = new Position(2, 3);
        board.setPiece(piece, position);
        board.setPiece(opponent1, opponentPosition1);
        board.setPiece(opponent2, opponentPosition2);
        board.setPiece(opponent3, opponentPosition3);

        List<Position> expected = List.of(new Position(2, 5), new Position(2, 3));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPDirectionNW() {
        System.out.println("getPossibleMoves DirectionNW");
        Piece piece = new Piece(Color.WHITE);
        Position position = new Position(1, 1);
        Piece opponent1 = new Piece(Color.BLACK);
        Position opponentPosition1 = new Position(2, 1);
        Piece opponent2 = new Piece(Color.BLACK);
        Position opponentPosition2 = new Position(2, 0);
        board.setPiece(piece, position);
        board.setPiece(opponent1, opponentPosition1);
        board.setPiece(opponent2, opponentPosition2);

        List<Position> expected = List.of(new Position(2, 0));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPDirectionNEdge() {
        System.out.println("getPossibleMoves DirectionN Edge");
        Piece piece = new Piece(Color.WHITE);
        Position position = new Position(7, 4);
        board.setPiece(piece, position);

        List<Position> expected = new ArrayList<>();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPDirectionNENWEdge() {
        System.out.println("getPossibleMoves DirectionN Edge");
        Piece piece = new Piece(Color.WHITE);
        Position position = new Position(3, 0);
        board.setPiece(piece, position);

        List<Position> expected = List.of(new Position(4, 0));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    //black player-----------------------------------------
    @Test
    public void testGetPossibleMovesPDirectionS() {
        System.out.println("getPossibleMoves DirectionS");
        Piece piece = new Piece(Color.BLACK);
        Position position = new Position(5, 4);
        board.setPiece(piece, position);

        List<Position> expected = List.of(new Position(4, 4));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPDirectionSS() {
        System.out.println("getPossibleMoves DirectionSS");
        Piece piece = new Piece(Color.BLACK);
        Position position = new Position(6, 6);
        board.setPiece(piece, position);

        List<Position> expected = List.of(new Position(5, 6), new Position(4, 6));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPDirectionSE() {
        System.out.println("getPossibleMoves DirectionSE");
        Piece piece = new Piece(Color.BLACK);
        Position position = new Position(6, 4);
        Piece opponent1 = new Piece(Color.WHITE);
        Position opponentPosition1 = new Position(5, 5);
        board.setPiece(piece, position);
        board.setPiece(opponent1, opponentPosition1);

        List<Position> expected = List.of(new Position(5, 4), new Position(4, 4), new Position(5, 5));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPDirectionSESW() {
        System.out.println("getPossibleMoves DirectionSESW");
        Piece piece = new Piece(Color.BLACK);
        Position position = new Position(6, 4);
        Piece opponent1 = new Piece(Color.WHITE);
        Position opponentPosition1 = new Position(5, 5);
        Piece opponent2 = new Piece(Color.WHITE);
        Position opponentPosition2 = new Position(5, 4);
        Piece opponent3 = new Piece(Color.WHITE);
        Position opponentPosition3 = new Position(5, 3);
        board.setPiece(piece, position);
        board.setPiece(opponent1, opponentPosition1);
        board.setPiece(opponent2, opponentPosition2);
        board.setPiece(opponent3, opponentPosition3);

        List<Position> expected = List.of(new Position(5, 3), new Position(5, 5));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPDirectionSW() {
        System.out.println("getPossibleMoves DirectionSW");
        Piece piece = new Piece(Color.BLACK);
        Position position = new Position(6, 1);
        Piece opponent1 = new Piece(Color.WHITE);
        Position opponentPosition1 = new Position(5, 1);
        Piece opponent2 = new Piece(Color.WHITE);
        Position opponentPosition2 = new Position(5, 0);
        board.setPiece(piece, position);
        board.setPiece(opponent1, opponentPosition1);
        board.setPiece(opponent2, opponentPosition2);

        List<Position> expected = List.of(new Position(5, 0));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPDirectionSEdge() {
        System.out.println("getPossibleMoves DirectionS Edge");
        Piece piece = new Piece(Color.BLACK);
        Position position = new Position(0, 4);
        board.setPiece(piece, position);

        List<Position> expected = new ArrayList<>();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPDirectionSRightEdge() {
        System.out.println("getPossibleMoves DirectionS Right Edge");
        Piece piece = new Piece(Color.BLACK);
        Position position = new Position(4, 7);
        board.setPiece(piece, position);

        List<Position> expected = List.of(new Position(3, 7));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    /**
     * ******* A vous d'écrire les autres cas. Veuillez faire attention à avoir
     * un plan de test complet (comme précisé dans l'énoncé) **********
     */
    /*
     *      Permet de tester si deux listes de positions sont identiques à l'ordre
     *      des éléments prêts. Cette méthode est appelée
     *      par les méthodes de test.
     */
    private void assertEqualsIgnoringOrder(List<Position> expected, List<Position> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(expected.containsAll(actual));
    }

}
