package homeaway.Exeptions;

public class NoStudentsOnServiceException extends RuntimeException {
    private static final String message1 = "No students on ";
    private static final String message2 = "!";
    public NoStudentsOnServiceException(String serviceName) {
        super(message1 + serviceName + message2);
    }
}
