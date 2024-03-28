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
    // return board size
    {
        return len;
    }

    public String toString()
    /*
     * return the board String to visible set of columns, like this
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
            for (int j = 0; j <= len; j++) { // XX causes exception
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
        int j = -col;
        while (B[col][j] != null) {
            j++;
        }
        B[col][j] = P;
    }

    public static void main(String[] args) {
        // test the class
        Board b = new Board();
        System.out.println(b.toString());
        Piece p = new Piece('x');
        Piece p1 = new Piece('x');
        b.add(p, 0);
        b.add(p1, 0);
        System.out.println(b.toString());
    }

}
