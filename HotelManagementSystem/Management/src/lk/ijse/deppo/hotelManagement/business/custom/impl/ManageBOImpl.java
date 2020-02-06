package lk.ijse.deppo.hotelManagement.business.custom.impl;

import lk.ijse.deppo.hotelManagement.business.custom.ManageBO;
import lk.ijse.deppo.hotelManagement.dao.DAOFactory;
import lk.ijse.deppo.hotelManagement.dao.DAOTypes;
import lk.ijse.deppo.hotelManagement.dao.custom.ManageDAO;
import lk.ijse.deppo.hotelManagement.dao.custom.impl.ManageDAOImpl;

public class ManageBOImpl implements ManageBO {
     ManageDAO manageDAO =
            DAOFactory.getInstance().getDAO
                    (DAOTypes.MANAGE);

    @Override
    public double getCurrency1(String cuusd) throws Exception {
       return Double.parseDouble(manageDAO.getCurrency1(cuusd));

    }

    @Override
    public void updateUSD(double x, String cuusd) throws Exception {
        manageDAO.updateUSD(x,cuusd);
    }
}
