package lk.ijse.deppo.hotelManagement.business.custom;

import lk.ijse.deppo.hotelManagement.business.SuperBO;

public interface ManageBO extends SuperBO {
    double getCurrency1(String cuusd)throws Exception;


    void updateUSD(double x, String cuusd)throws Exception;
}
