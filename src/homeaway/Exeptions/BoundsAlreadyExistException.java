package homeaway.Exeptions;

import java.io.Serializable;

public class BoundsAlreadyExistException extends RuntimeException implements Serializable {

  private static final long serialVersionUID = 0L;

  /**
   * Exception used to print the error message when the
   */
  private static final String message = "Bounds already exists. Please load it!";
  public BoundsAlreadyExistException() {
    super(message);
  }
}
