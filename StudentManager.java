import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Manages student and course enrollment data
 * @author Rory Hackney
 * @version 4/13/2023
 */
public class StudentManager implements StudentManagerInterface {
    /** Names of all the courses */
    private String[] courseNames;
    /** All enrolled students in each course, parallel with courseNames */
    private Student[][] students;

    /**
     * Constructor, reads course and student enrollment data from files.
     * If files not found, getCourseCount and getStudentCount return 0.
     */
    public StudentManager() {
        //if courseNames file not found exit with array length 0
        File courseFile = new File("src/Courses.csv");
        Scanner scanCourses;
        try {
            scanCourses = new Scanner(courseFile);
        } catch (FileNotFoundException e) {
            courseNames = new String[0];
            students = new Student[0][0];
            return;
        }

        //fill courseNames[] and set length of enrollment for each course
        courseNames = new String[scanCourses.nextInt()];
        scanCourses.nextLine();
        scanCourses.nextLine();
        students = new Student[courseNames.length][];
        for (int courseIdx = 0; courseIdx < courseNames.length; courseIdx++) {
            String[] line = scanCourses.nextLine().split(",");
            courseNames[courseIdx] = line[0];
            students[courseIdx] = new Student[Integer.parseInt(line[1])];
        }
        scanCourses.close();

        //if students file not found exit with array length 0
        File studentsFile = new File("src/Students.csv");
        Scanner scanStudents;
        try {
            scanStudents = new Scanner(studentsFile);
        } catch (FileNotFoundException e) {
            courseNames = new String[0];
            students = new Student[0][0];
            return;
        }

        //fill each course with students
        scanStudents.nextLine();
        for (int courseIdx = 0; courseIdx < students.length; courseIdx++) {
            for (int studIdx = 0; studIdx < students[courseIdx].length; studIdx++) {
                String[] line = scanStudents.nextLine().split(",");
                Student stud = new Student(line[1], line[2], line[3], line[4], line[5]);
                students[courseIdx][studIdx] = stud;
            }
            //sort each course's students
            Arrays.sort(students[courseIdx]);
        }
        scanStudents.close();
    }

    @Override
    public int getCourseCount() {
        return courseNames.length;
    }

    /**
     * @param courseIndex the index of the course; must be 0 through 14
     */
    @Override
    public int getStudentCount(int courseIndex) {
        Utility.verifyIndexInRange("courseIndex", courseIndex, getCourseCount() - 1);
        return students[courseIndex].length;
    }

    @Override
    public int getStudentCount() {
        int sum = 0;
        for (int courseIndex = 0; courseIndex < students.length; courseIndex++) {
            sum += students[courseIndex].length;
        }
        return sum;
    }

    @Override
    public int getStudentCount(String courseName) {
        for (int courseIdx = 0; courseIdx < students.length; courseIdx++) {
            if (courseNames[courseIdx].equals(courseName)) {
                return students[courseIdx].length;
            }
        }
        return -1;
    }

    @Override
    public String getCourseName(int courseIndex) {
        Utility.verifyIndexInRange("courseIndex", courseIndex, getCourseCount() - 1);
        return courseNames[courseIndex];
    }

    @Override
    public Student getStudent(int courseIndex, int studentIndex) {
        Utility.verifyIndexInRange("courseIndex", courseIndex, getCourseCount() - 1);
        Utility.verifyIndexInRange("studentIndex", studentIndex, students[courseIndex].length - 1);
        return students[courseIndex][studentIndex];
    }

    @Override
    public Student[] getStudents(int courseIndex) {
        Utility.verifyIndexInRange("courseIndex", courseIndex, getCourseCount() - 1);
        return students[courseIndex];
    }

    @Override
    public int findStudentCourse(String id) {
        for (int courseIdx = 0; courseIdx < students.length; courseIdx++) {
            for (int studIdx = 0; studIdx < students[courseIdx].length; studIdx++) {
                if (students[courseIdx][studIdx].id().equals(id)) {
                    return courseIdx;
                }
            }
        }
        return -1;
    }
}
