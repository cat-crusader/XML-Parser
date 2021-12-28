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

public class MyDOMParser extends MyParser {
        public MyDOMParser(String xml_path, String xsd_path) {
                super(xml_path,xsd_path);
        }

        public List<TouristVoucher> parseXML() throws IOException {
                if (!validateXMLByXSD())
                        throw new IOException();
                List<TouristVoucher> touristVouchers = new ArrayList<>();
                DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder;
                try {
                        builder = builderFactory.newDocumentBuilder();
                        Document document;
                        document = (Document) builder.parse(new File(xml_path));
                        Element rootElement = document.getDocumentElement();
                        NodeList nodes = rootElement.getChildNodes();
                        for (int i = 0; i < nodes.getLength(); i++) {
                                Node node = nodes.item(i);
                                if (node instanceof Element touristVoucher) {
                                        int id = Integer.parseInt(touristVoucher.getElementsByTagName("id")
                                                .item(0)
                                                .getTextContent());
                                        String type = touristVoucher.getElementsByTagName("type")
                                                .item(0)
                                                .getTextContent();
                                        String country = touristVoucher.getElementsByTagName("country")
                                                .item(0)
                                                .getTextContent();
                                        int duration = Integer.parseInt(touristVoucher.getElementsByTagName("duration")
                                                .item(0)
                                                .getTextContent());
                                        String transport = touristVoucher.getElementsByTagName("transport")
                                                .item(0)
                                                .getTextContent();
                                        String hc = touristVoucher.getElementsByTagName("hc")
                                                .item(0)
                                                .getTextContent();
                                        int cost = Integer.parseInt(touristVoucher.getElementsByTagName("cost")
                                                .item(0)
                                                .getTextContent());
                                        String food = touristVoucher.getElementsByTagName("food")
                                                .item(0)
                                                .getTextContent();
                                        int stars = Integer.parseInt(touristVoucher.getElementsByTagName("stars")
                                                .item(0)
                                                .getTextContent());
                                        boolean aircooler = Boolean.parseBoolean(touristVoucher.getElementsByTagName("aircooler")
                                                .item(0)
                                                .getTextContent());
                                        boolean tv = Boolean.parseBoolean(touristVoucher.getElementsByTagName("tv")
                                                .item(0)
                                                .getTextContent());
                                        touristVouchers.add(new TouristVoucher(id,type,country,duration,transport,hc,cost,food,stars,aircooler,tv));
                                }
                        }
                } catch (ParserConfigurationException | SAXException | IOException e) {
                        e.printStackTrace();
                }
                return touristVouchers;
        }
}