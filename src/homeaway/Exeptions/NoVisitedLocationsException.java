package homeaway.Exeptions;

public class NoVisitedLocationsException extends RuntimeException {
    private static final String message = " has not visited any locations!";
    public NoVisitedLocationsException(String studentName) {
        super(studentName + message);
    }
}
