package lk.ijse.deppo.hotelManagement.business.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.business.custom.UserBO;
import lk.ijse.deppo.hotelManagement.dao.DAOFactory;
import lk.ijse.deppo.hotelManagement.dao.DAOTypes;
import lk.ijse.deppo.hotelManagement.dao.custom.UserDAO;
import lk.ijse.deppo.hotelManagement.dao.custom.impl.UserDAOImpl;
import lk.ijse.deppo.hotelManagement.dto.UserDTO;
import lk.ijse.deppo.hotelManagement.entity.User;
import lk.ijse.deppo.hotelManagement.util.UserTM;


public class UserBOImpl implements UserBO {
    private UserDAO userDAO = DAOFactory.getInstance().getDAO
                    (DAOTypes.USER);
    @Override
    public String loadUsersLogin(String name, String passowrd) throws Exception {
       return userDAO.loadUsersLogin(name,passowrd);
    }

    @Override
    public void loadAll(ObservableList<UserTM> items) throws Exception {
        userDAO.loadAll(items);
    }

    @Override
    public boolean saveUser(UserDTO newUser) throws Exception {
        return userDAO.save(new User(newUser.getId(), newUser.getName(), newUser.getPost(),newUser.getPassword(),newUser.getAge(),newUser.getDate()));
    }

    @Override
    public boolean updateCustomer(UserDTO userDTO) throws Exception {
        return userDAO.update(new User(userDTO.getId(), userDTO.getName(), userDTO.getPost(),userDTO.getPassword(),userDTO.getAge(),userDTO.getDate()));
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return userDAO.delete(id);
    }

    @Override
    public String getManager() throws Exception {
        return userDAO.getManager();
    }
}
