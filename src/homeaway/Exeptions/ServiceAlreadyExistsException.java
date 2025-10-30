package homeaway.Exeptions;

import java.io.Serializable;

public class ServiceAlreadyExistsException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;
    private static final String message = " already exists!\n";
    public ServiceAlreadyExistsException(String serviceName) {
        super(serviceName+message);
    }
}
