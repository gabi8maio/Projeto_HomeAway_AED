package homeaway.Exeptions;

public class InvalidRoomPriceException extends RuntimeException {
  private static final String message = "Invalid room price!";
  public InvalidRoomPriceException() {
    super(message);
  }
}
