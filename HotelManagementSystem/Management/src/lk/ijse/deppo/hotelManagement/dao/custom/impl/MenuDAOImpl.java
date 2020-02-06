package lk.ijse.deppo.hotelManagement.dao.custom.impl;

import lk.ijse.deppo.hotelManagement.dao.CrudUtil;
import lk.ijse.deppo.hotelManagement.dao.custom.MenuDAO;
import lk.ijse.deppo.hotelManagement.db.DBConnection;
import lk.ijse.deppo.hotelManagement.dto.MenuDTO;
import lk.ijse.deppo.hotelManagement.entity.Menu;
import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.entity.Reservation;
import lk.ijse.deppo.hotelManagement.util.MenuTM;

import java.sql.*;
import java.util.List;

public class MenuDAOImpl implements MenuDAO {

    @Override
    public boolean loadAllMenu(ObservableList<MenuTM> menu) throws Exception {
        Connection connection =DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM menu");

        menu.clear();

        while (rst.next()) {
            menu.add(new MenuTM(rst.getString(1),
                    rst.getDouble(2),
                    rst.getString(3),
                    rst.getInt(4)));
        }
        return false;
    }


    @Override
    public boolean updateMenu(MenuTM menuTM) {
        return false;
    }

    @Override
    public boolean saveMenu(Menu menu) throws Exception {

        Connection connection =DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO menu VALUES (?,?,?,?)");
        pstm.setObject(1, menu.getId());
        pstm.setObject(2, menu.getPrice());
        pstm.setObject(3, menu.getDescription());
        pstm.setObject(4, menu.getQtyOnHand());
        System.out.println("5");
        return (pstm.executeUpdate() > 0);

    }


    @Override
    public String findMenuPrice(Object selectedItem) throws Exception {
        Connection connection =DBConnection.getInstance().getConnection();
        PreparedStatement getMenuId = connection.prepareStatement("SELECT price FROM  menu where description = ?");
        getMenuId.setObject(1, selectedItem);
        ResultSet rst = getMenuId.executeQuery();
        if (rst.next()) {
            selectedItem = rst.getString("price");
        }

        return (String) selectedItem;
    }
    @Override
    public boolean updateRoomPrice(String no, String price1) throws Exception {
        Connection connection =DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE menu SET price=? WHERE `id`=?");
        pstm.setObject(2, no);
        pstm.setObject(1, price1);

        return (pstm.executeUpdate() > 0);
    }

    @Override
    public void saveMenu(MenuDTO menu) throws Exception {
        Connection connection =DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO menu VALUES (?,?,?,?)");
        pstm.setObject(1, menu.getId());
        pstm.setObject(2, menu.getPrice());
        pstm.setObject(3, menu.getDescription());
        pstm.setObject(4, menu.getQty());
        pstm.executeUpdate();
    }

    @Override
    public boolean updateQty(int menuqty, String menu) throws Exception {

        Connection connection =DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE menu SET qtyOnHand=? WHERE `id`=?");
        pstm.setObject(1,( menuqty-1));
        pstm.setObject(2, menu);

        return (pstm.executeUpdate() > 0);
    }

    @Override
    public boolean updateItem(String itemCode, String description, double unitePrice, int qty) throws Exception {
        Connection connection =DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE menu SET `id`=?, price=? ,description=?,qtyOnHand=? WHERE `id`=?");
        pstm.setObject(1,( itemCode));
        pstm.setObject(2, unitePrice);
        pstm.setObject(3, description);
        pstm.setObject(4, qty);
        pstm.setObject(5, itemCode);

        return (pstm.executeUpdate() > 0);
    }

    @Override
    public String getMax() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT id FROM menu ORDER BY id DESC LIMIT 1");
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }

    @Override
    public int getDailyList() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT id FROM reservation");
        int count =0;
        while (rst.next()) {
        count++;
        }
        return count;
    }

    @Override
    public boolean updateMenuQty(String itemCode, int qty) throws Exception {
        Connection connection =DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE menu SET qtyOnHand=? WHERE description=?");
        pstm.setObject(1,( qty));
        pstm.setObject(2, itemCode);
        return (pstm.executeUpdate() > 0);
    }


    @Override
    public Menu find(String key) throws Exception {
        return null;
    }

    @Override
    public List<Reservation> findAll() throws Exception {
        return null;
    }

    @Override
    public boolean save(Menu entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Menu entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE FROM menu WHERE id=?", key);
    }

    @Override
    public boolean delete2(String key) throws Exception {
        return false;
    }
}
