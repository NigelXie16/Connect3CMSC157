class Board {
    int len; // length of the board, different to size the total number
    Piece p;
    Piece[][] B;

    /**
     * Constructor: create a 5x5 board, with all null pieces
     */
    public Board() {
        len = 5;
        B = new Piece[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                B[i][j] = null;
            }
        }
    }

    /**
     * Constructor with column
     * i is the row, j is the column
     * 
     * @param col the number of columns aka. length of the board
     */
    public Board(int col) {
        this.len = col;
        B = new Piece[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                B[i][j] = null;
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
     * 0 1 2 3 4
     * | | | | | |
     * | | | | | |
     * | | | | | |
     * | | | | | |
     * |X| | | | |
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < len; i++) {
            s += i + " ";
        }
        s += "\n";
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) { // XX causes exception
                if (B[j][i] == null) {
                    s += "| ";
                } else {
                    s += "|" + B[j][i].toString();
                }
            }
            s += "|\n";
        }
        return s;
    }

    /**
     * Add a piece to the board
     * 
     * @param P   the piece to add
     * @param col the column number to add the piece to
     */
    public void add(Piece P, int col)
    {
        int j = 0;
        while (B[col][j] != null) {
            j++;
        }
        B[col][j] = P;
    }

    /**
     * Return the winner of the game, in char
     * Using if statements to check if there are four in a row, horizontally, vertically, or diagonally
     * 
     * @return char of the winner
     */
    public String winner() {
        // check horizontally
        for (int i = 0; i < this.getLength(); i++) {
            for (int j = 0; j < this.getLength(); j++) {
                if (this.B[i][j] != null
                        && this.B[i + 1][j] != null
                        && this.B[i + 2][j] != null
                        && this.B[i + 3][j] != null
                        && this.B[i][j].player == this.B[i + 1][j].player
                        && this.B[i][j].player == this.B[i + 2][j].player
                        && this.B[i][j].player == this.B[i + 3][j].player)
                    return this.B[i][j].player;
            }
        }
        // check vertically
        for (int i = 0; i < this.getLength(); i++) {
            for (int j = 0; j < this.getLength(); j++) {
                if (this.B[i][j] != null
                        && this.B[i][j + 1] != null
                        && this.B[i][j + 2] != null
                        && this.B[i][j + 3] != null
                        && this.B[i][j].player == this.B[i][j + 1].player
                        && this.B[i][j].player == this.B[i][j + 2].player
                        && this.B[i][j].player == this.B[i][j + 3].player) {
                    return this.B[i][j].player;
                }
            }
        }
        // check diagonally
        for (int i = 0; i < this.getLength(); i++) {
            for (int j = 0; j < this.getLength(); j++) {
                if (this.B[i][j] != null
                        && this.B[i + 1][j + 1] != null
                        && this.B[i + 2][j + 2] != null
                        && this.B[i + 3][j + 3] != null
                        && this.B[i][j].player == this.B[i + 1][j + 1].player
                        && this.B[i][j].player == this.B[i + 2][j + 2].player
                        && this.B[i][j].player == this.B[i + 3][j + 3].player) {
                    return this.B[i][j].player;
                }
            }
        }
        // check diagonally
        for (int i = 0; i < this.getLength(); i++) {
            for (int j = 0; j < this.getLength(); j++) {
                if (this.B[i][j] != null
                        && this.B[i + 1][j - 1] != null
                        && this.B[i + 2][j - 2] != null
                        && this.B[i + 3][j - 3] != null
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
        Piece p = new Piece("player1");
        Piece p1 = new Piece("player1");
        Piece p2 = new Piece("player1");
        Piece p3 = new Piece("player1");
        b.add(p, 0);
        b.add(p1, 1);
        b.add(p2, 2);
        b.add(p3, 3);
        System.out.println(b.toString());
        System.out.println(b.winner());
    }

}
