package homeaway.Exeptions;

public class InvalidLocationException extends RuntimeException {
    private static final String message = "Invalid location!";
    public InvalidLocationException() {
        super(message);
    }
}
