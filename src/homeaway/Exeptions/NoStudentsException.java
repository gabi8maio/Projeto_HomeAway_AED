package homeaway.Exeptions;

import java.io.Serializable;

public class NoStudentsException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;
    private static final String message = "No students yet!";
    public NoStudentsException() {
        super(message);
    }
}
