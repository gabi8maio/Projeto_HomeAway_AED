package homeaway.Exeptions;

import java.io.Serializable;

public class OrderNotExistsException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;
    private static final String message = "This order does not exists!";
    public OrderNotExistsException() {
        super(message);
    }
}
