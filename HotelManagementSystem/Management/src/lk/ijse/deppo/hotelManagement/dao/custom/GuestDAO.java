package lk.ijse.deppo.hotelManagement.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.dao.CrudDAO;
import lk.ijse.deppo.hotelManagement.entity.Guest;
import lk.ijse.deppo.hotelManagement.util.EditReservationTM;
import lk.ijse.deppo.hotelManagement.util.GuestControllerTM;

public interface GuestDAO extends CrudDAO<Guest, String> {
    String getmenuQty(String menu) throws Exception;
    boolean updateGuestTotal(double tt, String text) throws Exception;
    double getGestTotal(double t, String text) throws Exception;

    //Get All MenuController Description
    void loadAllMenuIDCombo(ObservableList menu) throws Exception;

    void submitReserVation(String id, String typeCombo, String txtGuestName, String txtGuestEmail, String txtGuestAddress, String txtPlateNo, String txtTotal, String lblReservationId, String lblCurrentDate, String comboCurrency, String txtDiscount, String txtSubTotal, String total,String submittedBy, ObservableList<GuestControllerTM> items) throws Exception;

    //Getting Meal Id From Meal Description
    String findID(String menu) throws Exception;

    //Getting Reservation ID
    String getAll() throws Exception;



    Guest find(String id) throws Exception;

    boolean deleteTotal(String guestId) throws Exception;
}
