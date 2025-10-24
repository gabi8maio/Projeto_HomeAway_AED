package homeaway.Exeptions;

public class InvalidStudentTypeException extends RuntimeException {
    private static final String message = "Invalid student type!";
    public InvalidStudentTypeException() {
        super(message);
    }
}
