package homeaway.Exeptions;

import java.io.Serializable;

public class UnknownLocationException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;
    private static final String message = "Unknown ";
    public UnknownLocationException(String serviceName) {
        super(message+serviceName + "!\n");
    }
}
