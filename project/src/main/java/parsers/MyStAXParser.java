package parsers;
import tourist_voucher.TouristVoucher;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyStAXParser implements ParserXML {

    private XMLHandler handler;

    MyStAXParser(XMLHandler _handler){
        handler=_handler;
    }

    @Override
    public void parse(String xmlPath) {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader reader = null;
        try {
            reader = factory.createXMLEventReader(new FileInputStream(xmlPath));
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }

        while (reader.hasNext()) {
            try {
                XMLEvent event = reader.nextEvent();

                switch (event.getEventType()) {
                    case XMLStreamConstants.END_DOCUMENT:
                        break;

                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        event = reader.nextEvent();
                        handler.setTag(startElement.getName().getLocalPart(), event.asCharacters().getData());
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();
                        if (endElement.getName().getLocalPart().equalsIgnoreCase(handler.name)) {
                            handler.endTag(handler.name);
                        }
                        break;
                }
            } catch (XMLStreamException e) {
            }
        }
        return;
    }

}