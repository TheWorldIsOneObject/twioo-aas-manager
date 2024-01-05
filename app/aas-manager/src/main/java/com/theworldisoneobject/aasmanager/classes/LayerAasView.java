package com.theworldisoneobject.aasmanager.classes;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;

public class LayerAasView extends JPanel implements ActionListener, ActionEventListener {
    
    private ActionEventListener listener;
    
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
        // ...
    }

    /**
     * Method to be called when an ActionEvent is received
     * @param event
     */
    public void remoteActionPerformed(ActionEvent event) {
        // Logging
        System.out.println("Action event received " + event.getSource().getClass().getName() + " " + event.getActionCommand());

        // Remote Event Handling
        // ...
    }

    //constructor
    LayerAasView() {
        setLayout(new GridBagLayout());

        JButton backLoad = new JButton();
        //set gui options
        backLoad.setText("Back to Load");
        backLoad.setVerticalTextPosition(AbstractButton.CENTER);
        backLoad.setHorizontalTextPosition(AbstractButton.LEADING);
        backLoad.setActionCommand("Back to Load");
        backLoad.addActionListener(this);
        add(backLoad);

        JButton backRecent = new JButton();
        //set gui options
        backRecent.setText("Back to Recent");
        backRecent.setVerticalTextPosition(AbstractButton.CENTER);
        backRecent.setHorizontalTextPosition(AbstractButton.LEADING);
        backRecent.setActionCommand("Back to Recent");
        backRecent.addActionListener(this);
        add(backRecent);

        JButton enableEdit = new JButton();
        //set gui options
        enableEdit.setText("Enable Edit");
        enableEdit.setVerticalTextPosition(AbstractButton.CENTER);
        enableEdit.setHorizontalTextPosition(AbstractButton.LEADING);
        enableEdit.setActionCommand("Enable Edit");
        enableEdit.addActionListener(this);
        add(enableEdit);

        JButton saveAAS = new JButton();
        //set gui options
        saveAAS.setText("Save AAS");
        saveAAS.setVerticalTextPosition(AbstractButton.CENTER);
        saveAAS.setHorizontalTextPosition(AbstractButton.LEADING);
        saveAAS.setActionCommand("Save AAS");
        saveAAS.addActionListener(this);
        add(saveAAS);

        JButton startUp = new JButton();
        //set gui options
        startUp.setText("Back to StartUp");
        startUp.setVerticalTextPosition(AbstractButton.CENTER);
        startUp.setHorizontalTextPosition(AbstractButton.LEADING);
        startUp.setActionCommand("Back to StartUp");
        startUp.addActionListener(this);
        add(startUp);

    }
    
}
