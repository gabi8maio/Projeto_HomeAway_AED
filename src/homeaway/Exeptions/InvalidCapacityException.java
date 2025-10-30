package homeaway.Exeptions;

import java.io.Serializable;

public class InvalidCapacityException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 0L;
    private static final String message = "Invalid capacity!";
    public InvalidCapacityException() {
        super(message);
    }
}
