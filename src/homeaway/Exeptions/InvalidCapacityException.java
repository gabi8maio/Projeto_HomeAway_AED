package homeaway.Exeptions;

public class InvalidCapacityException extends RuntimeException {
    private static final String message = "Invalid capacity!";
    public InvalidCapacityException() {
        super(message);
    }
}
