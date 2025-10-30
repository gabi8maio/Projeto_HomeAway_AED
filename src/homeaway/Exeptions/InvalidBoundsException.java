package homeaway.Exeptions;

import java.io.Serializable;

public class InvalidBoundsException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 0L;

    private static final String message = "Invalid bounds.";
    public InvalidBoundsException() {
        super(message);
    }
}
