/**
 * Represents a single student in a course
 * @author    Rory Hackney
 * @version   4/13/2023
 * @param id        id number assigned to the student; must not be null or blank
 * @param lastName  last name; must not be null or blank
 * @param firstName first name; must not be null or blank
 * @param email     email contact; must not be null or blank
 * @param phone     phone number contact; must not be null or blank
 */
public record Student(String id, String lastName, String firstName, String email, String phone) implements Comparable<Student> {
    /**
     * Constructor
     * @param id        id number assigned to the student; must not be null or blank
     * @param lastName  last name; must not be null or blank
     * @param firstName first name; must not be null or blank
     * @param email     email contact; must not be null or blank
     * @param phone     phone number contact; must not be null or blank
     */
    public Student {
        Utility.verifyNotNullOrBlank("id", id);
        Utility.verifyNotNullOrBlank("lastName", lastName);
        Utility.verifyNotNullOrBlank("firstName", firstName);
        Utility.verifyNotNullOrBlank("email", email);
        Utility.verifyNotNullOrBlank("phone", phone);
    }

    /**
     * Compares two Students by lastName for ordering. Same name means same Student.
     * @param other the Student to be compared.
     * @return  negative if this less than other, positive if greater than, or zero if equal
     */
    @Override
    public int compareTo(Student other) {
        return lastName.compareTo(other.lastName);
    }

    /**
     * Checks if two Students are equal. Same lastName means same Student.
     * @param other   the Student to be compared.
     * @return  true if lastNames are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Student)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        return this.compareTo((Student)other) == 0;
    }
}