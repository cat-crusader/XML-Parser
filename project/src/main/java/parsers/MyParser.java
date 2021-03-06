package parsers;

import tourist_voucher.TouristVoucher;
import validator.ValidatorXML;

import java.io.IOException;
import java.util.List;

public abstract class MyParser {
    protected final String xml_path;
    protected final String xsd_path;

    public MyParser(String xml_path, String xsd_path) {
        this.xsd_path = xsd_path;
        this.xml_path = xml_path;
    }

    protected boolean validateXMLByXSD() {
        return ValidatorXML.validateAgainstXSD(xml_path, xsd_path);
    }

    public abstract List<TouristVoucher> parseXML() throws IOException;
}