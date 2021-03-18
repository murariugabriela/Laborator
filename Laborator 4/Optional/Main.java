package faker;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<Student> students = IntStream.rangeClosed(0, 3).mapToObj(i -> new Student()).collect(Collectors.toList());
        Faker faker = new Faker();
        students.get(0).setName(faker.name().fullName());
        students.get(0).setExamGrade(6);
        students.get(1).setName(faker.name().fullName());
        students.get(0).setExamGrade(7);
        students.get(2).setName(faker.name().fullName());
        students.get(0).setExamGrade(10);
        students.get(3).setName(faker.name().fullName());
        students.get(0).setExamGrade(8);
        List<School> schools = IntStream.rangeClosed(0, 2).mapToObj(i -> new School("School" + i, (int) (Math.random() * 2 + 1))).collect(Collectors.toList());
        schools.get(0).setName("School 3");
        System.out.println(schools.get(0).getCapacity());
        schools.get(1).setName("School 2");
        System.out.println(schools.get(1).getCapacity());
        schools.get(2).setName("School 1");
        System.out.println(schools.get(2).getCapacity());
        List<Student> studentList = new LinkedList<>(students);
        Set<School> schoolSet = new TreeSet<>(schools);
        for (School s : schoolSet) {
            System.out.println(s.getName());
        }
        studentList.sort(new GradeComparator());
        for (Student s : studentList) {
            System.out.println(s.getName());
        }
        Map<Student, List<School>> studentsPreferences = new HashMap<>();
        studentsPreferences.put(students.get(0), Arrays.asList(schools.get(0), schools.get(2), schools.get(1)));
        students.get(0).setPreferences(studentsPreferences.get(students.get(0)));
        studentsPreferences.put(students.get(1), Arrays.asList(schools.get(1), schools.get(2), schools.get(0)));
        students.get(1).setPreferences(studentsPreferences.get(students.get(1)));
        studentsPreferences.put(students.get(2), Arrays.asList(schools.get(2), schools.get(1),schools.get(0)));
        students.get(2).setPreferences(studentsPreferences.get(students.get(2)));
        studentsPreferences.put(students.get(3), Arrays.asList(schools.get(1), schools.get(0), schools.get(2)));
        students.get(3).setPreferences(studentsPreferences.get(students.get(3)));
        Map<School, List<Student>> schoolsPreferences = new HashMap<>();
        schoolsPreferences.put(schools.get(0), studentList);
        schoolsPreferences.put(schools.get(1), studentList);
        schoolsPreferences.put(schools.get(2), studentList);
        System.out.println("Studentii cu preferintele lor:");
        for (Map.Entry<Student, List<School>> entry : studentsPreferences.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
        System.out.println("Scolile cu preferintele lor:");
        for (Map.Entry<School, List<Student>> entry : schoolsPreferences.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }

        Solution solution = new Solution();
        solution.studentsWhoAcceptSchools(students, schools, studentsPreferences);
        solution.schoolsWhichAcceptStudents(students, schools, schoolsPreferences);
        solution.organizeStudentsAtSchools(studentList, schools);
    }

}
