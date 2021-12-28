package parsers;

import org.xml.sax.SAXException;
import tourist_voucher.TouristVoucher;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MySAXParser extends MyParser{
    public MySAXParser(String xml_path, String xsd_path){
        super(xml_path, xsd_path);
    }
    @Override
    public List<TouristVoucher> parseXML() throws IOException {
        if (!validateXMLByXSD())
            throw new IOException();
        List<TouristVoucher> touristVouchers = new ArrayList<>();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler();
            saxParser.parse(new File(xml_path), handler);
            touristVouchers = handler.getTouristVouchers();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return touristVouchers;
    }
}
