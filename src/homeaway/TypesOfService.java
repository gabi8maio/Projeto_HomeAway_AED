package homeaway;

/**
 * Enum used to check if the type of service given by the user is a valid service type
 */
public enum TypesOfService {

    LODGING("LODGING"),
    EATING("EATING"),
    LEISURE("LEISURE");
    private final String typeName;

    private static final long serialVersionUID = 0L;

    TypesOfService(String typeName) {

        this.typeName = typeName;
    }

    /**
     * @return - The type given ate the constructor
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Checks if the type given is valid or not
     * @param type - String of the type
     * @return the enum value corresponding to the given string, case-insensitive. Null if no matching enum value was found.
     */
    public static TypesOfService fromString(String type) {
        for (TypesOfService serviceType : TypesOfService.values()) {
            if (serviceType.typeName.equalsIgnoreCase(type)) {
                return serviceType;
            }
        }
        return null;
    }
}
