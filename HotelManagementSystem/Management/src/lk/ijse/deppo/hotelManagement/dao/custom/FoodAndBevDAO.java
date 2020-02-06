package lk.ijse.deppo.hotelManagement.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.dao.CrudDAO;
import lk.ijse.deppo.hotelManagement.entity.FoodAndBev;
import lk.ijse.deppo.hotelManagement.util.FoodAndBrvTM;

public interface FoodAndBevDAO extends CrudDAO<FoodAndBev, String> {
    String getAll() throws Exception;

    void placeOrder(String orderId, String customerId, ObservableList<FoodAndBrvTM> menu, String text) throws Exception;

    double menuPrice(double price) throws Exception;

    double menuPrice2(double price) throws Exception;

    double getPrice(String id1)throws Exception;
}
