package sit.tu_varna.bg;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private String facultyNumber;
    private int group;
    private Major major;
    private List<Grade> grades = new ArrayList<>();
    private int year = 1;
    private boolean graduated = false;

    public boolean isGraduated() {
        return graduated;
    }

    public int getYear() {
        return year;
    }

    public void changeGrade(Discipline discipline, double grade){
        if(graduated == true){
            System.err.println("This student has already graduated");
            return;
        }
        for(Grade grd:grades){
            if(grd.getDiscipline()== discipline){
                grd.setGrade(grade);
                System.out.println("Grade changed successfully!");
                return;
            }
        }
        System.err.println("Student hasn't been graded in this discipline yet!");
    }

    public void Grade(Grade grade){
        if(graduated == true){
            System.err.println("This student has already graduated");
            return;
        }
        for(Grade grd: grades){
            if(grd.getDiscipline()== grade.getDiscipline()){
                System.err.println("Student already has a grade in this discipline!");
                return;
            }
        }
        if(grade.getGrade()>=2&&grade.getGrade()<=6) {
            grades.add(grade);
            System.out.println(grade);
            System.out.println("Student graded successfully\n");
            return;
        }
        System.err.println("Grades must be between 2.00 and 6.00!");
    }

    public void advance(){
        if(graduated == true){
            System.err.println("This student has already graduated");
            return;
        }
        if(grades.isEmpty()){
            System.err.println("This student hasn't been graded yet!");
            return;
        }
        for(Grade grade: grades){
            if(grade.getGrade()<3 && grade.getDiscipline().isMandatory()) {
                System.err.println("This student has failed one or more  mandatory classes and cannot advance!");
                return;
            }
        }
        if(year<4){
            year++;
            System.out.println("Student has advanced to the next year!");
            return;
        }
        System.out.println("Student is ready to graduate! Use command \"graduate <faculty number>\" to graduate the student.");
    }

    public void graduate(){
        if(graduated == true){
            System.err.println("This student has already graduated");
            return;
        }
        if(year >= 4){
            for(Grade grade : grades){
                if(grade.getGrade()<3 && grade.getDiscipline().isMandatory()) {
                    System.err.println("This student has failed one or more  mandatory classes and cannot graduate!");
                    return;
                }
            }
            graduated = true;
            System.out.println("Student has graduated successfully!");
            return;
        }
        System.err.println("This student is not in the 4th year and cannot graduate!");
    }

    public void showGrades(){
        if(graduated == true){
            System.err.println("This student has already graduated");
            return;
        }
        if(grades.isEmpty()){
            System.err.println("This student hasn't been graded yet!");
            return;
        }
        for (Grade grade:grades){
            System.out.println(grade);
        }
    }

    public List getGrades(){
        return grades;
    }

    public double averageGrade(){

        double averageGrade=0;
        int i=0;
        for (Grade grade:grades){
            averageGrade+=grade.getGrade();
            i++;
        }
        averageGrade/=i;
        return averageGrade;
    }

    public Student(String facultyNumber,Major major, int group,String name) {
        //op1 = facultyNumber, op2 = Major(string),op3 = group, op4 = name
        setName(name);
        this.group = group;
        this.facultyNumber = facultyNumber;
        this.major = major;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }


    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }
    @Override
    public String toString(){
        return "Student{\n" +
                "  name: "+getName()+"\n" +
                "  faculty number: "+getFacultyNumber()+"\n" +
                "  major: "+getMajor().getName()+"\n" +
                "  year: " + getYear()+"\n" +
                "  group: "+getGroup()+"\n" +
                "  graduated: "+isGraduated()+"\n"+
                "}";
    }
 }