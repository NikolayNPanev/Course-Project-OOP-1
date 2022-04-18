package sit.tu_varna.bg;

import java.util.ArrayList;

public class Teacher extends Person{
    private String title;
    private ArrayList disciplines;

    //constructor za suzdavane na Teacher samo s lichno i familno ime, kakto i takuv s 3 imena
    public Teacher(String firstName,String lastName,String title, ArrayList disciplines) {
        setName(firstName,lastName);
        this.title = title;
        this.disciplines = disciplines;
    }
    public Teacher(String firstName,String middleName,String lastName,String title, ArrayList disciplines) {
        setName(firstName,middleName,lastName);
        this.title = title;
        this.disciplines = disciplines;
    }

    @Override
    public String getName(){
        String name=this.title+" ";
        if(getFirstName()!=null)name+=getFirstName()+" ";
        if(getMiddleName()!=null)name+=getMiddleName()+" ";
        if(getLastName()!=null)name+=getLastName();
        return name;
    }
}
