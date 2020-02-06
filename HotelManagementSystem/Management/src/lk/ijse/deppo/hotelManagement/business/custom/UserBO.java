package lk.ijse.deppo.hotelManagement.business.custom;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.business.SuperBO;
import lk.ijse.deppo.hotelManagement.dto.UserDTO;
import lk.ijse.deppo.hotelManagement.util.UserTM;

public interface UserBO extends SuperBO {
      String loadUsersLogin(String name, String passowrd)throws Exception;

      void loadAll(ObservableList<UserTM> items) throws Exception;

      boolean saveUser(UserDTO newUser)throws Exception;

      boolean updateCustomer(UserDTO userDTO) throws Exception;

      boolean deleteCustomer(String id)throws Exception;

    String getManager() throws Exception;
}
