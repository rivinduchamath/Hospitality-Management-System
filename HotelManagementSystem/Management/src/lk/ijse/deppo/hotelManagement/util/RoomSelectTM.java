package lk.ijse.deppo.hotelManagement.util;

import java.util.Date;

public class RoomSelectTM {

    private String no;
    private String type;
    private double price;
    private String category;
    private String state;
    private String clean;
    private Date date;

    public RoomSelectTM(String no, String type, double price, String state) {
        this.no = no;
        this.type = type;
        this.price = price;
        this.state = state;

    }

    public RoomSelectTM(String no, String type, double price, String category, String state, String clean) {
        this.no = no;
        this.type = type;
        this.price = price;
        this.category = category;
        this.state = state;
        this.clean = clean;
        this.date = date;
    }

    public RoomSelectTM(String no) {
    }

    public RoomSelectTM(String no, String type, double price, String state, String clean) {
        this.no = no;
        this.type = type;
        this.price = price;
        this.state = state;
        this.clean = clean;
    }

    @Override
    public String toString() {
        return "RoomSelectTM{" +
                "no='" + no + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", state='" + state + '\'' +
                ", clean='" + clean + '\'' +
                ", date=" + date +
                '}';
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

    public String getClean() {
        return clean;
    }

    public void setClean(String clean) {
        this.clean = clean;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
