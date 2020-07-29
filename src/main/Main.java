package main;
import java.awt.EventQueue;

import view.*;


public class Main {

		  public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Start logInFrame = new Start();
                    logInFrame.setLocationRelativeTo(null);
                    logInFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


	

}
