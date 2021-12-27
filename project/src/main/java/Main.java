import validator.ValidatorXML;

import java.io.IOException;
import java.util.List;


public class Main {

        public static void main(String[] args) {
                System.out.println("lol");
                System.out.println(ValidatorXML.validateAgainstXSD("touristvoucher.xml", "touristvoucher.xsd"));
        }

}
