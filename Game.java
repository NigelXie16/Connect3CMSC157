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

    private Connect4 connect4;

    public Game() {
        connect4 = new Connect4(5); // Adjust the board size as needed
    }

    public void start() {
        System.out.println("Starting Connect4 Game...");

        while (!connect4.gameOver()) {
            System.out.println(connect4);
            System.out.println("Player 1's turn (Enter column number): ");
            int column1 = scanner.nextInt();
            connect4.move(1, column1);

            if (connect4.gameOver()) {
                break;
            }

            System.out.println(connect4);
            System.out.println("Player 2's turn (Enter column number): ");
            int column2 = scanner.nextInt();
            connect4.move(2, column2);
        }

        System.out.println(connect4);
        char winner = connect4.winner();
        if (winner == 'N') {
            System.out.println("It's a draw!");
        } else {
            System.out.println("Player " + winner + " wins!");
        }
    }
}