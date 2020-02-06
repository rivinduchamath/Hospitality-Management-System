package lk.ijse.deppo.hotelManagement.dto;

public class MenuDTO {

    private String id;
    private double price;
    private String description;
    private int qty;
    /////////////////////////
    private String ressevationId;
    private String guestId;
    private String maalID;

    public MenuDTO(String ressevationId, String guestId, String maalID) {
        this.ressevationId = ressevationId;
        this.guestId = guestId;
        this.maalID = maalID;
    }

    public MenuDTO(String id, double price, String description, int qty) {
        this.setId(id);
        this.setPrice(price);
        this.setDescription(description);
        this.setQty(qty);
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", qty=" + qty +
                ", ressevationId='" + ressevationId + '\'' +
                ", guestId='" + guestId + '\'' +
                ", maalID='" + maalID + '\'' +
                '}';
    }

    public String getRessevationId() {
        return ressevationId;
    }

    public void setRessevationId(String ressevationId) {
        this.ressevationId = ressevationId;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getMaalID() {
        return maalID;
    }

    public void setMaalID(String maalID) {
        this.maalID = maalID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

}
