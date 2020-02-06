package lk.ijse.deppo.hotelManagement.business.custom.impl;

import lk.ijse.deppo.hotelManagement.business.custom.GuestBO;
import lk.ijse.deppo.hotelManagement.dao.DAOFactory;
import lk.ijse.deppo.hotelManagement.dao.DAOTypes;
import lk.ijse.deppo.hotelManagement.dao.custom.GuestDAO;
import lk.ijse.deppo.hotelManagement.dao.custom.QueryDAO;
import lk.ijse.deppo.hotelManagement.dao.custom.impl.GuestDAOImpl;
import lk.ijse.deppo.hotelManagement.dto.GuestDTO;
import lk.ijse.deppo.hotelManagement.entity.Guest;
import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.util.EditReservationTM;
import lk.ijse.deppo.hotelManagement.util.GuestControllerTM;

public class GuestBOImpl implements GuestBO {

     GuestDAO guestDAOImpl =
            DAOFactory.getInstance().getDAO
                    (DAOTypes.GUEST);
     QueryDAO queryDAO =
            DAOFactory.getInstance().getDAO
                    (DAOTypes.QUERY);

    @Override
    public void submitReserVation2(String id, String typeCombo, String txtGuestName, String txtGuestEmail, String txtGuestAddress, String txtPlateNo, String txtTotal, String lblReservationId, String lblCurrentDate, String comboCurrency, String txtDiscount, String txtSubTotal, String total, String submittedBy, ObservableList<GuestControllerTM> items) throws Exception {
        guestDAOImpl.submitReserVation(id,typeCombo,txtGuestName,txtGuestEmail,txtGuestAddress,txtPlateNo,txtTotal,lblReservationId,lblCurrentDate,comboCurrency,txtDiscount,txtSubTotal,total,submittedBy,items);
    }
    @Override
    public String findMenuID(String menu) throws Exception {
        return guestDAOImpl.findID(menu);
    }
    @Override
    public String getAll()throws Exception {
        return guestDAOImpl.getAll();
    }
    @Override
    public void loadFandBCustomers(ObservableList<EditReservationTM> items) throws Exception {
        queryDAO.loadFandBCustomers(items);
    }
    @Override
    public GuestDTO findCustomer(String id) throws Exception {
        Guest customer = guestDAOImpl.find(id);
        if (customer != null) {
            return new GuestDTO(
                    customer.getId(),
                    customer.getIdType(),
                    customer.getGuestName(),
                    customer.getCountry(),
                    customer.getEmail(),
                    customer.getVehicle(),
                    customer.getTotal()

            );
        }
        return null;

    }

    @Override
    public double getGestTotal(double t, String text) throws Exception{
           return guestDAOImpl.getGestTotal(t,text);
     }
    @Override
    public void updateGuestTotal(double tt, String text)throws Exception {
        guestDAOImpl.updateGuestTotal(tt,text);
    }

    @Override
    public void deleteTotal(String guestId) throws Exception {
        guestDAOImpl.deleteTotal(guestId);
    }

    @Override
    public double getGuestTota(double dd, String text) throws Exception {
        return guestDAOImpl.getGestTotal(dd,text);
    }


}
