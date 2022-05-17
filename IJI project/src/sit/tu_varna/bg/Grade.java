package sit.tu_varna.bg;

public class Grade {
    private Discipline discipline;
    private double grade;

    public Grade(Discipline discipline, double grade) {
        this.discipline = discipline;
        this.grade = grade;
    }

    @Override
    public String toString(){
        return "discipline: "+getDiscipline().getDisciplineName()+"" +
                "\ngrade: "+getGrade()+"\n==========";
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
