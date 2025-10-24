package homeaway.Exeptions;

public class NoStudentsException extends RuntimeException {
    private static final String message = "No students yet!";
    public NoStudentsException() {
        super(message);
    }
}
