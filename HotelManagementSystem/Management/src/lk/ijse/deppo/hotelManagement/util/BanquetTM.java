package lk.ijse.deppo.hotelManagement.util;

import java.util.Date;

public class BanquetTM {
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

    public BanquetTM(String id, String guestId, String guestName, int chair, Date banquetDate, double platePrice, String mealType, int noofPeople, double subTotal, double discount, Date date, String submittedBy) {
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

    @Override
    public String toString() {
        return "BanquetTM{" +
                "id='" + id + '\'' +
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

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getChair() {
        return chair;
    }

    public void setChair(int chair) {
        this.chair = chair;
    }

    public Date getBanquetDate() {
        return banquetDate;
    }

    public void setBanquetDate(Date banquetDate) {
        this.banquetDate = banquetDate;
    }

    public double getPlatePrice() {
        return platePrice;
    }

    public void setPlatePrice(double platePrice) {
        this.platePrice = platePrice;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public int getNoofPeople() {
        return noofPeople;
    }

    public void setNoofPeople(int noofPeople) {
        this.noofPeople = noofPeople;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }
}
