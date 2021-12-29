package parsers;

import tourist_voucher.TouristVoucher;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class XMLHandler {
    private TouristVoucher touristVoucher;
    private List<TouristVoucher> touristVouchers;
    public String name;

    public XMLHandler(){
        touristVoucher = new TouristVoucher();
        touristVouchers = new ArrayList<>();
        name = "touristvoucher";
    }
    public void setTag(String element, String value){
        switch (element.toLowerCase()){
            case "touristvoucher":
                touristVoucher = new TouristVoucher();
            case "id":
                touristVoucher.setId(Integer.parseInt(value));
                break;
            case "country":
                touristVoucher.setCountry(value);
                break;
            case "duration":
                touristVoucher.setDuration(Integer.parseInt(value));
                break;
            case "transport":
                touristVoucher.setTransport(value);
                break;
            case "hc":
                touristVoucher.setHc(value);
                break;
            case "cost":
                touristVoucher.setCost(Integer.parseInt(value));
                break;
            case "food":
                touristVoucher.getHc().setFood(value);
                break;
            case "stars":
                touristVoucher.getHc().setStars(Integer.parseInt(value));
                break;
            case "aircooler":
                touristVoucher.getHc().setAircooler(Boolean.parseBoolean(value));
                break;
            case "tv":
                touristVoucher.getHc().setTv(Boolean.parseBoolean(value);
                break;
            default:
                break;
        }
    }
    public void endTag(String element){
        if(element.equalsIgnoreCase("touristvoucher")){
            touristVouchers.add(touristVoucher);
            touristVoucher = new TouristVoucher();
        }
    }
}
