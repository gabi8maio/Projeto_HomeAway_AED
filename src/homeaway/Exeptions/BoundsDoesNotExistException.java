package homeaway.Exeptions;

public class BoundsDoesNotExistException extends RuntimeException {
    private static final String message = "Bounds %s does not exists.\n";
    public BoundsDoesNotExistException() {
        super(message);
    }
}
