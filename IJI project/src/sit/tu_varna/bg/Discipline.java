package sit.tu_varna.bg;

import java.util.ArrayList;
import java.util.List;

public class Discipline {
    private String disciplineName;
    private boolean isMandatory;

    public boolean isMandatory() {
        return isMandatory;
    }

    public void setMandatory(boolean mandatory) {
        isMandatory = mandatory;
    }

    public Discipline(String disciplineName, boolean isMandatory) {
        this.disciplineName = disciplineName;
        this.isMandatory = isMandatory;
    }

    public String getDisciplineName() {return disciplineName;}

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }
}