package lk.ijse.deppo.hotelManagement.util;

public class GuestControllerTM {
    private String arrivalDate;
    private String departureDate;
    private String roomType;
    private String roomNo;
    private int adult;
    private int children;
    private String menu;
    private double discount;
    private double ratePrice;
    private double subTotal;

    public GuestControllerTM(String arrivalDate, String departureDate, String roomType, String roomNo, int adult, int children, String menu, double discount, double ratePrice, double subTotal) {
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.roomType = roomType;
        this.roomNo = roomNo;
        this.adult = adult;
        this.children = children;
        this.menu = menu;
        this.discount = discount;
        this.ratePrice = ratePrice;
        this.subTotal = subTotal;
    }

    public String getArrivalDate() { return arrivalDate; }

    public void setArrivalDate(String arrivalDate) { this.arrivalDate = arrivalDate; }

    public String getDepartureDate() { return departureDate; }

    public void setDepartureDate(String departureDate) { this.departureDate = departureDate; }

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

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getRatePrice() {
        return ratePrice;
    }

    public void setRatePrice(double ratePrice) {
        this.ratePrice = ratePrice;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "GuestControllerTM{" +
                "arrivalDate=" + arrivalDate +
                ", departureDate=" + departureDate +
                ", roomType='" + roomType + '\'' +
                ", roomNo='" + roomNo + '\'' +
                ", adult=" + adult +
                ", children=" + children +
                ", menu='" + menu + '\'' +
                ", discount=" + discount +
                ", ratePrice=" + ratePrice +
                ", subTotal=" + subTotal +
                '}';
    }
}
