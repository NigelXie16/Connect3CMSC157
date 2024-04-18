import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
        // XX awkward to open the scanner one place and close it another.
        // You might put the scanner etc all in main or all in a game object.
        scanner.close(); // Close the scanner when the program exits
    }

    private Board board;
    private GUI canvas;

    public Game() {
        board = new Board(5); // Adjust the board size as needed
        canvas = new GUI(5, board);
    }

    public void start() {
        System.out.println("Starting board Game...");

        while (!board.gameOver()) {
            System.out.println(board);
            System.out.println("Player 1's turn (Enter column number): ");
            int column1 = scanner.nextInt();
            board.add("Player1", column1);

            if (board.gameOver()) {
                System.out.println("Game over!");
                break;
            }

            System.out.println(board);
            System.out.println("Player 2's turn (Enter column number): ");
            int column2 = scanner.nextInt();
            board.add("Player2", column2);
        }

        System.out.println(board);
        String winner = board.winner();
        if (winner == "no winner") {
            System.out.println("It's a draw!");
        } else {
            System.out.println( winner + " wins!");
        }
    }
}