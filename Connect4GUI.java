
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Connect4GUI{
    // private JLabel statusBar; // status of mouse relative to window (in or out?)
    // private JLabel locationBar; // location of mouse in window, jlabel for display 
   private JFrame win;
    public static int WIDTH = 600;
    public static int HEIGHT = 700;
    
    MyCanvas canvas;

    // public Connect4GUI(int size){
    //   //assign size of rows and columns
    //   Board [][] = new Board [size][size];
    // }


    private MouseTracker2 MouseT;

    public Connect4GUI(int size) {   
        //creat a windwo frame and set the title in the toolbar
        JFrame window = new JFrame("game");
        MyCanvas canvas = new MyCanvas(WIDTH,HEIGHT);
        
        //when we close the window stop the app
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);////window.setSize(900,600);

        this.MouseT = new MouseTracker2(canvas);
        canvas.addMouseListener(MouseT);
        canvas.addMouseMotionListener(MouseT);
   
        //canvas.setPreferredSize(prefferedsize);
        window.add(canvas);

        //fit the window around the compents (just our canvas)
        window.pack();

        //dont allow the user to resize the window
        window.setResizable(false);

        //open window in the center of the screen
        window.setLocationRelativeTo(null);

        //display the window
        window.setVisible(true);

        System.out.println("works");


    }
      public static void main( String args[] )
        { 
        Connect4GUI gui = new Connect4GUI(4);//constructor takes in input
        }


}
