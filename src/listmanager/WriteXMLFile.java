package listmanager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXMLFile {
    ArrayList<User> toXml;
    
    WriteXMLFile(ArrayList<User> mergedList){
        toXml = mergedList;
    }
    //Getters method for encapsulated xml
    public ArrayList<User> getXMLArray(){
        return toXml;
    }
        
    public void outputToXMLFile(String xmlOutFileName){
        
        try {

        DocumentBuilderFactory docFac = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = docFac.newDocumentBuilder();
        Document doc = build.newDocument();

        Element root = doc.createElement("users");
        doc.appendChild(root);

        Element Users = doc.createElement("user");
        root.appendChild(Users);


        for (User user : toXml) {
            Element userId = doc.createElement("userid");
            userId.appendChild(doc.createTextNode(String.valueOf(user.getUserId())));
            Users.appendChild(userId);
            
            Element firstName = doc.createElement("firstname");
            firstName.appendChild(doc.createTextNode(String.valueOf(user
                    .getFirstName())));
            Users.appendChild(firstName);
            
            Element lastName = doc.createElement("lastname");
            lastName.appendChild(doc.createTextNode(String.valueOf(user
                    .getLastName())));
            Users.appendChild(lastName);

            Element userName = doc.createElement("username");
            userName.appendChild(doc.createTextNode(String.valueOf(user
                    .getUserName())));
            Users.appendChild(userName);
            
            Element userType = doc.createElement("usertype");
            userType.appendChild(doc.createTextNode(String.valueOf(user.getUserType())));
            Users.appendChild(userType);

            Element lastLoginTime = doc.createElement("lastlogintime");
            lastLoginTime.appendChild(doc.createTextNode(String.valueOf(user.getLastLoginTime())));
            Users.appendChild(lastLoginTime);
        }

        // Save the document to the disk file
        TransformerFactory tranFactory = TransformerFactory.newInstance();
        Transformer aTransformer = tranFactory.newTransformer();

        // XML Presentation format
        aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
        aTransformer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "2");
        aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        try {
            // location and name of XML file you can change as per need
            FileWriter fos = new FileWriter(xmlOutFileName);
            StreamResult result = new StreamResult(fos);
            aTransformer.transform(source, result);

        } catch (IOException e) {

            e.printStackTrace();
        }

    } catch (TransformerException ex) {
        System.out.println("Error outputting document");

    } catch (ParserConfigurationException ex) {
        System.out.println("Error building document");
    }
    }
   
}
