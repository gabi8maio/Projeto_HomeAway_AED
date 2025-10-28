package homeaway.Exeptions;

public class ServiceDoesNotExistException extends RuntimeException {
    private static final String message = " does not exist!";
    public ServiceDoesNotExistException(String serviceName) {
        super(serviceName + message);
    }
}
