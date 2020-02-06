package lk.ijse.deppo.hotelManagement.dto;

import java.util.Date;

public class RoomDTO {
    private String no;
    private String type;
    private double price;
    private String catogry;
    private String state;
    private String clean;
    private Date date;
    private boolean avilability;

    public RoomDTO(String no, String type, double price, String catogry, String state, String clean, Date date, boolean avilability) {
        this.no = no;
        this.type = type;
        this.price = price;
        this.catogry = catogry;
        this.state = state;
        this.clean = clean;
        this.date = date;
        this.avilability = avilability;
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

    public String getCatogry() {
        return catogry;
    }

    public void setCatogry(String catogry) {
        this.catogry = catogry;
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

    public boolean isAvilability() {
        return avilability;
    }

    public void setAvilability(boolean avilability) {
        this.avilability = avilability;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "no='" + no + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", catogry='" + catogry + '\'' +
                ", state='" + state + '\'' +
                ", clean='" + clean + '\'' +
                ", date=" + date +
                ", avilability=" + avilability +
                '}';
    }
}
