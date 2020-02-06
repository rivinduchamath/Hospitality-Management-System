package lk.ijse.deppo.hotelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.deppo.hotelManagement.business.BOFactory;
import lk.ijse.deppo.hotelManagement.business.BOTypes;
import lk.ijse.deppo.hotelManagement.business.custom.UserBO;
import lk.ijse.deppo.hotelManagement.db.DBConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Login implements Initializable {
    public JFXTextField txtUserName;
    public JFXButton btnSignIn;
    public JFXTextField txtpass;
    public AnchorPane root;

    private UserBO user = BOFactory.getInstance().getBO(BOTypes.USER);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Fade Style
        FadeTransition fadeIn = new FadeTransition(Duration.millis(500), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    public void txtUserNameOnAction(ActionEvent actionEvent) {
        txtpass.requestFocus();
    }

    public void btnSignInOnAction(ActionEvent actionEvent) throws IOException, SQLException {

        String name = txtUserName.getText();
        String passowrd = txtpass.getText();
        try {
            String pw = user.loadUsersLogin(name, passowrd);
            if (passowrd.equals(pw)) {
                DBConnection.nameq = name;
                Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Dashboard.fxml"));
                Scene newScene = new Scene(root);
                Stage primeryStage = (Stage) btnSignIn.getScene().getWindow();
                primeryStage.setScene(newScene);
            } else {
                new Alert(Alert.AlertType.ERROR, "Please Check the Password").show();
                txtpass.clear();
                return;
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Went Wrong").show();
        }


    }

    public void txtpassOnAction(ActionEvent actionEvent) {
        btnSignIn.requestFocus();
    }
}
