package sit.tu_varna.bg;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Boolean.parseBoolean;

public class Menu {
    public static List<Major> majors = new ArrayList<>();
    public static List<Student> students = new ArrayList<>();
    private static final DecimalFormat df = new DecimalFormat("#.##");

    private static void Help() {
        System.out.println("\n===================================" +
                "\nLIST OF COMMANDS:");
        System.out.println("enroll <fn> <major> <group> <name>                    //enrolls a student");
        System.out.println("major " +
                "\n     add <major name>                                 //creates a major");
        System.out.println("     remove <major name>                              //removes a major");
        System.out.println("discipline " +
                "\n     add <discipline name> <major name> <mandatory(true/false)> <year>//adds a discipline to a major");
        System.out.println("     remove <discipline name> <major name> <year>     //removes a discipline from a major");
        System.out.println("grade <faculty number> <discipline> <grade>           //gives a student a grade");
        System.out.println("      change <faculty number> <discipline> <grade>    //changes a student's grade");
        System.out.println("average grade <faculty number>                        //displays a student's average grade");
        System.out.println("advance <faculty number>                              //advance student to the next year");
        System.out.println("graduate <faculty number>                             //graduates a student");
        System.out.println("exit                                                  //exits the program" +
                "\n===================================");
    }

    private static void invalidSyntax(){
        System.err.println("Invalid syntax! Type \"help\" or \"?\" for a list of commands");
    }

    private static void graduate(String[] command){
        if(command.length<2){
            invalidSyntax();
            return;
        }
        for(Student student: students){
            if(student.getFacultyNumber().equals(command[1])){
                student.graduate();
                return;
            }
        }
        System.err.println("Student with this faculty number doesn't exist");
    }

    private static void advance(String[] command){
        if(command.length<2){
            invalidSyntax();
            return;
        }
        for (Student student:students){
            if(student.getFacultyNumber().equals(command[1]))
                student.advance();
            return;
        }
        System.out.println("A student with this faculty number doesn't exist!");
    }

    private static void discipline(String[] command) {

        //check for syntax
        if (command.length < 4) {
            invalidSyntax();
            menu();
        }

        //switch for "discipline" commands
        switch (command[1]) {
            //-----------------------------------remove discipline
            case "remove" -> {
                for (Major major : majors) {
                    for (int i = 0; i < major.getDisciplines(Integer.parseInt(command[3])).size(); i++) {
                        if (major.getDisciplines(Integer.parseInt(command[3])).get(i).getDisciplineName().equals(command[2]) && major.getName().equals(command[3])) {
                            major.getDisciplines(Integer.parseInt(command[3])).remove(major.getDisciplines(Integer.parseInt(command[3])).get(i));
                            System.out.println("Discipline successfully removed from this major!");
                            menu();
                        }
                    }
                }
                System.err.println("This discipline doesn't exist");
            }
            //---------------------------------add discipline
            case "add" -> {
                if (command.length == 6) {
                    if (command[4].equals("true") || command[4].equals("false") || command[4].equals("TRUE") || command[4].equals("FALSE") || command[4].equals("1") || command[4].equals("0") || command[4].equals("True") || command[4].equals("False")) {
                        Discipline D = new Discipline(command[2], Boolean.parseBoolean(command[4]));

                        for (Major major : majors) {
                            for (int i = 0; i < major.getDisciplines(Integer.parseInt(command[4])).size(); i++) {
                                if (major.getDisciplines(Integer.parseInt(command[4])).get(i).getDisciplineName().equals(command[2]) && major.getName().equals(command[3])) {
                                    System.err.println("Discipline already exists in this major!");
                                    menu();
                                }
                            }
                        }
                        for (Major major : majors) {
                            if (major.getName().equals(command[3])) {
                                major.addDiscipline(D,Integer.parseInt(command[4]));
                                System.out.println("Discipline added successfully to this major!");
                            }
                        }
                    }
                    else{
                        invalidSyntax();
                    }
                }else {
                    invalidSyntax();
                }
            }
            default -> invalidSyntax();
        }
    }

    public static void major(String[] command){
        if(command.length<3){
            invalidSyntax();
            menu();
        }

        //switch for "major" commands
        switch (command[1]) {
            //---------------------------------add major
            case "add" -> {
                Major M = new Major(command[2]);
                for (Major major : majors) {
                    if (major.getName().equals(command[2])) {
                        System.err.println("This major already exists!");
                        menu();
                    }
                }
                majors.add(M);
                System.out.println("Major added!");
            }
            //------------------------------remove major
            case "remove" -> {
                for (Major major : majors) {
                    if (major.getName().equals(command[2])) {
                        majors.remove(major);
                        System.out.println("Major removed!");
                        menu();
                    }
                }
                System.err.println("This major does not exist!");
            }
            default -> invalidSyntax();
        }
    }

    private static void enroll(String[] command){
        if(command.length<5){
            invalidSyntax();
            menu();
        }
        for (Student student: students){
            if(student.getFacultyNumber().equals(command[1])){
                System.err.println("A student with this faculty number already exists");
                menu();
            }
        }
        for(Major major: majors) {
            if(command[2].equals(major.getName())) {
                try {
                    Student P = new Student(command[1], major, Integer.parseInt(command[3]), command[4]);
                    students.add(P);
                    System.out.println(P);
                }catch (NumberFormatException e){
                    invalidSyntax();
                }

                menu();
            }
        }
        System.err.println("This major doesn't exist!");
    }

    private static void grade(String[] command){
        if(command.length<4){
            invalidSyntax();
            menu();
        }
        if(command[1].equals("change")||command[1].equals("Change")||command[1].equals("CHANGE")){
            if(command.length<5){
                invalidSyntax();
                menu();
            }
            for(Student student: students){
                if(student.getFacultyNumber().equals(command[2])){
                    for(Discipline discipline: student.getMajor().getDisciplines(student.getYear())) {
                        if(discipline.getDisciplineName().equals(command[3])) {
                            student.changeGrade(discipline, Double.parseDouble(command[4]));
                            return;
                        }
                    }
                    System.err.println("Student doesn't have this discipline");
                    return;
                }
            }
            System.err.println("Student with this faculty number doesn't exist");
            return;
        }

        for(Student student: students){
            if(student.getFacultyNumber().equals(command[1])) {
                for (Discipline discipline : student.getMajor().getDisciplines(student.getYear())) {
                    if (discipline.getDisciplineName().equals(command[2])) {
                        try {
                            student.Grade(new Grade(discipline, Double.parseDouble(command[3])));

                        }catch (NumberFormatException e){
                            invalidSyntax();
                        }
                        menu();
                    }
                }
                System.err.println("This discipline is not part of this student's major");
                menu();
            }
        }
        System.err.println("Student with this faculty number doesn't exist");
    }

    private static void averageGrade(String[] command){
        if(command.length==3) {
            if (command[1].equals("grade") || command[1].equals("Grade") || command[1].equals("GRADE")) {
                for (Student student : students) {
                    if (student.getFacultyNumber().equals(command[2])) {
                        System.out.println(student.getFacultyNumber() + ": " + df.format(student.averageGrade()));
                        menu();

                    }
                }
                System.err.println("A student with this faculty number doesnt exist!");
            } else {
                invalidSyntax();
            }
            menu();
        }
        if(command.length==2) {
            for (Student student : students) {


                if (student.getFacultyNumber().equals(command[1])) {
                    System.out.println(student.getFacultyNumber() + ": " + df.format(student.averageGrade()));
                    menu();
                }
            }
        }else{
            invalidSyntax();
        }
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter command:      //type \"help\" or \"?\" to see the commands");
        String userInput = sc.nextLine();

        String[] command = userInput.split(" ");

        switch(command[0]) {
            //------------------------------------------------------------------------------------------exit
            case "exit":
                //exiting with code 0, stating successful termination of the program
                System.exit(0);
                break;
                //-------------------------------------------------------------------------------------help
            case "help":
            case "Help":
            case "HELP":
            case "?":
                Help();
                menu();
                break;
                //--------------------------------------------------------------------------------graduate
            case "graduate":
            case "Graduate":
            case "GRADUATE":
                graduate(command);
                break;
           //-------------------------------------------------------------------------------------advance
            case "advance":
            case "Advance":
            case "ADVANCE":
                advance(command);
                break;
            //-------------------------------------------------------------------------------------average grade
            case "average":
            case "Average":
            case "AVERAGE":
            case "averagegrade":
            case "Averagegrade":
            case "AVERAGEGRADE":
                averageGrade(command);
                break;
            //-----------------------------------------------------------------------------------------enroll
            case "enroll":
            case "Enroll":
            case "ENROLL":
               enroll(command);
                break;
            //-------------------------------------------------------------------------------------------major
            case "major":
            case "Major":
            case "MAJOR":
               major(command);
                break;
                //------------------------------------------------------------------------------------discipline
            case "discipline":
                discipline(command);
                break;
                //-------------------------------------------------------------------------------------grade
            case "grade":
                   grade(command);
                break;
                //-------------------------------------------------------------------------------------default
            default:
                System.err.println("Invalid command! Type \"help\" or \"?\" for a list of commands");
                break;
        }
        menu();
    }
}
