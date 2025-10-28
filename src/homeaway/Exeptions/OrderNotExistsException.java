package homeaway.Exeptions;

public class OrderNotExistsException extends RuntimeException {
    private static final String message = "This order does not exists!";
    public OrderNotExistsException() {
        super(message);
    }
}
