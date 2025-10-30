package homeaway.Exeptions;

import java.io.Serializable;

public class BoundsDoesNotExistException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 0L;

    private static final String message = "Bounds %s does not exists.\n";
    public BoundsDoesNotExistException() {
        super(message);
    }
}
