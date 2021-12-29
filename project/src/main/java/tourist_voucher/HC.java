package tourist_voucher;

public class HC {
//                <food>BB</food>
//            <stars>5</stars>
//            <aircooller>true</aircooller>
//            <tv>false</tv>
    private Food food;
    private int stars;
    private boolean aircooler;
    private boolean tv;

    public HC(){

    }
    public HC(String _food,int _stars,boolean _aircooler,boolean _tv){
        food = Food.valueOf(_food);
        stars=_stars;
        aircooler=_aircooler;
        tv=_tv;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public boolean isAircooler() {
        return aircooler;
    }

    public void setAircooler(boolean aircooler) {
        this.aircooler = aircooler;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }
}
