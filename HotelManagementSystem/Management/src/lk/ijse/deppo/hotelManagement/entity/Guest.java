package lk.ijse.deppo.hotelManagement.entity;

import java.io.Serializable;
import java.sql.Date;


public class Guest implements SuperEntity{

    private String id;
    private String idType;
    private String guestName;
    private String country;
    private String email;
    private String vehicle;
    private String roomNo;
    private Date arivalDate;
    private Date depatureDate;
    private String  ratePrice;
    private String adults;
    private String children;
    private  String menu;
    private  String discount;
    private  String subTotal;
    private  String total;

    public Guest(String id, String idType, String guestName, String country, String email, String vehicle, String roomNo, Date arivalDate,Date depatureDate, String ratePrice, String adults, String children, String menu, String discount, String subTotal, String total) {
        this.id = id;
        this.idType = idType;
        this.guestName = guestName;
        this.country = country;
        this.email = email;
        this.vehicle = vehicle;
        this.roomNo = roomNo;
        this.arivalDate = arivalDate;
        this.depatureDate = depatureDate;
        this.ratePrice = ratePrice;
        this.adults = adults;
        this.children = children;
        this.menu = menu;
        this.discount = discount;
        this.subTotal = subTotal;
        this.total = total;
    }

    public Guest(String id, String idType, String guestName, String country, String email, String vehicle, String total) {
        this.id = id;
        this.idType = idType;
        this.guestName = guestName;
        this.country = country;
        this.email = email;
        this.vehicle = vehicle;
        this.total = total;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Date getArivalDate() {
        return arivalDate;
    }

    public void setArivalDate(Date arivalDate) {
        this.arivalDate = arivalDate;
    }

    public Date getDepatureDate() {
        return depatureDate;
    }

    public void setDepatureDate(Date depatureDate) {
        this.depatureDate = depatureDate;
    }

    public String getRatePrice() {
        return ratePrice;
    }

    public void setRatePrice(String ratePrice) {
        this.ratePrice = ratePrice;
    }

    public String getAdults() {
        return adults;
    }

    public void setAdults(String adults) {
        this.adults = adults;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "GuestDTO{" +
                "id='" + id + '\'' +
                ", idType='" + idType + '\'' +
                ", guestName='" + guestName + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", roomNo='" + roomNo + '\'' +
                ", arivalDate=" + arivalDate +
                ", depatureDate=" + depatureDate +
                ", ratePrice='" + ratePrice + '\'' +
                ", adults='" + adults + '\'' +
                ", children='" + children + '\'' +
                ", menu='" + menu + '\'' +
                ", discount='" + discount + '\'' +
                ", subTotal='" + subTotal + '\'' +
                ", total='" + total + '\'' +
                '}';
    }


}
