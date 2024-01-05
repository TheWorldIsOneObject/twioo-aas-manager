package com.theworldisoneobject.aasmanager;

import java.io.IOException;

import javax.swing.JFrame;

import com.theworldisoneobject.aasmanager.classes.LayerMain;
import com.theworldisoneobject.aasmanager.classes.FrameMenuBar;

/**
 * This class is the entry point of the application. It creates the main layer and sets it visible.
 * @author IAmAMerlin
 */

public class App {
    public static void main( String[] args )
    {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowUi();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void createAndShowUi() throws IOException {
        //Create and set up the content.
        LayerMain content = new LayerMain();
        content.setOpaque(true); //content panes must be opaque
        
        FrameMenuBar frameMenuBar = new FrameMenuBar();

        //Create and set up the window.
        JFrame frame = new JFrame("TWIOO-AAS-Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set content
        frame.setContentPane(content);
        //set menubar
        frame.setJMenuBar(frameMenuBar.createFrameMenuBar());
        frame.pack();
        frame.setVisible(true);
    }
}
