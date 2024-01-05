package com.theworldisoneobject.aasmanager.classes;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class FrameMenuBar {
    
        public JMenuBar createFrameMenuBar() {
            // MenuBar
            JMenuBar menuBar = new JMenuBar();
            //First menu
            JMenu firstMenu = new JMenu("File");
                
            firstMenu.setMnemonic(KeyEvent.VK_A);
            firstMenu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");

            //a group of JMenuItems
            JMenuItem menuItem = new JMenuItem("A text-only menu item",KeyEvent.VK_T);
            menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
            menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
            
            firstMenu.add(menuItem);

            menuBar.add(firstMenu);

            return menuBar;
        }



}
