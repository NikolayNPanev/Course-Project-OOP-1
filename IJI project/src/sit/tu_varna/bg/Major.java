package sit.tu_varna.bg;

import java.util.ArrayList;
import java.util.List;

public class Major {
    private List<Discipline> disciplines = new ArrayList();
    private String name;

    public Major(String name) {
        this.name = name;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void addDiscipline(Discipline disciplines) {
        this.disciplines.add(disciplines);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}