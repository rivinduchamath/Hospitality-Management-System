package lk.ijse.deppo.hotelManagement.entity;

public class Menu implements SuperEntity{
    private String id;
    private double price;
    private String description;
    private int qtyOnHand;
    private String ressevationId;
    private String guestId;
    private String maalID;

    public Menu(String id, double price, String description, int qtyOnHand) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.qtyOnHand = qtyOnHand;
    }

    public Menu(String ressevationId, String guestId, String maalID) {
        this.ressevationId = ressevationId;
        this.guestId = guestId;
        this.maalID = maalID;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", qtyOnHand=" + qtyOnHand +
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

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

}
