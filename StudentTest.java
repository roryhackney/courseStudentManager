import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class StudentTest {
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

    //check not null, not empty, not whitespace, not start with Student@/default
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
                () -> new Student("  ", "X", "X", "X", "X"));
    }

    @Test
    void test_constructorNullEmptyLastName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("X", null, "X", "X", "X"));
        assertThrows(IllegalArgumentException.class,
                () -> new Student("X", "  ", "X", "X", "X"));
    }

    @Test
    void test_constructorNullEmptyFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("X", "X", null, "X", "X"));
        assertThrows(IllegalArgumentException.class,
                () -> new Student("X", "X", "  ", "X", "X"));
    }

    @Test
    void test_constructorNullEmptyEmail() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("X", "X", "X", null, "X"));
        assertThrows(IllegalArgumentException.class,
                () -> new Student("X", "X", "X", "  ", "X"));
    }

    @Test
    void test_constructorNullEmptyPhone() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("X", "X", "X", "X", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Student("X", "X", "X", "X", "  "));
    }

    @Test
    void test_compareTo() {
        Student bobby = new Student("654321", "Angler", "Bobby", "Y", "Z");
        Student alice = new Student("123456", "Xavier", "Alice", "X", "Y");
        assertTrue(bobby.compareTo(alice) < 0);
        assertTrue(alice.compareTo(bobby) > 0);
        assertEquals(0, bobby.compareTo(bobby));
        Student kevin = new Student("654321", "Angler", "Kevin", "A", "B");
        assertTrue(bobby.compareTo(kevin) < 0);
        assertTrue(kevin.compareTo(bobby) > 0);
        Student bobby2 = new Student("234561", "Angler", "Bobby", "Y", "Z");
        assertTrue(bobby.compareTo(bobby2) > 0);
        Student bobby3 = new Student("654321", "Angler", "Bobby", "Z", "A");
        assertEquals(0, bobby.compareTo(bobby3));
    }

    @Test
    void test_equals() {

    }
}