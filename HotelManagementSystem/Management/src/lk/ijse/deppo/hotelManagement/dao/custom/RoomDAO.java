package lk.ijse.deppo.hotelManagement.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.dao.CrudDAO;
import lk.ijse.deppo.hotelManagement.entity.Room;
import lk.ijse.deppo.hotelManagement.util.HouseKeepingTM;
import lk.ijse.deppo.hotelManagement.util.RoomSelectTM;
import java.sql.Date;

public interface RoomDAO extends CrudDAO<Room, String> {
    boolean  loadAllRoomIDCombo(ObservableList<String> room) throws Exception;

    boolean saveRoom(HouseKeepingTM newRoom) throws Exception;

    boolean loadAllRoom(ObservableList<HouseKeepingTM> rooms)throws Exception;

    String loadAllRoomNO(String selectedItem) throws Exception;

    String loadAllRoomN1(String selectedItem) throws Exception;

    String loadAllRoomN2(String selectedItem) throws Exception;

    String loadAllRoomN3(String selectedItem) throws Exception;

    boolean loadAllRooms(ObservableList<RoomSelectTM> items) throws Exception;

    boolean updateRoomPrice(String no, String text) throws Exception;

    double menuPrice(double price) throws Exception;

    double menuPrice2(double price) throws Exception;

    boolean updateAvilability(boolean available, String roomNo) throws Exception;

    boolean checkAvilability(boolean available, String roo) throws Exception;

    boolean loadAllRooms2(ObservableList<RoomSelectTM> items) throws Exception;

    boolean updateRoomAvilability(String reservationId)throws Exception;

    boolean udateNew(String roomId, String roocatogery, String type, String state, String name, Date date1) throws Exception;

    String getLast()throws Exception;

    boolean updateState(String roomId)throws Exception;
}
