package homeaway.Exeptions;

public class ServiceAlreadyExistsException extends RuntimeException {
    private static final String message = " already exists!\n";
    public ServiceAlreadyExistsException(String serviceName) {
        super(serviceName+message);
    }
}
