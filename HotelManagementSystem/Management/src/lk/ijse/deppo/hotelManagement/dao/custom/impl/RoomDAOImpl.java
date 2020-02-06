package lk.ijse.deppo.hotelManagement.dao.custom.impl;

import lk.ijse.deppo.hotelManagement.dao.CrudUtil;
import lk.ijse.deppo.hotelManagement.dao.custom.RoomDAO;
import lk.ijse.deppo.hotelManagement.db.DBConnection;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.entity.Reservation;
import lk.ijse.deppo.hotelManagement.entity.Room;
import lk.ijse.deppo.hotelManagement.util.HouseKeepingTM;
import lk.ijse.deppo.hotelManagement.util.RoomSelectTM;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {


    @Override
    public  boolean  loadAllRoomIDCombo(ObservableList<String> room) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT `no` FROM room");
        while (rst.next()) {
            String ids = rst.getString("no");
            room.add(ids);
        }
        return false; }


    @Override
    public boolean saveRoom(HouseKeepingTM newRoom) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO room VALUES (?,?,?,?,?,?,?,?)");
        pstm.setObject(1, newRoom.getNo());
        pstm.setObject(2, newRoom.getType());
        pstm.setObject(3, newRoom.getPrice());
        pstm.setObject(4, newRoom.getCategory());
        pstm.setObject(5, newRoom.getState());
        pstm.setObject(6, newRoom.getCleanby());
        pstm.setObject(7, newRoom.getDate());
        pstm.setObject(8, newRoom.isAvilable());
        System.out.println("5");
        return (pstm.executeUpdate() > 0);
    }
    @Override
    public boolean loadAllRoom(ObservableList<HouseKeepingTM> rooms)throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM room");

        rooms.clear();

        while (rst.next()) {
            rooms.add(new HouseKeepingTM(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getBoolean(8)
                  ));
        }
        return false;
    }

    @Override
    public String loadAllRoomNO(String selectedItem) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement getMenuId = connection.prepareStatement("SELECT type FROM  room where `no` = ?");
        getMenuId.setObject(1, selectedItem);
        ResultSet rst = getMenuId.executeQuery();
        while (rst.next()) {
            selectedItem = rst.getString("type");
        }
        return selectedItem;
    }

    @Override
    public String loadAllRoomN1(String selectedItem) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement getMenuId = connection.prepareStatement("SELECT catogry FROM  room where `no` = ?");
        getMenuId.setObject(1, selectedItem);
        ResultSet rst = getMenuId.executeQuery();
        while (rst.next()) {
            selectedItem = rst.getString("catogry");
        }
        return selectedItem;
    }
    @Override
    public String loadAllRoomN2(String selectedItem) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement getMenuId = connection.prepareStatement("SELECT state FROM  room where `no` = ?");
        getMenuId.setObject(1, selectedItem);
        ResultSet rst = getMenuId.executeQuery();
        while (rst.next()) {
            selectedItem = rst.getString("state");
        }
        return selectedItem;
    }
    @Override
    public String loadAllRoomN3(String selectedItem) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement getMenuId = connection.prepareStatement("SELECT price FROM  room where `no` = ?");
        getMenuId.setObject(1, selectedItem);
        ResultSet rst = getMenuId.executeQuery();
        while (rst.next()) {
            selectedItem = rst.getString("price");
        }
        return selectedItem;
    }
    @Override
    public boolean loadAllRooms(ObservableList<RoomSelectTM> items) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT `no`,`type`,price,state FROM room");

        items.clear();

        while (rst.next()) {
            items.add(new RoomSelectTM(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getString(4)
            ));
        }
        return false;

}
    @Override
    public  boolean updateRoomPrice(String no, String text) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE room SET price=? WHERE `no`=?");
        pstm.setObject(2, no);
        pstm.setObject(1, text);

        return (pstm.executeUpdate() > 0);
    }
    @Override
    public double menuPrice(double price) throws Exception {
        Date date = Date.valueOf((LocalDate.now()));
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pre = connection.prepareStatement("SELECT total FROM reservation where `date` = ?");

        pre.setObject(1, date);
        ResultSet rst = pre.executeQuery();
        if (rst.next()) {
            price = rst.getDouble("total");
        }

        return price;
    }
    @Override
    public double menuPrice2(double price) throws Exception {
        Calendar cal  = Calendar.getInstance();
        //subtracting a day
        cal.add(Calendar.DATE, -1);

        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
        String result = s1.format(new Date(cal.getTimeInMillis()));

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pre = connection.prepareStatement("SELECT total FROM reservation where `date` = ?");

        pre.setObject(1, result);
        ResultSet rst = pre.executeQuery();
        if (rst.next()) {
            price = rst.getDouble("total");
        }

        return price;
    }
    @Override
    public boolean updateAvilability(boolean available, String roomNo) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE room SET avilability=? WHERE `no`=?");
        pstm.setObject(2, roomNo);
        pstm.setObject(1, available);

        return (pstm.executeUpdate() > 0);
    }
    @Override
    public boolean checkAvilability(boolean available, String roo) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement getMenuId = connection.prepareStatement("SELECT avilability FROM  room where `no` = ?");
        getMenuId.setObject(1, roo);
        ResultSet rst = getMenuId.executeQuery();
        while (rst.next()) {
            available = rst.getBoolean("avilability");
        }
        return available;
    }

    @Override
    public boolean loadAllRooms2(ObservableList<RoomSelectTM> items) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT `no`,`type`,price,state,clean FROM room");

        items.clear();

        while (rst.next()) {
            items.add(new RoomSelectTM(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getString(4),
                    rst.getString(5)
            ));
        }
        return false;
    }

    @Override
    public boolean updateRoomAvilability(String roomNo) throws Exception {
        return CrudUtil.execute("UPDATE room SET avilability=1 WHERE `no`=?",roomNo);
    }

    @Override
    public boolean udateNew(String roomId, String roocatogery, String type, String state, String name, Date date1) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE room SET `no`=?,type=?,catogry=?,state=?,clean=?,date=? WHERE `no`=?");
        pstm.setObject(1, roomId);
        pstm.setObject(2, type);
        pstm.setObject(3, roocatogery);
        pstm.setObject(4, state);
        pstm.setObject(5, name);
        pstm.setObject(6, date1);
        pstm.setObject(7, roomId);
        return (pstm.executeUpdate() > 0);
    }

    @Override
    public String getLast() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT `no` FROM room ORDER BY `no` DESC LIMIT 1");
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }

    @Override
    public boolean updateState(String roomId) throws Exception {
        return CrudUtil.execute("UPDATE room SET state = 'Not Clean' WHERE `no`=?",roomId);
    }

    @Override
    public Room find(String key) throws Exception {
        return null;
    }

    @Override
    public List<Reservation> findAll() throws Exception {
        return null;
    }

    @Override
    public boolean save(Room entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Room entity) throws Exception {
        java.sql.Date d = Date.valueOf(LocalDate.now());
        return CrudUtil.execute("UPDATE room SET type=?, price=?,catogry=?,state=?,clean=?,date= ?,avilability=? WHERE `no`=?", entity.getType(), entity.getPrice(),entity.getCatogry(),entity.getState(),entity.getClean(),d,true,entity.getNo());
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE FROM room WHERE `no`=?", key);
    }

    @Override
    public boolean delete2(String key) throws Exception {
        return false;
    }
}
