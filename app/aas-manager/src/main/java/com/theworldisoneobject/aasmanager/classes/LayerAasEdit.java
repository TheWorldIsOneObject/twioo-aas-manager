package com.theworldisoneobject.aasmanager.classes;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;

public class LayerAasEdit extends JPanel implements ActionListener, ActionEventListener {
    
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
    LayerAasEdit() {
        setLayout(new GridBagLayout());

        //TODO: Back button needs to know from where the edit mode was initiated (new or load) -> Combination needed!
        JButton backSetup = new JButton();
        //set gui options
        backSetup.setText("Back to Setup");
        backSetup.setVerticalTextPosition(AbstractButton.CENTER);
        backSetup.setHorizontalTextPosition(AbstractButton.LEADING);
        //set interaction options
        backSetup.setActionCommand("Back to Setup");
        backSetup.addActionListener(this);
        //add to panel        
        add(backSetup);

        JButton backView = new JButton();
        //set gui options
        backView.setText("Back to View");
        backView.setVerticalTextPosition(AbstractButton.CENTER);
        backView.setHorizontalTextPosition(AbstractButton.LEADING);
        //set interaction options
        backView.setActionCommand("Back to View");
        backView.addActionListener(this);
        //add to panel        
        add(backView);

        JButton saveAAS = new JButton();
        //set gui options
        saveAAS.setText("Save AAS");
        saveAAS.setVerticalTextPosition(AbstractButton.CENTER);
        saveAAS.setHorizontalTextPosition(AbstractButton.LEADING);
        //set interaction options
        saveAAS.setActionCommand("Save AAS");
        saveAAS.addActionListener(this);
        //add to panel       
        add(saveAAS);

        JButton back = new JButton();
        //set gui options
        back.setText("Back to StartUp");
        back.setVerticalTextPosition(AbstractButton.CENTER);
        back.setHorizontalTextPosition(AbstractButton.LEADING);
        //set interaction options
        back.setActionCommand("Back to StartUp");
        back.addActionListener(this);
        //add to panel       
        add(back);

    }


}
