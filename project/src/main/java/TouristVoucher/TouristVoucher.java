package TouristVoucher;

public class TouristVoucher implements  Comparable {

    int id;
    Type type;
    String country;
    int duration;
    Transport transport;
    HC hc;
    int cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public HC getHc() {
        return hc;
    }

    public void setHc(HC hc) {
        this.hc = hc;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
//<trips>
//<Тourist_voucher>
//<id>1</id>
//<type>excursion</type>
//<country>Ukraine</country>
//<duration>7</duration>
//<transport>helicopter</transport>
//<hc>
//<food>BB</food>
//<stars>5</stars>
//<aircooller>true</aircooller>
//<tv>false</tv>
//</hc>
//<cost>10000</cost>
//</Тourist_voucher>
//
//</trips>