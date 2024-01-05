package com.theworldisoneobject.aasmanager.classes;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;

public class LayerAasSave extends JPanel implements ActionListener, ActionEventListener {
    
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
    public LayerAasSave() {
        setLayout(new GridBagLayout());
        
        JButton backEdit = new JButton();
        //set gui options
        backEdit.setText("Back to Edit");
        backEdit.setVerticalTextPosition(AbstractButton.CENTER);
        backEdit.setHorizontalTextPosition(AbstractButton.LEADING);
        backEdit.setActionCommand("Back to Edit");
        backEdit.addActionListener(this);
        add(backEdit);

        JButton backView = new JButton();
        //set gui options
        backView.setText("Back to View");
        backView.setVerticalTextPosition(AbstractButton.CENTER);
        backView.setHorizontalTextPosition(AbstractButton.LEADING);
        backView.setActionCommand("Back to View");
        backView.addActionListener(this);
        add(backView);

        JButton backStartUp = new JButton();
        //set gui options
        backStartUp.setText("Back to StartUp");
        backStartUp.setVerticalTextPosition(AbstractButton.CENTER);
        backStartUp.setHorizontalTextPosition(AbstractButton.LEADING);
        backStartUp.setActionCommand("Back to StartUp");
        backStartUp.addActionListener(this);
        add(backStartUp);        

        JButton openFileExplorer = new JButton();
        //set gui options
        openFileExplorer.setText("FileExplorer: SaveFile");
        openFileExplorer.setVerticalTextPosition(AbstractButton.CENTER);
        openFileExplorer.setHorizontalTextPosition(AbstractButton.LEADING);
        //set interaction options
        openFileExplorer.setActionCommand("FileExplorer: SaveFile");
        openFileExplorer.addActionListener(this);
        //add to panel
        add(openFileExplorer);
    }
}
