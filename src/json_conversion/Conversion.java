package json_conversion;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Handles reading and witting files.
 *
 * @author David Azofeifa H.
 */
public class Conversion {

    /**
     * Reads .json file and turns it into an JSONObject instance.
     *
     * @param docName, .json file name
     * @return JSONObject instance
     */
    public JSONObject fetchJsonFile(String docName) {
        JSONObject json = null;
        try { 
            FileReader doc = new FileReader(docName);
            JSONParser parser = new JSONParser();
            try {
                json = (JSONObject) parser.parse(doc);
            } catch (ParseException e1) {
                e1.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * Turns a JSONObject instance into a file and saves it into disk.
     *
     * @param jsonDoc
     */
    public void saveJsonFile(JSONObject jsonDoc, String docName) {
        List<String> lines = Arrays.asList(jsonDoc.toString());
        Path file = Paths.get(docName);
        try {
            Files.write(file, lines, Charset.forName("UTF-8"));
        }
        catch (IOException e) {
            System.out.println(e.toString());
            System.out.println("Couldn't save file in specified path");
        }
    }
}
