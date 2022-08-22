package g59939.chess.model;

import java.util.List;

import org.junit.jupiter.api.Test;

import java.util.List;

import static g59939.chess.model.JuinChessTestUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static g59939.chess.model.JuinChessTestUtils.asPos;
import static g59939.chess.model.JuinChessTestUtils.move;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AoutGameTest {

    public AoutGameTest() {
    }

    Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    @Test
    void testGame_CastlingWithWhite() {
        game.start();
        move(game, "e2", "e4");
        move(game, "e7", "e5");

        move(game, "f1", "c4");
        move(game, "g8", "f6");

        move(game, "g1", "f3");
        move(game, "f6", "e4");

        assertValidMove(game,"e1", "g1"); // petit roque possible

        move(game, "d1", "e2");
        move(game, "e4", "g3");

        assertInvalidMove(game, "e1", "g1"); // petit roque impossible
    }
}
