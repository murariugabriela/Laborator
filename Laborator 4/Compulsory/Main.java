package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<Student> students = IntStream.rangeClosed(0, 3).mapToObj(i -> new Student("S" + i)).collect(Collectors.toList());
        students.get(0).setName("Student a");
        students.get(1).setName("Student d");
        students.get(2).setName("Student c");
        students.get(3).setName("Student a2");
        List<School> schools = IntStream.rangeClosed(0, 2).mapToObj(i -> new School("School" + i, (int) (Math.random() * 4))).collect(Collectors.toList());
        schools.get(0).setName("School 3");
        schools.get(1).setName("School 2");
        schools.get(2).setName("School 1");
        List<Student> studentList = new LinkedList<>(students);
        Set<School> schoolSet = new TreeSet<>(schools);
        for (School s : schoolSet) {
            System.out.println(s.getName());
        }
        studentList.sort(new LexicographicComparator());
        for (Student s : studentList) {
            System.out.println(s.getName());
        }
        Map<Student, List<School>> studentsPreferences = new HashMap<>();
        studentsPreferences.put(students.get(0), Arrays.asList(schools.get(0), schools.get(2), schools.get(1)));
        studentsPreferences.put(students.get(1), Arrays.asList(schools.get(1), schools.get(2)));
        studentsPreferences.put(students.get(2), Arrays.asList(schools.get(2), schools.get(1)));
        studentsPreferences.put(students.get(2), Arrays.asList(schools.get(1), schools.get(0), schools.get(2)));
        Map<School, List<Student>> schoolsPreferences = new HashMap<>();
        schoolsPreferences.put(schools.get(0), Arrays.asList(students.get(0), students.get(2), students.get(3)));
        schoolsPreferences.put(schools.get(1), Arrays.asList(students.get(1), students.get(3), students.get(0)));
        schoolsPreferences.put(schools.get(2), Arrays.asList(students.get(2), students.get(0)));
        System.out.println("Studentii cu preferintele lor:");
        for (Map.Entry<Student, List<School>> entry : studentsPreferences.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
        System.out.println("Scolile cu preferintele lor:");
        for (Map.Entry<School, List<Student>> entry : schoolsPreferences.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }

}
