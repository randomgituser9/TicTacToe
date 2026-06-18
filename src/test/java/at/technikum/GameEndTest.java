package at.technikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameEndTest {

    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
        game.start();
    }

    @Test
    void gameDetectsWinnerInRow() {
        game.makeMove(0, 0);
        game.switchCurrentPlayer();
        game.makeMove(1, 0);
        game.switchCurrentPlayer();
        game.makeMove(0, 1);
        game.switchCurrentPlayer();
        game.makeMove(1, 1);
        game.switchCurrentPlayer();
        game.makeMove(0, 2);
        assertTrue(game.hasWinner());
    }

    @Test
    void gameDetectsDraw() {
        game.makeMove(0, 0); game.switchCurrentPlayer();
        game.makeMove(0, 1); game.switchCurrentPlayer();
        game.makeMove(0, 2); game.switchCurrentPlayer();
        game.makeMove(1, 1); game.switchCurrentPlayer();
        game.makeMove(1, 0); game.switchCurrentPlayer();
        game.makeMove(1, 2); game.switchCurrentPlayer();
        game.makeMove(2, 1); game.switchCurrentPlayer();
        game.makeMove(2, 0); game.switchCurrentPlayer();
        game.makeMove(2, 2);
        assertFalse(game.hasWinner());
        assertTrue(game.isBoardFull());
    }

    @Test
    void gameEndsAfterWin() {
        game.makeMove(0, 0); game.switchCurrentPlayer();
        game.makeMove(1, 0); game.switchCurrentPlayer();
        game.makeMove(0, 1); game.switchCurrentPlayer();
        game.makeMove(1, 1); game.switchCurrentPlayer();
        game.makeMove(0, 2);
        assertTrue(game.isGameEnded());
    }

    @Test
    void noMoreMovesAfterGameEnds() {
        game.makeMove(0, 0); game.switchCurrentPlayer();
        game.makeMove(1, 0); game.switchCurrentPlayer();
        game.makeMove(0, 1); game.switchCurrentPlayer();
        game.makeMove(1, 1); game.switchCurrentPlayer();
        game.makeMove(0, 2);
        assertThrows(IllegalStateException.class, () -> game.makeMove(2, 2));
    }
}
