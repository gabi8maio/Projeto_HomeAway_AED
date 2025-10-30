package homeaway.Exeptions;

import java.io.Serializable;

public class NoServicesWithAverage extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 0L;
  private static final String message1 = "No ";
  private static final String message2 = " services with average!";
    public NoServicesWithAverage(String type) {
        super(message1 + type + message2);
    }
}
