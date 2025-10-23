package homeaway.Exeptions;

public class InvalidServiceTypeException extends RuntimeException {
    private static final String message = "Invalid service type!";
    public InvalidServiceTypeException() {
        super(message);
    }
}
