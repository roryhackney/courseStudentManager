/**
 * Manages student data
 * @param id    id number assigned to the student, must not be null or blank
 * @param lastName last name, must not be null or blank
 * @param firstName first name, must not be null or blank
 * @param email email contact, must not be null or blank
 * @param phone phone number contact, must not be null or blank
 */
public record Student(String id, String lastName, String firstName, String email, String phone) implements Comparable<Student> {
    @Override
    public int compareTo(Student o) {
        return 0;
    }
}