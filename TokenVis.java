/**
 * 4. Create TokenVisualization
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
 */

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