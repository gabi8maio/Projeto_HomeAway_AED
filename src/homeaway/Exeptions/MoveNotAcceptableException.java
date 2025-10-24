package homeaway.Exeptions;

public class MoveNotAcceptableException extends RuntimeException {
    private static final String message = "Move is not acceptable for %s!";
    public MoveNotAcceptableException() {
        super(message);
    }
}
