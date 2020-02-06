package lk.ijse.deppo.hotelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.deppo.hotelManagement.business.BOFactory;
import lk.ijse.deppo.hotelManagement.business.BOTypes;
import lk.ijse.deppo.hotelManagement.business.custom.RoomBO;
import lk.ijse.deppo.hotelManagement.business.custom.impl.RoomBOImpl;
import lk.ijse.deppo.hotelManagement.db.DBConnection;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.deppo.hotelManagement.util.RoomSelectTM;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RoomSelect implements Initializable {


    public ImageView iconReserVation;
    public JFXComboBox comboRoomPrice;
    public AnchorPane root;
    @FXML
    private JFXTextField txtSearchRoom;

    @FXML
    private Label lblNoOfRooms;

    @FXML
    private TableView<RoomSelectTM> tblSearchRoom;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnReset;

    @FXML
    private JFXTextField txtRoomNo;

    @FXML
    private JFXComboBox<String> comboRoomType;

    @FXML
    private JFXTextField txtRatePrice;

    @FXML
    private JFXComboBox<String> comboRoomNo;

    PreparedStatement getAllData;
    private RoomBO roomBO = BOFactory.getInstance().getBO(BOTypes.ROOM);
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Fade Style
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2500), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        tblSearchRoom.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("no"));
        tblSearchRoom.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("type"));
        tblSearchRoom.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("state"));
        tblSearchRoom.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("category"));
        tblSearchRoom.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));
        tblSearchRoom.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("clean"));
        try {
            Connection connection = DBConnection.getInstance().getConnection();


            roomBO.loadAllRooms2(tblSearchRoom.getItems());

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
        @FXML
    void SearchGuest(MouseEvent event) {

    }

    @FXML
    void comboRoomNoOnAction(ActionEvent event) {

    }

    @FXML
    void comboRoomTypeOnAction(ActionEvent event) {

    }

    @FXML
    void searchGuestMouseClick(MouseEvent event) {

    }

    @FXML
    void tblCustomers_OnMouseClicked(MouseEvent event) {

    }


    @FXML
    void txtRoomNoOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearchRoomOnAction(ActionEvent event) {

    }


    public void comboRoomPriceOnAction(ActionEvent actionEvent) {
    }
}
