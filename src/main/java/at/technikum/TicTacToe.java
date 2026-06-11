package at.technikum;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    private boolean gameEnded;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        board = new Board();
        gameEnded = false;
    }

    public void start() {
        currentPlayer = player1;
        board.clear();
        gameEnded = false;
    }

    public void makeMove(int x, int y) {
        if (gameEnded) {
            throw new IllegalStateException("Das Spiel ist bereits zu Ende ");
        }
        board.place(x, y, currentPlayer.getMarker());

        if (hasWinner()) {
            gameEnded = true;
        } else if (board.isFull()) {
            gameEnded = true;
        }
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean checkRows() {
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getCell(i, 0) != ' ' &&
                    board.getCell(i, 0) == board.getCell(i, 1) &&
                    board.getCell(i, 1) == board.getCell(i, 2)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int j = 0; j < board.getSize(); j++) {
            if (board.getCell(0, j) != ' ' &&
                    board.getCell(0, j) == board.getCell(1, j) &&
                    board.getCell(1, j) == board.getCell(2, j)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        // Check main diagonal (top-left to bottom-right)
        if (board.getCell(0, 0) != ' ' &&
                board.getCell(0, 0) == board.getCell(1, 1) &&
                board.getCell(1, 1) == board.getCell(2, 2)) {
            return true;
        }

        // Check anti-diagonal (top-right to bottom-left)
        if (board.getCell(0, 2) != ' ' &&
                board.getCell(0, 2) == board.getCell(1, 1) &&
                board.getCell(1, 1) == board.getCell(2, 0)) {
            return true;
        }

        return false;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public boolean isBoardFull() {
        return board.isFull();
    }
}