package lk.ijse.deppo.hotelManagement.dao.custom;

import lk.ijse.deppo.hotelManagement.dao.CrudDAO;
import lk.ijse.deppo.hotelManagement.entity.Manage;

public interface ManageDAO extends CrudDAO<Manage, String> {
    String getCurrency1(String cuusd)throws Exception;

    boolean updateUSD(double x, String cuusd)throws Exception;
}
