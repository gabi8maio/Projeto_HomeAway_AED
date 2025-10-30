package homeaway.Exeptions;

import java.io.Serializable;

public class EatingIsFullException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 0L;

    private static final String message = "eating %s is full!\n";
    public EatingIsFullException() {
        super(message);
    }
}
