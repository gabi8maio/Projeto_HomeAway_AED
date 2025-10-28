package homeaway.Exeptions;

public class StudentDoesNotExistsException extends RuntimeException {
    private static final String message = " does not exist!";
    public StudentDoesNotExistsException(String studentName) {
        super(studentName + message);
    }
}
