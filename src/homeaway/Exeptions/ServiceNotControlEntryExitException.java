package homeaway.Exeptions;

public class ServiceNotControlEntryExitException extends RuntimeException {
    private static final String message = " does not control student entry and exit!";
    public ServiceNotControlEntryExitException(String serviceName) {
        super(serviceName + message);
    }
}
