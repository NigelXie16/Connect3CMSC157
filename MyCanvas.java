import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


class MyCanvas extends JPanel implements KeyListener{
	int ix;
	int iy;
	private BoardVis boardvis; 
	private ArrayList<TokenVis> tokens; // array storing the tokens
	public static int TOKENWIDTH = 50;
	public static int TOKENHIEGHT = 50;

	public MyCanvas(int w, int h){ 
		tokens = new ArrayList<TokenVis>();
		setPreferredSize(new Dimension(w,h));
		setBackground(Color.pink);
		int padding = 50;
		ix = padding;
		iy = padding;
		boardvis = new BoardVis(ix, iy, w - padding * 2, h - padding * 2, Color.blue, 50, 7);
		
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

	@Override //this method replaces something in the parent class
	public void paintComponent(Graphics g){
		//super allows to still use important code in aprent class but overriding 
		super.paintComponent(g);
		g.setColor(Color.red);
		boardvis.draw(g);

        //test the TokenVis class
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
        JFrame window = new JFrame("Connect 4 ;)");
        MyCanvas canvas = new MyCanvas( 600, 600);
		//when we close the window stop the app
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(canvas);
		// canvas.addKeyMotionListener(MouseT);
        //fit the window around the compents (just our canvas)
        window.pack();

        //dont allow the user to resize the window
        window.setResizable(false);

        //open window in the center of the screen
        window.setLocationRelativeTo(null);

        //display the window
        window.setVisible(true);
        }

}
