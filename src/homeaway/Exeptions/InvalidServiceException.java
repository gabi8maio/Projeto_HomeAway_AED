package homeaway.Exeptions;

public class InvalidServiceException extends RuntimeException {
    private static final String message = " is not a valid service!";
    public InvalidServiceException(String serviceName) {
        super(serviceName + message);
    }
}
