package sit.tu_varna.bg;


import static sit.tu_varna.bg.Menu.menu;

public class Main {
    public static void main(String[] args){

        Major KST = new Major("KST");
        Discipline MPT = new Discipline("MPT",true);
        Discipline OOP = new Discipline("OOP",true);
        Discipline MPS = new Discipline("MPS",false);
        KST.addDiscipline(MPT,1);
        KST.addDiscipline(OOP,1);
        KST.addDiscipline(MPS,1);
        Menu.majors.add(KST);
        Student ivan = new Student("1",KST,1,"Ivan");
        ivan.Grade(new Grade(MPT,5.50));
        ivan.Grade(new Grade(OOP,2.25));
        ivan.Grade(new Grade(MPS,4.00));
        ivan.advance();
        Menu.students.add(ivan);
        System.out.println(ivan);
        menu();
    }
}
