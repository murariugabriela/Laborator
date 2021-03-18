package faker;


import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int examGrade;
    private List<School> preferences = new ArrayList<>();

    public void setExamGrade(int examGrade) {
        this.examGrade = examGrade;
    }

    public int getExamGrade() {
        return examGrade;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setPreferences(List<School> preferences) {
        this.preferences = preferences;
    }

    public List<School> getPreferences() {
        return preferences;
    }

    public void setName(String name) {
        this.name = name;
    }


}
