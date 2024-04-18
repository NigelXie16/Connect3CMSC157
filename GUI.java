
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
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
    public GUI(int size) {

        JFrame window = new JFrame("Connect 4 ;)");
        Board board = new Board(5);
        MyCanvas canvas = new MyCanvas(600, 600, board);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(canvas);
        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    /**
     * the size of the board
     * 
     * @return
     */
    public int getLength() {
        return this.size;
    }

    public static void main(String args[]) {
        GUI gui = new GUI(4);
    }

}
