package lk.ijse.deppo.hotelManagement.entity;

public class FoodAndBevDataPK implements SuperEntity{

    private String id;
    private String itemId;

    public FoodAndBevDataPK(String id, String itemId) {
        this.id = id;
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "FoodAndBevDataPK{" +
                "id='" + id + '\'' +
                ", itemId='" + itemId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
