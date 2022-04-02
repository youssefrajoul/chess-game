package g59939.chess.model;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g59939
 */
public class PieceTest {

    public PieceTest() {
    }

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    ////Tests for Moves with no possible Opponent to attack (Vartical Moves)
    //White Player
    @Test
    public void testPossibleMovesForwardWhite() {
        System.out.println("Test Possible moves forwad in the middle White Pawn");
        Position position = new Position(1, 5);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(new Position(2, 5), new Position(3, 5));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesForwardLeftEdgeWhite() {
        System.out.println("Test Possible moves forwad in the Left Edge White Pawn");
        Position position = new Position(1, 0);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(new Position(2, 0), new Position(3, 0));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesForwardRightEdgeWhite() {
        System.out.println("Test Possible moves forwad in the Right Edge White Pawn");
        Position position = new Position(1, 7);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(new Position(2, 7), new Position(3, 7));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesForwardTopEdgeWhite() {
        System.out.println("Test Possible moves forwad in the Top Edge White Pawn");
        Position position = new Position(7, 0);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    //Black Player
    @Test
    public void testPossibleMovesForwardBlack() {
        System.out.println("Test Possible moves forwad in the middle Black Pawn");
        Position position = new Position(6, 4);
        Piece piece = new Piece(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(new Position(5, 4), new Position(4, 4));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesForwardLeftEdgeBlack() {
        System.out.println("Test Possible moves forwad in the Left Edge Black Pawn");
        Position position = new Position(5, 0);
        Piece piece = new Piece(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(new Position(4, 0));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesForwardRightEdgeBlack() {
        System.out.println("Test Possible moves forwad in the Right Edge Black Pawn");
        Position position = new Position(6, 7);
        Piece piece = new Piece(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(new Position(5, 7), new Position(4, 7));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesForwardBottomEdgeBlack() {
        System.out.println("Test Possible moves forwad in the Top Edge Black Pawn");
        Position position = new Position(0, 7);
        Piece piece = new Piece(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesForwardBottomEdgeBlack2() {
        System.out.println("Test Possible moves forwad in the Bottom Edge Black Pawn");
        Position position = new Position(0, 0);
        Piece piece = new Piece(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    ////Tests for Moves with a possible Opponent to attack (Diagonal Moves)
    //White Player
    @Test
    public void testPossibleMovesDiagonalWhite1() {
        System.out.println("Test Possible moves BLACK Opponent in N");
        Position position = new Position(1, 3);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        Position OpponentPosition = new Position(2, 3);
        Piece OpponentPiece = new Piece(Color.BLACK);
        board.setPiece(OpponentPiece, OpponentPosition);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesDiagonalWhite2() {
        System.out.println("Test Possible moves BLACK Opponent in NW");
        Position position = new Position(4, 7);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        Position OpponentPosition = new Position(5, 6);
        Piece OpponentPiece = new Piece(Color.BLACK);
        board.setPiece(OpponentPiece, OpponentPosition);

        List<Position> expected = List.of(new Position(5, 6), new Position(5, 7));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesDiagonalWhite3() {
        System.out.println("Test Possible moves BLACK Opponent in NE");
        Position position = new Position(1, 0);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        Position OpponentPosition = new Position(2, 1);
        Piece OpponentPiece = new Piece(Color.BLACK);
        board.setPiece(OpponentPiece, OpponentPosition);

        List<Position> expected = List.of(new Position(2, 0), new Position(2, 1), new Position(3, 0));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesDiagonalWhite4() {
        System.out.println("Test Possible moves BLACK Opponent in NE AND NW");
        Position position = new Position(3, 1);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        Position OpponentPosition1 = new Position(4, 0);
        Piece OpponentPiece1 = new Piece(Color.BLACK);
        board.setPiece(OpponentPiece1, OpponentPosition1);

        Position OpponentPosition2 = new Position(4, 2);
        Piece OpponentPiece2 = new Piece(Color.BLACK);
        board.setPiece(OpponentPiece2, OpponentPosition2);

        List<Position> expected = List.of(new Position(4, 0), new Position(4, 1), new Position(4, 2));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesDiagonalWhite5() {
        System.out.println("Test Possible moves BLACK Opponent in NE, NW , AND N");
        Position position = new Position(5, 3);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        Position OpponentPosition1 = new Position(6, 2);
        Piece OpponentPiece1 = new Piece(Color.BLACK);
        board.setPiece(OpponentPiece1, OpponentPosition1);

        Position OpponentPosition2 = new Position(6, 3);
        Piece OpponentPiece2 = new Piece(Color.BLACK);
        board.setPiece(OpponentPiece2, OpponentPosition2);

        Position OpponentPosition3 = new Position(6, 4);
        Piece OpponentPiece3 = new Piece(Color.BLACK);
        board.setPiece(OpponentPiece3, OpponentPosition3);

        List<Position> expected = List.of(new Position(6, 2), new Position(6, 4));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    //Black Player
    @Test
    public void testPossibleMovesDiagonalBlack1() {
        System.out.println("Test Possible moves BLACK Opponent in S");
        Position position = new Position(6, 3);
        Piece piece = new Piece(Color.BLACK);
        board.setPiece(piece, position);

        Position OpponentPosition = new Position(5, 3);
        Piece OpponentPiece = new Piece(Color.WHITE);
        board.setPiece(OpponentPiece, OpponentPosition);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesDiagonalBlack2() {
        System.out.println("Test Possible moves BLACK Opponent in SW");
        Position position = new Position(3, 7);
        Piece piece = new Piece(Color.BLACK);
        board.setPiece(piece, position);

        Position OpponentPosition = new Position(2, 6);
        Piece OpponentPiece = new Piece(Color.WHITE);
        board.setPiece(OpponentPiece, OpponentPosition);

        List<Position> expected = List.of(new Position(2, 6), new Position(2, 7));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesDiagonalBlack3() {
        System.out.println("Test Possible moves BLACK Opponent in SE");
        Position position = new Position(6, 0);
        Piece piece = new Piece(Color.BLACK);
        board.setPiece(piece, position);

        Position OpponentPosition = new Position(5, 1);
        Piece OpponentPiece = new Piece(Color.WHITE);
        board.setPiece(OpponentPiece, OpponentPosition);

        List<Position> expected = List.of(new Position(5, 0), new Position(5, 1), new Position(4, 0));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesDiagonalBlack4() {
        System.out.println("Test Possible moves BLACK Opponent in SE AND SW");
        Position position = new Position(4, 1);
        Piece piece = new Piece(Color.BLACK);
        board.setPiece(piece, position);

        Position OpponentPosition1 = new Position(3, 0);
        Piece OpponentPiece1 = new Piece(Color.WHITE);
        board.setPiece(OpponentPiece1, OpponentPosition1);

        Position OpponentPosition2 = new Position(3, 2);
        Piece OpponentPiece2 = new Piece(Color.WHITE);
        board.setPiece(OpponentPiece2, OpponentPosition2);

        List<Position> expected = List.of(new Position(3, 0), new Position(3, 1), new Position(3, 2));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesDiagonalBlack5() {
        System.out.println("Test Possible moves BLACK Opponent in SE, SW , AND S");
        Position position = new Position(2, 5);
        Piece piece = new Piece(Color.BLACK);
        board.setPiece(piece, position);

        Position OpponentPosition1 = new Position(1, 4);
        Piece OpponentPiece1 = new Piece(Color.WHITE);
        board.setPiece(OpponentPiece1, OpponentPosition1);

        Position OpponentPosition2 = new Position(1, 5);
        Piece OpponentPiece2 = new Piece(Color.WHITE);
        board.setPiece(OpponentPiece2, OpponentPosition2);

        Position OpponentPosition3 = new Position(1, 6);
        Piece OpponentPiece3 = new Piece(Color.WHITE);
        board.setPiece(OpponentPiece3, OpponentPosition3);

        List<Position> expected = List.of(new Position(1, 4), new Position(1, 6));

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
