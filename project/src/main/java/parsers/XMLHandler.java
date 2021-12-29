package parsers;

import tourist_voucher.*;

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

    public TouristVoucher getTouristVoucher()
    {return touristVoucher;}

    public List<TouristVoucher> getTouristVouchers()
    {return touristVouchers;}

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
                touristVoucher.setTransport(Transport.valueOf(value));
                break;
            case "cost":
                touristVoucher.setCost(Integer.parseInt(value));
                break;
            case "food":
                touristVoucher.getHc().setFood(Food.valueOf(value));
                break;
            case "stars":
                touristVoucher.getHc().setStars(Integer.parseInt(value));
                break;
            case "aircooler":
                touristVoucher.getHc().setAircooler(Boolean.parseBoolean(value));
                break;
            case "tv":
                touristVoucher.getHc().setTv(Boolean.parseBoolean(value));
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
