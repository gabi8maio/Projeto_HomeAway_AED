package homeaway.Exeptions;

public class StudentHomeException extends RuntimeException {
    private static final String message = "That is %s's home!";
    public StudentHomeException() {
        super(message);
    }
}
