package homeaway.Exeptions;

public class StudentHomeException extends RuntimeException {
    private static final String message = "That is ";
    private static final String message2 = "'s home!";
    public StudentHomeException(String studentName) {
        super(message + studentName + message2);
    }
}
