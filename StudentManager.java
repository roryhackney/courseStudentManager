import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//TODO: //remind me how to handle file input failure and which bits should be in the catch block
/**
 * Manages student and class data
 * @author Rory Hackney
 * @version 4/13/2023
 */
public class StudentManager implements StudentManagerInterface {
    String[] courseNames;
    Student[][] students;
    /**
     * Constructor, reads data from files and sets up arrays
     */
    public StudentManager() {
        File courseFile = new File("courses.csv");
        Scanner scanCourses = null;
        try {
            scanCourses = new Scanner(courseFile);
        } catch (FileNotFoundException e) {
            courseNames = new String[0];
            return;
        }
        scanCourses.close();

    }


}
