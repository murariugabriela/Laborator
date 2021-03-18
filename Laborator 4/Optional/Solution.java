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
            List<Pair<Student,Optional>> studentSchoolPairList = new ArrayList<>();
            int suma=0;
        for (School school : schools) {
            suma+=school.getCapacity();
            }
        if(suma<studentOrderedList.size()) {
            System.err.println("Problema nu are solutie");
        } else {
            studentOrderedList.forEach(student -> studentSchoolPairList.add(new Pair(student, student.getPreferences().stream().filter(school -> school.getCapacity() > 0).findFirst())));
            for (Pair<Student, Optional> studentSchoolPair : studentSchoolPairList) {
                System.out.println(studentSchoolPair.getKey().toString() + " " + studentSchoolPair.getValue().toString().substring(studentSchoolPair.getValue().toString().indexOf('[') + 1,studentSchoolPair.getValue().toString().indexOf(']')));
            }
        }
    }
}
