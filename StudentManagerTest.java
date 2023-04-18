import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentManagerTest {

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //          HAPPY PATH TESTS
    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
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

    @Test
    void test_getStudentCount() {
        StudentManager sm = new StudentManager();
        assertEquals(24, sm.getStudentCount("CSC110a"));
        assertEquals(-1, sm.getStudentCount("doesn't exist"));
    }

    @Test
    void test_getStudent() {
        StudentManager sm = new StudentManager();
        Student stud = new Student("228229", "Bale", "Allianora",
                "abale0@cdbaby.com", "161-231-3382");
        assertTrue(stud.equals(sm.getStudent(0,0)));
    }

    @Test
    void test_getStudents() {
        StudentManager sm = new StudentManager();
        Student students[] = sm.getStudents(0);
        Student first = new Student("228229", "Bale", "Allianora",
                "abale0@cdbaby.com", "161-231-3382");
        Student last = new Student(152664, "Worge", "Fraser",
                "fworgea@dropbox.com", "924-641-3333");
        assertTrue(first.equals(students[0]));
        assertTrue(last.equals(students[students.length - 1]));
    }

    @Test
    void test_findStudentCourse() {
        StudentManager sm = new StudentManager();
        assertEquals(1, sm.findStudentCourse("147017"));
        assertEquals(-1, sm.findStudentCourse("nonexistent"));
    }

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //          EXCEPTION TESTS
    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    @Test
    void test_getStudentCountExceptions() {
        StudentManager sm = new StudentManager();
        assertThrows(IllegalArgumentException.class,
                () -> sm.getStudentCount(-1));
        assertThrows(IllegalArgumentException.class,
                () -> sm.getStudentCount(15));
    }
}