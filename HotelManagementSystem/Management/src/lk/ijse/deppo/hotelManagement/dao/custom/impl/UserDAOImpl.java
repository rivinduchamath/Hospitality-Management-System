package lk.ijse.deppo.hotelManagement.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.dao.CrudUtil;
import lk.ijse.deppo.hotelManagement.dao.custom.UserDAO;
import lk.ijse.deppo.hotelManagement.db.DBConnection;
import lk.ijse.deppo.hotelManagement.dto.UserDTO;
import lk.ijse.deppo.hotelManagement.entity.Reservation;
import lk.ijse.deppo.hotelManagement.entity.User;
import lk.ijse.deppo.hotelManagement.util.UserTM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public String loadUsersLogin(String name, String passowrd) throws Exception {

        ResultSet rst = CrudUtil.execute("SELECT password FROM user where name = ?",name);
        String passowr = null;
        if (rst.next()) {
            passowr = rst.getString("password");
        }

        return passowr;

    }

    @Override
    public ObservableList<UserTM> loadAll(ObservableList<UserTM> items) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT id,name,post,password,age,`date` FROM user");
        String passowr = null;
        while (rst.next()) {
            items.add(new User(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getInt(5),
                    rst.getDate(6)
            ));
        }
        return items;

    }

    @Override
    public void saveUser(UserDTO newUser) throws Exception {

    }

    @Override
    public String getManager() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT password FROM user where post=?","Manager");
        if (rst.next()) {
           return rst.getString("password");
        }

        return null;
    }

    @Override
    public User find(String key) throws Exception {
        return null;
    }

    @Override
    public List<Reservation> findAll() throws Exception {
        return null;
    }

    @Override
    public boolean save(User entity) throws Exception {
        return CrudUtil.execute("INSERT INTO user VALUES (?,?,?,?,?,?)",entity.getId(), entity.getName(), entity.getPost(),entity.getPassword(),entity.getAge(),entity.getDate());
    }

    @Override
    public boolean update(User entity) throws Exception {
        return CrudUtil.execute("UPDATE user SET name=?, post=?,password =?,age=?,date=? WHERE id=?", entity.getName(), entity.getPost(),entity.getPassword(),entity.getAge(),entity.getDate(),entity.getId());
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE FROM user WHERE id=?", key);
    }

    @Override
    public boolean delete2(String key) throws Exception {
        return false;
    }
}
