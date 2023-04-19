import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.awt.*;

/**
 * Tests for Student class
 */
class StudentTest {
    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //          HAPPY PATH TESTS
    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    /**
     * Checks constructor creates Student and get methods return correct data
     */
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

    /**
     * Checks not null, not empty, not whitespace, does not start with Student@/default
     */
    @Test
    void test_toString() {
        Student student = new Student("123456", "Stone", "Ashley", "astone@college.edu",
                "123-456-7890");
        assertFalse(student.toString().isBlank());
        assertNotEquals("Student@", student.toString().substring(0, 8));
    }
    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //          EXCEPTION TESTS
    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    /**
     * Checks null or empty id throws exception
     */
    @Test
    void test_constructorNullEmptyId() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student(null, "X", "X", "X", "X"));
        assertThrows(IllegalArgumentException.class,
                () -> new Student("  ", "X", "X", "X", "X"));
    }

    /**
     * Checks null or empty lastName throws exception
     */
    @Test
    void test_constructorNullEmptyLastName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("X", null, "X", "X", "X"));
        assertThrows(IllegalArgumentException.class,
                () -> new Student("X", "  ", "X", "X", "X"));
    }

    /**
     * Checks null or empty firstName throws exception
     */
    @Test
    void test_constructorNullEmptyFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("X", "X", null, "X", "X"));
        assertThrows(IllegalArgumentException.class,
                () -> new Student("X", "X", "  ", "X", "X"));
    }

    /**
     * Checks null or empty email throws exception
     */
    @Test
    void test_constructorNullEmptyEmail() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("X", "X", "X", null, "X"));
        assertThrows(IllegalArgumentException.class,
                () -> new Student("X", "X", "X", "  ", "X"));
    }

    /**
     * Checks null or empty phone throws exception
     */
    @Test
    void test_constructorNullEmptyPhone() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("X", "X", "X", "X", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Student("X", "X", "X", "X", "  "));
    }

    /**
     * Checks comparisons return appropriate relationships
     */
    @Test
    void test_compareTo() {
        Student bobby = new Student("654321", "Angler", "Bobby", "Y", "Z");
        Student alice = new Student("123456", "Xavier", "Alice", "X", "Y");
        Student b = bobby;
        assertTrue(bobby.compareTo(alice) < 0);
        assertTrue(alice.compareTo(bobby) > 0);
        assertEquals(0, bobby.compareTo(b));
        Student anna = new Student("234561", "Angler", "Anna", "Y", "Z");
        assertEquals(0, bobby.compareTo(anna));
    }

    /**
     * Checks Students are equal with same last name, else not equal
     */
    @Test
    void test_equals() {
        Student bobby = new Student("654321", "Angler", "Bobby", "Y", "Z");
        Student alice = new Student("123456", "Xavier", "Alice", "X", "Y");
        Student b = bobby;
        Student anna = new Student("234561", "Angler", "Anna", "Y", "Z");
        assertNotEquals(bobby, alice);
        assertEquals(bobby, b);
        assertNotEquals(null, bobby);
        assertNotEquals(bobby, new Point());
        assertEquals(bobby, anna);
    }
}