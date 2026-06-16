package at.technikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {

    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
        game.start();
    }

    @Test
    void boardShowsPlacedMarkers() {
        game.makeMove(0, 0);
        assertEquals('X', game.getBoard().getCell(0, 0));
    }

    @Test
    void emptySquaresAreBlank() {
        assertEquals(' ', game.getBoard().getCell(1, 1));
    }

    @Test
    void boardReflectsMovesOfBothPlayers() {
        game.makeMove(0, 0);
        game.switchCurrentPlayer();
        game.makeMove(1, 1);

        assertEquals('X', game.getBoard().getCell(0, 0));
        assertEquals('O', game.getBoard().getCell(1, 1));
    }

    @Test
    void currentPlayerIsDisplayedCorrectly() {
        assertEquals('X', game.getCurrentPlayer().getMarker());
        game.switchCurrentPlayer();
        assertEquals('O', game.getCurrentPlayer().getMarker());
    }

    @Test
    void boardStateRemainsAfterMultipleMoves() {
        game.makeMove(0, 0);
        game.switchCurrentPlayer();
        game.makeMove(0, 1);
        game.switchCurrentPlayer();
        game.makeMove(0, 2);

        assertEquals('X', game.getBoard().getCell(0, 0));
        assertEquals('O', game.getBoard().getCell(0, 1));
        assertEquals('X', game.getBoard().getCell(0, 2));
    }

    @Test
    void allNineCellsStartEmpty() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', game.getBoard().getCell(i, j));
            }
        }
    }
}
