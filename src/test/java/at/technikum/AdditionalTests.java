package at.technikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionalTests {

    private TicTacToe game;
    private Board board;
    private Player player;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
        game.start();
        board = new Board();
        player = new Player('X');
    }

    // Player.getMarker()
    @Test
    void playerXHasCorrectMarker() {
        assertEquals('X', player.getMarker());
    }

    @Test
    void playerOHasCorrectMarker() {
        Player playerO = new Player('O');
        assertEquals('O', playerO.getMarker());
    }

    // Board.isCellEmpty()
    @Test
    void cellIsEmptyOnNewBoard() {
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void cellIsNotEmptyAfterPlace() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    // Board.clear()
    @Test
    void boardIsEmptyAfterClear() {
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void allCellsEmptyAfterClear() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        board.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(board.isCellEmpty(i, j));
            }
        }
    }

    // Board.isFull()
    @Test
    void boardIsNotFullWhenEmpty() {
        assertFalse(board.isFull());
    }

    @Test
    void boardIsFullWhenAllCellsFilled() {
        char[][] moves = {{'X','O','X'},{'O','X','O'},{'O','X','O'}};
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board.place(i, j, moves[i][j]);
        assertTrue(board.isFull());
    }

    // hasWinner()
    @Test
    void hasWinnerReturnsTrueForColumn() {
        game.makeMove(0, 0); game.switchCurrentPlayer();
        game.makeMove(1, 2); game.switchCurrentPlayer();
        game.makeMove(1, 0); game.switchCurrentPlayer();
        game.makeMove(2, 2); game.switchCurrentPlayer();
        game.makeMove(2, 0);
        assertTrue(game.hasWinner());
    }

    @Test
    void hasWinnerReturnsTrueForDiagonal() {
        game.makeMove(0, 0); game.switchCurrentPlayer();
        game.makeMove(0, 1); game.switchCurrentPlayer();
        game.makeMove(1, 1); game.switchCurrentPlayer();
        game.makeMove(0, 2); game.switchCurrentPlayer();
        game.makeMove(2, 2);
        assertTrue(game.hasWinner());
    }

    @Test
    void hasWinnerReturnsFalseOnEmptyBoard() {
        assertFalse(game.hasWinner());
    }

    // TicTacToe.getBoard()
    @Test
    void getBoardReturnsNonNull() {
        assertNotNull(game.getBoard());
    }

    @Test
    void getBoardReturnsCorrectBoard() {
        game.makeMove(0, 0);
        assertEquals('X', game.getBoard().getCell(0, 0));
    }

    // TicTacToe.isGameEnded()
    @Test
    void gameIsNotEndedAtStart() {
        assertFalse(game.isGameEnded());
    }

    @Test
    void gameIsEndedAfterWin() {
        game.makeMove(0, 0); game.switchCurrentPlayer();
        game.makeMove(1, 0); game.switchCurrentPlayer();
        game.makeMove(0, 1); game.switchCurrentPlayer();
        game.makeMove(1, 1); game.switchCurrentPlayer();
        game.makeMove(0, 2);
        assertTrue(game.isGameEnded());
    }

    // Board.getSize()
    @Test
    void boardSizeIsThree() {
        assertEquals(3, board.getSize());
    }

    @Test
    void boardSizeIsConsistent() {
        board.place(0, 0, 'X');
        assertEquals(3, board.getSize());
    }

    // Board.print() - verifies it runs without errors
    @Test
    void printDoesNotThrowOnEmptyBoard() {
        assertDoesNotThrow(() -> board.print());
    }

    @Test
    void printDoesNotThrowOnFilledBoard() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        assertDoesNotThrow(() -> board.print());
    }
}
