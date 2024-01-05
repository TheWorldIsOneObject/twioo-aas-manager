package com.theworldisoneobject.aasmanager.classes;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;

public class LayerAasLoad extends JPanel implements ActionListener, ActionEventListener {
    
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
    LayerAasLoad() {
        setLayout(new GridBagLayout());

        JButton back = new JButton();
        //set gui options
        back.setText("Back to StartUp");
        back.setVerticalTextPosition(AbstractButton.CENTER);
        back.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        back.setActionCommand("Back to StartUp");
        back.addActionListener(this);
        add(back);
    
        JButton insert = new JButton();
        //set gui options
        insert.setText("Insert AAS");
        insert.setVerticalTextPosition(AbstractButton.CENTER);
        insert.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        insert.setActionCommand("Insert AAS");
        insert.addActionListener(this);
        add(insert);

        JButton openFileExplorer = new JButton();
        //set gui options
        openFileExplorer.setText("FileExplorer: OpenFile");
        openFileExplorer.setVerticalTextPosition(AbstractButton.CENTER);
        openFileExplorer.setHorizontalTextPosition(AbstractButton.LEADING);
        //set interaction options
        openFileExplorer.setActionCommand("FileExplorer: OpenFile");
        openFileExplorer.addActionListener(this);
        //add to panel
        add(openFileExplorer);

    }
}
