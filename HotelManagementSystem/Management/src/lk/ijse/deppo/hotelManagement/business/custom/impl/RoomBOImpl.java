package lk.ijse.deppo.hotelManagement.business.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.deppo.hotelManagement.business.custom.RoomBO;
import lk.ijse.deppo.hotelManagement.dao.DAOFactory;
import lk.ijse.deppo.hotelManagement.dao.DAOTypes;
import lk.ijse.deppo.hotelManagement.dao.custom.RoomDAO;
import lk.ijse.deppo.hotelManagement.dao.custom.impl.RoomDAOImpl;
import lk.ijse.deppo.hotelManagement.dto.RoomDTO;
import lk.ijse.deppo.hotelManagement.entity.Room;
import lk.ijse.deppo.hotelManagement.util.HouseKeepingTM;
import lk.ijse.deppo.hotelManagement.util.RoomSelectTM;

import java.sql.Date;

public class RoomBOImpl implements RoomBO {

    private  RoomDAO roomDAOImpl =
            DAOFactory.getInstance().getDAO
                    (DAOTypes.ROOM);
    @Override
    public void loadAllRoomIDCombo(ObservableList<String> room) throws Exception {
        roomDAOImpl.loadAllRoomIDCombo(room);
    }

    @Override
    public void saveMenu(HouseKeepingTM newRoom) throws Exception {
        roomDAOImpl.saveRoom(newRoom);
    }

    @Override
    public void loadAllRoom(ObservableList<HouseKeepingTM> rooms) throws Exception {
        roomDAOImpl.loadAllRoom(rooms);
    }

    @Override
    public String loadAllRoomNO(String select) throws Exception {
        return roomDAOImpl.loadAllRoomNO(select);
    }

    @Override
    public String loadAllRoomN1(String selectedItem) throws Exception {
        return roomDAOImpl.loadAllRoomN1(selectedItem);
    }

    @Override
    public String loadAllRoomN2(String selectedItem) throws Exception {
        return roomDAOImpl.loadAllRoomN2(selectedItem);
    }

    @Override
    public String loadAllRoomN3(String selectedItem) throws Exception {
        return roomDAOImpl.loadAllRoomN3(selectedItem);
    }

    @Override
    public void loadAlRooms(ObservableList<RoomSelectTM> items) throws Exception {
        roomDAOImpl.loadAllRooms(items);
    }

    @Override
    public void updateRoom(String no, String text) throws Exception {
        roomDAOImpl.updateRoomPrice(no, text);
    }

    @Override
    public double updateMenuPrice(double price) throws Exception {

        double p = roomDAOImpl.menuPrice(price);
        return p;
    }

    @Override
    public double updateMenuPrice2(double price) throws Exception {
        double p = roomDAOImpl.menuPrice2(price);
        return p;
    }

    @Override
    public void updateAvilability(boolean available, String roomNo) throws Exception {
        roomDAOImpl.updateAvilability(available, roomNo);
    }

    @Override
    public boolean checkAvilability(boolean available, String roo) throws Exception {
        return roomDAOImpl.checkAvilability(available, roo);
    }

    @Override
    public void loadAllRooms2(ObservableList<RoomSelectTM> items) throws Exception {
        roomDAOImpl.loadAllRooms2(items);
    }

    @Override
    public void updateRoomAvilability(String reservationId)throws Exception {
        roomDAOImpl.updateRoomAvilability(reservationId);
    }

    @Override
    public void updateRoom2(String roomId, String roocatogery, String type, String state, String name, String date1) throws Exception {
       Date d = Date.valueOf(date1);
        roomDAOImpl.udateNew(roomId,roocatogery,type,state,name, d);
    }

    @Override
    public String getLast() throws Exception {
        return roomDAOImpl.getLast();
    }

    @Override
    public boolean updateCustomer(RoomDTO roomDTO) throws Exception {
        return roomDAOImpl.update(new Room(roomDTO.getNo(), roomDTO.getType(), roomDTO.getPrice(),roomDTO.getCatogry(),roomDTO.getState(),roomDTO.getClean()));
    }

    @Override
    public boolean deleteCustomer(String no) throws Exception {
        return roomDAOImpl.delete(no);

    }

    @Override
    public boolean updateState(String roomId) throws Exception {
        return roomDAOImpl.updateState(roomId);
    }
}
