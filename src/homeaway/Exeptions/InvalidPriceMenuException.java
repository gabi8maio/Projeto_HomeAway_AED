package homeaway.Exeptions;

public class InvalidPriceMenuException extends RuntimeException {
    private static final String message = "Invalid menu price!";
    public InvalidPriceMenuException() {
        super(message);
    }
}
