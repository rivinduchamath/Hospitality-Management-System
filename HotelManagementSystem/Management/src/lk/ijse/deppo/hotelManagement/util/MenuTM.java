package lk.ijse.deppo.hotelManagement.util;

public class MenuTM {
    private String id;
    private double price;
    private String description;
    private int qtyOnHand;
    private String guestID;
    private String fullBoard;
    private String halfBoard;
    private String breakfest;
    private String lunch;
    private String dinner;
    public MenuTM(String id, double price, String description, int qtyOnHand) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.qtyOnHand = qtyOnHand;
    }
    public MenuTM(String guestID, String fullBoard, String halfBoard, String breakfest,String lunch,String dinner) {
        this.guestID = guestID;
        this.fullBoard = fullBoard;
        this.halfBoard = halfBoard;
        this.breakfest = breakfest;
        this.lunch = lunch;
        this.dinner = dinner;
    }
    public MenuTM(String guestID, String fullBoard, String halfBoard){
        this.guestID = guestID;
        this.fullBoard = fullBoard;
        this.halfBoard = halfBoard;
    }

    public String getGuestID() {
        return guestID;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

    public String getFullBoard() {
        return fullBoard;
    }

    public void setFullBoard(String fullBoard) {
        this.fullBoard = fullBoard;
    }

    public String getHalfBoard() {
        return halfBoard;
    }

    public void setHalfBoard(String halfBoard) {
        this.halfBoard = halfBoard;
    }

    public String getBreakfest() {
        return breakfest;
    }

    public void setBreakfest(String breakfest) {
        this.breakfest = breakfest;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
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

    @Override
    public String toString() {
        return "MenuTM{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", qtyOnHand=" + qtyOnHand +
                ", guestID='" + guestID + '\'' +
                ", fullBoard='" + fullBoard + '\'' +
                ", halfBoard='" + halfBoard + '\'' +
                ", breakfest='" + breakfest + '\'' +
                ", lunch='" + lunch + '\'' +
                ", dinner='" + dinner + '\'' +
                '}';
    }
}
