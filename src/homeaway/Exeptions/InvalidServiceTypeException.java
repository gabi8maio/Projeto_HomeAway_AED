package homeaway.Exeptions;

import java.io.Serializable;

public class InvalidServiceTypeException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;
    private static final String message = "Invalid service type!";
    public InvalidServiceTypeException() {
        super(message);
    }
}
