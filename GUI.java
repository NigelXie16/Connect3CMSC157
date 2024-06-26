
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
    public GUI(int size, Board board) {

        JFrame window = new JFrame("Connect 4 ;)");
        board = new Board(5);
        MyCanvas canvas = new MyCanvas(600, 600, board);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(canvas);
        window.pack();
        window.setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(screenSize.width - window.getWidth(), 0);
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

}
