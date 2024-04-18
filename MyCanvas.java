import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.*;
import java.util.*;

class MyCanvas extends JPanel implements KeyListener {
    public static int padding = 50; // default padding for the board
    int ix = padding; // padding on the x axis
    int iy = padding; // padding on the y axis
    public static final Color LIGHT_BLUE = new Color(87, 125, 185);
    public Board board;
    private BoardVis boardvis; // board visualization
    private ArrayList<TokenVis> tokens; // storing tokens as TokenVis objects
    public int w = 600; // width of the canvas
    public int h = 600; // height of the canvas
    public static int TOKENSIZE;
    public static int slotSize;

    public String currentPlayer = "Player1"; // current player, alternating between player1 and player2

    public static final Color PLAYER1_COLOR = Color.red;
    public static final Color PLAYER2_COLOR = Color.blue;
    public Color currentColor = PLAYER1_COLOR; // current player color

    /**
     * constructor for MyCanvas
     * 
     * @param w
     * @param h
     */
    public MyCanvas(int w, int h, Board board) {
        this.w = w;
        this.h = h;
        tokens = new ArrayList<TokenVis>();
        this.board = board;
        TOKENSIZE = (int) ((w - padding * 2) / board.getLength() * 0.8);
        slotSize = (int) ((w - padding * 2) / board.getLength());

        setPreferredSize(new Dimension(w, h));
        setBackground(Color.pink);

        // create a new BoardVis object
        boardvis = new BoardVis(ix, iy, w - padding * 2, h - padding * 2, LIGHT_BLUE, TOKENSIZE, board.getLength());

        // Enable keyboard input
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped");
    }

    @Override
    // work on the rest of the key events, add() returns boolean!!!!! 
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed"); // testing case
        if (e.getKeyCode() == KeyEvent.VK_1) { // if the key pressed is 0 the number key
            System.out.println("1 keyPressed");
            board.add(currentPlayer, 1);
            add(ix + 50, iy + 50, currentColor);
            repaint();
            alternate();
        }
        if (e.getKeyCode() == KeyEvent.VK_2) { // if the key pressed is 1 the number key
            System.out.println("2 keyPressed");
            board.add(currentPlayer, 2);
            add(ix + 50 + slotSize, iy + 50, currentColor);
            repaint();
            alternate();
        }
        if (e.getKeyCode() == KeyEvent.VK_3) { // if the key pressed is 2 the number key
            System.out.println("3 keyPressed");
            board.add(currentPlayer, 3);
            add(ix + 50 + slotSize * 2, iy + 50, currentColor);
            repaint();
            alternate();
        }
        if (e.getKeyCode() == KeyEvent.VK_4) { // if the key pressed is 3 the number key
            System.out.println("4 keyPressed");

        }
        if (e.getKeyCode() == KeyEvent.VK_5) { // if the key pressed is 4 the number key
            System.out.println("5 keyPressed");

        }
        if (e.getKeyCode() == KeyEvent.VK_6) { // if the key pressed is 5 the number key
            System.out.println("6 keyPressed");

        }
        if (e.getKeyCode() == KeyEvent.VK_7) { // if the key pressed is 6 the number key
            System.out.println("7 keyPressed");

        }
        if (e.getKeyCode() == KeyEvent.VK_8) { // if the key pressed is 7 the number key
            System.out.println("8 keyPressed");

        }
        if (e.getKeyCode() == KeyEvent.VK_9) { // if the key pressed is 8 the number key
            System.out.println("9 keyPressed");

        }
        if (e.getKeyCode() == KeyEvent.VK_0) { // if the key pressed is 9 the number key
            System.out.println("0 keyPressed");

        }
    }

    /**
     * add TokenVis object to the tokens arraylist
     */
    public void add(int x, int y, Color c) {
        TokenVis t = new TokenVis(x, y, TOKENSIZE, TOKENSIZE);
        t.setColor(c);
        tokens.add(t);
    }

    /**
     * when the method is called, alternate the two current variables:
     * alternate between players,
     * and the color of the token
     */
    public void alternate() {
        if (currentPlayer == "Player1") {
            currentPlayer = "Player2";
            currentColor = PLAYER2_COLOR;
        } else {
            currentPlayer = "Player1";
            currentColor = PLAYER1_COLOR;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased");
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        boardvis.draw(g);

        for (TokenVis t : this.tokens) {
            t.draw(g);
        }
    }

    public static void main(String args[]) {
        // the above testing lines serves the same functions as Connect4GUI, but static
        JFrame window = new JFrame("Connect 4 ;)");
        Board board = new Board(5);
        MyCanvas canvas = new MyCanvas(600, 600, board);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(canvas);
        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

}
// when key pressed add draw and drop piece, repaint() method with