package lk.ijse.deppo.hotelManagement.business.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.business.custom.ReservationBO;
import lk.ijse.deppo.hotelManagement.dao.DAOFactory;
import lk.ijse.deppo.hotelManagement.dao.DAOTypes;
import lk.ijse.deppo.hotelManagement.dao.custom.QueryDAO;
import lk.ijse.deppo.hotelManagement.dao.custom.ReservationDAO;
import lk.ijse.deppo.hotelManagement.dao.custom.impl.QueryDAOImpl;
import lk.ijse.deppo.hotelManagement.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.deppo.hotelManagement.dto.ReservationDTO;
import lk.ijse.deppo.hotelManagement.entity.Reservation;
import lk.ijse.deppo.hotelManagement.util.EditReservationTM;

import java.util.ArrayList;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {

    private QueryDAO qreservationDAO =
            DAOFactory.getInstance().getDAO
                    (DAOTypes.QUERY);
    private ReservationDAO reservationDAO =
            DAOFactory.getInstance().getDAO
                    (DAOTypes.RESERVATION);
    @Override
    public void deleteReservations(String res)throws Exception {
        qreservationDAO.deleteReservations(res);
    }

    @Override
    public List<ReservationDTO> findAllReservation() throws Exception {
        List<Reservation> alreservations = reservationDAO.findAll();
        List<ReservationDTO> dtos = new ArrayList<>();
        for (Reservation customer : alreservations) {
            dtos.add(new ReservationDTO(customer.getId(), customer.getGuestId(), customer.getCurrency(),customer.getDiscount(),customer.getTotal()));
        }
        return dtos;
    }

    @Override
    public void loadAll(ObservableList<EditReservationTM> items, String orderID) throws Exception {
        qreservationDAO.loadAll(items,orderID);
    }

}
