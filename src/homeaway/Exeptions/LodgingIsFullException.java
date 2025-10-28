package homeaway.Exeptions;

public class LodgingIsFullException extends RuntimeException {
    private static final String message = " is full!";
    public LodgingIsFullException(String serviceName) {
        super("lodging " + serviceName + message);
    }
}
