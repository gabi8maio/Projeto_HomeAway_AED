package homeaway.Exeptions;

public class StudentDoesNotExistsException extends RuntimeException {
    private static final String message = " does not exist!\n";
    public StudentDoesNotExistsException(String studentName) {
        super(studentName + message);
    }
}
