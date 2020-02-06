package lk.ijse.deppo.hotelManagement.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.dao.CrudDAO;
import lk.ijse.deppo.hotelManagement.dto.UserDTO;
import lk.ijse.deppo.hotelManagement.entity.User;
import lk.ijse.deppo.hotelManagement.util.UserTM;

public interface UserDAO extends CrudDAO<User, String> {
    String loadUsersLogin(String name, String passowrd) throws Exception;

    ObservableList<UserTM> loadAll(ObservableList<UserTM> items) throws Exception;

    void saveUser(UserDTO newUser)throws Exception;

    String getManager()throws Exception;
}
