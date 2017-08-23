package listmanager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class WriteCSVFile {
PrintWriter writer;
    private String csv;

    public WriteCSVFile(ArrayList<User> mergedList) {
        csv = String.join(",", mergedList.toString());
    }
    

        public String getUsersCSV() {
        return csv;
    }
        
            //Polymorphism - Method Overloading
    public void outputToCSVFIle(String outputFileName) {
                try {
            writer = new PrintWriter(outputFileName, "UTF-8");
            writer.println(csv);
            writer.close();
        } catch (IOException e) {
            // do something
        }
    }

    public void printWriteCSV() {
        System.out.println("CSV: " + csv);
    }
}
