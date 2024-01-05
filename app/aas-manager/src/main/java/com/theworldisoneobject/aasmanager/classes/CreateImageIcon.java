package com.theworldisoneobject.aasmanager.classes;

import javax.swing.ImageIcon;

//TODO: why did  I add this? no purpose right? -> probably because i wanted to add an img to a button...

public class CreateImageIcon {
       
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = CreateImageIcon.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
