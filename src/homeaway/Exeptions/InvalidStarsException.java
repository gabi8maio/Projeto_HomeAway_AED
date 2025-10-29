package homeaway.Exeptions;

public class InvalidStarsException extends RuntimeException {
  private static final String message = "Invalid stars!";
    public InvalidStarsException() {
        super(message);
    }
}
