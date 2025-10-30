package homeaway.Exeptions;

import java.io.Serializable;

public class InvalidLocationException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;
    private static final String message = "Invalid location!";
    public InvalidLocationException() {
        super(message);
    }
}
