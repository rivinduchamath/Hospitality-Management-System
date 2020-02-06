package lk.ijse.deppo.hotelManagement.business.custom;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.business.SuperBO;
import lk.ijse.deppo.hotelManagement.dto.ReservationDTO;
import lk.ijse.deppo.hotelManagement.util.EditReservationTM;

import java.util.List;

public interface ReservationBO extends SuperBO {
    void deleteReservations(String res)throws Exception;
    List<ReservationDTO> findAllReservation() throws Exception;

    void loadAll(ObservableList<EditReservationTM> items, String orderID) throws Exception;
}
