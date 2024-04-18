class Piece {
    // Instance variable to store the player
    public String player;

    // Constructor with player
    public Piece(String player) {
        this.player = player;
    }

    // Method to set the player
    public void setPlayer(String player) {
        this.player = player;
    }

    // Method to return Piece as a string
    @Override
    public String toString() {
        return String.valueOf(player);
    }

    // test the Piece class
    public static void main(String[] args) {
        Piece p = new Piece("Player1");
        System.out.println(p);
        p.setPlayer("Player2");
        System.out.println(p);
    }
}
