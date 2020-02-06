package lk.ijse.deppo.hotelManagement.util;


import javafx.scene.control.Button;

import java.util.Date;

public class EditReservationTM {

    private String id;
    private String guestId;
    private String currency;
    private double discount;
    private double total;
    private String guestName;
    private Date aerivalDate;
    private Date depatureDate;
    private String roomType;
    private String roomNo;
    private int adults;
    private int children;
    private String menu;
    private double subtotal;
    private Button delete;
    private double ratePrice;


    public EditReservationTM(String guestId, String guestName) {
        this.guestId = guestId;
        this.guestName = guestName;
    }


    public EditReservationTM(Date aerivalDate, Date depatureDate, String roomType, String roomNo, int adults, int children, String menu, double discount, double ratePrice, double subtotal) {
        this.aerivalDate = aerivalDate;
        this.depatureDate = depatureDate;
        this.roomType = roomType;
        this.roomNo = roomNo;
        this.adults = adults;
        this.children = children;
        this.menu = menu;
        this.discount = discount;
        this.ratePrice = ratePrice;
        this.subtotal = subtotal;

    }

    public EditReservationTM(String id, String guestId, String currency, double discount, double total) {
        this.id = id;
        this.guestId = guestId;
        this.currency = currency;
        this.discount = discount;
        this.total = total;
    }


    public String getGuestName() { return guestName; }

    public void setGuestName(String guestName) { this.guestName = guestName; }

    public Date getAerivalDate() {
        return aerivalDate;
    }

    public void setAerivalDate(Date aerivalDate) {
        this.aerivalDate = aerivalDate;
    }

    public Date getDepatureDate() {
        return depatureDate;
    }

    public void setDepatureDate(Date depatureDate) {
        this.depatureDate = depatureDate;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public double getRatePrice() {
        return ratePrice;
    }

    public void setRatePrice(double ratePrice) {
        this.ratePrice = ratePrice;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    @Override
    public String toString() {
        return "EditReservationTM{" +
                "id='" + id + '\'' +
                ", guestId='" + guestId + '\'' +
                ", currency='" + currency + '\'' +
                ", discount=" + discount +
                ", total=" + total +
                ", guestName='" + guestName + '\'' +
                ", aerivalDate=" + aerivalDate +
                ", depatureDate=" + depatureDate +
                ", roomType='" + roomType + '\'' +
                ", roomNo='" + roomNo + '\'' +
                ", adults=" + adults +
                ", children=" + children +
                ", menu='" + menu + '\'' +
                ", subtotal=" + subtotal +
                ", delete=" + delete +
                ", ratePrice=" + ratePrice +
                '}';
    }

}
