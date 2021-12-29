package parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import tourist_voucher.TouristVoucher;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyDOMParser implements ParserXML {
        private XMLHandler handler;

        MyDOMParser(XMLHandler _handler){
                handler=_handler;
        }
        @Override
        public void parse(String xmlPath) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder;
                Document doc = null;
                try {
                        builder = factory.newDocumentBuilder();
                        doc = builder.parse(xmlPath);
                } catch (ParserConfigurationException | SAXException | IOException e) {}

                Element root = doc.getDocumentElement();

                NodeList gunsNodes = root.getElementsByTagName(handler.name);

                for (int i = 0; i < gunsNodes.getLength(); i++) {

                        Element gunElem = (Element) gunsNodes.item(i);
                        NodeList childNodes = gunElem.getChildNodes();

                        for (int j = 0; j < childNodes.getLength(); j++) {
                                if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {

                                        Element child = (org.w3c.dom.Element) childNodes.item(j);

                                        handler.setTag(child.getNodeName(), getChildValue(gunElem, child.getNodeName()));
                                        NodeList childChildNodes = child.getChildNodes();

                                        for (int k = 0; k < childChildNodes.getLength(); k++) {
                                                if (childChildNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
                                                        Element childChild = (org.w3c.dom.Element) childChildNodes.item(k);
                                                        handler.setTag(childChild.getNodeName(), getChildValue(child, childChild.getNodeName()));
                                                }
                                        }
                                }
                        }
                        handler.endTag(gunElem.getNodeName());
                }
        }
        private static String getChildValue(Element element, String name) {
                Element child = (Element) element.getElementsByTagName(name).item(0);
                if (child == null) {
                        return new String();
                }
                Node node = child.getFirstChild();
                return node.getNodeValue();
        }
        

}