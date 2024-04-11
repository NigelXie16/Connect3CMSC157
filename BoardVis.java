/**
 * This class is used to draw the board 
*/

import java.awt.*;

public class BoardVis extends Rectangle {
    public static final Color CLEAR = Color.BLACK;
    private Color color; // color of board
    private int tokensize;
    private int n; // number of rows/cols

//this is the constructor for BoardVis, it will take in paratmeter
    public BoardVis(int x, int y, int width, int height, Color color, int tokensize, int n) {
        super(x, y, width, height);
        this.color = color;
        this.tokensize = tokensize;
        this.n = n;
    }

  /** @return minimum X value of the board */
    public int minX() {
        return x;
    }

/** @return minimum Y value of the board */
    public int minY() {
        return y;
    }

/** @return max X value of the board */
    public int maxX() {
        return x + width;
    }

/** @return max Y value of the board */
    public int maxY() {
        return y + height;
    }

/** draw a blue or colored rectangle in center of canvas, draw any tokens that are in the board */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
}
