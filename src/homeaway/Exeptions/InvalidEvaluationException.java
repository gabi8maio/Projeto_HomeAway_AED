package homeaway.Exeptions;

public class InvalidEvaluationException extends RuntimeException {
    private static final String message = "Invalid evaluation!";
    public InvalidEvaluationException() {
        super(message);
    }
}
