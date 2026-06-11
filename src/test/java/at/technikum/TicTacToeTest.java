package at.technikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
        game.start();
    }

    @Test
    void playerCanPlaceMarkerOnEmptyCell() {
        game.makeMove(0, 0);
        assertEquals('X', game.getBoard().getCell(0, 0));
    }

    @Test
    void playerCannotPlaceMarkerOnOccupiedCell() {
        game.makeMove(1, 1);
        assertThrows(IllegalArgumentException.class, () -> game.makeMove(1, 1));
    }

    @Test
    void moveOutOfBoundsThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> game.makeMove(3, 0));
        assertThrows(IllegalArgumentException.class, () -> game.makeMove(0, -1));
    }

    @Test
    void firstPlayerIsX() {
        assertEquals('X', game.getCurrentPlayer().getMarker());
    }

    @Test
    void switchPlayerChangesCurrentPlayer() {
        char first = game.getCurrentPlayer().getMarker();
        game.switchCurrentPlayer();
        assertNotEquals(first, game.getCurrentPlayer().getMarker());
    }
}
