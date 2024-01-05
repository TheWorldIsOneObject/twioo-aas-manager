package com.theworldisoneobject.aasmanager.classes.archive;

import javax.swing.JLayeredPane;

import com.theworldisoneobject.aasmanager.classes.ActionEventListener;
import com.theworldisoneobject.aasmanager.classes.LayerStartUp;

import javax.swing.JButton;
import javax.swing.AbstractButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;


public class SecondLayer extends JLayeredPane implements ActionListener, ActionEventListener {
    
    private ActionEventListener listener;
    private LayerStartUp myStart;

    /**
     * Sets the ActionEventListener
     * @param listener
     */
    public void setActionEventListener(ActionEventListener listener) {
        this.listener = listener;
    }

    /**
     * Method to be called when an ActionEvent is created
     * @param event
     */
    public void actionPerformed(ActionEvent event) {
        // Logging
        System.out.println("Action event created " + event.getSource().getClass().getName() + " " + event.getActionCommand());
        
        // sending to interface ActionEventListener
        if (listener != null) {
            listener.remoteActionPerformed(event);
        }
        // Local Event Handling
        /*if ("Button: Back".equals(event.getActionCommand())) {
            myStart.setVisible(true);
        }*/
    }

    /**
     * Method to be called when an ActionEvent is received
     * @param event
     */
    public void remoteActionPerformed(ActionEvent event) {
        // Logging
        System.out.println("Action event received " + event.getSource().getClass().getName() + " " + event.getActionCommand());

        // Remote Event Handling
        // Button New pressed
        /*if ("Button: New AAS".equals(event.getActionCommand())) {
            myStart.setVisible(false);
        }
        // Button Back Pressed
        if ("Button: Back".equals(event.getActionCommand())) {
            myStart.setVisible(true);
        }*/
    }

    public SecondLayer() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Create LayeredPane
        JLayeredPane myPane = new JLayeredPane();
        myPane.setPreferredSize(new Dimension(1000, 800));

        // Create StartUpLayer
        myStart = new LayerStartUp();
        myStart.setActionEventListener(this);
        myStart.setBounds(0, 0, 1000, 800);
        myPane.add(myStart, JLayeredPane.DEFAULT_LAYER);

        // Create SecondLayer
        JButton backToStart = new JButton();
        //Appearance
        backToStart.setText("Back");
        backToStart.setVerticalTextPosition(AbstractButton.CENTER);
        backToStart.setHorizontalTextPosition(AbstractButton.LEADING);
        backToStart.setBounds(10, 10, 100, 100);
        //Functionality
        backToStart.setActionCommand("Button: Back");
        backToStart.addActionListener(this);
        
        myPane.add(backToStart, JLayeredPane.PALETTE_LAYER);

        // Add LayeredPane to SecondLayer
        add(myPane, gbc);
    }
}
//Note:
/*
 * Tasks for the future:
 * - add comments and docStrings to all classes
 * - add listener/interface for the buttons so the visibility of the layers can be changed
 * - refactor code to have a main listener which handles the visibility of the layers
 */