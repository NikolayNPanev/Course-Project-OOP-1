package sit.tu_varna.bg;


import static sit.tu_varna.bg.Menu.menu;

public class Main {
    public static void main(String[] args){
        //TEST DATA

        //Creating majors
        Major KST = new Major("KST");
        Major SIT = new Major("SIT");

        //Creating disciplines for the majors
        Discipline MPT = new Discipline("MPT",true);
        Discipline OOP = new Discipline("OOP",true);
        Discipline MPS = new Discipline("MPS",false);
        Discipline ASLS = new Discipline("ASLS",true);
        Discipline OOP2 = new Discipline("OOP2",true);

        //Adding the disciplines to the majors, and the year they are taught in
            //KST
        KST.addDiscipline(MPT,1);
        KST.addDiscipline(OOP,2);
        KST.addDiscipline(MPS,3);
        KST.addDiscipline(ASLS,4);
            //SIT
        SIT.addDiscipline(MPT,1);
        SIT.addDiscipline(OOP,2);
        SIT.addDiscipline(MPS,3);
        SIT.addDiscipline(OOP2,4);

        //Adding the majors and, subsequently, their disciplines to the static array list of majors in the menu class
        Menu.majors.add(KST);
        Menu.majors.add(SIT);

        //Ceating a test student in the KST major
        Student ivan = new Student("1",KST,1,"Ivan");
        //Creating a test student in the SIT major
        Student kolyo = new Student("2",SIT,1,"Kolyo");

        //Grading and advancing the KST test student
        ivan.Grade(new Grade(MPT,5.50));
        ivan.advance();
        ivan.Grade(new Grade(OOP,3.25));
        ivan.advance();
        ivan.Grade(new Grade(MPS,4.00));
        ivan.advance();
        ivan.Grade(new Grade(ASLS,2.00));

        //Grading and advancing the SIT test student
        kolyo.Grade(new Grade(MPT,5.50));
        kolyo.advance();
        kolyo.Grade(new Grade(OOP,3.25));
        kolyo.advance();
        kolyo.Grade(new Grade(MPS,4.00));
        kolyo.advance();
        kolyo.Grade(new Grade(OOP2,6.00));

        //Adding the test students and all of their grades to the static array list of students in the menu class
        Menu.students.add(ivan);
        Menu.students.add(kolyo);
        menu();
    }
}
