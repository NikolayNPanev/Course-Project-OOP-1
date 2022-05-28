package sit.tu_varna.bg;

import java.text.DecimalFormat;

public class Grade {
    private Discipline discipline;
    private double grade;
    private static DecimalFormat df = new DecimalFormat("#.##");

    public Grade(Discipline discipline, double grade) {
        this.discipline = discipline;
        this.grade = grade;
    }

    @Override
    public String toString(){
        return "discipline: "+getDiscipline().getDisciplineName()+"" +
                "\ngrade: "+df.format(getGrade())+"\n==========";
    }

    public Discipline getDiscipline() {
        return discipline;
    }
    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}