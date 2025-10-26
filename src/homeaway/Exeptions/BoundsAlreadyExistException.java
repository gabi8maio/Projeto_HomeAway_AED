package homeaway.Exeptions;

public class BoundsAlreadyExistException extends RuntimeException {
  private static final String message = "Bounds already exists. Please load it!";
  public BoundsAlreadyExistException() {
    super(message);
  }
}
