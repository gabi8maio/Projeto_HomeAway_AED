package homeaway.Exeptions;

public class InvalidBoundsException extends RuntimeException {
    private static final String message = "Invalid bounds.";
    public InvalidBoundsException() {
        super(message);
    }
}
