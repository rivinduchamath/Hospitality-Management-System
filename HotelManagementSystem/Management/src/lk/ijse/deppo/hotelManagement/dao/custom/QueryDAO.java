package lk.ijse.deppo.hotelManagement.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.dao.SuperDAO;
import lk.ijse.deppo.hotelManagement.entity.Banquet;
import lk.ijse.deppo.hotelManagement.entity.Menu;
import lk.ijse.deppo.hotelManagement.util.EditReservationTM;

import java.util.List;

public interface QueryDAO extends SuperDAO {
    boolean deleteReservations(String res) throws Exception;

    boolean loadAll(ObservableList<EditReservationTM> items, String orderID) throws Exception;

    boolean loadFandBCustomers(ObservableList<EditReservationTM> items)throws Exception;

    List<Menu> findGuest()throws Exception;

}
