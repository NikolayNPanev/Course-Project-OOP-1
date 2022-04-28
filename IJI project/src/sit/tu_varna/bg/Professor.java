package sit.tu_varna.bg;

import java.util.ArrayList;

public class Professor extends Person{
    private String title;
    private ArrayList disciplines;


    public Professor(String name,String title) {
        setName(name);
        this.title = title;
        this.disciplines = disciplines;
    }

    @Override
    public String getName(){
        String name = this.title+" "+this.getName();
        return name;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public ArrayList getDisciplines(){
        return this.disciplines;
    }
    public void addDiscipline(Discipline discipline){
        this.disciplines.add(discipline);
    }
}
