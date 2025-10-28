package homeaway.Exeptions;

public class NoTypeServicesException extends RuntimeException {
    private static final String message1 = "No ";
    private static final String message2 = " services!";
    public NoTypeServicesException(String type) {
        super(message1 + type + message2);
    }
}
