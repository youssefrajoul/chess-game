/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package g59939.chess.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
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

    @Test
    public void testPossibleTwoMovesPWhite() {
        System.out.println("Test Two Moves Forward for White Pawns");
        Position position = new Position(1, 1);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(new Position(2, 1), new Position(3, 1));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleOneMovePWhite() {
        System.out.println("Test one Move Forward for White Pawns");
        Position position = new Position(3, 3);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(new Position(4, 3));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleTwoMovesPBlack() {
        System.out.println("Test Two Moves Forward for Black Pawns");
        Position position = new Position(6, 6);
        Piece piece = new Piece(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(new Position(5, 6), new Position(4, 6));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleoneMovePBlack() {
        System.out.println("Test One Move Forward for Black Pawn");
        Position position = new Position(3, 3);
        Piece piece = new Piece(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(new Position(2, 3));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesWhenDetectingBlackOpenentinNE() {
        System.out.println("Test One Move Nord Est Diagonal for White Pawn");
        Position position = new Position(4, 3);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);
        Position positionOppenent = new Position(5, 4);
        Piece pieceOppenent = new Piece(Color.BLACK);
        board.setPiece(pieceOppenent, positionOppenent);

        List<Position> expected = List.of(new Position(5, 3), new Position(5, 4));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesWhenDetectingBlackOpenentinNW() {
        System.out.println("Test One Move Nord West Diagonal for White Pawn");
        Position position = new Position(4, 3);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);
        Position positionOppenent = new Position(5, 2);
        Piece pieceOppenent = new Piece(Color.BLACK);
        board.setPiece(pieceOppenent, positionOppenent);

        List<Position> expected = List.of(new Position(5, 3), new Position(5, 2));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesWhenDetectingBlackOpenentinNEandNW() {
        System.out.println("Test One Move Nord EST & WEST Diagonal for White Pawn");
        Position position = new Position(4, 3);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);
        Position positionOppenent1 = new Position(5, 4);
        Piece pieceOppenent1 = new Piece(Color.BLACK);
        board.setPiece(pieceOppenent1, positionOppenent1);
        Position positionOppenent2 = new Position(5, 2);
        Piece pieceOppenent2 = new Piece(Color.BLACK);
        board.setPiece(pieceOppenent2, positionOppenent2);

        List<Position> expected = List.of(new Position(5, 3), new Position(5, 4), new Position(5, 2));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesWhenDetectingBlackOpenentinSE() {
        System.out.println("Test One Move Nord Est Diagonal for White Pawn");
        Position position = new Position(4, 3);
        Piece piece = new Piece(Color.BLACK);
        board.setPiece(piece, position);
        Position positionOppenent = new Position(3, 4);
        Piece pieceOppenent = new Piece(Color.BLACK);
        board.setPiece(pieceOppenent, positionOppenent);

        List<Position> expected = List.of(new Position(3, 4), new Position(3, 3));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesWhenDetectingBlackOpenentinSW() {
        System.out.println("Test One Move Nord West Diagonal for White Pawn");
        Position position = new Position(4, 3);
        Piece piece = new Piece(Color.BLACK);
        board.setPiece(piece, position);
        Position positionOppenent = new Position(3, 2);
        Piece pieceOppenent = new Piece(Color.BLACK);
        board.setPiece(pieceOppenent, positionOppenent);

        List<Position> expected = List.of(new Position(3, 2), new Position(3, 3));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testPossibleMovesWhenDetectingBlackOpenentinSEandSW() {
        System.out.println("Test One Move Nord EST & WEST Diagonal for White Pawn");
        Position position = new Position(4, 3);
        Piece piece = new Piece(Color.BLACK);
        board.setPiece(piece, position);
        Position positionOppenent1 = new Position(3, 2);
        Piece pieceOppenent1 = new Piece(Color.BLACK);
        board.setPiece(pieceOppenent1, positionOppenent1);
        Position positionOppenent2 = new Position(3, 4);
        Piece pieceOppenent2 = new Piece(Color.BLACK);
        board.setPiece(pieceOppenent2, positionOppenent2);

        List<Position> expected = List.of(new Position(3, 2), new Position(3, 3), new Position(3, 4));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testBlockedPawnsByOppenent() {
        System.out.println("Test Blocked Pawns By Oppenent");

        Position position = new Position(3, 3);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        Position positionOppenent1 = new Position(4, 3);
        Piece pieceOppenent1 = new Piece(Color.BLACK);
        board.setPiece(pieceOppenent1, positionOppenent1);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testBlockedPawnsByFriend() {
        System.out.println("Test Blocked Pawns By Friend");

        Position position = new Position(3, 3);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        Position positionOppenent1 = new Position(4, 3);
        Piece pieceOppenent1 = new Piece(Color.WHITE);
        board.setPiece(pieceOppenent1, positionOppenent1);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testWhitePawnInBorders() {
        System.out.println("Test White Pawn In Borders");

        Position position = new Position(7, 1);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testBlackPawnInBorders() {
        System.out.println("Test Black Pawn In Borders");

        Position position = new Position(0, 0);
        Piece piece = new Piece(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of();

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
