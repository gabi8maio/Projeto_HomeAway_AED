package homeaway.Exeptions;

public class LodgingNotExistsException extends RuntimeException {
    private static final String message = "lodging %s does not exist!\n";
    public LodgingNotExistsException() {
        super(message);
    }
}
