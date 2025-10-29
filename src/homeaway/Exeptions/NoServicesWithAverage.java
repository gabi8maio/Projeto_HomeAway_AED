package homeaway.Exeptions;

public class NoServicesWithAverage extends RuntimeException {
  private static final String message1 = "No ";
  private static final String message2 = " services with average! ";
    public NoServicesWithAverage(String type) {
        super(message1 + type + message2);
    }
}
