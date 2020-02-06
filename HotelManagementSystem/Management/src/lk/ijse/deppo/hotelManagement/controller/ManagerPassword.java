package lk.ijse.deppo.hotelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.deppo.hotelManagement.business.BOFactory;
import lk.ijse.deppo.hotelManagement.business.BOTypes;
import lk.ijse.deppo.hotelManagement.business.custom.UserBO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerPassword implements Initializable {


    public AnchorPane root1;
    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXPasswordField txtPassword;
    private UserBO user = BOFactory.getInstance().getBO(BOTypes.USER);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Fade Style
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2500), root1);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    @FXML
    void IconNavigate(MouseEvent event) throws IOException {

    }

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/ManageControll.fxml"));
//        Scene newScene = new Scene(root);
//        Stage primeryStage = (Stage) btnLogin.getScene().getWindow();
//        primeryStage.setScene(newScene);
//        primeryStage.centerOnScreen();
        oad();
    }

    private void oad() {

        String name = txtUserName.getText();
        String passowrd = txtPassword.getText();
        try {
            String ma = user.getManager();
            String pw = user.loadUsersLogin(name, passowrd);

            if (passowrd.equals(ma)) {
                Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/ManageControll.fxml"));
                Scene newScene = new Scene(root);
                Stage primeryStage = (Stage) btnLogin.getScene().getWindow();
                primeryStage.setScene(newScene);
                primeryStage.centerOnScreen();
            } else {
                new Alert(Alert.AlertType.ERROR, "Please Check the Password").show();
                txtPassword.clear();
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void txtPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) {

    }

}
