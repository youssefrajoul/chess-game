package g59939.chess.model;

import java.util.List;

import static g59939.chess.model.JuinChessTestUtils.asPos;
import static g59939.chess.model.JuinChessTestUtils.move;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class JuinGameTest {

    @Test
    void testGame_whiteToPlayFirst() {
        Model game = new Game();
        game.start();
        assertEquals(game.getCurrentPlayer().getColor(), Color.WHITE);
    }

    @Test
    void testGame_blackToPlayAfterOneMove_oneSquare() {
        Model game = new Game();
        game.start();
        move(game, "a2", "a3");
        assertEquals(game.getCurrentPlayer().getColor(), Color.BLACK);
    }

    @Test
    void testGame_pawnHasOneMove_after_initial_move() {
        Model game = new Game();
        game.start();
        move(game, "c2", "c3");
        move(game, "c7", "c5");
        List<Position> possibleMoves = game.getPossibleMoves(asPos("c3"));
        assertEquals(List.of(asPos("c4")), possibleMoves);
    }

    @Test
    void testGame_blackToPlayAfterOneMove_twoSquares() {
        Model game = new Game();
        game.start();
        move(game, "a2", "a4");
        assertEquals(game.getCurrentPlayer().getColor(), Color.BLACK);
    }

    @Test
    void testGame_canMoveTwoSquaresAtStart() {
        Model game = new Game();
        game.start();
        List<Position> possibleMoves = game.getPossibleMoves(asPos("a2"));
        JuinChessTestUtils.assertEqualsIgnoringOrder(List.of(
                asPos("a3"),
                asPos("a4")
        ), possibleMoves);
    }

    @Test
    void testGame_twoPawnsBlockEachOther() {
        Model game = new Game();
        game.start();
        move(game, "e2", "e4");
        move(game, "e7", "e5");
        List<Position> possibleMoves = game.getPossibleMoves(asPos("e4"));
        assertEquals(List.of(), possibleMoves);
    }

    @Test
    void testGame() {
        Model game = new Game();
        game.start();
        move(game, "a2", "a3");
        move(game, "a7", "a5");
        List<Position> possibleMoves = game.getPossibleMoves(asPos("a3"));
        assertEquals(List.of(asPos("a4")), possibleMoves);
    }

    @Test
    void testGame_isMoveValid() {
        Model game = new Game();
        game.start();
        move(game, "e2", "e3");
        move(game, "b8", "c6");
        move(game, "e1", "e2");
        move(game, "c6", "d4"); // échec
        assertFalse(game.isValidMove(asPos("e2"), asPos("f3"))); // reste en échec
        assertTrue(game.isValidMove(asPos("e2"), asPos("d3"))); // quitte l'échec
    }

    @Test
    void testGame_isMoveValid_ScholarsCheckMate() {
        Model game = new Game();
        game.start();
        game.start();
        move(game, "e2", "e4");
        move(game, "e7", "e5");
        move(game, "d1", "h5");
        move(game, "b8", "c6");
        move(game, "f1", "c4");
        move(game, "g8", "f6");
        move(game, "h5", "f7");
        assertFalse(game.isValidMove(asPos("c6"), asPos("b8")));
    }

    @Test
    void testGame_scholarCheckMate() {
        Model game = new Game();
        game.start();
        move(game, "e2", "e4");
        move(game, "e7", "e5");
        move(game, "d1", "h5");
        // assertEquals(game.getPossibleMoves(asPos("f7")), List.of());
        move(game, "b8", "c6");
        move(game, "f1", "c4");
        move(game, "g8", "f6");
        assertEquals(GameState.PLAY, game.getState());
        move(game, "h5", "f7");
        assertEquals(GameState.CHECK_MATE, game.getState());
    }

    @Test
    void testGame_checkWithoutMate() {
        Model game = new Game();
        game.start();
        move(game, "f2", "f4");
        move(game, "e7", "e5");

        move(game, "g1", "f3");
        move(game, "d8", "h4");

        assertEquals(GameState.CHECK, game.getState());
        move(game, "f3", "h4");
        assertEquals(GameState.PLAY, game.getState());

        move(game, "e8", "e7");
        move(game, "h4", "f5");
        assertEquals(GameState.CHECK, game.getState());

        move(game, "e7", "e8");
        assertEquals(GameState.PLAY, game.getState());
    }

    void testGame_noMovesIfNoPiee() {
        Model game = new Game();
        game.start();
        assertEquals(game.getPossibleMoves(asPos("e3")), List.of());
    }

    @Test
    void testGame_quickestStaleMate() {
        Model game = new Game();
        game.start();
        move(game, "e2", "e3");
        move(game, "a7", "a5");

        move(game, "d1", "h5");
        move(game, "a8", "a6");

        move(game, "h5", "a5");
        move(game, "h7", "h5");

        move(game, "h2", "h4");
        move(game, "a6", "h6");

        move(game, "a5", "c7");
        move(game, "f7", "f6");

        move(game, "c7", "d7"); //6
        move(game, "e8", "f7");

        move(game, "d7", "b7");
        move(game, "d8", "d3");

        move(game, "b7", "b8");
        move(game, "d3", "h7");

        move(game, "b8", "c8");
        move(game, "f7", "g6");

        assertEquals(GameState.PLAY, game.getState());

        move(game, "c8", "e6");

        assertEquals(GameState.STALE_MATE, game.getState());

    }

    @Test
    void testGame_FoolsMate() {
        Model game = new Game();
        game.start();
        move(game, "f2", "f3");
        move(game, "e7", "e6");

        move(game, "g2", "g4");
        assertEquals(GameState.PLAY, game.getState());

        move(game, "d8", "h4");

        assertEquals(GameState.CHECK_MATE, game.getState());
    }
}
