package at.technikum;

public class Board {
    private char[][] cells;
    private static final int SIZE = 3;
    private static final char EMPTY = ' ';

    public Board() {
        cells = new char[SIZE][SIZE];
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        validateCoordinates(x, y);
        return cells[x][y] == EMPTY;
    }

    public void place(int x, int y, char marker) {
        validateCoordinates(x, y);
        if (!isCellEmpty(x, y)) {
            throw new IllegalArgumentException("Feld (" + x + "," + y + ") ist bereits angekreuzt");
        }
        cells[x][y] = marker;
    }

    public char getCell(int x, int y) {
        validateCoordinates(x, y);
        return cells[x][y];
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellEmpty(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = EMPTY;
            }
        }
    }

    public void print() {
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" " + cells[i][0] + " | " + cells[i][1] + " | " + cells[i][2]);
            if (i < SIZE - 1) {
                System.out.println("\n-----------");
            } else {
                System.out.println();
            }
        }
        System.out.println();
    }

    private void validateCoordinates(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            throw new IllegalArgumentException("Fehlerhaftes Feld: (" + x + "," + y + ")");
        }
    }

    public int getSize() {
        return SIZE;
    }
}