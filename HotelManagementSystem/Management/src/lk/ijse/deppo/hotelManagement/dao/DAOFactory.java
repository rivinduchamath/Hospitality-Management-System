package lk.ijse.deppo.hotelManagement.dao;


import lk.ijse.deppo.hotelManagement.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoType) {
        switch (daoType) {
            case GUEST:
                return (T) new GuestDAOImpl();
            case MENU:
                return (T) new MenuDAOImpl();
            case ROOM:
                return  (T) new RoomDAOImpl();
            case USER:
                return (T) new UserDAOImpl();
            case RESERVATION:
                return (T) new ReservationDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            case MANAGE:
                return (T)new ManageDAOImpl();
            case FOOD:
                return (T)new FoodAndBevDAOImpl();
            case BANQUET:
                return(T) new BanquetDAOImpl();
            default:
                return null;
        }
    }


}
