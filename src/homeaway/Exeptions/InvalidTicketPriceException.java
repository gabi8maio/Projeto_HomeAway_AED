package homeaway.Exeptions;

public class InvalidTicketPriceException extends RuntimeException {
    private static final String message = "Invalid ticket price!";
    public InvalidTicketPriceException() {
        super(message);
    }
}
