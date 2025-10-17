package homeaway;

public enum TypesOfService {

    LODGING("LODGING"),
    EATING("EATING"),
    LEISURE("LEISURE");
    private final String typeName;

    TypesOfService(String typeName) {

        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public static TypesOfService fromString(String type) {
        for (TypesOfService serviceType : TypesOfService.values()) {
            if (serviceType.typeName.equalsIgnoreCase(type)) {
                return serviceType;
            }
        }
        return null;
    }
}
