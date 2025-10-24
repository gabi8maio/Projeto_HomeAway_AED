package homeaway.Exeptions;

public class InvalidServiceException extends RuntimeException {
    private static final String message = "%s is not a valid service!";
    public InvalidServiceException() {
        super(message);
    }
}
