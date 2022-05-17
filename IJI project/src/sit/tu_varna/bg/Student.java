package sit.tu_varna.bg;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private String facultyNumber;
    private int group;
    private Major major;
    private List<Grade> grades = new ArrayList<>();

//constructor za suzdavane na Student samo s lichno i familno ime, kakto i takuv s 3 imena

    public void Grade(Grade grade){
        grades.add(grade);
    }

    public void showGrades(){
        for (Grade grade:grades){
            System.out.println(grade);
        }
    }

    public List getGrades(){
        return grades;
    }

    public Student(String facultyNumber,Major major, int group,String name) {
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
                "  group: "+getGroup()+"\n" +
                "}";
    }



    }

