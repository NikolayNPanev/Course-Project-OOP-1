package sit.tu_varna.bg;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private String name = null;
    private String faculty;

    //default getName() za vseki naslednik na Person
    public String getName(){
        return name;
    }

    public void setName(String name){
    this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

}
