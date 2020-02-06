package lk.ijse.deppo.hotelManagement.entity;

import java.sql.Date;

public class ReservationData implements SuperEntity {
   private ReservationDataPK reservationDataPK;
    private Date arrivalDate;
    private Date depatureDate;
    private String mealId;
    private int noOfStudent;
    private int noOfAdults;
    private double totalPrice;
    private String incharge;


    public ReservationData(ReservationDataPK reservationDataPK, Date arrivalDate, Date depatureDate, String mealId, int noOfStudent, int noOfAdults, double totalPrice, String incharge) {
        this.reservationDataPK =reservationDataPK;
        this.arrivalDate = arrivalDate;
        this.depatureDate = depatureDate;
        this.mealId = mealId;
        this.noOfStudent = noOfStudent;
        this.noOfAdults = noOfAdults;
        this.totalPrice = totalPrice;
        this.incharge = incharge;
    }
    public ReservationData(String reservationId,String roomNo, Date arrivalDate, Date depatureDate, String mealId, int noOfStudent, int noOfAdults, double totalPrice, String incharge) {
        this.reservationDataPK =new ReservationDataPK(reservationId,roomNo);
        this.arrivalDate = arrivalDate;
        this.depatureDate = depatureDate;
        this.mealId = mealId;
        this.noOfStudent = noOfStudent;
        this.noOfAdults = noOfAdults;
        this.totalPrice = totalPrice;
        this.incharge = incharge;
    }
    public ReservationDataPK getReservationDataPK() {
        return reservationDataPK;
    }

    public void setReservationDataPK(ReservationDataPK reservationDataPK) {
        this.reservationDataPK = reservationDataPK;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepatureDate() {
        return depatureDate;
    }

    public void setDepatureDate(Date depatureDate) {
        this.depatureDate = depatureDate;
    }

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public int getNoOfStudent() {
        return noOfStudent;
    }

    public void setNoOfStudent(int noOfStudent) {
        this.noOfStudent = noOfStudent;
    }

    public int getNoOfAdults() {
        return noOfAdults;
    }

    public void setNoOfAdults(int noOfAdults) {
        this.noOfAdults = noOfAdults;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getIncharge() {
        return incharge;
    }

    public void setIncharge(String incharge) {
        this.incharge = incharge;
    }



}
