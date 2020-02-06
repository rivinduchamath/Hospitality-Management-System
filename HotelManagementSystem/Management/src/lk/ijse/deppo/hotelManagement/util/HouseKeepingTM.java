package lk.ijse.deppo.hotelManagement.util;



public class HouseKeepingTM {
    private String no;
    private String type;
    private double price;
    private String category;
    private String state;
    private String cleanby;
    private String date;
    private boolean avilable;



    public HouseKeepingTM(String no, String type, double price, String category, String state, String cleanby, String date, boolean avilable) {
        this.no = no;
        this.type = type;
        this.price = price;
        this.category = category;
        this.state = state;
        this.cleanby = cleanby;
        this.date = date;
        this.avilable = avilable;
    }

    @Override
    public String toString() {
        return "HouseKeepingTM{" +
                "no='" + no + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", state='" + state + '\'' +
                ", cleanby='" + cleanby + '\'' +
                ", date='" + date + '\'' +
                ", avilable=" + avilable +
                '}';
    }

    public boolean isAvilable() {
        return avilable;
    }

    public void setAvilable(boolean avilable) {
        this.avilable = avilable;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCleanby() {
        return cleanby;
    }

    public void setCleanby(String cleanby) {
        this.cleanby = cleanby;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
