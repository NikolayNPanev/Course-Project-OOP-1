package sit.tu_varna.bg;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static List<Major> majors = new ArrayList<>();
    public static List<Student> students = new ArrayList<>();
    public static void menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter command:      //type \"help\" or \"?\" to see the commands");
        String userInput = sc.nextLine();

        String[] command = userInput.split(" ");

        switch(command[0]) {
            case "exit":
                System.exit(1);
            case "help":
            case "Help":
            case "HELP":
            case "?":
                Help();
                menu();
                break;



            case "enroll":
            case "Enroll":
            case "ENROLL":
                for (Student student: students){
                    if(student.getFacultyNumber().equals(command[1])){
                        System.err.println("A student with this faculty number already exists");
                        menu();
                    }
                }
                for(Major major: majors) {
                    if(command[2].equals(major.getName())) {
                        Student P = new Student(command[1], major, Integer.parseInt(command[3]),command[4]);
                        students.add(P);
                        System.out.println(P);
                        menu();
                    }
                }
                System.err.println("This major doesn't exist!");
                break;


            case "major":
                //check for syntax
                if(command.length<3){
                    System.err.println("Invalid syntax! Type \"help\" or \"?\" for a list of commands");
                    break;
                }

                //switch for "major" commands
                switch(command[1]){
                    case "add":
                        Major M = new Major(command[2]);
                        for(Major major:majors){
                            if(major.getName().equals(command[2])) {
                                System.err.println("This major already exists!");
                                menu();
                            }
                        }
                        majors.add(M);
                        System.out.println("Major added!");
                        break;
                    case "remove":
                        for(Major major:majors){
                            if(major.getName().equals(command[2])) {
                                majors.remove(major);
                                System.out.println("Major removed!");
                                menu();
                            }
                        }
                        System.err.println("This major does not exist!");
                        break;
                    default:
                        System.err.println("Invalid syntax! Type \"help\" or \"?\" for a list of commands");
                }
                break;
            case "discipline":

                //check for syntax
                if(command.length<3){
                    System.err.println("Invalid syntax! Type \"help\" or \"?\" for a list of commands");
                    break;
                }

                //switch for "discipline" commands--------------
                switch (command[1]){
                    case "remove":
                        for(Major major: majors) {
                            for(int i=0;i<major.getDisciplines().size();i++) {
                                if (major.getDisciplines().get(i).getDisciplineName().equals(command[2]) && major.getName().equals(command[3])){
                                   major.getDisciplines().remove(major.getDisciplines().get(i));
                                    System.out.println("Discipline successfully removed from this major!");
                                    menu();
                                }
                            }
                        }
                        System.err.println("This discipline doesn't exist");
                        break;
                    case "add":
                                Discipline D = new Discipline(command[2]);
                                for(Major major: majors) {
                                    for(int i=0;i<major.getDisciplines().size();i++) {
                                        if (major.getDisciplines().get(i).getDisciplineName().equals(command[2]) && major.getName().equals(command[3])){
                                            System.err.println("Discipline already exists in this major!");
                                            menu();
                                        }
                                    }
                                }
                                for(Major major: majors){
                                    if(major.getName().equals(command[3])){
                                        major.addDiscipline(D);
                                        System.out.println("Discipline added successfully to this major!");
                                    }
                                }
                                break;
                    default:
                        System.err.println("Invalid syntax! Type \"help\" or \"?\" for a list of commands");
                        break;
                }
                break;
            default:
                System.err.println("Invalid command! Type \"help\" or \"?\" for a list of commands");
                break;
        }
        menu();
    }




    private static void Help() {
        System.out.println("LIST OF COMMANDS:");
        System.out.println("enroll <fn> <major> <group> <name>                  //saves a student to a file in folder \"Students\"");
        System.out.println("major add <major name>                              //creates a major");
        System.out.println("------remove <major name>                           //removes a major");
        System.out.println("discipline add <discipline name> <major name>       //adds a discipline to a major");
        System.out.println("-----------remove <discipline name> <major name>    //removes a discipline from a major");
        System.out.println("\nexit //exits the program");
    }

}
