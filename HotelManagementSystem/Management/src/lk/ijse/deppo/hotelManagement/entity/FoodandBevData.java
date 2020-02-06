package lk.ijse.deppo.hotelManagement.entity;

public class FoodandBevData implements SuperEntity{
 private FoodAndBevDataPK foodAndBevDataPK;
    private String description;
    private int orderQty;
    private double unitePrice;


    public FoodandBevData(FoodAndBevDataPK foodAndBevDataPK, String description, int orderQty, double unitePrice) {
        this.foodAndBevDataPK = foodAndBevDataPK;
        this.description = description;
        this.orderQty = orderQty;
        this.unitePrice = unitePrice;
    }
    public FoodandBevData(String id,String itemId, String description, int orderQty, double unitePrice) {
        this.foodAndBevDataPK = new FoodAndBevDataPK(id, itemId);
        this.description = description;
        this.orderQty = orderQty;
        this.unitePrice = unitePrice;
    }
    public FoodAndBevDataPK getFoodAndBevDataPK() {
        return foodAndBevDataPK;
    }

    public void setFoodAndBevDataPK(FoodAndBevDataPK foodAndBevDataPK) {
        this.foodAndBevDataPK = foodAndBevDataPK;
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

    @Override
    public String toString() {
        return "FoodandBevData{" +
                "foodAndBevDataPK=" + foodAndBevDataPK +
                ", description='" + description + '\'' +
                ", orderQty=" + orderQty +
                ", unitePrice=" + unitePrice +
                '}';
    }
}
