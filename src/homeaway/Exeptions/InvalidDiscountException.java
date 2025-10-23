package homeaway.Exeptions;

public class InvalidDiscountException extends RuntimeException {
    private static final String message = "Invalid discount price!";
    public InvalidDiscountException() {
        super(message);
    }
}
