package com.theworldisoneobject.aasmanager.classes;

import javax.swing.JLayeredPane;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.DeserializationException;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 * This class functions as a Main Layer for the application.
 * 
 * This class creates a JLayeredPane which aggregates all Sub-Layers of the application. It handles the visibility of Sub-Layers.
 * @author IAmAMerlin
 */

public class LayerMain extends JLayeredPane implements ActionEventListener {

//PopUps
    //FileExplorer has its own frame -> no need to instantiate here. It will be created, used and destroyed by the PopUpFileExplorer class

// private Sub-Layers 
    //index 0
    private LayerStartUp layerStartUp = new LayerStartUp();
    //index 1
    private LayerAasNew layerAasNew = new LayerAasNew();
    private LayerAasLoad layerAasLoad = new LayerAasLoad();
    private LayerAasRecent layerAasRecent = new LayerAasRecent();
    //index 2
    private LayerAasView layerAasView = new LayerAasView();
    //index 3
    private LayerAasEdit layerAasEdit = new LayerAasEdit();
    //index 4
    private LayerAasSave layerAasSave = new LayerAasSave();

    //Constructor
    public LayerMain() {
        //set layout -> no configuration needed as every Sub-Layer fills out the entire application Window and only one Sub-Layer is visible at a time
        //setLayout(new GridBagLayout());
        setLayout(new BorderLayout());

        JLayeredPane layerMain = new JLayeredPane();
        // TODO: make this dynamic to screen size
            //layerMain.setPreferredSize(new Dimension(800, 600));
    
    //index 0
        //StartUpLayer
            //options
            //layerStartUp.setBounds(0, 0, 800, 600);
            //add to layerMain
            layerMain.add(layerStartUp, JLayeredPane.DEFAULT_LAYER); //DEFAULT translates to 0
            //set ActionEventListener
            layerStartUp.setActionEventListener(this);
    
    //index 1
        //AasNewLayer
            //options 
            layerAasNew.setBounds(0, 0, 800, 600);
            layerAasNew.setVisible(false);
            //add to layerMain
            layerMain.add(layerAasNew, 1);
            //set ActionEventListener
            layerAasNew.setActionEventListener(this);
        
        //AasLoadLayer
            //options
            layerAasLoad.setBounds(0, 0, 800, 600);
            layerAasLoad.setVisible(false);
            //add to layerMain
            layerMain.add(layerAasLoad, 1);
            //set ActionEventListener
            layerAasLoad.setActionEventListener(this);

        //AasRecentLayer
            //options
            layerAasRecent.setBounds(0, 0, 800, 600);
            layerAasRecent.setVisible(false);
            //add to layerMain
            layerMain.add(layerAasRecent, 1);
            //set ActionEventListener
            layerAasRecent.setActionEventListener(this);

    //index 2
        //AasViewLayer
            //options
            layerAasView.setBounds(0, 0, 800, 600);
            layerAasView.setVisible(false);
            //add to layerMain
            layerMain.add(layerAasView, 2);
            //set ActionEventListener
            layerAasView.setActionEventListener(this);
    
    //index 3
        //AasEditLayer
            //options
            layerAasEdit.setBounds(0, 0, 800, 600);
            layerAasEdit.setVisible(false);
            //add to layerMain
            layerMain.add(layerAasEdit, 3);
            //set ActionEventListener
            layerAasEdit.setActionEventListener(this);

    //index 4
        //AASSaveLayer
            //options
            layerAasSave.setBounds(0, 0, 800, 600);
            layerAasSave.setVisible(false);
            //add to layerMain
            layerMain.add(layerAasSave, 4);
            //set ActionEventListener
            layerAasSave.setActionEventListener(this);

    //add layerMain
        add(layerMain);
    }

    //Receive ActionEvent from Sub-Layers
    public void remoteActionPerformed(ActionEvent event) {
        // Logging
        System.out.println("Action event received " + event.getSource().getClass().getName() + " " + event.getActionCommand());
    
    //from StartUpLayer
        if ("New AAS".equals(event.getActionCommand())) {
            //set visibility of StartUpLayer to false and AasNewLayer to true
            layerStartUp.setVisible(false);
            layerAasNew.setVisible(true);   
        }
        if ("Load AAS".equals(event.getActionCommand())) {
            //set visibility of StartUpLayer to false and AasLoadLayer to true
            layerStartUp.setVisible(false);
            layerAasLoad.setVisible(true);   
        }
        if ("Recent AAS".equals(event.getActionCommand())) {
            //set visibility of StartUpLayer to false and AasRecentLayer to true
            layerStartUp.setVisible(false);
            layerAasRecent.setVisible(true);   
        }
    //from layerAasNew
        if ("Back to StartUp".equals(event.getActionCommand())) {
            //set visibility of StartUpLayer to true and AasNewLayer to false
            layerStartUp.setVisible(true);
            layerAasNew.setVisible(false);
            layerAasEdit.setVisible(false);
            layerAasView.setVisible(false);
            layerAasSave.setVisible(false);
            layerAasLoad.setVisible(false);
            layerAasRecent.setVisible(false);
        }
        if ("Setup Complete".equals(event.getActionCommand())) {
            //set visibility of AasNewLayer to false and AasEditLayer to true
            layerAasNew.setVisible(false);
            layerAasEdit.setVisible(true);   
        }

    //from layerAasLoad
        //"Back to StartUp" is already handled by layerAasNew
        if ("Insert AAS".equals(event.getActionCommand())) {
            //set visibility of StartUpLayer to false and AasLoadLayer to true
            layerAasLoad.setVisible(false);
            layerAasRecent.setVisible(false);
            layerAasView.setVisible(true);   
        }
        try {
            if ("FileExplorer: OpenFile".equals(event.getActionCommand())){
                ;
                //TODO: This should be handled by some kind if Build Editor class or something. Because i can call a method from which takes in the filepath and disable the AasLoadLayer and enable the AasViewLayer
                System.out.println(new FileAasAASX().load(PopUpFileExplorer.load()));
                }
            } catch (InvalidFormatException | IOException | DeserializationException e) {
                e.printStackTrace();
            }
        
    //from layerAasRecent
        //"Back to StartUp" is already handled by layerAasNew
        //"Load AAS" is already handled by layerAasLoad
    
    //from layerAasView
        if ("Back to Load".equals(event.getActionCommand())) {
            //set visibility of AasLoadLayer to true and AasViewLayer to false
            layerAasLoad.setVisible(true);
            layerAasView.setVisible(false);   
        }
        if ("Back to Recent".equals(event.getActionCommand())) {
            //set visibility of AasRecentLayer to true and AasViewLayer to false
            layerAasRecent.setVisible(true);
            layerAasView.setVisible(false);   
        }
        if ("Enable Edit".equals(event.getActionCommand())) {
            //set visibility of AasViewLayer to false and AasEditLayer to true
            layerAasView.setVisible(false);
            layerAasEdit.setVisible(true);   
        }
        if ("Save AAS".equals(event.getActionCommand())) {
            //set visibility of AasViewLayer to false and AasSaveLayer to true
            layerAasView.setVisible(false);
            layerAasEdit.setVisible(false);
            layerAasSave.setVisible(true);   
        }
        //"Back to StartUp" is already handled by layerAasNew

    //from layerAasEdit
        if ("Back to Setup".equals(event.getActionCommand())) {
            //set visibility of AasEditLayer to false and StartUpLayer to true
            layerAasEdit.setVisible(false);
            layerAasNew.setVisible(true);   
        }        
        if ("Back to View".equals(event.getActionCommand())) {
            //set visibility of AasEditLayer to false and StartUpLayer to true
            layerAasEdit.setVisible(false);
            layerAasView.setVisible(true);   
        }
        //"save AAS" is already handled by layerAasView
        //"Back to StartUp" is already handled by layerAasNew

    //from layerAasSave
        if ("Back to Edit".equals(event.getActionCommand())) {
            //set visibility of AasSaveLayer to false and AasEditLayer to true
            layerAasSave.setVisible(false);
            layerAasEdit.setVisible(true);   
        }
        if ("Back to View".equals(event.getActionCommand())) {
            //set visibility of AasSaveLayer to false and AasViewLayer to true
            layerAasSave.setVisible(false);
            layerAasView.setVisible(true);   
        }
        //"Back to StartUp" is already handled by layerAasNew
        if ("FileExplorer: SaveFile".equals(event.getActionCommand())) {
            String filepath = PopUpFileExplorer.save();
            System.out.println("Filepath: " + filepath);
        }
   }
}
