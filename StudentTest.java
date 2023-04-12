import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class StudentTest {

    //check not null, not empty, not whitespace, not start with Student@/default

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //          HAPPY PATH TESTS
    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    @Test
    void test_constructorAndGets() {
        Student student = new Student("123456", "Stone", "Ashley", "astone@college.edu",
                "123-456-7890");
        assertEquals("123456", student.id());
        assertEquals("Stone", student.lastName());
        assertEquals("Ashley", student.firstName());
        assertEquals("astone@college.edu", student.email());
        assertEquals("123-456-7890", student.phone());
    }
    @Test
    void test_toString() {
        Student student = new Student("123456", "Stone", "Ashley", "astone@college.edu",
                "123-456-7890");
        assertFalse(student.toString().isBlank());
        assertNotEquals("Student@", student.toString().substring(0, 8));

    }
    // =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //          EXCEPTION TESTS
    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    @Test
    void test_constructorNullEmptyId() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student(null, "X", "X", "X", "X"));
        assertThrows(IllegalArgumentException.class,
                () -> new Student("",   "X", "X", "X", "X"));
    }
}