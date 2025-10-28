package homeaway.Exeptions;

public class StudentAlreadyExistsException extends RuntimeException {
    private static final String message = " already exists!";
    public StudentAlreadyExistsException(String studentName) {
        super(studentName + message);
    }
}
