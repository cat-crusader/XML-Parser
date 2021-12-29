package parsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {
    XMLHandler handler;
    private StringBuilder data;

    public SAXHandler(XMLHandler _handler)
    {
         handler=_handler;
         data=null;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase(handler.name))
            handler.endTag(qName);
        handler.setTag(qName, data.toString());
        data = new StringBuilder();
    }


    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

}
