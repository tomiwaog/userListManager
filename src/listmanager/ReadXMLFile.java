package listmanager;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class ReadXMLFile extends FilesReader implements ReaderInterface {

    ArrayList<User> userXMLList = new ArrayList<User>();

    public ReadXMLFile(String xmlFile) {
        fileType = xmlFile;
        incomingFile = new File(xmlFile);
    }

    public void reader() {
        if (fileExist(incomingFile)) {
            if (!fileType.endsWith("xml")) {
                System.out.println("The file must be an XML file");
            } else {

                try {
                    //Get Document Builder
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

                    //Build Document
                    Document docu = dBuilder.parse(incomingFile);

                    //Normalize the XML Structure; It's just too important !!
                    docu.getDocumentElement().normalize();

                    NodeList nList = docu.getElementsByTagName("user");

                    //Iterate via each user's detail
                    for (int temp = 0; temp < nList.getLength(); temp++) {
                        Node kNode = nList.item(temp);

                        if (kNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element eElement = (Element) kNode;
                            userId = Integer.parseInt(eElement.getElementsByTagName("userid").item(0).getTextContent());
                            firstName = eElement.getElementsByTagName("firstname").item(0).getTextContent();
                            lastName = eElement.getElementsByTagName("surname").item(0).getTextContent();
                            userName = eElement.getElementsByTagName("username").item(0).getTextContent();
                            String userType = eElement.getElementsByTagName("type").item(0).getTextContent();
                            String lastLoginTime = eElement.getElementsByTagName("lastlogintime").item(0).getTextContent();
                            User singleUser = new User(userId, firstName, lastName, userName, userType, lastLoginTime);
                            userXMLList.add(singleUser);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printer() {
        reader();
        for (User eachlist : userXMLList) {
            System.out.println(eachlist);
        }
    }

    public ArrayList<User> getUsers() {
        reader();
        return userXMLList;
    }
}
