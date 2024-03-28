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
        // check if four in a row horizontally, vertically, or diagonally
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.B[i][j] != null) {
                    if (i + 3 < board.getSize() && board.B[i][j].player == board.B[i + 1][j].player
                            && board.B[i][j].player == board.B[i + 2][j].player
                            && board.B[i][j].player == board.B[i + 3][j].player) {
                        return true;
                    }
                    if (j + 3 < board.getSize() && board.B[i][j].player == board.B[i][j + 1].player
                            && board.B[i][j].player == board.B[i][j + 2].player
                            && board.B[i][j].player == board.B[i][j + 3].player) {
                        return true;
                    }
                    if (i + 3 < board.getSize() && j + 3 < board.getSize()
                            && board.B[i][j].player == board.B[i + 1][j + 1].player
                            && board.B[i][j].player == board.B[i + 2][j + 2].player
                            && board.B[i][j].player == board.B[i + 3][j + 3].player) {
                        return true;
                    }
                    if (i + 3 < board.getSize() && j - 3 >= 0
                            && board.B[i][j].player == board.B[i + 1][j - 1].player
                            && board.B[i][j].player == board.B[i + 2][j - 2].player
                            && board.B[i][j].player == board.B[i + 3][j - 3].player) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.board.toString();
    }

    public boolean gameOver() {
        // Implement logic to check if the game is over
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.B[i][j] == null) {
                    return false;
                }
            }
        }
        if (winner()) {
            return false;
        }
        return true;
    }

    public void move(int player, int column) {
        // Implement logic to make a move
        if (player == 1) {
            board.add(new Piece('X'), column);
        } else {
            board.add(new Piece('O'), column);
        }
    }

    public static void main(String[] args) {
        Connect4 game = new Connect4(5);
        System.out.println(game);
        game.move(1, 0);
        game.move(2, 1);
        game.move(1, 0);
        game.move(2, 1);
        game.move(1, 0);
        game.move(2, 1);
        game.move(1, 0);
        game.move(2, 1);
        System.out.println(game);
        System.out.println(game.winner());
    }
}
