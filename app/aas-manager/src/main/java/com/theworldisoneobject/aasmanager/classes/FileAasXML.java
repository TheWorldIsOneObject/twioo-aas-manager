package com.theworldisoneobject.aasmanager.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.digitaltwin.aas4j.v3.dataformat.DeserializationException;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.SerializationException;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.xml.XmlDeserializer;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.xml.XmlSerializer;
import org.eclipse.digitaltwin.aas4j.v3.model.Environment;

public class FileAasXML {
    
    public void save(Environment env, String path) throws IOException, SerializationException{
        // check if path end with ".xml" if not add it
        if (path.endsWith(".xml") == false){
            path = path + ".xml";
        }
        File myXML = new File(path);
            myXML.createNewFile();
        FileWriter writer = new FileWriter(myXML);
            writer.write(new XmlSerializer().write(env));
            writer.close();
    }
    public Environment load(String path) throws DeserializationException, FileNotFoundException {
        InputStream stream = new FileInputStream(path);
        Environment env = new XmlDeserializer().read(stream);
        return env;
    }

    public Environment load(File file) throws DeserializationException, FileNotFoundException {
        InputStream stream = new FileInputStream(file);
        Environment env = new XmlDeserializer().read(stream);
        return env;
    }
}
