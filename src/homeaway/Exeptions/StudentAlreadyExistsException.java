package homeaway.Exeptions;

import java.io.Serializable;

public class StudentAlreadyExistsException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;
    private static final String message = " already exists!";
    public StudentAlreadyExistsException(String studentName) {
        super(studentName + message);
    }
}
