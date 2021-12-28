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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyStAXParser extends MyParser {

    public MyStAXParser(String xml_path, String xsd_path){
        super(xml_path, xsd_path);
    }

    public List<TouristVoucher> parseXML() throws IOException {
        if (!validateXMLByXSD())
            throw new IOException();
        List<TouristVoucher> touristVouchers = new ArrayList<>();
        Integer id = null;
        String type = null;
        String country = null;
        int duration = 1;
        String transport = null;
        String hc = null;
        int cost = 10;
        String food = null;
        int stars = 5;
        boolean aircooler = false;
        boolean tv = false;

        String taq = "no taq";

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =
                    factory.createXMLEventReader(new FileReader(xml_path));

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT -> {
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        if (qName.equalsIgnoreCase("id")) {
                            taq = "id";
                        } else if (qName.equalsIgnoreCase("type")) {
                            taq = "type";
                        } else if (qName.equalsIgnoreCase("country")) {
                            taq = "country";
                        } else if (qName.equalsIgnoreCase("duration")) {
                            taq = "duration";
                        } else if (qName.equalsIgnoreCase("transport")) {
                            taq = "transport";
                        } else if (qName.equalsIgnoreCase("hc")) {
                            taq = "hc";
                        } else if (qName.equalsIgnoreCase("cost")) {
                            taq = "cost";
                        } else if (qName.equalsIgnoreCase("food")) {
                            taq = "food";
                        } else if (qName.equalsIgnoreCase("stars")) {
                            taq = "stars";
                        } else if (qName.equalsIgnoreCase("aircooler")) {
                            taq = "aircooler";
                        } else if (qName.equalsIgnoreCase("tv")) {
                            taq = "tv";
                        } else {
                            taq = "no taq";
                        }
                    }
                    case XMLStreamConstants.CHARACTERS -> {
                        Characters characters = event.asCharacters();
                        switch (taq) {
                            case "id" -> id = Integer.parseInt(characters.toString());
                            case "type" -> type = characters.toString();
                            case "country" -> country = characters.toString();
                            case "duration" -> duration = Integer.parseInt(characters.toString());
                            case "transport" -> transport = characters.toString();
                            case "hc" -> hc = characters.toString();
                            case "cost" -> cost = Integer.parseInt(characters.toString());
                            case "food" -> food = characters.toString();
                            case "stars" -> stars = Integer.parseInt(characters.toString());
                            case "aircooler" -> aircooler = Boolean.parseBoolean(characters.toString());
                            case "tv" -> tv = Boolean.parseBoolean(characters.toString());
                        }
                        taq = "no taq";
                    }
                    case XMLStreamConstants.END_ELEMENT -> {
                        EndElement endElement = event.asEndElement();
                        if (endElement.getName().getLocalPart().equalsIgnoreCase("touristvoucher")) {
                            touristVouchers.add(new TouristVoucher(id, type, country, duration, transport, hc,
                                    cost, food, stars, aircooler, tv));
                        }
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return touristVouchers;
    }

}