package homeaway.Exeptions;

import java.io.Serializable;

public class StudentIsThriftyException extends RuntimeException implements Serializable {
  private static final long serialVersionUID = 0L;
  private static final String message = " is thrifty!";
  public StudentIsThriftyException(String name) {
    super(name + message);
  }
}
