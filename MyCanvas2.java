import java.awt.*;
import javax.swing.*;
import java.util.*;


class MyCanvas2 extends JPanel implements ActionListener{
	// int ix;
	// int iy;
	private BoardVis boardvis;//visualize the board
	private ArrayList<TokenVis> tokens; //list of tokens
	public static int TOKENWIDTH = 50;
	public static int TOKENHIEGHT = 50;


	public MyCanvas2(int w, int h){
		//set the canavas size
		tokens = new ArrayList<TokenVis>();
		setPreferredSize(new Dimension(w,h));
		//setting our background with a method that belong to out parent class
		setBackground(Color.pink);
		//this.rand = new Random();
		int padding = 50;
		boardvis = new Boardvis(----);

	}


	@Override//this method replaces something in the parent class
	public void paintComponent(Graphics g){
		//super allows to still use important code in aprent class but overriding 
		super.paintComponent(g);
		//g.setColor(Color.red);
		boardvis.draw(g);
		//g.fillOval(this.ix, this.iy,3,3);
		for(Tokenvis t : this.tokens){
			t.draw(g);
		}

		//works
		// g.setColor(Color.red);
		// g.fillRect(100, 200, 90, 120);
	}

	public void addToken(int x, int y){
		this.TOKENWIDTH=x;
		this.TOKENHIEGHT=y;
		repaint();
	}

	public static void main( String args[] )
        { 
        JFrame window = new JFrame("Art");
        
        //when we close the window stop the app
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyCanvas2 canvas = new MyCanvas2( 600, 300);
         window.add(canvas);

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
