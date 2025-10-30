package homeaway.Exeptions;

import java.io.Serializable;

public class InvalidPriceMenuException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;
    private static final String message = "Invalid menu price!";
    public InvalidPriceMenuException() {
        super(message);
    }
}
