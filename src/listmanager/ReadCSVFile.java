/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listmanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author tomiwaogun
 */
class ReadCSVFile extends FilesReader implements ReaderInterface {

    ArrayList<User> usersCSVList = new ArrayList<User>();

    ReadCSVFile(String csvFile){
        fileType = csvFile;
        incomingFile = new File(csvFile);
    }
    
    public void reader() {

        BufferedReader reader = null;
        String line1 = "";

        if (fileExist(incomingFile)) {
            if (!fileType.endsWith("csv")) {
                System.out.println("The file must be an CSV file");
            } else {
                try {

                    FileReader csvFile = new FileReader(incomingFile);
                    reader = new BufferedReader(csvFile);
                    reader.readLine();
                    while ((line1 = reader.readLine()) != null) {
                        // use comma as separator
                        String[] users = line1.split(",");
                        userId = Integer.parseInt(users[0]);
                        firstName = users[1];
                        lastName = users[2];
                        userName = users[3];
                        userType = users[4];
                        /*
                DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
                try{
                Date lastLoginTime = df.parse(users[5]);
                }catch(Exception e){
                    e.printStackTrace();
                }*/
                        lastLoginTime = users[5];
                        User singleUser = new User(userId, firstName, lastName, userName, userType, lastLoginTime);
                        usersCSVList.add(singleUser);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    

    public void printer() {
        reader();
        for (User eachlist : usersCSVList) {
            System.out.println(eachlist);
        }
    }

    public ArrayList<User> getUsers() {
        reader();
        return usersCSVList;
    }
}
