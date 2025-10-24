package homeaway.Exeptions;

public class StudentAlreadyExistsException extends RuntimeException {
    private static final String message = "%s already exists!\n";
    public StudentAlreadyExistsException() {
        super(message);
    }
}
