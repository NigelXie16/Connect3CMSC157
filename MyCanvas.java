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

    public Piece B[][];

    public int len; // length of the board

    /**
     * constructor for MyCanvas
     * 
     * @param w
     * @param h
     */
    public MyCanvas(int w, int h, Board board) {
        this.w = w;
        this.h = h;
        tokens = new ArrayList<TokenVis>(); // only to store the TokenVis objects
        this.board = board;
        B = board.getBoard();
        len = board.getLength();
        TOKENSIZE = (int) ((w - padding * 2) / len * 0.8);
        slotSize = (int) ((w - padding * 2) / len);

        setPreferredSize(new Dimension(w, h));
        setBackground(Color.pink);

        // create a new BoardVis object
        boardvis = new BoardVis(ix, iy, w - padding * 2, h - padding * 2, LIGHT_BLUE, TOKENSIZE, len);

        // Enable keyboard input
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped");
        System.out.println(board.toString());
    }

    @Override
    // work on the rest of the key events, add() in board returns boolean!!!!!
    public void keyPressed(KeyEvent e) { // testing case
        if (e.getKeyCode() == KeyEvent.VK_1) { // if the key pressed is 0 the number key
            System.out.println("1 keyPressed");
            if (board.add(currentPlayer, 1)) {
                alternatePlayer();
                drawPieces();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_2) { // if the key pressed is 1 the number key
            System.out.println("2 keyPressed");
            if (board.add(currentPlayer, 2)) {
                alternatePlayer();
                drawPieces();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_3) { // if the key pressed is 2 the number key
            System.out.println("3 keyPressed");
            if (board.add(currentPlayer, 3)) {
                alternatePlayer();
                drawPieces();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_4) { // if the key pressed is 3 the number key
            System.out.println("4 keyPressed");
            if (board.add(currentPlayer, 4)) {
                alternatePlayer();
                drawPieces();
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_5) { // if the key pressed is 4 the number key
            System.out.println("5 keyPressed");
            if (board.add(currentPlayer, 5)) {
                alternatePlayer();
                drawPieces();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_6) { // if the key pressed is 5 the number key
            System.out.println("6 keyPressed");
            if (board.add(currentPlayer, 6)) {
                alternatePlayer();
                drawPieces();
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_7) { // if the key pressed is 6 the number key
            System.out.println("7 keyPressed");
            if (board.add(currentPlayer, 7)) {
                alternatePlayer();
                drawPieces();
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_8) { // if the key pressed is 7 the number key
            System.out.println("8 keyPressed");
            if (board.add(currentPlayer, 8)) {
                alternatePlayer();
                drawPieces();
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_9) { // if the key pressed is 8 the number key
            System.out.println("9 keyPressed");
            if (board.add(currentPlayer, 9)) {
                alternatePlayer();
                drawPieces();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_0) { // if the key pressed is 9 the number key
            System.out.println("0 keyPressed");
            if (board.add(currentPlayer, 0)) {
                alternatePlayer();
                drawPieces();
            }
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
     * alternate the player
     */
    public void alternatePlayer() {
        if (currentPlayer == "Player1") {
            currentPlayer = "Player2";
        } else {
            currentPlayer = "Player1";
        }
    }

    /**
     * alternate the color of the token
     */
    public void alternateColor() {
        if (currentColor == PLAYER1_COLOR) {
            currentColor = PLAYER2_COLOR;
        } else {
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

    // method to draw the Pieces
    public void drawPieces() {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (B[i][j].toString() == "Player1") {
                    add( ix + i * slotSize + slotSize / 2, h - (iy + j * slotSize + slotSize / 2 ), PLAYER1_COLOR);
                }
                if (B[i][j].toString() == "Player2") {
                    add( ix + i * slotSize + slotSize / 2, h -(iy + j * slotSize + slotSize / 2), PLAYER2_COLOR);
                }
            }
        }
        repaint();
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
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(screenSize.width - window.getWidth(), 0);
        window.setVisible(true);
    }

}
// when key pressed add draw and drop piece, repaint() method with