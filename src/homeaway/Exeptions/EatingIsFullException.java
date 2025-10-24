package homeaway.Exeptions;

public class EatingIsFullException extends RuntimeException {
    private static final String message = "eating %s is full!";
    public EatingIsFullException() {
        super(message);
    }
}
