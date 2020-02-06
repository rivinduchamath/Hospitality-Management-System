package lk.ijse.deppo.hotelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.deppo.hotelManagement.business.BOFactory;
import lk.ijse.deppo.hotelManagement.business.BOTypes;
import lk.ijse.deppo.hotelManagement.business.custom.FoodAndBevBO;
import lk.ijse.deppo.hotelManagement.business.custom.GuestBO;
import lk.ijse.deppo.hotelManagement.business.custom.ReservationBO;
import lk.ijse.deppo.hotelManagement.business.custom.RoomBO;
import lk.ijse.deppo.hotelManagement.business.custom.impl.FoodAndBevBOImpl;
import lk.ijse.deppo.hotelManagement.business.custom.impl.RoomBOImpl;
import lk.ijse.deppo.hotelManagement.db.DBConnection;
import lk.ijse.deppo.hotelManagement.dto.ReservationDTO;
import lk.ijse.deppo.hotelManagement.util.EditReservationTM;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class EditReservation implements Initializable {
    public JFXButton btnCheckOut;
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private TableView<EditReservationTM> tblAllReserVationData;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnReset;

    @FXML
    private TableView<EditReservationTM> tblreservationall;

    private ReservationBO reserve = BOFactory.getInstance().getBO(BOTypes.RESERVATION);
    private RoomBO roomBO = BOFactory.getInstance().getBO(BOTypes.ROOM);
    private FoodAndBevBO food = BOFactory.getInstance().getBO(BOTypes.FOODANDBEV);
    private GuestBO guest = BOFactory.getInstance().getBO(BOTypes.GUEST);


    //Initialized Method
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Fade Style
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2500), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        //Upper Table
        tblAllReserVationData.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblAllReserVationData.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("guestId"));
        tblAllReserVationData.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("currency"));
        tblAllReserVationData.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("discount"));
        tblAllReserVationData.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));


        //Bottom
        tblreservationall.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("aerivalDate"));
        tblreservationall.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("depatureDate"));
        tblreservationall.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("roomType"));
        tblreservationall.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("roomNo"));
        tblreservationall.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("adults"));
        tblreservationall.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("children"));
        tblreservationall.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("menu"));
        tblreservationall.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("discount"));
        tblreservationall.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("ratePrice"));
        tblreservationall.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("subtotal"));
        load1();

    }

    void load1() {

        try {
            List<ReservationDTO> allCustomers = reserve.findAllReservation();

            ObservableList<EditReservationTM> reserve = tblAllReserVationData.getItems();
            for (ReservationDTO c : allCustomers) {
                reserve.add(new EditReservationTM(c.getId(), c.getGuestId(), c.getCurrency(), c.getDiscount(), c.getTotal()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void SearchGuest(MouseEvent event) {

    }

    @FXML
    void tblCustomers_OnMouseClicked(MouseEvent event) throws Exception {

        if (event.getClickCount() == 1) {
            load2();
        }
    }

    void load2() {
        String x = "";
        try {
            if (tblAllReserVationData.getSelectionModel().getSelectedItem().equals(x)) {

            }

        } catch (Exception e) {
            return;
        }
        String orderID = tblAllReserVationData.getSelectionModel().getSelectedItem().getId();

        try {
            reserve.loadAll(tblreservationall.getItems(), orderID);
        } catch (Exception e) {
        }

    }

    void load2(String oid) {

        try {
            reserve.loadAll(tblreservationall.getItems(), oid);
        } catch (Exception e) {
        }

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

    public void btnCheckOutOnaction(ActionEvent actionEvent) throws Exception {
        String Id1 = tblAllReserVationData.getSelectionModel().getSelectedItem().getGuestId();
        double d = food.getPrice(Id1);
        String Id = tblAllReserVationData.getSelectionModel().getSelectedItem().getId();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/lk/ijse/deppo/hotelManagement/report/newPo.jasper"));
        Map<String, Object> params = new HashMap<>();
        params.put("reservationId", Id);
        params.put("tit", d);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, DBConnection.getInstance().getConnection());
        JasperViewer.viewReport(jasperPrint, false);

        String guestId = tblAllReserVationData.getSelectionModel().getSelectedItem().getGuestId();

        guest.deleteTotal(guestId);
        ObservableList<EditReservationTM> reservationId = tblreservationall.getItems();
        for (EditReservationTM editReservationTM : reservationId) {
            String roomId = editReservationTM.getRoomNo();
            roomBO.updateRoomAvilability(roomId);
            roomBO.updateState(roomId);
        }

        String res = tblAllReserVationData.getSelectionModel().getSelectedItem().getId();
        reserve.deleteReservations(res);
        tblAllReserVationData.getItems().clear();
        load1();
        load2(Id);
        tblreservationall.refresh();
        tblAllReserVationData.refresh();

//        new GuestController().reset();
    }


    public void tblCustomers_OnMouseClicked2(MouseEvent mouseEvent) {
    }
}
