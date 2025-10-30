package homeaway.Exeptions;

import java.io.Serializable;

public class StudentAlreadyThereException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;
    private static final String message = "Already there!";
    public StudentAlreadyThereException() {
        super(message);
    }
}
