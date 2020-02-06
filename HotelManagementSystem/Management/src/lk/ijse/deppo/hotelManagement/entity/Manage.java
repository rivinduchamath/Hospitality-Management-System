package lk.ijse.deppo.hotelManagement.entity;

public class Manage implements SuperEntity{
    private String currency;
    private double price;

    public Manage(String currency, double price) {
        this.currency = currency;
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Manage{" +
                "currency='" + currency + '\'' +
                ", price=" + price +
                '}';
    }
}
