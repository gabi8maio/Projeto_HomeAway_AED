package homeaway.Exeptions;

public class NoServicesInSystemException extends RuntimeException {
    private static final String message = "No services in the system.";
    public NoServicesInSystemException() {
        super(message);
    }
}
