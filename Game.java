
public class Game {

    private static Board board;
    private GUI gui;

    public Game() {
        board = new Board(5); // Adjust the board size as needed
        gui = new GUI(5, board);
    }

    /**
     * Main method using the Board class and its methods, to create the logic of the
     * Connect4 game
     * 
     * @param args
     */
    public static void main(String[] args) {
        Game game = new Game();
        while (board.gameOver() == false) {
        }
        if (board.gameOver() == true) {
            System.out.println("Game is over");
            if (board.winner() == "Player1") {
                System.out.println("Player1 wins");
            }
            if (board.winner() == "Player2") {
                System.out.println("Player2 wins");
            }
        }
    }

}