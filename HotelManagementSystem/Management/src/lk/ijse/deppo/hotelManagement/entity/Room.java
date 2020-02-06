package lk.ijse.deppo.hotelManagement.entity;

public class Room implements SuperEntity{
    private String no;
    private String type;
    private double price;
    private String catogry;
    private String state;
    private String clean;

    public Room(String no, String type, double price, String catogry, String state, String clean) {
        this.no = no;
        this.type = type;
        this.price = price;
        this.catogry = catogry;
        this.state = state;
        this.clean = clean;
    }

    public Room(String no){
        this.no = no;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCatogry() {
        return catogry;
    }

    public void setCatogry(String catogry) {
        this.catogry = catogry;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getClean() {
        return clean;
    }

    public void setClean(String clean) {
        this.clean = clean;
    }

    @Override
    public String toString() {
        return "Room{" +
                "no='" + no + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", catogry='" + catogry + '\'' +
                ", state='" + state + '\'' +
                ", clean='" + clean + '\'' +
                '}';
    }
}
