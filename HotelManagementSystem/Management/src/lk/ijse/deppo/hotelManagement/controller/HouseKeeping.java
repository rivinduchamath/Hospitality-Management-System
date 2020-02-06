package lk.ijse.deppo.hotelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.deppo.hotelManagement.business.BOFactory;
import lk.ijse.deppo.hotelManagement.business.BOTypes;
import lk.ijse.deppo.hotelManagement.business.custom.RoomBO;
import lk.ijse.deppo.hotelManagement.business.custom.impl.RoomBOImpl;
import lk.ijse.deppo.hotelManagement.db.DBConnection;
import lk.ijse.deppo.hotelManagement.util.HouseKeepingTM;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class HouseKeeping implements Initializable {

    public JFXComboBox combostate;
    public Label nrooms;
    ObservableList<String> list = FXCollections.observableArrayList(
            "A/C",
            "Non A/C"

    );
    ObservableList<String> list1 = FXCollections.observableArrayList(
            "Clean",
            "Not Clean"

    );
    private RoomBO roomBO = BOFactory.getInstance().getBO(BOTypes.ROOM);
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtSerch;

    @FXML
    private Label lblNoOfRooms;

    @FXML
    private TableView<HouseKeepingTM> tblSearchRoom;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnReset;

    @FXML
    private JFXTextField txtCustomerId;

    @FXML
    private JFXTextField txtQtyOnHand;

    @FXML
    private JFXDatePicker date;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXButton btnAdd1;

    @FXML
    private JFXComboBox<String> roomCategory;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        //Fade Style
        FadeTransition fadeIn = new FadeTransition(Duration.millis(1500), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        //set Room type to Combo Box (A/C || N.A/C)
        roomCategory.setItems(list);

        //set Room state to Combo Box
        combostate.setItems(list1);

        try {
            roomBO.loadAllRoom(tblSearchRoom.getItems());
        } catch (Exception e) {
            e.printStackTrace();
        }
        date.setValue(LocalDate.now());
        date.setDisable(true);
        txtQtyOnHand.setDisable(true);
        txtCustomerId.setDisable(true);

        tblSearchRoom.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("no"));
        tblSearchRoom.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("category"));
        tblSearchRoom.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("state"));
        tblSearchRoom.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("type"));
        tblSearchRoom.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("cleanby"));
        tblSearchRoom.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("date"));

        //Table click event
        tblSearchRoom.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<HouseKeepingTM>() {
            @Override
            public void changed(ObservableValue<? extends HouseKeepingTM> observable, HouseKeepingTM oldValue, HouseKeepingTM newValue) {
                HouseKeepingTM selectedOrderDetail = tblSearchRoom.getSelectionModel().getSelectedItem();
                if (selectedOrderDetail != null) {//Check Weather Table Select Or Not

                    //If Clicked Table Cell
                    txtCustomerId.setText(selectedOrderDetail.getNo() + "");
                    combostate.setValue(selectedOrderDetail.getState() + "");
                    roomCategory.setValue(selectedOrderDetail.getCategory() + "");
                    txtQtyOnHand.setText(selectedOrderDetail.getType() + "");
                    txtCustomerName.setText(selectedOrderDetail.getCleanby() + "");
                }
            }//End Of Override Method
        });
        int i =0;
        ObservableList<HouseKeepingTM> hs= tblSearchRoom.getItems();
        for (HouseKeepingTM ff: hs) {
            ff.getNo();
            i++;
            nrooms.setText(String.valueOf(i));
        }
    }

    @FXML
    void IconNavigate(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;

            switch (icon.getId()) {
                case "IconHome":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Dashboard.fxml"));
                    break;

                case "IconBanquet":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/BanquetManagement.fxml"));
                    break;
                case "imgReserVation":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/ManageGuest.fxml"));
                    break;
                case "iconMenu":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Menu.fxml"));
                    break;
                case "iconFoodAndBev":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Food&Bev.fxml"));
                    break;

            }


            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }
    }

    @FXML
    void SearchGuest(MouseEvent event) {

    }

    @FXML
    void btnAddOnAction(ActionEvent event) throws Exception {
        String roomId = txtCustomerId.getText();
        String roocatogery = roomCategory.getSelectionModel().getSelectedItem();
        String type = txtQtyOnHand.getText();
        String state = (String) combostate.getSelectionModel().getSelectedItem();
        String name = txtCustomerName.getText();
        String date1 = String.valueOf((date.getValue()));
        roomBO.updateRoom2(roomId,roocatogery,type,state,name,date1);
        roomBO.loadAllRoom(tblSearchRoom.getItems());
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }


    @FXML
    void btnResetOnAction(ActionEvent event) throws Exception {
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/lk/ijse/deppo/hotelManagement/report/order-report.jasper"));
        Map<String, Object> params = new HashMap<>();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, DBConnection.getInstance().getConnection());
        JasperViewer.viewReport(jasperPrint, false);

    }

    @FXML
    void dateOnAction(ActionEvent event) {

    }

    @FXML
    void searchGuestMouseClick(MouseEvent event) {

    }

    @FXML
    void tblCustomers_OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtCustomerIdOnAction(ActionEvent event) {

    }

    @FXML
    void txtCustomerNameOnAction(ActionEvent event) {

    }


    @FXML
    void txtQtyOnHandOnAction(ActionEvent event) {

    }

    public void roomCategoryOnAction(ActionEvent actionEvent) {
    }

    public void txtSerchOnAction(ActionEvent actionEvent) {
    }
}
