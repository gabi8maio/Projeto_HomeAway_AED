package homeaway.Exeptions;

import java.io.Serializable;

public class InvalidDiscountException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;
    private static final String message = "Invalid discount price!";
    public InvalidDiscountException() {
        super(message);
    }
}
