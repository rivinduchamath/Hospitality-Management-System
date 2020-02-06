package lk.ijse.deppo.hotelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
import lk.ijse.deppo.hotelManagement.util.MenuTM;
import lk.ijse.deppo.hotelManagement.util.RoomSelectTM;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Accountant implements Initializable {

    public JFXButton btnAddroom;
    public AnchorPane rootpane1;
    public JFXButton btnyesterDay;
    public JFXButton btnLastMonth;
    public JFXButton btnThisMonth;
    public JFXButton btnToday;
    public PieChart dailyIncomep;
    public PieChart dailyIncomep1;
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtOrderId;

    @FXML
    private TableView<RoomSelectTM> tblSearchRoom;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnReset;

    @FXML
    private JFXTextField txtCustomerId;

    @FXML
    private JFXTextField txtItemCode;

    @FXML
    private JFXDatePicker date;

    @FXML
    private TableView<MenuTM> tblSearchRoom1;

    @FXML
    private JFXButton btnFoodAndBev;

    @FXML
    private JFXButton btnReset1;

    @FXML
    private JFXTextField txtOrderId1;

    @FXML
    private JFXTextField txtOrderId11;
    private MenuBO menuBO = BOFactory.getInstance().getBO(BOTypes.MENU);
    private RoomBO roomBO = BOFactory.getInstance().getBO(BOTypes.ROOM);
    private ManageBO manageBO = BOFactory.getInstance().getBO(BOTypes.MANAGE);
    private FoodAndBevBO food = BOFactory.getInstance().getBO(BOTypes.FOODANDBEV);


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Fade Style
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2500), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        tblSearchRoom1.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblSearchRoom1.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblSearchRoom1.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        tblSearchRoom1.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("price"));

        tblSearchRoom.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("no"));
        tblSearchRoom.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("type"));
        tblSearchRoom.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("state"));
        tblSearchRoom.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("price"));

        loadTables();
        date.setValue(LocalDate.now());
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
        date.setDisable(true);
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList(
                new PieChart.Data("Food And Brverage", pp),
                new PieChart.Data("Reservation", pp1),
                new PieChart.Data("Rate", 43)


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
                new PieChart.Data("Rate", 43)


        );
        dailyIncomep.setData(list2);
////////////////////////////////////////////////////
        try {
            loadUSD();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//End Initialized


    //Method For Currency Management
    private void loadUSD()throws Exception {


        double f= manageBO.getCurrency1("CUUSD");
        double f2= manageBO.getCurrency1("CUEURO");
        txtOrderId.setText(String.valueOf(f));
        txtCustomerId.setText(String.valueOf(f2));
    }

    void loadTables() {
        try {
            menuBO.loadAllMenu(tblSearchRoom1.getItems());
            roomBO.loadAlRooms(tblSearchRoom.getItems());
        } catch (Exception e) {
            e.printStackTrace();
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
                case "imgReserVation":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/ManageGuest.fxml"));
                    break;
                case "IconBanquet":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/BanquetManagement.fxml"));
                    break;
                case "iconClean":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/HouseKeeping.fxml"));
                    break;
                case "imgManager":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/ManageControll.fxml"));
                    break;
                case "imgAccount":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Accountant.fxml"));
                    break;
                case "iconStore":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Menu.fxml"));
                    break;
                case "imgLogOut":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Login.fxml"));
                    break;
//                case "imgSettings1":
//                    Desktop d = Desktop.getDesktop();
//                    d.browse(new URI("http://localhost:55063/POS-System/IJSE/view/SignUp.html?_ijt=8vj5061f4bvhssaofto7pis2d9"));
//                    break;
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
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnFoodAndBevOnAction(ActionEvent event) {

    }

    @FXML
    void btnResetOnAction(ActionEvent event)throws Exception {

        if (!txtOrderId.getText().matches("^(\\d+(\\.\\d+)?)$")) {
            new Alert(Alert.AlertType.ERROR, "Please Enter Valid Number").show();
            txtOrderId.setStyle("-fx-background-color: #F9A693");
            txtOrderId.requestFocus();
            return;
        }
        txtOrderId.setStyle("-fx-background-color: none");
        double x = Double.parseDouble(txtOrderId.getText());
        manageBO.updateUSD(x,"CUUSD");
        loadUSD();
    }
    public void btnResetOnAction2(ActionEvent actionEvent) throws Exception {

        if (!txtCustomerId.getText().matches("^(\\d+(\\.\\d+)?)$")) {
            new Alert(Alert.AlertType.ERROR, "Please Check The Number").show();
            txtCustomerId.setStyle("-fx-background-color: #F9A693");
            txtCustomerId.requestFocus();
            return;
        }
        txtCustomerId.setStyle("-fx-background-color: none");
        double x = Double.parseDouble(txtCustomerId.getText());
        manageBO.updateUSD(x, "CUEURO");
        loadUSD();
    }

    @FXML
    void dateOnAction(ActionEvent event) {

    }

    @FXML
    void searchGuestMouseClick(MouseEvent event) {

    }


    @FXML
    void txtCustomerIdOnAction(ActionEvent event) {

    }

    @FXML
    void txtItemCodeOnAction(ActionEvent event) {

    }

    @FXML
    void txtOrderIdOnAction(ActionEvent event) {

    }

    public void btnAddroomOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Addroom.fxml"));
        Scene newScene = new Scene(root);
        Stage primeryStage = (Stage) dailyIncomep.getScene().getWindow();
        primeryStage.setScene(newScene);
        primeryStage.centerOnScreen();

    }

    @FXML
    void tblCustomers_OnMouseClicked(MouseEvent event) throws Exception {
        if (event.getClickCount() == 2) {

            String price = "";
            try {//For Get Selection Item Is Null
                if (!tblSearchRoom.getSelectionModel().getSelectedItem().getNo().equals("")) {
                    //Getting Selected Cell Price
                    price = String.valueOf(tblSearchRoom.getSelectionModel().getSelectedItem().getPrice());
                }
            } catch (Exception c) {
                return;
            }
            txtOrderId1.setText(price);
        }//End Of The If Condition
    }//End Of The Method

    public void tblCustomers_OnMouseClicked2(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {


            String price = "";

            try {//For Get Selection Item Is Null
                if (!tblSearchRoom1.getSelectionModel().getSelectedItem().getId().equals("")) {
                    //Getting Selected Cell Price
                    price = String.valueOf(tblSearchRoom1.getSelectionModel().getSelectedItem().getPrice());
                }
            } catch (Exception c) {
                return;
            }
            txtOrderId11.setText(price);
        }//End Of The If Condition
    }//End Of The Method

    public void txtPriceOnAction(ActionEvent actionEvent) throws Exception {
        String price1 = txtOrderId1.getText();
        String no = String.valueOf(tblSearchRoom.getSelectionModel().getSelectedItem().getNo());
        if (!txtOrderId1.getText().matches("^(\\d+(\\.\\d+)?)$")) {
            new Alert(Alert.AlertType.ERROR, "Please Enter Valid Number").show();
            txtOrderId1.setStyle("-fx-background-color: #F9A693");
            return;
        }
        txtOrderId1.setStyle("-fx-background-color: none");
        roomBO.updateRoom(no, price1);
        loadTables();
    }

    public void txtPrice2OnAction(ActionEvent actionEvent) throws Exception {
        String price1 = txtOrderId11.getText();
        String no = String.valueOf(tblSearchRoom1.getSelectionModel().getSelectedItem().getId());
        if (!txtOrderId11.getText().matches("^(\\d+(\\.\\d+)?)$")) {
            new Alert(Alert.AlertType.ERROR, "Please Enter Valid Number").show();
            txtOrderId11.setStyle("-fx-background-color: #F9A693");
            return;
        }
        txtOrderId11.setStyle("-fx-background-color: none");
        menuBO.updateMenuPrice(no, price1);
        loadTables();
    }

    public void btnThisMonthOnAction(ActionEvent actionEvent) throws Exception {


    }

    public void btnLastMonthOnAction(ActionEvent actionEvent) {
    }

    public void btnTodayOnAction(ActionEvent actionEvent) throws Exception {

        double price = 0;
        double pp = food.updateMenuPrice(price);
        double pp1 = roomBO.updateMenuPrice(price);

        ObservableList<PieChart.Data> piChart = FXCollections.observableArrayList(
                new PieChart.Data("Food And Brverage", pp),
                new PieChart.Data("Reservation", pp1),
                new PieChart.Data("Rate", 43)


        );

        PieChart pChart = new PieChart(piChart);

        Group root = new Group(pChart);
        Scene scene = new Scene(root, 500, 600);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void btnyesterDayOnAction(ActionEvent actionEvent) throws Exception {
        double price = 0;
        double pp = food.updateMenuPrice2(price);
        double pp1 = roomBO.updateMenuPrice2(price);

        ObservableList<PieChart.Data> piChart = FXCollections.observableArrayList(
                new PieChart.Data("Food And Brverage", pp),
                new PieChart.Data("Reservation", pp1),
                new PieChart.Data("Rate", 43)


        );

        PieChart pChart = new PieChart(piChart);

        Group root = new Group(pChart);
        Scene scene = new Scene(root, 500, 600);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
