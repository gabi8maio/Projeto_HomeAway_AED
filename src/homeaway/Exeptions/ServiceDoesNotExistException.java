package homeaway.Exeptions;

import java.io.Serializable;

public class ServiceDoesNotExistException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;
    private static final String message = " does not exist!";
    public ServiceDoesNotExistException(String serviceName) {
        super(serviceName + message);
    }
}
