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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
import lk.ijse.deppo.hotelManagement.dto.RoomDTO;
import lk.ijse.deppo.hotelManagement.util.HouseKeepingTM;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddRoom implements Initializable {

    public JFXTextField currentDate;
    ObservableList<String> list = FXCollections.observableArrayList(
            "A/C",
            "Non A/C"

    );
    ObservableList<String> list1 = FXCollections.observableArrayList(
            "Clean",
            "Not Clean"

    );
    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField txtSerch;
    @FXML
    private Label lblNoOfRooms;
    @FXML
    private Label nrooms;
    @FXML
    private TableView<HouseKeepingTM> tblSearchRoom;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnReset;
    @FXML
    private JFXTextField txtRoomId;
    @FXML
    private JFXTextField txtType;
    @FXML
    private JFXDatePicker Date;
    @FXML
    private JFXTextField txtClean;
    @FXML
    private JFXComboBox<String> combostate;
    @FXML
    private JFXComboBox<String> comboCategory;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXTextField txtPrice;
    private RoomBO roomBO = BOFactory.getInstance().getBO(BOTypes.ROOM);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Fade Style
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2500), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        currentDate.setText(String.valueOf(LocalDate.now()));

        //set Room type to Combo Box (A/C || N.A/C)
        comboCategory.setItems(list);

        //set Room state to Combo Box
        combostate.setItems(list1);

        try {
            roomBO.loadAllRoom(tblSearchRoom.getItems());
        } catch (Exception e) {
            e.printStackTrace();
        }

        tblSearchRoom.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("no"));
        tblSearchRoom.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("type"));
        tblSearchRoom.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("price"));
        tblSearchRoom.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("category"));
        tblSearchRoom.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("state"));
        tblSearchRoom.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("cleanby"));
        tblSearchRoom.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("date"));

        int i = 0;
        ObservableList<HouseKeepingTM> g = tblSearchRoom.getItems();
        for (HouseKeepingTM g5 : g) {
            i++;
            nrooms.setText(String.valueOf(i));
        }
        txtRoomId.setDisable(true);
        //Table click event
        tblSearchRoom.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<HouseKeepingTM>() {
            @Override
            public void changed(ObservableValue<? extends HouseKeepingTM> observable, HouseKeepingTM oldValue, HouseKeepingTM newValue) {
                HouseKeepingTM selectedOrderDetail = tblSearchRoom.getSelectionModel().getSelectedItem();
                if (selectedOrderDetail == null) {
                    btnAdd.setText("Add");
                    btnDelete.setDisable(true);
                    return;
                } else {//Check Weather Table Select Or Not

                    //If Clicked Table Cell
                    txtRoomId.setText(selectedOrderDetail.getNo() + "");
                    combostate.setValue(selectedOrderDetail.getState() + "");
                    comboCategory.setValue(selectedOrderDetail.getCategory() + "");
                    txtType.setText(selectedOrderDetail.getType() + "");
                    txtClean.setText(selectedOrderDetail.getCleanby() + "");
                    txtPrice.setText(selectedOrderDetail.getPrice() + "");
                    btnAdd.setText("Update");
                }
            }//End Of Override Method
        });
        try {
            loadLast();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadLast() throws Exception {
        String r = roomBO.getLast();
        int maxId = 0;
        if (r == null) {
            maxId = 0;
        } else {
            maxId = Integer.parseInt(r.replace("RO", ""));
        }
        maxId = maxId + 1;
        String id = "";
        if (maxId < 10) {
            id = "RO00" + maxId;
        } else if (maxId < 100) {
            id = "RO0" + maxId;
        } else {
            id = "RO" + maxId;
        }
        txtRoomId.setText(id);

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
    void btnAddOnAction(ActionEvent event) {
        if (!txtClean.getText().matches("[A-Za-z][A-Za-z. ]+")) {
            new Alert(Alert.AlertType.ERROR, "Invalid Name").show();
            return;
        }

        if (btnAdd.getText().equals("Add")) {
            ObservableList<HouseKeepingTM> menu = tblSearchRoom.getItems();
            String cdate = currentDate.getText();
            double p = Double.parseDouble(txtPrice.getText());
            HouseKeepingTM newRoom = new HouseKeepingTM(
                    txtRoomId.getText(),
                    txtType.getText(),
                    p,
                    comboCategory.getValue(),
                    combostate.getValue(),
                    txtClean.getText(),
                    currentDate.getText(),
                    true

            );
            try {
                roomBO.saveMenu(newRoom);
                menu.add(new HouseKeepingTM(newRoom.getNo(), newRoom.getType(), newRoom.getPrice(), newRoom.getCategory(), newRoom.getState(), newRoom.getCleanby(), newRoom.getDate(), newRoom.isAvilable()));
                btnAdd(event);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            HouseKeepingTM selectedroom = tblSearchRoom.getSelectionModel().getSelectedItem();
            try {
                double ff = Double.parseDouble(txtPrice.getText());
                java.sql.Date f = java.sql.Date.valueOf(LocalDate.now());
                roomBO.updateCustomer(new RoomDTO(selectedroom.getNo(),
                        txtType.getText(),
                        ff,
                        comboCategory.getValue(),
                        combostate.getValue(),
                        txtClean.getText(),
                        f,
                        true
                ));

                try {
                    roomBO.loadAllRoom(tblSearchRoom.getItems());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                tblSearchRoom.refresh();
                btnAddNew_OnAction(event);
            } catch (Exception e) {
               new Alert(Alert.AlertType.INFORMATION, "Something went wrong").show();
            }
        }
    }

    private void btnAddNew_OnAction(ActionEvent event) {
    }

    private void btnAdd(ActionEvent event) {
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Are you sure whether you want to delete this Room?",
                ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get() == ButtonType.YES) {
            HouseKeepingTM selectedItem = tblSearchRoom.getSelectionModel().getSelectedItem();
            try {
                roomBO.deleteCustomer(selectedItem.getNo());
                tblSearchRoom.getItems().remove(selectedItem);
            } catch (Exception e) {
                new Alert(Alert.AlertType.INFORMATION,"Something went wrong").show();

            }

        }
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void combostateOnAction(ActionEvent event) {

    }

    @FXML
    void dateOnAction(ActionEvent event) {

    }

    @FXML
    void roomCategoryOnAction(ActionEvent event) {

    }

    @FXML
    void searchGuestMouseClick(MouseEvent event) {

    }

    @FXML
    void tblCustomers_OnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtCleanOnAction(ActionEvent event) {

    }

    @FXML
    void txtCustomerIdOnAction(ActionEvent event) {

    }

    @FXML
    void txtPriceOnAction(ActionEvent event) {

    }

    @FXML
    void txtSerchOnAction(ActionEvent event) {

    }

    @FXML
    void txtTypeOnAction(ActionEvent event) {

    }

}
