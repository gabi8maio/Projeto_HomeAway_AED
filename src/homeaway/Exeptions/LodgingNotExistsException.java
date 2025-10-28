package homeaway.Exeptions;

public class LodgingNotExistsException extends RuntimeException {
    private static final String message = " does not exist!";
    public LodgingNotExistsException(String serviceName) {
        super("lodging " + serviceName + message);
    }
}
