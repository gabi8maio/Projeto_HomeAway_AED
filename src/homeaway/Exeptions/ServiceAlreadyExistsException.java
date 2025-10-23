package homeaway.Exeptions;

public class ServiceAlreadyExistsException extends RuntimeException {
    private static final String message = "%s already exists";
    public ServiceAlreadyExistsException() {
        super(message);
    }
}
