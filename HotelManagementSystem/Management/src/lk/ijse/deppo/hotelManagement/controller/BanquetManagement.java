package lk.ijse.deppo.hotelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
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
import lk.ijse.deppo.hotelManagement.business.custom.BanquetBO;
import lk.ijse.deppo.hotelManagement.business.custom.ReservationBO;
import lk.ijse.deppo.hotelManagement.dto.BanqetDTO;
import lk.ijse.deppo.hotelManagement.dto.ReservationDTO;
import lk.ijse.deppo.hotelManagement.util.BanquetTM;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BanquetManagement implements Initializable {

    public AnchorPane root;
    @FXML
    private AnchorPane root1;

    @FXML
    private JFXTextField txtGuestId;

    @FXML
    private JFXTextField txtGuestName;

    @FXML
    private JFXTextField txtGuestAddress;

    @FXML
    private JFXTextField txtGuestEmail;

    @FXML
    private JFXComboBox<?> typeCombo;

    @FXML
    private JFXButton btnState;

    @FXML
    private JFXButton btnSelect;

    @FXML
    private JFXTextField txtSubTotal;

    @FXML
    private JFXTextField txtDiscount;

    @FXML
    private TableView<BanquetTM> tblAddGuest;

    @FXML
    private Label lblReservationId;

    @FXML
    private Label lblCurrentDate;

    @FXML
    private JFXComboBox<?> comboCurrency;

    @FXML
    private JFXButton btnSelect2;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnReset;

    @FXML
    private JFXButton btnCalculator;

    @FXML
    private JFXComboBox<?> combotype;

    @FXML
    private JFXTextField txtCustomerId12;

    @FXML
    private JFXTextField txtnoOfpeople;

    @FXML
    private JFXDatePicker Date2;

    @FXML
    private JFXTextField txtNoofChairs;

    @FXML
    private JFXComboBox<?> combomeal;

    @FXML
    private JFXButton btnDelete1;
    private BanquetBO banquetBO = BOFactory.getInstance().getBO(BOTypes.BANQUET);
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Fade Style
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2500), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        tblAddGuest.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblAddGuest.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("guestId"));
        tblAddGuest.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("guestName"));
        tblAddGuest.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("chair"));
        tblAddGuest.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("banquetDate"));
        tblAddGuest.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("platePrice"));
        tblAddGuest.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("mealType"));
        tblAddGuest.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("noofPeople"));
        tblAddGuest.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("subTotal"));
        tblAddGuest.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("discount"));
        tblAddGuest.getColumns().get(10).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblAddGuest.getColumns().get(11).setCellValueFactory(new PropertyValueFactory<>("submittedBy"));

        try {
            loadAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadAll() throws Exception {
        ObservableList<BanquetTM> tbl = tblAddGuest.getItems();
        for (BanquetTM d: tbl) {

        }
    }

    @FXML
    void Enter4(ActionEvent event) {

    }

    @FXML
    void Enter5(ActionEvent event) {

    }

    @FXML
    void Enter7(ActionEvent event) {

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
                case "iconF&B":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Food&Bev.fxml"));
                    break;
                case "IconReserve":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/ManageGuest.fxml"));
                    break;
                case "iconClean":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/HouseKeeping.fxml"));
                    break;
                case "iconStore":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Menu.fxml"));
                    break;

            }


            if (root!= null) {
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
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnCalculatorOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnReport_OnAction(ActionEvent event) {

    }

    @FXML
    void btnResetOnAction(ActionEvent event) {

    }

    @FXML
    void btnSelectOnAction(ActionEvent event) {

    }

    @FXML
    void btnStateOnAction(ActionEvent event) {

    }

    @FXML
    void comboCurrencyOnAction(ActionEvent event) {

    }

    @FXML
    void combomeal(ActionEvent event) {

    }

    @FXML
    void combotype(ActionEvent event) {

    }

    @FXML
    void searchGuestMouseClick(MouseEvent event) {

    }

    @FXML
    void tblCustomers_OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtDiscountOnAction(ActionEvent event) {

    }

    @FXML
    void txtGuestAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtGuestEmailOnAction(ActionEvent event) {

    }

    @FXML
    void txtGuestIdOnAction(ActionEvent event) {

    }

    @FXML
    void txtGuestNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtSubTotalOnAction(ActionEvent event) {

    }

    @FXML
    void typeComboOnAction(ActionEvent event) {

    }


}
