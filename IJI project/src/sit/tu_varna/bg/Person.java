package sit.tu_varna.bg;

public abstract class Person {
    private String firstName = null;
    private String middleName = null;
    private String lastName = null;
    private String faculty;

    //default getName() za vseki naslednik na Person
    public String getName(){
        String name="";
        if(firstName!=null)name+=firstName+" ";
        if(middleName!=null)name+=middleName+" ";
        if(lastName!=null)name+=lastName;
        return name;
    }

    //method setName() za zadavane na lichno i familno ime, i za zadavane na 3te imena
    public void setName(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }
    public void setName(String firstName, String middleName, String lastName){
    this.firstName=firstName;
    this.middleName=middleName;
    this.lastName=lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
