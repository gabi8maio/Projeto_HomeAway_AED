package homeaway;

public enum StudentTypes {

    BOOKISH("BOOKISH"),
    OUTGOING("OUTGOING"),
    THRIFTY("THRIFTY");
    private final String typeName;

    StudentTypes(String typeName) {

        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public static StudentTypes fromString(String type) {
        for (StudentTypes serviceType : StudentTypes.values()) {
            if (serviceType.typeName.equalsIgnoreCase(type)) {
                return serviceType;
            }
        }
        return null;
    }
}
