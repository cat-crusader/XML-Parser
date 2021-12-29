import parsers.MyDOMParser;
import parsers.MySAXParser;
import parsers.MyStAXParser;
import parsers.TouristVoucherParser;
import tourist_voucher.TouristVoucher;
import tourist_voucher.TouristVouchers;
import validator.ValidatorXML;

import java.io.IOException;
import java.util.List;


public class Main {

        public static void main(String[] args) {

                System.out.print("Validator lol: ");
                System.out.println(ValidatorXML.validateAgainstXSD("tourist_voucher.xml", "tourist_voucher.xsd"));

                TouristVoucherParser pars = new TouristVoucherParser();
                System.out.println();
                System.out.println("DOM parser");
                pars.parse("xml/tourist_vouchers.xml","tourist_voucher.xsd","dom");

                System.out.println();
                System.out.println("StAX parser");
                pars.parse("xml/tourist_vouchers.xml","tourist_voucher.xsd","stax");

//                                MyDOMParser p = new MyDOMParser( "xml/tourist_vouchers.xml", "tourist_voucher.xsd");
//                                List<TouristVoucher> touristVouchers = p.parseXML();
//                                for (TouristVoucher k : touristVouchers){
//                                        System.out.println(k.getId());
//                                }
//
//                                System.out.println();
//                                System.out.println("SAX parser");
//                                MySAXParser p2 = new MySAXParser( "xml/tourist_vouchers.xml", "tourist_voucher.xsd");
//                                touristVouchers = p2.parseXML();
//                                for (TouristVoucher k : touristVouchers){
//                                        System.out.println(k.getId());
//                                }
//
//                                System.out.println();
//                                System.out.println("StAX parser");
//                                MyStAXParser p3 = new MyStAXParser( "xml/tourist_vouchers.xml", "tourist_voucher.xsd");
//                                touristVouchers = p3.parseXML();
//                                for (TouristVoucher k : touristVouchers){
//                                        System.out.println(k.getId());
//                                }

                                System.out.println();
                                System.out.println("End");


        }

}
