class Board {
    // instance variables

    int len;
    Piece p;
    int col;
    Piece[][] B;

    public Board()
    // constructor, initially each spot set to null
    {
        len = 5;
        B = new Piece[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                B[i][j] = null;
            }
        }
    }

    public Board(int col)
    // constructor
    {
        this.len = col;
        B = new Piece[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                B[i][j] = null;
            }
        }
    }

    public int getSize()
    // return this size
    {
        return len;
    }

    public String toString()
    /*
     * return the this String to visible set of columns, like this
     * 0 1 2 3 4
     * | | | | | |
     * | | | | | |
     * | | | | | |
     * | | | | | |
     * |X| | | | |
     */
    {
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

    public void add(Piece P, int col)
    // add piece to a column
    {
        int j = 0;
        while (B[col][j] != null) {
            j++;
        }
        B[col][j] = P;
    }

    public char winner() {
        // Implement logic to check if there's a winner
        // check if four in a row horizontally, vertically, or diagonally
        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < this.getSize(); j++) {
                // XX comment this: what does it do?
                if (this.B[i][j] != null && this.B[i + 1][j] != null && this.B[i][j + 1] != null
                        && this.B[i + 2][j] != null && this.B[i][j + 2] != null && this.B[i + 3][j] != null
                        && this.B[i][j + 3] != null && this.B[i + 4][j] != null && this.B[i][j + 4] != null
                        && this.B[i + 1][j + 1] != null && this.B[i + 2][j + 2] != null
                        && this.B[i + 3][j + 3] != null && this.B[i + 4][j + 4] != null
                        && this.B[i][j] != null && this.B[i + 1][j - 1] != null && this.B[i + 2][j - 2] != null
                        && this.B[i + 3][j - 3] != null && this.B[i + 4][j - 4] != null) {
                    if (i + 3 < this.getSize() // XX comment this: what does it do?
                            && this.B[i][j].player == this.B[i + 1][j].player
                            && this.B[i][j].player == this.B[i + 2][j].player
                            && this.B[i][j].player == this.B[i + 3][j].player
                            && this.B[i][j].player == this.B[i + 4][j].player) {
                        return this.B[i][j].player;
                    }
                    if (j + 3 < this.getSize()
                            && this.B[i][j].player == this.B[i][j + 1].player
                            && this.B[i][j].player == this.B[i][j + 2].player
                            && this.B[i][j].player == this.B[i][j + 3].player
                            && this.B[i][j].player == this.B[i][j + 4].player) {
                        return this.B[i][j].player;
                    }
                    if (i + 3 < this.getSize() && j + 3 < this.getSize()
                            && this.B[i][j].player == this.B[i + 1][j + 1].player
                            && this.B[i][j].player == this.B[i + 2][j + 2].player
                            && this.B[i][j].player == this.B[i + 3][j + 3].player
                            && this.B[i][j].player == this.B[i + 4][j + 4].player) {
                        return this.B[i][j].player;
                    }
                    if (i + 3 < this.getSize() && j - 3 >= 0
                            && this.B[i][j].player == this.B[i + 1][j - 1].player
                            && this.B[i][j].player == this.B[i + 2][j - 2].player
                            && this.B[i][j].player == this.B[i + 3][j - 3].player
                            && this.B[i][j].player == this.B[i + 4][j - 4].player) {
                        return this.B[i][j].player;
                    }
                }
            }
        }
        return 'N';
    }

    public static void main(String[] args) {
        // test the class
        Board b = new Board();
        System.out.println(b.toString());
        Piece p = new Piece('x');
        Piece p1 = new Piece('x');
        b.add(p, 1);
        b.add(p1, 0);
        System.out.println(b.toString());
    }

}
