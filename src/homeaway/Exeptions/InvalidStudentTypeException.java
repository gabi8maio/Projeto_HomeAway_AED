package homeaway.Exeptions;

import java.io.Serializable;

public class InvalidStudentTypeException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;
    private static final String message = "Invalid student type!";
    public InvalidStudentTypeException() {
        super(message);
    }
}
