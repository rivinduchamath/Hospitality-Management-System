package lk.ijse.deppo.hotelManagement.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.dao.CrudUtil;
import lk.ijse.deppo.hotelManagement.dao.custom.BanquetDAO;
import lk.ijse.deppo.hotelManagement.entity.Banquet;
import lk.ijse.deppo.hotelManagement.entity.Reservation;
import lk.ijse.deppo.hotelManagement.util.BanquetTM;

import java.sql.ResultSet;
import java.util.List;

public class BanquetDAOImpl implements BanquetDAO {

    @Override
    public Banquet find(String key) throws Exception {
        return null;
    }

    @Override
    public List<Reservation> findAll() throws Exception {
        return null;
    }

    @Override
    public boolean save(Banquet entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Banquet entity) throws Exception {
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
