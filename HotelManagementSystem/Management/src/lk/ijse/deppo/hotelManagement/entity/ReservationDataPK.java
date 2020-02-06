package lk.ijse.deppo.hotelManagement.entity;

public class ReservationDataPK implements SuperEntity{

    private String reservationId;
    private  String roomNo;

    public ReservationDataPK(String reservationId, String roomNo) {
        this.reservationId = reservationId;
        this.roomNo = roomNo;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        return "ReservationDataPK{" +
                "reservationId='" + reservationId + '\'' +
                ", roomNo='" + roomNo + '\'' +
                '}';
    }
}

