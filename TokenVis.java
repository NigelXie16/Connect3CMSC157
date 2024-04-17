import java.awt.*;

public class TokenVis extends Rectangle {
    private Color color;

    /**
     * constructor for TokenVis
     * @param x0 the center x coordinates of the token
     * @param y0 the center y coordinates of the token
     * @param w the width of the token
     * @param h the height of the token
     */
    
    public TokenVis(int x0, int y0, int w, int h) {
        super(x0 - w/2, y0 - h/2, w, h); // centers the Rectangle
    }
    
    /**
     * draw the token
     * @param g
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }

    /**
     * method to set the player color
     */
    public void setColor(Color a) {
        this.color = a;
    }
}
