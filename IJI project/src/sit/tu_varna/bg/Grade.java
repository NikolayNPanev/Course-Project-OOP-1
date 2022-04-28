package sit.tu_varna.bg;

public class Grade {
    private Discipline discipline;
    private int grade;

    public Grade(Discipline discipline, int grade) {
        this.discipline = discipline;
        this.grade = grade;
    }

    public Discipline getDiscipline() {
        return discipline;
    }
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
