
import java.awt.*;

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

    public void draw(Graphics g) {
        // Draw the colored rectangle representing the board
        g.setColor(color);
        g.fillRect(x, y, width, height);

        // Draw grid lines
        g.setColor(Color.LIGHT_GRAY); // Set grid line color

        // Calculate spacing between grid lines based on board size and number of
        // rows/columns (n)
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

    public void main(String args[]) {
        BoardVis board = new BoardVis(50, 50, 500, 500, Color.GREEN, 50, 7);
    }
}
