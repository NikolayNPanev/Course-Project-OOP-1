package sit.tu_varna.bg;

import static sit.tu_varna.bg.FileIO.XMLStudentParser;
import static sit.tu_varna.bg.Menu.menu;

public class Main {
    public static void main(String[] args) throws Exception {
        XMLStudentParser();
        menu();
    }
}
