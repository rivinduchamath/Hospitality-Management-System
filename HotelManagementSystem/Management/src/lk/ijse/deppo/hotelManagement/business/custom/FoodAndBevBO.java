package lk.ijse.deppo.hotelManagement.business.custom;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.business.SuperBO;
import lk.ijse.deppo.hotelManagement.util.FoodAndBrvTM;

public interface FoodAndBevBO extends SuperBO {
    String getAll() throws Exception;

    void placeOrder(String orderId, String customerId, String text, ObservableList<FoodAndBrvTM> menu) throws Exception;

    double updateMenuPrice(double price) throws Exception;

    double updateMenuPrice2(double price) throws Exception;

    double getPrice(String id1)throws Exception;
}
