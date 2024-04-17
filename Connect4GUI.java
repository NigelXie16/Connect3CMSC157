
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Connect4GUI {
    private JFrame window;
    private MyCanvas canvas;
    public static int WIDTH = 600;
    public static int HEIGHT = 600;
    public int size;

    /**
     * constructor for Connect4GUI
     * 
     * @param size 
     */
    public Connect4GUI(int size) {

        canvas = new MyCanvas(WIDTH, HEIGHT);
        window = new JFrame("game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(canvas);
        window.pack(); // fit the window around the canvas
        window.setResizable(false);
        window.setLocationRelativeTo(null); // open window in the center of the screen
        window.setVisible(true);
    }
    
    /** @return the size of the board */
    public int getLength() {
        return this.size;
    }
    public static void main(String args[]) {
        Connect4GUI gui = new Connect4GUI(4);
    }

}
