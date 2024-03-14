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
            for (int j = 0; j < len; j++) {
                if (B[i][j] == null) {
                    s += "| ";
                } else {
                    s += "|" + B[i][j].toString();
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

public static void main(String[] args)
{
    //test the class
    Board b=new Board();
    System.out.println(b.toString());
    Piece p=new Piece(char);
    b.add(p, 0);
    System.out.println(b.toString());
}

}
