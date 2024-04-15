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

    public void draw(Graphics g) {
        // Draw the colored rectangle representing the board
        g.setColor(color);
        g.fillRect(x, y, width, height);

        // Draw grid lines
        g.setColor(Color.LIGHT_GRAY); // Set grid line color

        // Calculate spacing between grid lines based on board size and number of rows/columns (n)
        int cellSize = width / n;

        // Draw vertical grid lines
        for (int i = 0; i <= n; i++) {
            int xPos = x + i * cellSize;
            g.drawLine(xPos, y, xPos, y + height);
        }

        // Draw horizontal grid lines
        for (int j = 0; j <= n; j++) {
            int yPos = y + j * cellSize;
            g.drawLine(x, yPos, x + width, yPos);
        }
    }
}
