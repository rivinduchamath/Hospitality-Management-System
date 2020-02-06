package lk.ijse.deppo.hotelManagement.dao.custom.impl;

import lk.ijse.deppo.hotelManagement.dao.CrudUtil;
import lk.ijse.deppo.hotelManagement.dao.custom.ReservationDAO;
import lk.ijse.deppo.hotelManagement.entity.Reservation;
import lk.ijse.deppo.hotelManagement.entity.Room;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public Room find(String key) throws Exception {
        return null;
    }

    @Override
    public List<Reservation> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT `id`,guestId,currency,discount,total FROM reservation");
        List<Reservation> reserve = new ArrayList<>();
        while (rst.next()) {
            reserve.add(new Reservation(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getDouble(5)
                    ));
        }
        return reserve;
    }

    @Override
    public boolean save(Room entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Room entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return false;
    }

    @Override
    public boolean delete2(String key) throws Exception {
        return false;
    }
}
