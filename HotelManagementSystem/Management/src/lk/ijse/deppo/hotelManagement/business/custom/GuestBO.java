package lk.ijse.deppo.hotelManagement.business.custom;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.business.SuperBO;
import lk.ijse.deppo.hotelManagement.dto.GuestDTO;
import lk.ijse.deppo.hotelManagement.util.EditReservationTM;
import lk.ijse.deppo.hotelManagement.util.GuestControllerTM;


public interface GuestBO extends SuperBO {

    void submitReserVation2(String id, String typeCombo, String txtGuestName, String txtGuestEmail, String txtGuestAddress, String txtPlateNo, String txtTotal, String lblReservationId, String lblCurrentDate, String comboCurrency, String txtDiscount, String txtSubTotal, String total, String submittedBy , ObservableList<GuestControllerTM> items) throws Exception;

    String findMenuID(String menu) throws Exception;

    String getAll()throws Exception;

    void loadFandBCustomers(ObservableList<EditReservationTM> items) throws Exception;

    GuestDTO findCustomer(String id) throws Exception;

    double getGestTotal(double t, String text) throws Exception;

    void updateGuestTotal(double tt, String text)throws Exception;

    void deleteTotal(String guestId) throws Exception;

    double getGuestTota(double dd, String text) throws Exception;
}
