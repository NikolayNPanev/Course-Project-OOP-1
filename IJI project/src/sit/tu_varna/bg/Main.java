package sit.tu_varna.bg;


import static sit.tu_varna.bg.Menu.menu;

public class Main {
    public static void main(String[] args){

        Major KST = new Major("KST");
        Discipline MPT = new Discipline("MPT");
        Discipline OOP = new Discipline("OOP");
        Discipline MPS = new Discipline("MPS");
        KST.addDiscipline(MPT);
        KST.addDiscipline(OOP);
        KST.addDiscipline(MPS);
        Menu.majors.add(KST);
        Student ivan = new Student("1",KST,1,"Ivan");
        ivan.Grade(new Grade(MPT,5.50));
        ivan.Grade(new Grade(OOP,3.25));
        ivan.Grade(new Grade(MPS,4.00));
        Menu.students.add(ivan);
        System.out.println(ivan);
        menu();
    }
}
