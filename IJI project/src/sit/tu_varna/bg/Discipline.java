package sit.tu_varna.bg;

import java.util.ArrayList;

public class Discipline {
    private String faculty;
    private String disciplineName;
    private ArrayList semesters;
    private ArrayList majors;

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }
    public void addSemester(int semester){
        this.semesters.add(semester);
    }
    public ArrayList getSemesters(){
        return this.semesters;
    }
    public void addMajor(String major){
        this.majors.add(major);
    }
    public ArrayList getMajors(){
        return this.majors;
    }
}
