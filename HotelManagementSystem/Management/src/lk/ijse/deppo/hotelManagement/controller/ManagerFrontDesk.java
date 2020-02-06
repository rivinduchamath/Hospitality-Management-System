package lk.ijse.deppo.hotelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.deppo.hotelManagement.business.BOFactory;
import lk.ijse.deppo.hotelManagement.business.BOTypes;
import lk.ijse.deppo.hotelManagement.business.custom.UserBO;
import lk.ijse.deppo.hotelManagement.dto.UserDTO;
import lk.ijse.deppo.hotelManagement.util.UserTM;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManagerFrontDesk implements Initializable {

    public JFXDatePicker date2;
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtOrderId;

    @FXML
    private TableView<UserTM> tblSearchRoom;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXTextField txtCustomerId;

    @FXML
    private JFXDatePicker date;

    @FXML
    private TableView<?> tblSearchRoom1;

    @FXML
    private JFXButton btnReset1;

    @FXML
    private JFXTextField txtOrderId1;

    @FXML
    private JFXTextField txtOrderId11;

    @FXML
    private JFXTextField txtOrderId2;

    @FXML
    private JFXTextField txtOrderId21;
    private UserBO user = BOFactory.getInstance().getBO(BOTypes.USER);
    @FXML
    private JFXTextField txtOrderId211;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Fade Style
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2500), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
        tblSearchRoom.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblSearchRoom.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblSearchRoom.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("age"));
        tblSearchRoom.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("post"));
        tblSearchRoom.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("password"));
        tblSearchRoom.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("date"));
        date.setDisable(true);
        date.setValue(LocalDate.now());
        try {
            user.loadAll(tblSearchRoom.getItems());
        } catch (Exception e) {
            e.printStackTrace();
        }

        tblSearchRoom.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<UserTM>() {
            @Override
            public void changed(ObservableValue<? extends UserTM> observable, UserTM oldValue, UserTM newValue) {
                UserTM selectedItem = tblSearchRoom.getSelectionModel().getSelectedItem();

                if (selectedItem == null) {
                    btnReset1.setText("Add");
                    btnDelete.setDisable(true);
                    return;
                } else {
                    btnReset1.setText("Update");
                    btnReset1.setDisable(false);
                    btnDelete.setDisable(false);
                    txtOrderId.setText(selectedItem.getId());
                    txtOrderId2.setText(selectedItem.getPassword());
                    txtOrderId21.setText(String.valueOf(selectedItem.getAge()));
                    txtCustomerId.setText(selectedItem.getName());
                    txtOrderId211.setText(selectedItem.getPost());
                }
            }
        });
    }

    @FXML
    void IconNavigate(MouseEvent event) {

    }

    @FXML
    void SearchGuest(MouseEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Are you sure whether you want to delete this User?",
                ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get() == ButtonType.YES) {
            UserTM selectedItem = tblSearchRoom.getSelectionModel().getSelectedItem();
            try {
                user.deleteCustomer(selectedItem.getId());
                tblSearchRoom.getItems().remove(selectedItem);
            }
            catch (Exception e) {
                new Alert(Alert.AlertType.INFORMATION,"Something went wrong").show();
            }
        }
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {

        int x =  regexValidations();
        if(x == 1){
            return;
        }

        if (btnReset1.getText().equals("Add")) {
            ObservableList<UserTM> users = tblSearchRoom.getItems();
            UserDTO newUser = new UserDTO(
                    txtOrderId.getText(),
                    txtCustomerId.getText(),
                    txtOrderId211.getText(),
                    txtOrderId2.getText(),
                    Integer.parseInt(txtOrderId21.getText()),
                    Date.valueOf(date.getValue())


            );
            try {
                user.saveUser(newUser);
                users.add(new UserTM(newUser.getId(), newUser.getName(), newUser.getPost(), newUser.getPassword(), newUser.getAge(), newUser.getDate()));
                btnAddNew_OnAction(event);
            } catch (Exception e) {
                new Alert(Alert.AlertType.INFORMATION, "Something went wrong").show();
            }
        }
        if (btnReset1.getText().equals("Update")) {
            UserTM selectedUser = tblSearchRoom.getSelectionModel().getSelectedItem();
            try {
                user.updateCustomer(new UserDTO(selectedUser.getId(),
                        txtCustomerId.getText(),
                        txtOrderId211.getText(),
                        txtOrderId2.getText(),
                        Integer.parseInt(txtOrderId21.getText()),
                        Date.valueOf(date.getValue())


                ));
                selectedUser.setName(txtCustomerId.getText());
                selectedUser.setId(txtOrderId.getText());
                selectedUser.setPassword(txtOrderId2.getText());
                selectedUser.setPost(txtOrderId211.getText());
                selectedUser.setDate(Date.valueOf(LocalDate.now()));
                selectedUser.setAge(Integer.parseInt(txtOrderId21.getText()));
                tblSearchRoom.refresh();
                btnAddNew_OnAction(event);
                btnReset1.setText("Add");
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Somthing Went Wrong").show();
            }
        }

    }

    private int regexValidations() {
        if (!txtCustomerId.getText().matches("[A-Za-z][A-Za-z. ]+")) {
            new Alert(Alert.AlertType.ERROR, "Invalid User Name").show();
            txtCustomerId.setStyle("-fx-background-color: #F9A693");
            return 1;
        }   txtCustomerId.setStyle("-fx-background-color: none");

        if (!txtOrderId211.getText().matches("[A-Za-z][A-Za-z. ]+")) {
            new Alert(Alert.AlertType.ERROR, "Invalid Post Name").show();
            txtOrderId211.setStyle("-fx-background-color: #F9A693");
            return 1;
        }
        txtOrderId211.setStyle("-fx-background-color: none");

        if (!txtOrderId21.getText().matches("^(\\d+(\\.\\d+)?)$")) {
            new Alert(Alert.AlertType.ERROR, "Please Enter Valid Number").show();
            txtOrderId21.setStyle("-fx-background-color: #F9A693");
            return 1;
        }txtOrderId21.setStyle("-fx-background-color: none");
        return 0;

    }

    private void btnAddNew_OnAction(ActionEvent event) {
        txtOrderId.clear();
        txtOrderId2.clear();
        txtOrderId211.clear();
        txtCustomerId.clear();
        txtOrderId21.clear();
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
    void txtOrderIdOnAction(ActionEvent event) {

    }


}
