package listmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* User List Manager allows you to import user lists in JSON format, CSV Format and XML Format.
One can also export this this list in similar format and output it to a file.
*/
public class Main {

    public static void main(String[] args) {
        //New Arraylist to store and merged XML, XSV and JSON mini files.
        ArrayList<User> mergedList = new ArrayList<User>();
        ReadXMLFile first = new ReadXMLFile("data/users.xml");
        //first.printer(); //test print
        //first.getUsers(); //Test method to see if Oject returns methods
        merge(first.getUsers(), mergedList); //Adds list to mergedList

        //Create a new readcsvfile passing file location as parameter
        ReadCSVFile second = new ReadCSVFile("data/users.csv");
        //second.printer(); //Test method to print newly read CSV FIle
        merge(second.getUsers(), mergedList); //appends list to mergedList

        ReadJSONFile third = new ReadJSONFile("data/users.json");
        //third.printer(); //Debug
        merge(third.getUsers(), mergedList); //appends list to mergedList
        //3 Merged List

        //printAllUsersList(mergedList);
        System.out.println("--- List Aggregate ---");
        printAllUsersList(mergedList); //test printing mergedList array before sorting function
        sortList(mergedList); //Sort method called on Aggregated list
        System.out.println("\n--- Sorted List ---");
        printAllUsersList(mergedList); //Anothing print test after sort function is called.
 
                System.out.println("\n--- Write to JSON OutputFile---");  
        WriteJSONFile newJsonOut = new WriteJSONFile(mergedList);
        newJsonOut.outputToJsonFIle("myjson.json");
        newJsonOut.printWriteJSON();
        
        System.out.println("\n--- Write to CSV OutputFile ---");  
        WriteCSVFile newCsvOut = new WriteCSVFile(mergedList);
        newCsvOut.outputToCSVFIle("mycsv.csv");
        newCsvOut.printWriteCSV();
        
        System.out.println("\n--- Write to XML OutputFile ---"); 
        //Takes a list of input and writes it to file
        WriteXMLFile newXmlOut = new WriteXMLFile(mergedList);
        newXmlOut.outputToXMLFile("myxml.xml");
    }

    private static void merge(ArrayList<User> source, ArrayList<User> destination) {
        for (int i = 0; i < source.size(); i++) {
            User user = source.get(i);
            destination.add(user);
        }
    }

    private static void printAllUsersList(ArrayList<User> userList) {
        for (User eachlist : userList) {
            System.out.println(eachlist);
        }
    }

    private static ArrayList<User> sortList(ArrayList<User> mergedList) {
        // Sorting
        Collections.sort(mergedList, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.getUserId() - user2.getUserId();
            }
        });
        return mergedList;
    }

}
