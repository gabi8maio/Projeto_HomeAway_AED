package homeaway.Exeptions;

import java.io.Serializable;

public class NoVisitedLocationsException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;
    private static final String message = " has not visited any locations!";
    public NoVisitedLocationsException(String studentName) {
        super(studentName + message);
    }
}
