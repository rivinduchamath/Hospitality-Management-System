package lk.ijse.deppo.hotelManagement.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.dao.CrudDAO;
import lk.ijse.deppo.hotelManagement.dto.MenuDTO;
import lk.ijse.deppo.hotelManagement.entity.Menu;
import lk.ijse.deppo.hotelManagement.util.MenuTM;

import java.util.List;

public interface MenuDAO extends CrudDAO<Menu, String> {
    boolean loadAllMenu(ObservableList<MenuTM> menu) throws Exception;

    boolean updateMenu(MenuTM menuTM);

    boolean saveMenu(Menu menu) throws Exception;

    String findMenuPrice(Object selectedItem) throws Exception;

    boolean updateRoomPrice(String no, String price1) throws Exception;

    void saveMenu(MenuDTO menu) throws Exception;


    boolean updateQty(int menuqty, String menu) throws Exception;

    boolean updateItem(String itemCode, String description, double unitePrice, int qty)throws Exception;

    String getMax()throws Exception;

    int getDailyList()throws Exception;


    boolean updateMenuQty(String itemCode, int qty)throws Exception;
}
