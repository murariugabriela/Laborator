package faker;

import java.util.Comparator;

class GradeComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        return s1.getExamGrade() < s2.getExamGrade() ? s2.getExamGrade() : s1.getExamGrade();
    }
}
