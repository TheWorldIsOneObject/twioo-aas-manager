package com.theworldisoneobject.aasmanager.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.digitaltwin.aas4j.v3.dataformat.DeserializationException;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.SerializationException;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.json.JsonDeserializer;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.json.JsonSerializer;
import org.eclipse.digitaltwin.aas4j.v3.model.Environment;

public class FileAasJSON {
    
    public void save(Environment env, String path) throws IOException, SerializationException{
        // check if path end with ".json" if not add it
        if (path.endsWith(".json") == false){
            path = path + ".json";
        }
        File myJSON = new File(path);
            myJSON.createNewFile();
        FileWriter writer = new FileWriter(myJSON);
            writer.write(new JsonSerializer().write(env));
            writer.close();
    }

    public Environment load(File file) throws DeserializationException, FileNotFoundException{
        InputStream stream = new FileInputStream(file);
        Environment env = new JsonDeserializer().read(stream);
        return env;
    }

    public Environment load(String path) throws DeserializationException, FileNotFoundException{
        InputStream stream = new FileInputStream(path);
        Environment env = new JsonDeserializer().read(stream);
        return env;
    }
}
