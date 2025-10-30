package homeaway.Exeptions;

import java.io.Serializable;

public class StudentDoesNotExistsException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;
    private static final String message = " does not exist!";
    public StudentDoesNotExistsException(String studentName) {
        super(studentName + message);
    }
}
