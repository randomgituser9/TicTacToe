package at.technikum;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        game.start();

        while (!game.isGameEnded()) {
            System.out.println("CurrentPlayer: " + game.getCurrentPlayer().getMarker());
            game.getBoard().print();

            int row = readInt(scanner, "Reihe (0-2): ");
            int col = readInt(scanner, "Spalte (0-2): ");

            try {
                game.makeMove(row, col);
            } catch (IllegalArgumentException e) {
                System.out.println("Ungültiger Zug " + e.getMessage());
                continue;
            }

            game.switchCurrentPlayer();
        }

        scanner.close();
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            scanner.next();
            System.out.println("Bitte gib eine Zahl ein zwischen 0 und 2.");
        }
    }
}
