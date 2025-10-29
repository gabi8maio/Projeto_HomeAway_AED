package homeaway.Exeptions;

public class NoServicesWithTagException extends RuntimeException {
    private static final String message = "There are no services with this tag!";
    public NoServicesWithTagException() {
        super(message);
    }
}
