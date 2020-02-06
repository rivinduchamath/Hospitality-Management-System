package lk.ijse.deppo.hotelManagement.dao.custom.impl;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import lk.ijse.deppo.hotelManagement.dao.CrudUtil;
import lk.ijse.deppo.hotelManagement.dao.custom.GuestDAO;
import lk.ijse.deppo.hotelManagement.db.DBConnection;
import lk.ijse.deppo.hotelManagement.entity.Guest;
import lk.ijse.deppo.hotelManagement.entity.Reservation;
import lk.ijse.deppo.hotelManagement.util.EditReservationTM;
import lk.ijse.deppo.hotelManagement.util.GuestControllerTM;

import java.sql.*;
import java.util.List;

public class GuestDAOImpl implements GuestDAO {


    //Get All MenuController Description
    @Override
    public void loadAllMenuIDCombo(ObservableList menu) throws Exception {
        ResultSet rst =CrudUtil.execute("SELECT description FROM menu");
        while (rst.next()) {
            String ids = rst.getString("description");
            menu.add(ids);
        }
    }

    @Override
    public void submitReserVation(String id, String typeCombo, String txtGuestName, String txtGuestEmail, String txtGuestAddress, String txtPlateNo, String txtTotal, String lblReservationId, String lblCurrentDate, String comboCurrency, String txtDiscount, String txtSubTotal, String total, String submittedBy,ObservableList<GuestControllerTM> items) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        String sql = "INSERT IGNORE INTO guest VALUES (?,?,?,?,?,?,?)";
        String sql1 = "INSERT INTO reservation VALUES (?,?,?,?,?,?,?)";
        String sql2 = ("INSERT INTO reservationdata VALUES (?,?,?,?,?,?,?,?,?)");

        PreparedStatement pstm = connection.prepareStatement(sql);
        PreparedStatement pstm1 = connection.prepareStatement(sql1);
        PreparedStatement pstm2 = connection.prepareStatement(sql2);

        pstm.setObject(1, id);
        pstm.setObject(2, typeCombo);
        pstm.setObject(3, txtGuestName);
        pstm.setObject(4, txtGuestEmail);
        pstm.setObject(5, txtGuestAddress);
        pstm.setObject(6, txtPlateNo);
        pstm.setObject(7, total);


        pstm1.setObject(1, lblReservationId);
        pstm1.setObject(2, id);
        pstm1.setObject(3, lblCurrentDate);
        pstm1.setObject(4, comboCurrency);
        pstm1.setObject(5, txtDiscount);
        pstm1.setObject(6, txtSubTotal);
        pstm1.setObject(7, total);


        pstm.executeUpdate();
        if (pstm1.executeUpdate() > 0) {

            //Insert data to the ReservationDetails Table
            for (GuestControllerTM item : items) { // While all Reservations
                pstm2.setObject(1, lblReservationId);
                pstm2.setString(2, item.getRoomNo());
                pstm2.setDate(3, Date.valueOf(item.getArrivalDate()));
                pstm2.setDate(4, Date.valueOf(item.getDepartureDate()));
                pstm2.setString(5, item.getMenu());
                pstm2.setInt(6, item.getChildren());
                pstm2.setInt(7, item.getAdult());
                pstm2.setDouble(8, item.getSubTotal());
                pstm2.setString(9, submittedBy);

                if(pstm2.executeUpdate() > 0) {
                    //updateQty(items.getCode(), items.getQty());
                }
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to save").show();
        }
    }

    //Getting Meal Id From Meal Description
    @Override
    public String findID(String menu) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        ResultSet rst =CrudUtil.execute("SELECT id FROM  menu where description = ?",menu);

        if (rst.next()) {
            menu = rst.getString("id");
        }
        return menu;
    }


    //Getting Reservation ID
    @Override
    public String getAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT id FROM reservation ORDER BY id DESC LIMIT 1");
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }

    //Load Guest For Food And beverage Table


    @Override
    public Guest find(String id) throws Exception {
        Connection connection =DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * from guest where id = ? ");
        pstm.setObject(1, id);
        ResultSet rst = pstm.executeQuery();

        if (rst.next()) {
            return new Guest(
                    rst.getString("id"),
                    rst.getString("idType"),
                    rst.getString("name"),
                    rst.getString("country"),
                    rst.getString("email"),
                    rst.getString("noPlate"),
                    rst.getString("total")
            );

        }

        return null;
    }

    @Override
    public boolean deleteTotal(String guestId) throws Exception {
        Connection connection =DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE guest SET total=0 WHERE `id`=?");

        pstm.setObject(1, guestId);

        return (pstm.executeUpdate() > 0);

    }

    @Override
    public List<Reservation> findAll() throws Exception {
        return null;
    }

    @Override
    public boolean save(Guest entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Guest entity) throws Exception {
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

    @Override
    public double getGestTotal(double t, String text) throws Exception {
        Connection connection =DBConnection.getInstance().getConnection();
        PreparedStatement getMenuId = connection.prepareStatement("SELECT total FROM  guest where id = ?");
        getMenuId.setObject(1, text);
        ResultSet rst = getMenuId.executeQuery();
        if (rst.next()) {
            t = rst.getDouble("total");
        }
        return t;
    }

    @Override
    public boolean updateGuestTotal(double tt, String text) throws Exception {
        Connection connection =DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE guest SET total=? WHERE `id`=?");
        pstm.setObject(2, text);
        pstm.setObject(1, tt);

        return (pstm.executeUpdate() > 0);
    }

    @Override
    public String getmenuQty(String menu) throws Exception {
        Connection connection =DBConnection.getInstance().getConnection();
        PreparedStatement getMenuId = connection.prepareStatement("SELECT qtyOnHand FROM  menu where description = ?");
        getMenuId.setObject(1, menu);
        ResultSet rst = getMenuId.executeQuery();
        if (rst.next()) {
            menu = String.valueOf(rst.getInt("qtyOnHand"));
        }
        return menu;
    }
}
