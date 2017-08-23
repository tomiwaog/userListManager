package listmanager;

import java.io.File;

public class FilesReader {

    int userId;
    protected String firstName, lastName, userName, userType;
    String lastLoginTime, fileType;
    boolean fileExist;
    File incomingFile;

    FilesReader() {

    }

    //Method to check if incoming file exists in the folder specified
    public boolean fileExist(File newFile) {
        this.incomingFile = newFile;
        if (incomingFile.exists())
            return true;
        else{
            System.out.println("ERROR! File not found, Please check file path");
            return false;
    }}
    
    
}
