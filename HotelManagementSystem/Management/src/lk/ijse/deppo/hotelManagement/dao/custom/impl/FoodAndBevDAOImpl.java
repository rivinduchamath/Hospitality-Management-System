package lk.ijse.deppo.hotelManagement.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.dao.CrudUtil;
import lk.ijse.deppo.hotelManagement.dao.custom.FoodAndBevDAO;
import lk.ijse.deppo.hotelManagement.entity.FoodAndBev;
import lk.ijse.deppo.hotelManagement.entity.Reservation;
import lk.ijse.deppo.hotelManagement.util.FoodAndBrvTM;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public class FoodAndBevDAOImpl implements FoodAndBevDAO {
    @Override
    public String getAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT orderid FROM foodandbev ORDER BY orderid DESC LIMIT 1");
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }
    @Override
    public void placeOrder(String orderId, String customerId, ObservableList<FoodAndBrvTM> menu, String tot) throws Exception {
        Date date = Date.valueOf((LocalDate.now()));
         CrudUtil.execute("INSERT INTO foodandbev VALUES (?,?,?,?)",customerId,tot,orderId,date);
            for (FoodAndBev item : menu) {
                CrudUtil.execute("INSERT INTO foodandbevdata VALUES (?,?,?,?,?)",customerId,item.getItemId(),item.getDescription(),item.getOrderQty(),item.getUnitePrice());
        }

    }
    @Override
    public double menuPrice(double price) throws Exception {
        Date date = Date.valueOf((LocalDate.now()));
        ResultSet rst = CrudUtil.execute("SELECT total FROM foodandbev where today = ?",date);
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

        ResultSet rst = CrudUtil.execute("SELECT total FROM foodandbev where today = ?",result);
        if (rst.next()) {
            price = rst.getDouble("total");
        }

        return price;
    }

    @Override
    public double getPrice(String id1) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT total FROM foodandbev where cusId = ?",id1);
        if (rst.next()) {
            return  (rst.getDouble("total"));
        }

        return 0;
    }

    @Override
    public FoodAndBev find(String key) throws Exception {
        return null;
    }

    @Override
    public List<Reservation> findAll() throws Exception {
        return null;
    }

    @Override
    public boolean save(FoodAndBev entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(FoodAndBev entity) throws Exception {
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
