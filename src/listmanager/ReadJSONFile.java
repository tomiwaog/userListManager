package listmanager;

import java.io.File;

//Utilising Json simple library, can be downloaded from https://github.com/fangyidong/json-simple
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author tomiwaogun
 */
public class ReadJSONFile extends FilesReader implements ReaderInterface {

    ArrayList<User> userJSONList = new ArrayList<User>();

    ReadJSONFile(String jsonFile) {
        fileType = jsonFile;
        incomingFile = new File(jsonFile);
    }

    @Override
    public void reader() {
        JSONParser parser = new JSONParser();

        if (fileExist(incomingFile)) {
            if (!fileType.endsWith("json")) {
                System.out.println("The file must be an JSON file");
            } else {

                try {
                    FileReader jsonUserFile = new FileReader(incomingFile);
                    Object obj = parser.parse(jsonUserFile);
                    //System.out.println(obj);

                    JSONArray jsonArray = (JSONArray) obj;
                    int length = jsonArray.size();

                    for (int i = 0; i < length; i++) {
                        JSONObject jsonObj = (JSONObject) jsonArray.get(i);
                        long userid = (long) jsonObj.get("user_id");
                        userId = (int) userid;
                        firstName = (String) jsonObj.get("first_name");

                        lastName = (String) jsonObj.get("last_name");
                        userName = (String) jsonObj.get("username");
                        userType = (String) jsonObj.get("user_type");
                        lastLoginTime = (String) jsonObj.get("last_login_time");
                        User singleUser = new User(userId, firstName, lastName, userName, userType, lastLoginTime);
                        userJSONList.add(singleUser);

                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Override
    public void printer() {
        reader();
        for (User eachlist : userJSONList) {
            System.out.println(eachlist);
        }
    }

    @Override
    public ArrayList<User> getUsers() {
        reader();
        return userJSONList;
    }

}
