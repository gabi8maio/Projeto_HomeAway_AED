package homeaway.Exeptions;

public class StudentDoesNotExistsException extends RuntimeException {
    private static final String message = "%s does not exist!\n";
    public StudentDoesNotExistsException() {
        super(message);
    }
}
