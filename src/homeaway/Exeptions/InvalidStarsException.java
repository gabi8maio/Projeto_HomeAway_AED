package homeaway.Exeptions;

import java.io.Serializable;

public class InvalidStarsException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;
  private static final String message = "Invalid stars!";
    public InvalidStarsException() {
        super(message);
    }
}
