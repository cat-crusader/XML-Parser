import parsers.MyDOMParser;
import parsers.MyStAXParser;
import tourist_voucher.TouristVoucher;
import validator.ValidatorXML;

import java.io.IOException;
import java.util.List;


public class Main {

        public static void main(String[] args) {
                        try{
                                System.out.println("Validator lol:");
                                System.out.println(ValidatorXML.validateAgainstXSD("tourist_voucher.xml", "tourist_voucher.xsd"));
                                System.out.println("DOM parser");
                                MyDOMParser p = new MyDOMParser( "xml/tourist_vouchers.xml", "tourist_voucher.xsd");
                                List<TouristVoucher> touristVouchers = p.parseXML();
                                for (TouristVoucher k : touristVouchers){
                                        System.out.println(k.getId());
                                }
                                System.out.println();

                                System.out.println("StAX parser");
                                MyStAXParser p3 = new MyStAXParser( "xml/tourist_vouchers.xml", "tourist_voucher.xsd");
                                touristVouchers = p3.parseXML();
                                for (TouristVoucher k : touristVouchers){
                                        System.out.println(k.getId());
                                }
                            System.out.println("End");

                        } catch (IOException e) {
                                e.printStackTrace();
                        }
        }

}
