package at.technikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewGameTest {

    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
        game.start();
    }

    @Test
    void boardIsEmptyAfterRestart() {
        game.makeMove(0, 0);
        game.start();
        assertEquals(' ', game.getBoard().getCell(0, 0));
    }

    @Test
    void firstPlayerIsXAfterRestart() {
        game.switchCurrentPlayer();
        game.start();
        assertEquals('X', game.getCurrentPlayer().getMarker());
    }

    @Test
    void gameIsNotEndedAfterRestart() {
        game.makeMove(0, 0); game.switchCurrentPlayer();
        game.makeMove(0, 1); game.switchCurrentPlayer();
        game.makeMove(0, 2);
        game.start();
        assertFalse(game.isGameEnded());
    }

    @Test
    void allCellsEmptyAfterRestart() {
        game.makeMove(1, 1);
        game.start();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', game.getBoard().getCell(i, j));
            }
        }
    }
}