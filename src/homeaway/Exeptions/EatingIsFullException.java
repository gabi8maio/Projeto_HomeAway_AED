package homeaway.Exeptions;

public class EatingIsFullException extends RuntimeException {
    private static final String message = "eating %s is full!\n";
    public EatingIsFullException() {
        super(message);
    }
}
