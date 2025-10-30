package homeaway.Exeptions;

import java.io.Serializable;

public class NoStudentsFromCountryException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;
    private static final String message = "No students from %s!\n";
    public NoStudentsFromCountryException() {
        super(message);
    }
}
