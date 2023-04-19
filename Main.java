import java.util.Arrays;

/**
 * Demonstrates capability of StudentManager
 */
public class Main {
    /**
     * Demonstrates capability of StudentManager
     * @param args command line arguments
     */
    public static void main(String[] args) {
        StudentManager mgr = new StudentManager();
        Student[] students = mgr.getStudents(0);
        System.out.println(students[0]);
        System.out.println(students[students.length - 1]);

        System.out.printf("There are a total of %s students in %s classes.\n",
                mgr.getStudentCount(), mgr.getCourseCount());
        System.out.printf("In %s, there are %s students.\n",
                mgr.getCourseName(4), mgr.getStudentCount(4));
        Student[] enrolled = mgr.getStudents(7);
        System.out.printf("Check attendance for these students in %s:\n", mgr.getCourseName(7));
        for (Student student : enrolled) {
            System.out.print(student.lastName() + ", " + student.firstName() + "\n");
        }
    }
}
