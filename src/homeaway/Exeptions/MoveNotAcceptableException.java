package homeaway.Exeptions;

public class MoveNotAcceptableException extends RuntimeException {
    private static final String message = "Move is not acceptable for ";
    private static final String message2 = "!";
    public MoveNotAcceptableException(String studentName) {
        super(message + studentName + message2);
    }
}
