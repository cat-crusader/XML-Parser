package parsers;

import tourist_voucher.TouristVoucher;
import tourist_voucher.TouristVouchers;
import validator.ValidatorXML;

import java.util.List;

public class TouristVoucherParser {

    private ParserXML parser;
    private TouristVouchers result;
    private XMLHandler handler;

    public TouristVouchers parse(String xmlPath, String xsdPath, String parserName){
        if(ValidatorXML.validateAgainstXSD(xmlPath,xsdPath)){
            switch (parserName.toUpperCase()){
                case "SAX":{
//                    handler = new XMLHandler();
//                    parser = new MySAXParser(xmlPath,xsdPath);
//                    parser.parseXML();
//                    result = new TouristVouchers();

                    break;
                }
                case "DOM":{
                    handler = new XMLHandler();
                    parser = new MyDOMParser(handler);
                    parser.parse(xmlPath);
                    result = new TouristVouchers(handler.getTouristVouchers());
                    break;
                }
                case "STAX":{

                    break;
                }
                default:break;



            }

            result.sort();
            System.out.println(result);
        }
        return result;
    }
}
