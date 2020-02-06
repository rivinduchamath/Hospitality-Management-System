package lk.ijse.deppo.hotelManagement.entity;

import java.util.Date;

public class Banquet implements SuperEntity {
    private double price;
    private String id;
    private String guestId;
    private String guestName;
    private int chair;
    private Date banquetDate;
    private double platePrice;
    private String mealType;
    private int noofPeople;
    private double subTotal;
    private double discount;
    private Date date;
    private String submittedBy;

    @Override
    public String toString() {
        return "Banquet{" +
                "price=" + price +
                ", id='" + id + '\'' +
                ", guestId='" + guestId + '\'' +
                ", guestName='" + guestName + '\'' +
                ", chair=" + chair +
                ", banquetDate=" + banquetDate +
                ", platePrice=" + platePrice +
                ", mealType='" + mealType + '\'' +
                ", noofPeople=" + noofPeople +
                ", subTotal=" + subTotal +
                ", discount=" + discount +
                ", date=" + date +
                ", submittedBy='" + submittedBy + '\'' +
                '}';
    }

    public Banquet(String id, String guestId, int chair, Date date, int noofPeople, double price, String mealType) {
        this.id = id;
        this.guestId = guestId;
        this.chair = chair;
        this.date = date;
        this.noofPeople = noofPeople;
        this.price = price;
        this.mealType = mealType;
    }
    public Banquet(String id, String guestId, String guestName, int chair, Date banquetDate, double platePrice, String mealType, int noofPeople, double subTotal, double discount, Date date, String submittedBy) {
        this.id = id;
        this.guestId = guestId;
        this.guestName = guestName;
        this.chair = chair;
        this.banquetDate = banquetDate;
        this.platePrice = platePrice;
        this.mealType = mealType;
        this.noofPeople = noofPeople;
        this.subTotal = subTotal;
        this.discount = discount;
        this.date = date;
        this.submittedBy = submittedBy;
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

}
