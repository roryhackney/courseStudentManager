import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the StudentManager class
 */
class StudentManagerTest {

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //          HAPPY PATH TESTS
    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    /**
     * Tests the constructor and simple related get methods
     */
    @Test
    void test_constructorAndGets() {
        StudentManager sm = new StudentManager();
        //bad file check - change file names manually in SM constructor or delete files to check these
        //assertEquals(0, sm.getCourseCount());
        //assertEquals(0, sm.getStudentCount());

        //should actually pass these
        assertEquals(15, sm.getCourseCount());
        assertEquals(24, sm.getStudentCount(0));
        assertEquals(403, sm.getStudentCount());
        assertEquals("CSC110a", sm.getCourseName(0));
    }

    /**
     * Tests getStudentCount()
     */
    @Test
    void test_getStudentCount() {
        StudentManager sm = new StudentManager();
        assertEquals(24, sm.getStudentCount("CSC110a"));
        assertEquals(-1, sm.getStudentCount("doesn't exist"));
    }

    /**
     * Tests getStudent()
     */
    @Test
    void test_getStudent() {
        StudentManager sm = new StudentManager();
        Student stud = new Student("131126", "Amer", "Sauncho",
                "samerj@miitbeian.gov.cn", "387-514-1547");
        assertEquals(stud, sm.getStudent(0, 0));
    }

    /**
     * Tests getStudents()
     */
    @Test
    void test_getStudents() {
        StudentManager sm = new StudentManager();
        Student[] students = sm.getStudents(0);
        Student first = new Student("131126", "Amer", "Sauncho",
                "samerj@miitbeian.gov.cn", "387-514-1547");
        Student last = new Student("152664", "Worge", "Fraser",
                "fworgea@dropbox.com", "924-641-3333");
        assertEquals(first, students[0]);
        assertEquals(last, students[students.length - 1]);
    }

    /**
     * Tests findStudentCourse
     */
    @Test
    void test_findStudentCourse() {
        StudentManager sm = new StudentManager();
        assertEquals(1, sm.findStudentCourse("147017"));
        assertEquals(-1, sm.findStudentCourse("nonexistent"));
    }

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //          EXCEPTION TESTS
    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    /**
     * Tests appropriate exceptions are thrown and null/blank are handled
     */
    @Test
    void test_getStudentCountExceptions() {
        StudentManager sm = new StudentManager();
        //int arg overload
        assertThrows(IllegalArgumentException.class,
                () -> sm.getStudentCount(-1));
        assertThrows(IllegalArgumentException.class,
                () -> sm.getStudentCount(15));

        //String arg overload
        assertEquals(-1, sm.getStudentCount(null));
        assertEquals(-1, sm.getStudentCount(""));
    }

    /**
     * tests exceptions are thrown for invalid indexes
     */
    @Test
    void test_getCourseNameExceptions() {
        StudentManager sm = new StudentManager();
        assertThrows(IllegalArgumentException.class,
                () -> sm.getCourseName(-1));
        assertThrows(IllegalArgumentException.class,
                () -> sm.getCourseName(15));
    }

    /**
     * Tests exceptions are thrown for invalid indexes
     */
    @Test
    void test_getStudentExceptions() {
        StudentManager sm = new StudentManager();
        //courseIndex checks
        assertThrows(IllegalArgumentException.class,
                () -> sm.getStudent(-1, 5));
        assertThrows(IllegalArgumentException.class,
                () -> sm.getStudent(15, 5));

        //studentIndex checks
        assertThrows(IllegalArgumentException.class,
                () -> sm.getStudent(5, -1));
        assertThrows(IllegalArgumentException.class,
                () -> sm.getStudent(5, sm.getStudents(5).length));
    }

    /**
     * Tests thrown exceptions for out of range indexes
     */
    @Test
    void test_getStudentsExceptions() {
        StudentManager sm = new StudentManager();
        assertThrows(IllegalArgumentException.class,
                () -> sm.getStudents(-1));
        assertThrows(IllegalArgumentException.class,
                () -> sm.getStudents(15));
    }

    /**
     * Tests null and blank values are handled
     */
    @Test
    void test_findStudentCourseExceptions() {
        StudentManager sm = new StudentManager();
        assertEquals(-1, sm.findStudentCourse(null));
        assertEquals(-1, sm.findStudentCourse(""));

    }
}