package lk.ijse.deppo.hotelManagement.dao.custom.impl;

import lk.ijse.deppo.hotelManagement.dao.custom.ManageDAO;
import lk.ijse.deppo.hotelManagement.db.DBConnection;
import lk.ijse.deppo.hotelManagement.entity.Manage;
import lk.ijse.deppo.hotelManagement.entity.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ManageDAOImpl implements ManageDAO {

    @Override
    public String getCurrency1(String cuusd) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement getMenuId = connection.prepareStatement("SELECT price FROM  manage where currency = ?");
        getMenuId.setObject(1, cuusd);
        ResultSet rst = getMenuId.executeQuery();
        if (rst.next()) {
            cuusd = String.valueOf(rst.getDouble("price"));
        }

        return  cuusd;

}

    @Override
    public boolean updateUSD(double x, String cuusd) throws Exception {

        Connection connection =DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE manage SET price=? WHERE currency=?");

        pstm.setObject(1, x);
        pstm.setObject(2, cuusd);

        return (pstm.executeUpdate() > 0);
    }

    @Override
    public Manage find(String key) throws Exception {
        return null;
    }

    @Override
    public List<Reservation> findAll() throws Exception {
        return null;
    }

    @Override
    public boolean save(Manage entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Manage entity) throws Exception {
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
