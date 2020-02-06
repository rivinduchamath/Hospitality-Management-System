package lk.ijse.deppo.hotelManagement.business.custom;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.business.SuperBO;
import lk.ijse.deppo.hotelManagement.dto.MenuDTO;
import lk.ijse.deppo.hotelManagement.util.MenuTM;

import java.util.List;

public interface MenuBO extends SuperBO {
    List<MenuDTO> loadAllMenu(ObservableList<MenuTM> items) throws Exception;

    void loadAllMenuItems(ObservableList items) throws Exception;



    void saveMenu(MenuDTO newMenu)throws  Exception;

    boolean updateMenu(MenuDTO menuDTO);

    String GetMenuPrice(Object selectedItem) throws Exception;

    void updateMenuPrice(String no, String price1)throws Exception;

    String getmenuQty(String menu) throws Exception;

    void updateQty(int menuqty, String menu) throws Exception;

    void updateItem(String itemCode, String description, double unitePrice, int qty)throws Exception;

    String getMax()throws Exception;

    int getDailyList()throws Exception;

    List<MenuDTO> getGuest()throws Exception;

    boolean deleteCustomer(String id)throws Exception;

    boolean updateMenuQty(String itemCode, int qty)throws Exception;
}
