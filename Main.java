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
        Student student = new Student("z","z","z","z","z");
        System.out.println(student);
        StudentManager mgr = new StudentManager();
        //print arrays
//        System.out.println(Arrays.toString(mgr.courseNames));
//        for (int index = 0; index < mgr.getCourseCount(); index++) {
//            System.out.println(Arrays.toString(mgr.getStudents(index)));
//        }

    }
}
