package lk.ijse.deppo.hotelManagement.dao.custom.impl;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import lk.ijse.deppo.hotelManagement.dao.CrudUtil;
import lk.ijse.deppo.hotelManagement.dao.custom.QueryDAO;
import lk.ijse.deppo.hotelManagement.db.DBConnection;
import lk.ijse.deppo.hotelManagement.entity.Menu;
import lk.ijse.deppo.hotelManagement.util.EditReservationTM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    private static final Object Button = new Button();

    @Override
    public boolean deleteReservations(String res) throws Exception {

        Connection connection =DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE  FROM reservationdata WHERE reservationId=?");
        PreparedStatement pstm1 = connection.prepareStatement("DELETE  FROM reservation WHERE id=?");
        pstm.setObject(1, res);
        pstm1.setObject(1, res);

        pstm.executeUpdate();
        return (pstm1.executeUpdate() > 0);

    }

    @Override
    public boolean loadAll(ObservableList<EditReservationTM> items, String orderID) throws Exception {

        Connection connection =DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT  arivalDate," +
                "depatureDate,ro.type,roomNo,noOfAdults," +
                "noOfChildren,mealID,discount,ro.price,totalPrice from reservationdata " +
                "JOIN reservation r on reservationdata.reservationId = r.id " +
                "JOIN room ro ON reservationdata.roomNo = ro.`no` where reservationId = ?");

        pstm.setString(1, orderID);
        ResultSet rst = pstm.executeQuery();
        items.clear();

        while (rst.next()) {

            Date aerivalDate = rst.getDate("arivalDate");
            Date depatureDate = rst.getDate("depatureDate");
            String roomType = rst.getString("type");
            String roomNo = rst.getString("roomNo");
            int adults = rst.getInt("noOfAdults");
            int noOfChildren = rst.getInt("noOfChildren");
            String menu = rst.getString("mealID");
            double discount = rst.getDouble("discount");
            double ratePrice = rst.getDouble("price");
            double subtotal = rst.getDouble("totalPrice");
            items.add(new EditReservationTM(aerivalDate, depatureDate, roomType,
                    roomNo, adults, noOfChildren, menu, discount, ratePrice, subtotal));
        }
        return false;

    }


        @Override
        public boolean loadFandBCustomers(ObservableList<EditReservationTM> items) throws Exception {
            Connection connection =DBConnection.getInstance().getConnection();
            PreparedStatement getReservationId = connection.prepareStatement("SELECT guestId,name FROM reservation join guest g on reservation.guestId = g.id ORDER BY reservation.id DESC ");
            ResultSet rst = getReservationId.executeQuery();
            items.clear();

            while (rst.next()) {
                items.add(new EditReservationTM(rst.getString(1),
                        rst.getString(2)
                ));
            }
            return false;
        }

    @Override
    public List<Menu> findGuest() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT reservationId,guestId,mealID FROM reservation join reservationdata r on reservation.id = r.reservationId");
        List<Menu> customers = new ArrayList<>();
        while (rst.next()) {
            customers.add(new Menu(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
                    ));
        }
        return customers;
    }

}
