package sit.tu_varna.bg;

import static sit.tu_varna.bg.FileIO.XMLStudentParser;
import static sit.tu_varna.bg.FileIO.XMLStudentWriter;
import static sit.tu_varna.bg.Menu.menu;

public class Main {
    public static void main(String[] args) throws Exception {

        Major KST = new Major("KST");
        Discipline MPT = new Discipline("MPT");
        KST.addDiscipline(MPT);
        Menu.majors.add(KST);
        Student kolyo = new Student("1",KST,1,"Ivan");
        Menu.students.add(kolyo);
        System.out.println(kolyo);
        menu();
    }
}
