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

public class MySAXParser implements ParserXML{
private XMLHandler handler;

    public MySAXParser(XMLHandler _handler){
        handler=_handler;
    }

    @Override
    public void parse(String xmlPath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXHandler saxHandler = new SAXHandler(handler);
            saxParser.parse(new File(xmlPath), saxHandler);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error: " + e.getMessage());
        }
    }
}
