package lk.ijse.deppo.hotelManagement.util;

import lk.ijse.deppo.hotelManagement.entity.FoodAndBev;

import java.util.Date;

public class FoodAndBrvTM extends FoodAndBev {
    private String itmCode;
    private String description;
    private int qty;
    private Date date;
    private double unitePrice;
    private double total;

    public FoodAndBrvTM(String itmCode, String description, int qty, Date date, double unitePrice, double total) {
        this.itmCode = itmCode;
        this.description = description;
        this.qty = qty;
        this.date = date;
        this.unitePrice = unitePrice;
        this.total = total;
    }

    @Override
    public String toString() {
        return "FoodAndBrvTM{" +
                "itmCode='" + itmCode + '\'' +
                ", description='" + description + '\'' +
                ", qty=" + qty +
                ", unitePrice=" + unitePrice +
                ", total=" + total +
                '}';
    }

    public String getItmCode() {
        return itmCode;
    }

    public void setItmCode(String itmCode) {
        this.itmCode = itmCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(double unitePrice) {
        this.unitePrice = unitePrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
