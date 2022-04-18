package sit.tu_varna.bg;

import java.util.ArrayList;

public class Student extends Person{
    private String facultyNumber;
    private int currentSemester;
    private String course;
    private ArrayList grades;
    private ArrayList disciplines;

//constructor za suzdavane na Student samo s lichno i familno ime, kakto i takuv s 3 imena
    public Student(String firstName,String lastName,String facultyNumber, String course) {
        setName(firstName,lastName);
        this.facultyNumber = facultyNumber;
        this.course = course;
    }
    public Student(String firstName,String middleName,String lastName,String facultyNumber, String course) {
        setName(firstName,middleName,lastName);
        this.facultyNumber = facultyNumber;
        this.course = course;
    }
}
