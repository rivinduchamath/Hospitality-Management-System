package lk.ijse.deppo.hotelManagement.business.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.business.custom.FoodAndBevBO;
import lk.ijse.deppo.hotelManagement.dao.DAOFactory;
import lk.ijse.deppo.hotelManagement.dao.DAOTypes;
import lk.ijse.deppo.hotelManagement.dao.custom.FoodAndBevDAO;
import lk.ijse.deppo.hotelManagement.util.FoodAndBrvTM;

public class FoodAndBevBOImpl implements FoodAndBevBO {


     private FoodAndBevDAO foodandbevDAOImpl = DAOFactory.getInstance().getDAO(DAOTypes.FOOD);

    @Override
    public String getAll() throws Exception {
        return foodandbevDAOImpl.getAll();
    }
    @Override
    public void placeOrder(String orderId, String customerId, String text, ObservableList<FoodAndBrvTM> menu) throws Exception {
        foodandbevDAOImpl.placeOrder(orderId, customerId, menu,text);
    }
    @Override
    public double updateMenuPrice(double price) throws Exception {

        double p = foodandbevDAOImpl.menuPrice(price);
        return p;
    }
    @Override
    public double updateMenuPrice2(double price) throws Exception {
        double p = foodandbevDAOImpl.menuPrice2(price);
        return p;
    }

    @Override
    public double getPrice(String id1) throws Exception {
        return foodandbevDAOImpl.getPrice(id1);
    }
}
