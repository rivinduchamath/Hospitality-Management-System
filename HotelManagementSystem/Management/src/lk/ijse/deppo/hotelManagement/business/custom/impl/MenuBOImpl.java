package lk.ijse.deppo.hotelManagement.business.custom.impl;

import lk.ijse.deppo.hotelManagement.business.custom.MenuBO;
import lk.ijse.deppo.hotelManagement.dao.DAOFactory;
import lk.ijse.deppo.hotelManagement.dao.DAOTypes;
import lk.ijse.deppo.hotelManagement.dao.custom.GuestDAO;
import lk.ijse.deppo.hotelManagement.dao.custom.MenuDAO;
import lk.ijse.deppo.hotelManagement.dao.custom.QueryDAO;
import lk.ijse.deppo.hotelManagement.dao.custom.impl.GuestDAOImpl;
import lk.ijse.deppo.hotelManagement.dao.custom.impl.MenuDAOImpl;
import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.dto.MenuDTO;
import lk.ijse.deppo.hotelManagement.entity.Menu;
import lk.ijse.deppo.hotelManagement.util.MenuTM;

import java.util.ArrayList;
import java.util.List;

public class MenuBOImpl implements MenuBO {
     GuestDAO guest =
            DAOFactory.getInstance().getDAO
                    (DAOTypes.GUEST);
     MenuDAO menuDAOImpl =
            DAOFactory.getInstance().getDAO
                    (DAOTypes.MENU);
     QueryDAO queryDAO =
            DAOFactory.getInstance().getDAO
                    (DAOTypes.QUERY);

    @Override
    public List<MenuDTO> loadAllMenu(ObservableList<MenuTM> items) throws Exception {
        menuDAOImpl.loadAllMenu(items);
        return null;
    }
    @Override
    public  void loadAllMenuItems(ObservableList items) throws Exception {
        guest.loadAllMenuIDCombo(items);
    }

    @Override
    public void saveMenu(MenuDTO newMenu) throws Exception {
        menuDAOImpl.saveMenu(newMenu);

    }



    @Override
    public boolean updateMenu(MenuDTO menuTM) {
        return false;
    }

    @Override
    public String GetMenuPrice(Object selectedItem) throws Exception {
        return menuDAOImpl.findMenuPrice(selectedItem);
    }
    @Override
    public void updateMenuPrice(String no, String price1)throws Exception {
        menuDAOImpl.updateRoomPrice(no,price1);
    }

    @Override
    public String getmenuQty(String menu) throws Exception {
        return guest.getmenuQty(menu);
    }

    @Override
    public void updateQty(int menuqty, String menu) throws Exception {
        menuDAOImpl.updateQty(menuqty,menu);
    }

    @Override
    public void updateItem(String itemCode, String description, double unitePrice, int qty) throws Exception {
        menuDAOImpl.updateItem(itemCode,description,unitePrice,qty);
    }

    @Override
    public String getMax() throws Exception {
       return menuDAOImpl.getMax();
    }

    @Override
    public int getDailyList() throws Exception {
        return menuDAOImpl.getDailyList();
    }

    @Override
    public List<MenuDTO> getGuest() throws Exception {
        List<Menu> alCustomers = queryDAO.findGuest();
        List<MenuDTO> dtos = new ArrayList<>();
        for (Menu menu : alCustomers) {
            dtos.add(new MenuDTO(menu.getRessevationId(), menu.getGuestId(), menu.getMaalID()));
        }
        return dtos;

    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return menuDAOImpl.delete(id);
    }

    @Override
    public boolean updateMenuQty(String itemCode, int qty) throws Exception {
       return menuDAOImpl.updateMenuQty(itemCode,qty);
    }

}
