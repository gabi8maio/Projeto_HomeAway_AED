package homeaway.Exeptions;

import java.io.Serializable;

public class LodgingNotExistsException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;
    private static final String message = " does not exist!";
    public LodgingNotExistsException(String serviceName) {
        super("lodging " + serviceName + message);
    }
}
