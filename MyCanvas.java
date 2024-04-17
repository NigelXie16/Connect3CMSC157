import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.*;
import java.util.*;


class MyCanvas extends JPanel implements KeyListener{
	int ix; // padding on the x axis
	int iy; // padding on the y axis
    public static final Color LIGHT_BLUE = new Color(87, 125, 185);
    public Board board;
	private BoardVis boardvis; // board visualization
	private ArrayList<TokenVis> tokens; // storing tokens as TokenVis objects
	public static int TOKENWIDTH = 50;
	public static int TOKENHIEGHT = 50;

    /**
     * constructor for MyCanvas
     * NEEED to be changed to pass in a Board object
     * 
     * @param w
     * @param h
     */
	public MyCanvas(int w, int h, Board board, int len){ 
		tokens = new ArrayList<TokenVis>();
        this.board = board;

		setPreferredSize(new Dimension(w,h));
		setBackground(Color.pink);

		int padding = 50; // default padding for the board
		ix = padding;
		iy = padding;
        // tokensize needs to be calculated based on the size of the board
		boardvis = new BoardVis(ix, iy, w - padding * 2, h - padding * 2, LIGHT_BLUE, 50, len);
		
        // Enable keyboard input
        this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(this);
	}

    @Override 
	public void keyTyped(KeyEvent e){
		System.out.println("keyTyped");
	}

    @Override
    public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed"); //testing case
		if (e.getKeyCode() == KeyEvent.VK_0) { //if the key pressed is 0 the number key
			System.out.println("0 keyPressed");
			//drop token in column 
		}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased");
    }

	@Override 
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.red);
		boardvis.draw(g);

        // test TokenVis class
        TokenVis token1 = new TokenVis(100, 100, TOKENWIDTH, TOKENHIEGHT);
        token1.setColor(Color.red);
        token1.draw(g);

		g.fillOval(this.ix, this.iy,3,3);
		for(TokenVis t : this.tokens){
			t.draw(g);
		}
	}

	public static void main( String args[] )
        { 
        // the above testing lines serves the same functions as Connect4GUI, but static
        JFrame window = new JFrame("Connect 4 ;)");
        MyCanvas canvas = new MyCanvas(600, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(canvas);
        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        }

}
