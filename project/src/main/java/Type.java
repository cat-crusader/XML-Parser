public enum Type {

//                <xsd:enumeration value="excursion"/>
//            <xsd:enumeration value="holiday"/>
//            <xsd:enumeration value="resort"/>
//            <xsd:enumeration value="pilgrimage"/>

    Excursion("excursion"),
    Holiday("holiday"),
    Resort("resort"),
    Pilgrimage("pilgrimage");

    private final String value;

    Type(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Type fromValue(String v) {
        return valueOf(v);
    }
}
