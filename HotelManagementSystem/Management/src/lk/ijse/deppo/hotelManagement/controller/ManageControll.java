package lk.ijse.deppo.hotelManagement.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.deppo.hotelManagement.business.BOFactory;
import lk.ijse.deppo.hotelManagement.business.BOTypes;
import lk.ijse.deppo.hotelManagement.business.custom.FoodAndBevBO;
import lk.ijse.deppo.hotelManagement.business.custom.ManageBO;
import lk.ijse.deppo.hotelManagement.business.custom.MenuBO;
import lk.ijse.deppo.hotelManagement.business.custom.RoomBO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManageControll implements Initializable {

    public ImageView imgKitchenDep;
    public PieChart dailyIncomep;
    public PieChart dailyIncomep1;
    @FXML
    private AnchorPane root;

    @FXML
    private ImageView imgReservation;

    @FXML
    private ImageView imgHome;

    @FXML
    private ImageView imgBanquet;

    @FXML
    private ImageView imgHouseKeeping;

    @FXML
    private ImageView imgFoodandBev;

    @FXML
    private ImageView imgChicken;

    @FXML
    private ImageView imgAccount;

    @FXML
    private JFXButton btnFrontDesk;

    @FXML
    private JFXButton btnAccountManagement;

    @FXML
    private JFXButton btnFoodAndBev;

    @FXML
    private JFXButton btnBanquet;

    @FXML
    private JFXButton btnHouseKeeping;

    @FXML
    private JFXButton btnDailyActive;

    @FXML
    private JFXButton btnMonthlyActive;
    private MenuBO menuBO = BOFactory.getInstance().getBO(BOTypes.MENU);
    private RoomBO roomBO = BOFactory.getInstance().getBO(BOTypes.ROOM);
    private ManageBO manageBO = BOFactory.getInstance().getBO(BOTypes.MANAGE);
    private FoodAndBevBO food = BOFactory.getInstance().getBO(BOTypes.FOODANDBEV);

    @FXML
    void IconNavigate(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent root1 = null;

            switch (icon.getId()) {
                case "IconHome":
                    root1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Dashboard.fxml"));
                    break;
                case "IconBanquet":
                    root1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/BanquetManagement.fxml"));
                    break;
                case "iconFoodAndBev":
                    root1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Food&Bev.fxml"));
                    break;
                case "imgReserVation":
                    root1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/ManageGuest.fxml"));
                    break;
                case "iconClean":
                    root1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/HouseKeeping.fxml"));
                    break;
                case "iconMenu":
                    root1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Menu.fxml"));
                    break;
                case "iconAccountant":
                    root1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/ManageGuest.fxml"));
                    break;

            }


            if (root1 != null) {
                Scene subScene = new Scene(root1);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }


////////////////////////////////////////////////////
    }

    @FXML
    void btnAccountManagementOnAction(ActionEvent event) {

    }

    @FXML
    void btnBanquetOnAction(ActionEvent event) {

    }

    @FXML
    void btnDailyActiveOnActive(ActionEvent event) {

    }

    @FXML
    void btnFoodAndBevOnAction(ActionEvent event) {

    }

    @FXML
    void btnFrontDeskOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/ijse/deppo/hotelManagement/view/ManagerFrontDesk.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("ManageReservation");
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void btnHouseKeepingOnAction(ActionEvent event) {

    }

    @FXML
    void btnMonthlyActiveOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Fade Style
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2500), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        /////////////////////////////////////////////////
        //Pie Chart Today
        double price = 0;
        double pp = 0;
        try {
            pp = food.updateMenuPrice(price);
        } catch (Exception e) {
            e.printStackTrace();
        }
        double pp1 = 0;
        try {
            pp1 = roomBO.updateMenuPrice(price);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ObservableList<PieChart.Data> list = FXCollections.observableArrayList(
                new PieChart.Data("Food And Brverage", pp),
                new PieChart.Data("Reservation", pp1),
                new PieChart.Data("Banquet", 43)


        );
        dailyIncomep1.setData(list);
//////////////////////////////////////////////////////
        //Pie Chart Yesterday
        double price1 = 0;
        double pp11 = 0;
        double pp1x = 0;
        try {
            pp11 = food.updateMenuPrice2(price);
            pp1x = roomBO.updateMenuPrice2(price1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ObservableList<PieChart.Data> list2 = FXCollections.observableArrayList(
                new PieChart.Data("Food And Brverage", pp11),
                new PieChart.Data("Reservation", pp1x),
                new PieChart.Data("Banquet", 43)


        );
        dailyIncomep.setData(list2);
    }
}
