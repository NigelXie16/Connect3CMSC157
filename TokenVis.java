import java.awt.*;

public class TokenVis extends Rectangle{
    private Color color;

    public TokenVis(int x0, int y0, int w, int h) {
        super(x0, y0, w, h);
    }
    
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }

    public void setColor(Color player) {
        this.color = player;
    }
}
