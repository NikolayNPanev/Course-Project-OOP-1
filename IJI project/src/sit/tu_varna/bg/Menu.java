package sit.tu_varna.bg;
import java.io.*;
import java.util.Scanner;

import static sit.tu_varna.bg.FileIO.readPerson;
import static sit.tu_varna.bg.FileIO.savePerson;

public class Menu {
    public static void menu() throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter command:");
        String userInput = sc.nextLine();

        String[] command = userInput.split(" ");

        if (command[0].equals("exit")) {
            return;
        }

        for (String a : command) {
            System.out.println(a);
        }
        if (command[0].equals("help")) {
            Help();
            menu();
        }
        if (command[0].equals("enroll")) {
            Student P = studentFactory(command[0], command[1], command[2], command[3], command[4]);
            P.toString();
            String filepath = "Students/"+P.getFacultyNumber() + ".student";
            savePerson(filepath,P);
            readPerson(filepath);
        }
        menu();
    }




    private static void Help() {
        System.out.println("LIST OF COMMANDS:");
        System.out.println("enroll <fn> <major> <group> <name> //saves a student to a file in folder \"Students\"");
        System.out.println("exit //exits the program");
    }

    private static Student studentFactory(String command, String op1, String op2, String op3, String op4) throws Exception {
        int group = Integer.valueOf(op3);
        if (command.equals("enroll")){
            return new Student(op1, op2, group, op4);
        }
        //op1 = facultyNumber, op2 = Major(string),op3 = group, op4 = name
        return null;
    }
}
