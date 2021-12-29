package tourist_voucher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TouristVouchers {
    protected List<TouristVoucher> touristVoucher;

    public TouristVouchers(List<TouristVoucher> guns) {
        touristVoucher = guns;
    }

    public List<TouristVoucher> getTouristVoucher() {
        if (touristVoucher == null) {
            touristVoucher = new ArrayList<TouristVoucher>();
        }
        return this.touristVoucher;
    }



    public void sort() {
        Collections.sort(touristVoucher);
    }

    @Override
    public String toString() {
        String string = "";
        for (TouristVoucher st : touristVoucher) {
            string += st;
        }
        return string;
    }

    public List<TouristVoucher> getList(){
        return touristVoucher;
    }

}
