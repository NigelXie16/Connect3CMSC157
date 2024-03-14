/*
 * Constructors: 
 * Connect4()
 * Connect4(size)
 * Methods: 
 * winner()
 * toString()
 * gameOver()
 * move(player,column)
 */
public class Connect4 {
    private Board board;

    public Connect4() {
        this.board = new Board();
    }

    public Connect4(int size) {
        this.board = new Board(size);
    }

    public boolean winner() {
        // Implement logic to check if there's a winner
        return false;
    }

    @Override
    public String toString() {
        return this.board.toString();
    }

    public boolean gameOver() {
        // Implement logic to check if the game is over
        return false;
    }

    public void move(int player, int column) {
        // Implement logic to make a move
    }
}
