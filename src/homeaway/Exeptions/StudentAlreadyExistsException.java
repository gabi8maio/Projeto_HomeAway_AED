package homeaway.Exeptions;

public class StudentAlreadyExistsException extends RuntimeException {
    private static final String message = " already exists!\n";
    public StudentAlreadyExistsException(String studentName) {
        super(studentName + message);
    }
}
