package sit.tu_varna.bg;

import static sit.tu_varna.bg.FileIO.XMLStudentParser;
import static sit.tu_varna.bg.FileIO.XMLStudentWriter;
import static sit.tu_varna.bg.Menu.menu;

public class Main {
    public static void main(String[] args) throws Exception {
        Student kolyo = new Student("20621511","SIT",1,"Kolyo");
        XMLStudentWriter(kolyo);
        XMLStudentParser("Students/20621511.xml");
        menu();
    }
}
