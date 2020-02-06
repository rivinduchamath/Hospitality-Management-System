package lk.ijse.deppo.hotelManagement.dto;

import java.util.Date;

public class BanqetDTO {
    private String id;
    private String guestId;
    private int chair;
    private Date date;
    private int noofPeople;
    private double price;
    private String mealType;

    public BanqetDTO(String id, String guestId, int chair, Date date, int noofPeople, double price, String mealType) {
        this.id = id;
        this.guestId = guestId;
        this.chair = chair;
        this.date = date;
        this.noofPeople = noofPeople;
        this.price = price;
        this.mealType = mealType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public int getChair() {
        return chair;
    }

    public void setChair(int chair) {
        this.chair = chair;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNoofPeople() {
        return noofPeople;
    }

    public void setNoofPeople(int noofPeople) {
        this.noofPeople = noofPeople;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    @Override
    public String toString() {
        return "Banquet{" +
                "id='" + id + '\'' +
                ", guestId='" + guestId + '\'' +
                ", chair=" + chair +
                ", date=" + date +
                ", noofPeople=" + noofPeople +
                ", price=" + price +
                ", mealType='" + mealType + '\'' +
                '}';
    }
}
