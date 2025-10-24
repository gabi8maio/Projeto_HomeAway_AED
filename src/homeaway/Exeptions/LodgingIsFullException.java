package homeaway.Exeptions;

public class LodgingIsFullException extends RuntimeException {
    private static final String message = "lodging % is full!\n";
    public LodgingIsFullException() {
        super(message);
    }
}
