package sit.tu_varna.bg;

import java.util.ArrayList;
import java.util.List;

public class Major {
    private List<Discipline> disciplinesYear1 = new ArrayList();
    private List<Discipline> disciplinesYear2 = new ArrayList();
    private List<Discipline> disciplinesYear3 = new ArrayList();
    private List<Discipline> disciplinesYear4 = new ArrayList();
    private String name;

    public Major(String name) {
        this.name = name;
    }

    public List<Discipline> getDisciplines(int year) {
        if(year==1)return disciplinesYear1;
        if(year==2)return disciplinesYear2;
        if(year==3)return disciplinesYear3;
        if(year==4)return disciplinesYear4;
        List<Discipline> disciplines = new ArrayList();
        for(Discipline discipline: disciplinesYear1){
            disciplines.add(discipline);
        }
        for(Discipline discipline: disciplinesYear2){
            disciplines.add(discipline);
        }
        for(Discipline discipline: disciplinesYear3){
            disciplines.add(discipline);
        }
        for(Discipline discipline: disciplinesYear4){
            disciplines.add(discipline);
        }
        return disciplines;
    }

    public void addDiscipline(Discipline discipline,int year) {
        if(year==1)this.disciplinesYear1.add(discipline);
        if(year==2)this.disciplinesYear2.add(discipline);
        if(year==3)this.disciplinesYear3.add(discipline);
        if(year==4)this.disciplinesYear4.add(discipline);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}