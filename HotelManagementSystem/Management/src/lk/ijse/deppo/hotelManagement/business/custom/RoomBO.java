package lk.ijse.deppo.hotelManagement.business.custom;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.business.SuperBO;
import lk.ijse.deppo.hotelManagement.dto.RoomDTO;
import lk.ijse.deppo.hotelManagement.util.HouseKeepingTM;
import lk.ijse.deppo.hotelManagement.util.RoomSelectTM;

public interface RoomBO extends SuperBO {
    void loadAllRoomIDCombo(ObservableList<String> room)throws Exception;

    void saveMenu(HouseKeepingTM newRoom) throws Exception;

    void loadAllRoom(ObservableList<HouseKeepingTM> rooms) throws  Exception;

    String loadAllRoomNO(String select)throws Exception;

    String loadAllRoomN1(String selectedItem)throws Exception;

    String loadAllRoomN2(String selectedItem) throws Exception;

    String loadAllRoomN3(String selectedItem) throws Exception;

    void loadAlRooms(ObservableList<RoomSelectTM> items) throws Exception;

    void updateRoom(String no, String text) throws Exception;

    double updateMenuPrice(double price)throws Exception;

    double updateMenuPrice2(double price)throws Exception;

    void updateAvilability(boolean available, String roomNo) throws Exception;

    boolean checkAvilability(boolean available, String roo)throws Exception;

    void loadAllRooms2(ObservableList<RoomSelectTM> items) throws Exception;

    void updateRoomAvilability(String reservationId)throws Exception;

    void updateRoom2(String roomId, String roocatogery, String type, String state, String name, String date1)throws Exception;

    String getLast()throws Exception;

    boolean updateCustomer(RoomDTO roomDTO)throws Exception;

    boolean deleteCustomer(String no)throws Exception;

    boolean updateState(String roomId)throws Exception;
}
