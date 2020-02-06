package lk.ijse.deppo.hotelManagement.entity;

import java.sql.Date;

public class Reservation implements SuperEntity{
    private String id;
    private String guestId;
    private Date date;
    private String currency;
    private double discount;
    private double subTotal;
    private double total;

    public Reservation(String id, String guestId, Date date, String currency, double discount, double subTotal, double total) {
        this.id = id;
        this.guestId = guestId;
        this.date = date;
        this.currency = currency;
        this.discount = discount;
        this.subTotal = subTotal;
        this.total = total;
    }
    public Reservation(String id, String guestId, String currency, double discount, double total) {
        this.id = id;
        this.guestId = guestId;
        this.currency = currency;
        this.discount = discount;
        this.total = total;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ReservationData{" +
                "id='" + id + '\'' +
                ", guestId='" + guestId + '\'' +
                ", date=" + date +
                ", currency='" + currency + '\'' +
                ", discount=" + discount +
                ", subTotal=" + subTotal +
                ", total=" + total +
                '}';
    }
}
