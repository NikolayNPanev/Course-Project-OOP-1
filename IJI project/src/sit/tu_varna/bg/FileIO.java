package sit.tu_varna.bg;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class FileIO {

    public static void XMLStudentParser() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File("Students/students.xml")); //REPLACE WITH 'pathname' VARIABLE!!!!!!!!

            document.getDocumentElement().normalize();

            NodeList studentList = document.getElementsByTagName("student");
            for(int i=0;i<studentList.getLength();i++){
                Node student = studentList.item(i);

                if(student.getNodeType() == Node.ELEMENT_NODE){
                    Element studentElement = (Element)student;
                    System.out.println("Student: "+studentElement.getAttribute("name"));
                    NodeList studentDetails = student.getChildNodes();
                    for(int j=0;j<studentDetails.getLength();j++){
                        Node details = studentDetails.item(j);
                        if(details.getNodeType() == Node.ELEMENT_NODE){
                            Element detail = (Element)details;
                            System.out.println("  "+detail.getTagName()+": "+detail.getAttribute("value"));
                        }

                    }

                }

            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
