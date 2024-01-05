package com.theworldisoneobject.aasmanager.classes;

import java.awt.FileDialog;
import java.awt.Frame;

public class PopUpFileExplorer {

    private static FileDialog chooser = new FileDialog((Frame) null);

    public static String load() {
        // setup FileDialog to load
        chooser.setTitle("Select File to Load");
        chooser.setMode(FileDialog.LOAD);
        chooser.setVisible(true);
        // collect filename and directorypath
        String filename = chooser.getFile();
        String directorypath = chooser.getDirectory();
        // logging
        System.out.println("Selected file: " + directorypath + filename);

        return (directorypath + filename);
    }

    public static String save() {
        // setup FileDialog to save
        chooser.setTitle("Select Save Destination");
        chooser.setMode(FileDialog.LOAD);
        chooser.setVisible(true);
        // collect filename and directorypath
        String filename = chooser.getFile();
        String directorypath = chooser.getDirectory();
        // logging
        System.out.println("Selected file: " + directorypath + filename);
        
        return (directorypath + filename);
    }
}
