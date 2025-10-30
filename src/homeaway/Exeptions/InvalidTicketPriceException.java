package homeaway.Exeptions;

import java.io.Serializable;

public class InvalidTicketPriceException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;
    private static final String message = "Invalid ticket price!";
    public InvalidTicketPriceException() {
        super(message);
    }
}
