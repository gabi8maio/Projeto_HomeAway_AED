package homeaway.Exeptions;

import java.io.Serializable;

public class InvalidEvaluationException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;
    private static final String message = "Invalid evaluation!";
    public InvalidEvaluationException() {
        super(message);
    }
}
