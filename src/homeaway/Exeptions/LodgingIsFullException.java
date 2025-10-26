package homeaway.Exeptions;

public class LodgingIsFullException extends RuntimeException {
    private static final String message = " is full!\n";
    public LodgingIsFullException(String serviceName) {
        super("lodging " + serviceName + message);
    }
}
