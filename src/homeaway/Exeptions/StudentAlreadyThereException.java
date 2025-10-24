package homeaway.Exeptions;

public class StudentAlreadyThereException extends RuntimeException {
    private static final String message = "Already there!";
    public StudentAlreadyThereException() {
        super(message);
    }
}
