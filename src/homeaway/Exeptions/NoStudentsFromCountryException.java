package homeaway.Exeptions;

public class NoStudentsFromCountryException extends RuntimeException {
    private static final String message = "No students from %s!\n";
    public NoStudentsFromCountryException() {
        super(message);
    }
}
