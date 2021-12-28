package parsers;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import tourist_voucher.TouristVoucher;

import java.util.ArrayList;
import java.util.List;

public class MyHandler extends DefaultHandler {
    private final List<TouristVoucher> touristVouchers = new ArrayList<>();
    private StringBuilder data = null;

    private Integer id = null;
    private String type = null;
    private String country = null;
    private Integer duration = null;
    private String transport = null;
    private String  hc = null;
    private Integer cost = null;
    private String food = null;
    private Integer stars = null;
    private Boolean aircooler = null;
    private Boolean tv = null;

    private String tag = "no tag";

    public List<TouristVoucher> getTouristVouchers() {
        return touristVouchers;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        if (qName.equalsIgnoreCase("id")) {
            tag = "id";
        } else if (qName.equalsIgnoreCase("type")) {
            tag = "type";
        } else if (qName.equalsIgnoreCase("country")) {
            tag = "country";
        } else if (qName.equalsIgnoreCase("duration")) {
            tag = "duration";
        } else if (qName.equalsIgnoreCase("transport")) {
            tag = "transport";
        } else if (qName.equalsIgnoreCase("hc")) {
            tag = "hc";
        } else if (qName.equalsIgnoreCase("cost")) {
            tag = "cost";
        } else if (qName.equalsIgnoreCase("food")) {
            tag = "food";
        } else if (qName.equalsIgnoreCase("stars")) {
            tag = "stars";
        } else if (qName.equalsIgnoreCase("aircooler")) {
            tag = "aircooler";
        } else if (qName.equalsIgnoreCase("tv")) {
            tag = "tv";
        }

        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (tag){
            case "id" -> this.id = Integer.parseInt(data.toString());
            case "type" -> this.type = data.toString();
            case "country" -> this.country = data.toString();
            case "duration" -> this.duration = Integer.parseInt(data.toString());
            case "transport" -> this.transport = data.toString();
            case "hc" -> this.hc = data.toString();
            case "cost" -> this.cost = Integer.parseInt(data.toString());
            case "food" -> this.food = data.toString();
            case "stars" -> this.stars = Integer.parseInt(data.toString());
            case "aircooler" -> this.aircooler = Boolean.parseBoolean(data.toString());
            case "tv" -> this.tv = Boolean.parseBoolean(data.toString());
        }
        tag = "no tag";

        if (qName.equalsIgnoreCase("touristvoucher")) {
            touristVouchers.add(new TouristVoucher(id, type, country, duration, transport, hc,
                    cost, food, stars, aircooler, tv));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(new String(ch, start, length));
    }
}
