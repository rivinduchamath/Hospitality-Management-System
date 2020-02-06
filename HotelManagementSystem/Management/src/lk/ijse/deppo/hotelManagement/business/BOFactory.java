package lk.ijse.deppo.hotelManagement.business;

import lk.ijse.deppo.hotelManagement.business.custom.impl.*;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){ }
    public static BOFactory getInstance(){
        return (boFactory == null)? (boFactory = new BOFactory()): boFactory;
    }

    public <T extends SuperBO> T getBO(BOTypes boTypes){
        switch (boTypes){
            case GUEST:
                return (T) new GuestBOImpl();
            case MENU:
                return (T) new MenuBOImpl();
            case ROOM:
                return (T) new RoomBOImpl();
            case FOODANDBEV:
                return (T) new FoodAndBevBOImpl();
            case USER:
                return (T) new UserBOImpl();
            case RESERVATION:
                return (T) new ReservationBOImpl();
            case MANAGE:
                return (T) new ManageBOImpl();
            case BANQUET:
                return (T) new BanquetBOImpl();
            default:
                return null;
        }
    }
}
