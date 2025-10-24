package homeaway.Exeptions;

public class UnknownLocationException extends RuntimeException {
    private static final String message = "Unknown %";
    public UnknownLocationException() {
        super(message);
    }
}
