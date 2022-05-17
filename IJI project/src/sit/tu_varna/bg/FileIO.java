package sit.tu_varna.bg;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class FileIO {



    //Save at default filepath
    public static void XMLStudentWriter(Student s){
        try {
            FileOutputStream fos = new FileOutputStream(new File("Students/" + s.getFacultyNumber() + ".xml"));
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(s);
            encoder.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    //Save at custom filepath
    public static void XMLStudentWriter(Student s,String pathname){
        try {
            FileOutputStream fos = new FileOutputStream(new File(pathname));
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(s);
            encoder.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void XMLStudentParser(String pathname) {

        try {
            FileInputStream fis = new FileInputStream(new File(pathname));
            XMLDecoder decoder = new XMLDecoder(fis);

            Student s = (Student) decoder.readObject();
            decoder.close();
            fis.close();

            System.out.println(s.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



       /* DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(pathname)); //REPLACE WITH 'pathname' VARIABLE!!!!!!!!

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
        */
    }
}
