package homeaway.Exeptions;

public class StudentIsThriftyException extends RuntimeException {
  private static final String message = " is thrifty!";
  public StudentIsThriftyException(String name) {
    super(name + message);
  }
}
