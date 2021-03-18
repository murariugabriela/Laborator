package faker;

import javafx.util.Pair;

import java.util.*;

public class Solution {
    public void studentsWhoAcceptSchools(List<Student> studentList, List<School> schoolList, Map<Student, List<School>> studentsPreferences) {
        try {
            studentList.stream()
                    .filter(std -> studentsPreferences.get(std).containsAll(Arrays.asList(schoolList.get(0), schoolList.get(2))))
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void schoolsWhichAcceptStudents(List<Student> studentList, List<School> schoolList, Map<School, List<Student>> schoolsPreferences) {
        try {
            schoolList.stream()
                    .filter(school -> schoolsPreferences.get(school).containsAll(Arrays.asList(studentList.get(0), studentList.get(2), studentList.get(3))))
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void organizeStudentsAtSchools(List<Student> studentOrderedList, List<School> schools) {
        List<Pair<Student, School>> studentSchoolPairList = new ArrayList<>();
        int suma = 0;
        for (School school : schools) {
            suma += school.getCapacity();
        }
        if (suma < studentOrderedList.size()) {
            System.err.println("Problema nu are solutie");
        } else {
            int i = 0;
            for (Student student : studentOrderedList) {

                for(School school : student.getPreferences())
                {
                    if(school.getCapacity()>0)
                    {
                        studentSchoolPairList.add(new Pair(student, school));
                        school.setCapacity(school.getCapacity() - 1);
                        break;
                    }
                }

            }
            for (Pair<Student, School> studentSchoolPair : studentSchoolPairList) {
                System.out.println(studentSchoolPair.getKey().toString() + " " + studentSchoolPair.getValue().toString());
            }
        }
    }
}
