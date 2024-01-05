package com.theworldisoneobject.aasmanager.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.DeserializationException;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.SerializationException;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.aasx.AASXDeserializer;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.aasx.AASXSerializer;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.aasx.InMemoryFile;
import org.eclipse.digitaltwin.aas4j.v3.model.Environment;

public class FileAasAASX {
    
    public void save(Environment env, String path) throws SerializationException, IOException {
        // check if path end with ".aasx" if not add it
            if (path.endsWith(".aasx") == false){
                path = path + ".aasx";
            }
        FileOutputStream fosAASX = new FileOutputStream(path);
        Collection <InMemoryFile> files = new ArrayList<InMemoryFile>();
        //create AASX-File 
        new AASXSerializer().write(env, files, fosAASX);
    }

    public void save(Environment env, String path, Collection<InMemoryFile> coll) throws SerializationException, IOException {
        // check if path end with ".aasx" if not add it
            if (path.endsWith(".aasx") == false){
                path = path + ".aasx";
            }
        FileOutputStream fosAASX = new FileOutputStream(path);
        //create AASX-File 
        new AASXSerializer().write(env, coll, fosAASX);
    }

    public Environment load(File file) throws InvalidFormatException, IOException, DeserializationException {
        InputStream stream = new FileInputStream(file);
        Environment env = new AASXDeserializer(stream).read();
        return env;
    }

    public Environment load(String path) throws InvalidFormatException, IOException, DeserializationException {
        InputStream stream = new FileInputStream(path);
        Environment env = new AASXDeserializer(stream).read();
        return env;
    }
}

