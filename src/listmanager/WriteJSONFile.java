package listmanager;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author tomiwaogun
 */
public class WriteJSONFile {
PrintWriter writer;
    private String json;


    WriteJSONFile(ArrayList<User> mergedList) {
        //Library downloaded from https://mvnrepository.com/artifact/com.google.code.gson/gson/2.3.1
        json = new Gson().toJson(mergedList); 

    }

    public String getUsersJson() {
        return json;
    }

    
    public void outputToJsonFile() {
        try {
            writer = new PrintWriter("newusers.json", "UTF-8");
            writer.println(json);
            writer.close();
        } catch (IOException e) {
            // do something
        }
    }

    //Polymorphism - Method Overloading
    public void outputToJsonFIle(String outputFileName) {
        try {
            writer = new PrintWriter(outputFileName, "UTF-8");
            writer.println(json);
            writer.close();
        } catch (IOException e) {
            // do something
        }
    }

    public void printWriteJSON() {
        System.out.println("JSON: " + json);
    }

}
