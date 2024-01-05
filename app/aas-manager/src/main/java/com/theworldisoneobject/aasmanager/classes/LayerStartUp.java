package com.theworldisoneobject.aasmanager.classes;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class LayerStartUp extends JPanel 
                       implements ActionListener, ActionEventListener {
    
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

    public LayerStartUp() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        //set insets to 2px - space around components
        gbc.insets = new java.awt.Insets(2, 2, 2, 2);

    // LogoBanner
        ImageIcon logoBanner = CreateImageIcon.createImageIcon("res/images/welcomeBanner.png");

        JLabel logoBannerLabel = new JLabel(logoBanner);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(logoBannerLabel, gbc);

    // button New
        JButton buttonNew = new JButton();
        buttonNew.setText("New AAS");
        buttonNew.setVerticalTextPosition(AbstractButton.CENTER);
        buttonNew.setHorizontalTextPosition(AbstractButton.LEADING);
        buttonNew.setActionCommand("New AAS");
        buttonNew.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.weightx = 0.33;
        add(buttonNew, gbc);
    
    // button Load
        JButton buttonLoad = new JButton("Load AAS");
        buttonLoad.setVerticalTextPosition(AbstractButton.CENTER);
        buttonLoad.setHorizontalTextPosition(AbstractButton.LEADING);
        buttonLoad.setActionCommand("Load AAS");
        buttonLoad.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.weightx = 0.33;
        add(buttonLoad, gbc);
    
    // button Recent
        JButton buttonRecent = new JButton("Recent AAS");
        buttonRecent.setVerticalTextPosition(AbstractButton.CENTER);
        buttonRecent.setHorizontalTextPosition(AbstractButton.LEADING);
        buttonRecent.setActionCommand("Recent AAS");
        buttonRecent.addActionListener(this);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.weightx = 0.33;
        add(buttonRecent, gbc);

    }
}
