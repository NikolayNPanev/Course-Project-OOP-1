package sit.tu_varna.bg;

import java.util.ArrayList;

public class Student extends Person{
    private String facultyNumber;
    private int group;
    //private int currentSemester;
    private String major;
    //private ArrayList grades;
    //private ArrayList disciplines;



//constructor za suzdavane na Student samo s lichno i familno ime, kakto i takuv s 3 imena

    public Student(String facultyNumber,String major, int group,String name) {
        //op1 = facultyNumber, op2 = Major(string),op3 = group, op4 = name
        setName(name);
        this.group = group;
        this.facultyNumber = facultyNumber;
        this.major = major;
    }

    public Student() {
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


    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    @Override
    public String toString(){
        return "Student{\n" +
                "  name: "+getName()+"\n" +
                "  faculty number: "+getFacultyNumber()+"\n" +
                "  major: "+getMajor()+"\n" +
                "  group: "+getGroup();
    }
/*
    public void addGrade(Grade grade){
        this.grades.add(grade);
    }

    public ArrayList getAllGrades(){
        return this.grades;
    }
    public ArrayList getDisciplines(){
        return this.disciplines;
    }

 */
    /*
    public int getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(int currentSemester) {
        this.currentSemester = currentSemester;
    }

 */
}
