class Board {
    int len; // length of the board, different to size the total number
    Piece p;
    Piece[][] B;

    /**
     * Constructor: create a 5x5 board, with "no winner" pieces as default
     */
    public Board() {
        len = 5;
        B = new Piece[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                B[i][j] = new Piece("no winner");
            }
        }
    }

    /**
     * Constructor with column
     * i is the row, j is the column, starting from 0
     * 
     * @param col the number of columns aka. length of the board
     */
    public Board(int col) {
        this.len = col;
        B = new Piece[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                B[i][j] = new Piece("no winner");
            }
        }
    }

    /**
     * Return the length of the board
     * 
     * @return
     */
    public int getLength() {
        return len;
    }

    /*
     * return the this String to visible set of columns, like this
     * 1 2 3 4 5
     * | | | | | |
     * | | | | | |
     * | | | | | |
     * | | | | | |
     * |X| | | | |
     */
    public String toString() {
        String s = ""; // the master string that is yet to includes the whole board
        for (int i = 0; i < len; i++) {
            s += (i + 1) + " ";
        }
        s += "\n";
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) { // XX causes exception
                if (B[j][i].toString() == "no winner") {
                    s += "| ";
                } else {
                    s += "|" + B[j][i];
                }
            }
            s += "|\n";
        }
        return s; // the master string that includes the whole board
    }

    /**
     * Add a piece to the board
     * 
     * @param P   the piece to add
     * @param col the column number to add the piece to
     */
    public boolean add(String player, int col) {
        Piece P = new Piece(player);
        int j = 0;
        while (B[col - 1][j].toString() != "no winner") {
            j++;
        }
        // if statement to avoid out of bounds exception when adding a piece to a full column
        if (j < len) {
            B[col - 1][j] = P;
            return true;
        }
        return false;
    }

    public boolean gameOver() {
        // Implement logic to check if the game is over
        for (int i = 0; i < this.getLength(); i++) {
            for (int j = 0; j < this.getLength(); j++) {
                if (this.B[i][j].toString() == "no winner") {
                    return false;
                }
            }
        }
        if (winner() == "no winner") {
            return false;
        }
        return true;
    }

    /**
     * Return the winner of the game in String, or return "no winner"
     * 
     * @return Player String, or return "no winner"
     */
    public String winner() {
        // check horizontally
        for (int i = 0; i < this.getLength() - 4; i++) {
            for (int j = 0; j < this.getLength(); j++) {
                if (this.B[i][j].toString() != "no winner"
                        && this.B[i + 1][j].toString() != "no winner"
                        && this.B[i + 2][j].toString() != "no winner"
                        && this.B[i + 3][j].toString() != "no winner"
                        && this.B[i][j].player == this.B[i + 1][j].player
                        && this.B[i][j].player == this.B[i + 2][j].player
                        && this.B[i][j].player == this.B[i + 3][j].player)
                    return this.B[i][j].player;
            }
        }
        // check vertically
        for (int i = 0; i < this.getLength(); i++) {
            for (int j = 0; j < this.getLength() - 4; j++) {
                if (this.B[i][j].toString() != "no winner"
                        && this.B[i][j + 1].toString() != "no winner"
                        && this.B[i][j + 2].toString() != "no winner"
                        && this.B[i][j + 3].toString() != "no winner"
                        && this.B[i][j].player == this.B[i][j + 1].player
                        && this.B[i][j].player == this.B[i][j + 2].player
                        && this.B[i][j].player == this.B[i][j + 3].player) {
                    return this.B[i][j].player;
                }
            }
        }
        // check diagonally
        for (int i = 0; i < this.getLength() - 4; i++) {
            for (int j = 0; j < this.getLength() - 4; j++) {
                if (this.B[i][j].toString() != "no winner"
                        && this.B[i + 1][j + 1].toString() != "no winner"
                        && this.B[i + 2][j + 2].toString() != "no winner"
                        && this.B[i + 3][j + 3].toString() != "no winner"
                        && this.B[i][j].player == this.B[i + 1][j + 1].player
                        && this.B[i][j].player == this.B[i + 2][j + 2].player
                        && this.B[i][j].player == this.B[i + 3][j + 3].player) {
                    return this.B[i][j].player;
                }
            }
        }
        // check diagonally
        for (int i = 0; i <= this.getLength() - 4; i++) {
            for (int j = 3; j < this.getLength(); j++) {
                if (this.B[i][j].toString() != "no winner"
                        && this.B[i + 1][j - 1].toString() != "no winner"
                        && this.B[i + 2][j - 2].toString() != "no winner"
                        && this.B[i + 3][j - 3].toString() != "no winner"
                        && this.B[i][j].player == this.B[i + 1][j - 1].player
                        && this.B[i][j].player == this.B[i + 2][j - 2].player
                        && this.B[i][j].player == this.B[i + 3][j - 3].player) {
                    return this.B[i][j].player;
                }
            }

        }

        return "no winner";
    }

    public static void main(String[] args) {
        // test the class, create and add pieces to the board, also test the winner
        // method
        Board b = new Board();
        System.out.println(b.toString());
        b.add("Player1", 1);
        b.add("Player1", 1);
        b.add("Player1", 1);
        b.add("Player2", 1);
        System.out.println(b.toString());
        System.out.println(b.winner() + " wins!");
    }

}
