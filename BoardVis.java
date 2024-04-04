/**
 * 3. Create BoardVisualization
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
/**    public int minX() {
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
 
*/
public class BoardVis extends Rectangle {
    public static final Color CLEAR = Color.BLACK;
    private Color color; // color of board
    private int tokensize;
    private int n; // number of rows/cols

    public BoardVis(int x, int y, int width, int height, Color color, int tokensize, int n) {
        super(x, y, width, height);
        this.color = color;
        this.tokensize = tokensize;
        this.n = n;
    }

    public int minX() {
        return x;
    }

    public int minY() {
        return y;
    }

    public int maxX() {
        return x + width;
    }

    public int maxY() {
        return y + height;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
}
