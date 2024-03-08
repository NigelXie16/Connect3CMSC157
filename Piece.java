public class Piece {
    public static char PLAYER1 = 'X';
    public static char PLAYER2 = 'O';

    // Constructor to initialize the piece with a specified player
public Piece(char player) {
    this.player = player;
    }

    // Method to represent the piece as a string 
    @Override
public String toString() {
    return String.valueOf(player);
    }
}
