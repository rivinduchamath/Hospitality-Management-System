package lk.ijse.deppo.hotelManagement.controller;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
/////////////////////////////////////
import javafx.event.ActionEvent;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import sun.plugin.dom.html.HTMLBodyElement;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;

public class DashboardController implements Initializable {

    public AnchorPane root;
    public Button btnLogOut;
    public ImageView imgFood1;
    @FXML
    private ImageView imgReserve;

    @FXML
    private ImageView imgFood;

    @FXML
    private ImageView imgStore;

    @FXML
    private ImageView imgBanquet;

    @FXML
    private ImageView imgClean;

    @FXML
    private ImageView imgAccount;

    @FXML
    private ImageView imgManager;

    @FXML
    private Label lblMenu;

    @FXML
    private Label lblDescription;

    @FXML
    void navigate(MouseEvent event) throws IOException, URISyntaxException {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;

            switch (icon.getId()) {
                case "IconhoverBanquet":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/BanquetManagement.fxml"));
                    break;
                case "imgReserve":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/ManageGuest.fxml"));
                    break;
                case "imgFood":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Food&Bev.fxml"));
                    break;
                case "imgClean":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/HouseKeeping.fxml"));
                    break;
                case "imgManager":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/ManagerPassword.fxml"));
                    break;
                case "imgAccount":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Accountant.fxml"));
                    break;
                case "imgMenu":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Menu.fxml"));
                    break;
                case "imgLogOut":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Login.fxml"));
                    break;
                case "imgFood1":
                    Desktop d = Desktop.getDesktop();
                    d.browse(new URI("http://localhost:50835/HotelManagementSystem/Management/lk/ijse/deppo/hotelManagement/view/html/Home.html?_ijt=sme0nohes2uj5tbtaru0p5las"));
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

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Login.fxml"));
        Scene newScene = new Scene(root);
        Stage primeryStage = (Stage) btnLogOut.getScene().getWindow();
        primeryStage.setScene(newScene);
    }

    public void playMouseEnterAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            switch (icon.getId()) {
                case "imgReserve":
                    lblMenu.setText("Reservation");
                    lblDescription.setText("Click to add, update, delete, search or guest");
                    break;
                case "imgItem":
                    lblMenu.setText("Store Room");
                    lblDescription.setText("Click here if you want to place a new order");
                    break;
                case "imgFood":
                    lblMenu.setText("Food & Beverage");
                    lblDescription.setText("Click to add, edit, delete, search or items");
                    break;
                case "imgClean":
                    lblMenu.setText("House Keeping");
                    lblDescription.setText("Click View Room States");
                    break;
                case "imgManager":
                    lblMenu.setText("Management Settings");
                    lblDescription.setText("Click here to Management Settings");
                    break;

                case "imgMenu":
                    lblMenu.setText("Store Room");
                    lblDescription.setText("Click here to Store Room Details");
                    break;
                case "imgAccount":
                    lblMenu.setText("Account Details");
                    lblDescription.setText("Click here to Visit Account Details");
                    break;
                case "IconhoverBanquet":
                    lblMenu.setText("Banquet Details");
                    lblDescription.setText("Click here to Visit Banquet Details");
                    break;

            }

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }

    public void playMouseExitAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
            lblMenu.setText("Welcome");
            lblDescription.setText("Please select one of above main operations to proceed");
        }
    }

    public void playMouseEnterAnimation1(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            switch (icon.getId()) {
                case "imgFood1":
                    lblMenu.setText("Visit Us");
                    lblDescription.setText("Click here to Visit Web & Reservation Details");

            }
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Fade Style
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2500), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }
}
