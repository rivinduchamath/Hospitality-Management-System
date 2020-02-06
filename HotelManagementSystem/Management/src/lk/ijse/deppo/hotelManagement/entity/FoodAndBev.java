package lk.ijse.deppo.hotelManagement.entity;

import java.util.Date;

public class FoodAndBev implements SuperEntity{
    private String orderId;
    private String cusId;
    private String itemId;
    private String description;
    private int orderQty;
    private double unitePrice;
    private double total;
    private Date date;
    public FoodAndBev(String itmCode, String description, int qty, Date date, double unitePrice, double total) {
        this.itemId = itmCode;
        this.description = description;
        this.orderQty = qty;
        this.date = date;
        this.unitePrice = unitePrice;
        this.total = total;
    }
    public  FoodAndBev(){}
    public FoodAndBev(String orderId, String cusId, String itemId, String description, int orderQty, double unitePrice, double total, Date date) {
        this.orderId = orderId;
        this.cusId = cusId;
        this.itemId = itemId;
        this.description = description;
        this.orderQty = orderQty;
        this.unitePrice = unitePrice;
        this.total = total;
        this.date = date;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FoodAndBev{" +
                "orderId='" + orderId + '\'' +
                ", cusId='" + cusId + '\'' +
                ", itemId='" + itemId + '\'' +
                ", description='" + description + '\'' +
                ", orderQty=" + orderQty +
                ", unitePrice=" + unitePrice +
                ", total=" + total +
                ", date=" + date +
                '}';
    }
}
