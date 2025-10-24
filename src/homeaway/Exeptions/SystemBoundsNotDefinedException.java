package homeaway.Exeptions;

public class SystemBoundsNotDefinedException extends RuntimeException {
    private static final String message = "Systemo bounds not defined.";
    public SystemBoundsNotDefinedException() {
        super(message);
    }
}
