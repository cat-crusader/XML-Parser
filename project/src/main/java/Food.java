public enum Food {


    HB("HB"),
    BB("BB"),
    B1("B1");


    private final String value;

    Food(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Food fromValue(String v) {
        return valueOf(v);
    }
}
