package homeaway.Exeptions;

import java.io.Serializable;

public class InvalidRoomPriceException extends RuntimeException implements Serializable {
  private static final long serialVersionUID = 0L;
  private static final String message = "Invalid room price!";
  public InvalidRoomPriceException() {
    super(message);
  }
}
