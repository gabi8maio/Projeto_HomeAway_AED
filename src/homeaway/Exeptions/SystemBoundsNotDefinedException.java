package homeaway.Exeptions;

import java.io.Serializable;

public class SystemBoundsNotDefinedException extends RuntimeException implements Serializable {
    private static final String message = "System bounds not defined.";
    public SystemBoundsNotDefinedException() {
        super(message);
    }
}
