To add graphics and (later) animation of the tokens for the game, I recommend that you begin with the event-handling code from the SketchPad lab.  In fact, If you rename SketchPad to Connect4GUI, that code will work quite well as a base for the Connect4GUI that you will build.
Directions
These instructions are intended to guide your group through the creation of a very basic display based on refactoring your SketchPad lab code.  You will have to answer many questions as you proceed.
1.  Rename your SketchPad to Connect4GUI.  
Connect4GUI is the graphical interface that will run the entire game.  In the beginning you will build a GUI that operates without reference to the game, but provides a view of the board and tokens and the ability to drop tokens.  Once this works you will connect your GUI classes to the game you created earlier.
Connect4GUI is a class that contains a main method and a constructor:
public static void main(String args[]) {
       Connect4GUI gui = new Connect4GUI(6);
}

The Connect4GUI instance variables and constructor signature are shown next.
public class Connect4GUI {
    private JFrame win; // window containing the board
    public int width = 600;
    public int height = 700;

    /** 
     * @param size number of rows/columns  
     */
    public Connect4GUI(int size) {
	...
    }
}


The constructor should do the following:
Make a JFrame window.
Make a MyCanvas (MyCanvas is from SketchPad).
Add the canvas to the window.
Create and add a mouselistener to the canvas.
Make the window visible.
Eventually, the constructor will also create a Connect4 game—but not yet!
2. Create MyCanvas, based on the one from Sketchpad.
I recommend the instance variables and constructor be initially something like this.
class MyCanvas extends JPanel implements ActionListener {
    private BoardVis boardvis; // to visualize the board
    private ArrayList<TokenVis> tokens; // a list of all token visualizations
    public static int TOKENWIDTH = 50;
    public static int TOKENHEIGHT = 50;

    /**
     * Create wxh canvas
     */
    public MyCanvas(int w, int h) {
        tokens = new ArrayList<TokenVis>();
        setPreferredSize(new Dimension(w, h));
        setBackground(Color.gray); // set the canvas background color

        int padding = 50;
        boardvis = new BoardVis(...);
    }


Note that a canvas of this type will hold board visualization (BoardVis class) (maybe a square with piece cutouts) and visualizations for tokens (TokenVis class).  You might write very basic skeletons for these which we’ll return to in just bit.  
MyCanvas will need these methods to start:
addToken(int x, int y): add a non-moving TokenVisualization at (x,y).  We’add details such as placement details, color and motion as we go.  You should be able to figure this out based on how you drew shapes in an earlier lab.
paintComponent(Graphics g): draw the board visualization and all of tokens present on the board, too.
 @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        boardvis.draw(g);
        for (TokenVis t : this.tokens) {
            t.draw(g);
        }
    }


3. Create BoardVisualization
Create a class for visualizing the Board.  I recommend that you extend the java.awt.Rectangle class.  You can then create a constructor that sets up a Color attribute, as well as the x,y,width, and height values (instance variables) where this board will be drawn.  
public class BoardVis extends Rectangle {
    public static final Color CLEAR = Color.BLACK;
    private Color color; // color of board
    private int tokensize;
    private int n; // number of rows/cols


Note that you inherit x, y, width, and height instance variables that you can access via methods like getX(), so do not create new ones.  You should also create a draw method that takes a Graphics parameter.  This method can set the color based on the class’s color attribute 



and call g.fillRect to actually draw the rectangle. For now, just draw a centered rectangle.  Mine looked like the one above when it was drawn.
You will want to create this visualization of the board by drawing it in MyCanvas paintComponent().  This board visualization represents the blue board in the actual Connect4 game, though it lacks the grid of circular cutouts that you can add later.
To actually draw the board, I’d recommend you add a call to the draw method of BoardVis.  Add it to the paintComponent method of the MyCanvas class. This method is responsible for drawing the board in the right color and the right location every time a repaint occurs.
Before going on, your group should determine the details of methods you need.  You don’t need to write any code, but for each method, your description must include:
The method name.
All of the method parameters.  This includes their types and expected values for them.
What changes to the state of any objects caused by your method’s execution.
The return value of your method.
To get you started, here are the initial methods I created along with their parameters.  I indicate for minX, a very simple getter, what it does.  Note that I specify that it does just give any x value: it gives the minimum x coordinate of the visual board.  Finish the interface description for the other methods.  draw() is the only hard one.  Where will it be called from?  What should it do?
    /** @return minimum X value of the board */
    public int minX() {
    }

    public int minY() {
    }

    public int maxX() {

    }

    public int maxY() {

    }

    public void draw(Graphics g) {

    }


Before your group starts on the GUI, it should now determine the interface details of every method in TokenVisualization.
4. Create TokenVisualization
Now you want to make tokens.  You can actually refactor the BoardVis class into a new class for token visualizations to make visualizations of the tokens (red and yellow disks) in the game.  The main difference is that these tokens might be Color.RED or Color.YELLOW and would be drawn with g.fillOval.
Here is my skeleton for the TokenVis class:
public class TokenVis extends  Rectangle{
    private Color color;

    public TokenVis(int x0, int y0, int w, int h) {

    }

    public void draw(Graphics g) {
    }

    public void setColor(player) {
    }
}




Once again, as a group, you should complete a detailed specification of the interface for each of these methods.  You need to think about when they will used in the overall program (and by which class).
To incorporate BoardVis and TokenVis I offer the following suggestions:



Add an ArrayList for token visualization objects in the MyCanvas class.  Initialize this in the  MyCanvas constructor.
When the user clicks the mouse, create a new token at the spot where they click.  You can do this by using your new addToken method in MyCanvas to add a token at the (x,y) coordinate of the mouse click event.  Call repaint() in addToken so the tokens are drawn.  
Your group should work together to make Connect4GUI a program that will draw a board and place a new token wherever you click on the canvas.
Animation of Tokens
Perhaps the simplest way to do this is to create a Timer object (please check out the documentation for javax.swing.Timer) and a listener for this timer.  The timer will fire every so many milliseconds (thousandths of a second), updating the position of the tokens and then calling repaint to actually redraw the canvas.
You can modify the y-coordinate of each token in the listener of the timer, increasing y up to some maximum value. Don’t let the tokens fall off the window!  Here is the shell of the listener:
public void actionPerformed(ActionEvent e) {

           if (needs_update) this.repaint(); // repaint if something changed.
           needs_update = false;
      
   }



I recommend that you implement the ActionListener within the MyCanvas class.  Then just satisfy this by implementing actionPerformed(ActionEvent e) within the class.  You will update token positions and then call repaint.  You can add some acceleration if you want tokens to fall more naturally.  Variables and constants that control tokens, positions, speeds, colors, etc, should be handled as instance variables and constants within the appropriate class.  Do not use literal values throughout your code: that makes it hard to understand and modify.
Test your graphics program.  It should permit the creation of tokens that fall.  You can also make it look more realistic with disk cutouts, a more square shape, etc.
