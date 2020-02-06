package lk.ijse.deppo.hotelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
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
import lk.ijse.deppo.hotelManagement.business.custom.GuestBO;
import lk.ijse.deppo.hotelManagement.business.custom.ManageBO;
import lk.ijse.deppo.hotelManagement.business.custom.MenuBO;
import lk.ijse.deppo.hotelManagement.business.custom.RoomBO;
import lk.ijse.deppo.hotelManagement.business.custom.impl.RoomBOImpl;
import lk.ijse.deppo.hotelManagement.controller.Calculator.CalculatorForm;
import lk.ijse.deppo.hotelManagement.db.DBConnection;
import lk.ijse.deppo.hotelManagement.util.GuestControllerTM;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class GuestController implements Initializable {
    @FXML
    public JFXButton btnSelect2;
    public ImageView imageSetting;
    public JFXComboBox comboMenu;
    public JFXTextField txtroomType;
    public JFXTextField txtState;
    public JFXTextField txtRoomCondition;
    public Label lblCurrencysymble;

    //Id Type Combo Box
    ObservableList<String> list = FXCollections.observableArrayList(
            "NIC",
            "Passport",
            "Driving Licence"

    );

    //Meal Type Combo Box
    ObservableList<String> list1 = FXCollections.observableArrayList(
            "Full Board",
            "Half Board",
            "Not a Menu"

    );
    //Meal Type Combo Box
    ObservableList<String> list2 = FXCollections.observableArrayList(
            "US Dollar",
            "Euro"
    );
    ArrayList<String> flds = new ArrayList<>();
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
    private JFXTextField txtPlateNo;
    @FXML
    private JFXComboBox<String> typeCombo;
    @FXML
    private JFXButton btnState;
    @FXML
    private JFXButton btnSelect;
    @FXML
    private JFXDatePicker dateOut;
    @FXML
    private JFXDatePicker dateIn;
    @FXML
    private JFXComboBox<String> comboRoomType;
    @FXML
    private JFXTextField txtRatePrice;
    @FXML
    private JFXTextField txtChildren;
    @FXML
    private JFXTextField txtAdult;
    @FXML
    private JFXTextField txtSubTotal;
    @FXML
    private JFXTextField txtDiscount;
    @FXML
    private JFXTextField txtTotal;
    @FXML
    private JFXButton btnState1;
    @FXML
    private JFXButton btnState11;
    @FXML
    private JFXButton btnState12;
    @FXML
    private JFXButton btnState111;
    @FXML
    private TableView<GuestControllerTM> tblAddGuest;
    @FXML
    private JFXComboBox<String> comboRoomNo;
    @FXML
    private Label lblReservationId;
    @FXML
    private Label lblCurrentDate;
    @FXML
    private JFXComboBox<String> comboCurrency;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnReset;
    @FXML
    private JFXButton btnCalculator;
    @FXML
    private JFXButton btnCheckIn;
    @FXML
    private Label lblSubmitCheckIn;

    private MenuBO menuBO = BOFactory.getInstance().getBO(BOTypes.MENU);
    private RoomBO roomBO = BOFactory.getInstance().getBO(BOTypes.ROOM);
    private GuestBO guest = BOFactory.getInstance().getBO(BOTypes.GUEST);
    private ManageBO manageBO = BOFactory.getInstance().getBO(BOTypes.MANAGE);

    //Initialized Method
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Fade Style
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2500), root1);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        //Rotate Setting Icon
        RotateTransition rotateTransition = new RotateTransition(Duration.hours(2.2), imageSetting);
        rotateTransition.setByAngle(999999);
        rotateTransition.play();

        //Add Current Date Top Right
        lblCurrentDate.setText(LocalDate.now() + "");
        dateIn.setValue(LocalDate.now());
        dateOut.setValue(LocalDate.now());


        try {

            //Get All Menu Descriptions
            /************************************************
             menuBO.loadAllMenuItems(comboMenu.getItems());
             ***********************************************/

            //Get Menu For Reservation
            comboMenu.setItems(list1);

            //Get Currency For Reservation
            comboCurrency.setItems(list2);

            //Get All room Description
            roomBO.loadAllRoomIDCombo(comboRoomNo.getItems());

        }//End Try Block
        catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION, "Something Went Wrong!").show();
            return;
        }

        //setDisable
        txtRatePrice.setDisable(true);
        btnDelete.setDisable(true);
        lblSubmitCheckIn.setDisable(true);
        btnCheckIn.setDisable(true);
        lblSubmitCheckIn.setText(DBConnection.nameq);
        txtroomType.setDisable(true);
        dateIn.setDisable(true);
        txtState.setDisable(true);
        txtRoomCondition.setDisable(true);
        comboCurrency.setValue("");
        txtAdult.setText("0");
        txtChildren.setText("0");
        txtDiscount.setText("0");
        txtSubTotal.setText("0");

        // Lets Map The Table table
        tblAddGuest.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));
        tblAddGuest.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("departureDate"));
        tblAddGuest.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("roomType"));
        tblAddGuest.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("roomNo"));
        tblAddGuest.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("adult"));
        tblAddGuest.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("children"));
        tblAddGuest.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("menu"));
        tblAddGuest.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("discount"));
        tblAddGuest.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("ratePrice"));
        tblAddGuest.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("subTotal"));


        //Table click event
        tblAddGuest.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<GuestControllerTM>() {
            @Override
            public void changed(ObservableValue<? extends GuestControllerTM> observable, GuestControllerTM oldValue, GuestControllerTM newValue) {
                GuestControllerTM selectedOrderDetail = tblAddGuest.getSelectionModel().getSelectedItem();
                if (selectedOrderDetail == null) {//Check Weather Table is Select Or Not
                    btnAdd.setText("Add");
                    btnDelete.setDisable(true);
                    return;
                }
                //If Clicked Table Cell
                comboRoomNo.setValue(selectedOrderDetail.getRoomNo()+"");
                txtAdult.setText(selectedOrderDetail.getAdult() + "");
                txtChildren.setText(selectedOrderDetail.getChildren() + "");
                txtDiscount.setText(selectedOrderDetail.getDiscount() + "");
                txtRatePrice.setText(selectedOrderDetail.getRatePrice() + "");
                txtSubTotal.setText(selectedOrderDetail.getSubTotal() + "");
                double x = Double.parseDouble((txtRatePrice.getText()));
                btnDelete.setDisable(false);
                btnAdd.setText("Update");
            }//End Of Override Method
        });

        //set Id Type to  Combo Box(NIC,...)
        typeCombo.setItems(list);

        try {
            //Add|Update ReservationId
            reset();
        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION, "Something Went Wrong!").show();
            return;
        }

    }//End Of the initializer Method


    //Button Add To the Table
    @FXML
    void btnAddOnAction(ActionEvent event) throws Exception {
        //Regex Validations Method Calling
      int x =  formValidations();
      if(x == 1){
            return;
        }
        calculations();
        //Observable List To Store temporary Table details
        ObservableList<GuestControllerTM> details = tblAddGuest.getItems();

        //Getting Input Values
        String arrivalDate = String.valueOf(dateIn.getValue());
        String departureDate = String.valueOf(dateOut.getValue());
        final LocalDate firstDate = LocalDate.parse(arrivalDate);
        final LocalDate secondDate = LocalDate.parse(departureDate);
        final long days = ChronoUnit.DAYS.between(firstDate, secondDate);

        if (days <= 0) {
            new Alert(Alert.AlertType.ERROR, "Invalid Date Input").show();
            return;

        }

        String roomType = (txtroomType.getText() + "");
        String roomNo = comboRoomNo.getValue() + "";
        int adults = Integer.parseInt(txtAdult.getText());
        int children = Integer.parseInt(txtChildren.getText());
        String menu = comboMenu.getValue() + "";
        double discount = Double.parseDouble(txtDiscount.getText()+0);
        double ratePrice = Double.parseDouble(txtRatePrice.getText()+0);
        double subTotal = Double.parseDouble(txtSubTotal.getText()+0);
        String room = String.valueOf(comboRoomNo.getSelectionModel().getSelectedItem()+"");

///////////////////Update MENU Qty When Order Menu In Reservation
//        int menuqty = 0;
//        try {
//            menuqty = Integer.parseInt(menuBO.getmenuQty(menu));
//        } catch (Exception e) {
//            menuqty=1;
//        }
//        if(menuqty <= 0 && !comboMenu.getSelectionModel().getSelectedItem().equals("Not a Menu")){
//            comboMenu.setStyle("-fx-background-color: #FBA18D");
//            new Alert(Alert.AlertType.ERROR,"Menu Qty Is Less than 1").show();
//            return;
//        }
//        comboMenu.setStyle("-fx-background-color: none");

/////////////////Add MenuController Id To the Table From MenuController Description
        try {
            menu = guest.findMenuID(menu);
        } catch (Exception e) { }


        boolean isExists = false;
        for (GuestControllerTM detai : tblAddGuest.getItems()) {
            //Get Table Items
            if (detai.getRoomNo().equals(room)) { //Check  new Add Already Added To The Table
                isExists = true;

                if (btnAdd.getText().equals("Update")) {

                    detai.setDepartureDate(departureDate);
                    detai.setAdult(adults);
                    detai.setChildren(children);
                    detai.setDiscount(discount);
                    detai.setSubTotal(subTotal);
                    totalfind();
                } else {
                    new Alert(Alert.AlertType.INFORMATION, "Same Room No").show();
                    return;
                }
                btnAdd.setText("Add");
                tblAddGuest.refresh();
                tblAddGuest.getSelectionModel().isEmpty();
                break;
            }//End If
        }//End For Each Loop

        if (!isExists) {//Data Adding To the Table

            GuestControllerTM guestControllerTM = new GuestControllerTM(
                    arrivalDate,
                    departureDate,
                    roomType,
                    roomNo,
                    adults,
                    children,
                    menu,
                    discount,
                    ratePrice,
                    subTotal
            );

            String roo = comboRoomNo.getSelectionModel().getSelectedItem();
            boolean available = false;

            try {
                boolean check = roomBO.checkAvilability(available, roo);
                if (check == false) {
                    new Alert(Alert.AlertType.ERROR, "This Room Is Already Checked In\nOr Room is Not Found!").show();
                    return;
                }

                flds.add(roo);


              //  roomBO.updateAvilability(available, roo);
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Cannot Update Room Availability").show();
            }

//            try {
//                menuBO.updateQty(menuqty,menu);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

            details.add(guestControllerTM);
            totalfind();
        }//End If(!isExists)

        //Submit Button
        btnCheckIn.setDisable(false);
        btnDelete.setDisable(true);
    }//End Method btnAddOnAction

    private void totalfind() throws Exception{
        double tot =0;
        ObservableList<GuestControllerTM> observableList = tblAddGuest.getItems();
        for (GuestControllerTM gm: observableList) {
            tot += gm.getSubTotal();
        }
        double f= manageBO.getCurrency1("CUUSD");
        double f2= manageBO.getCurrency1("CUEURO");
        if(comboCurrency.getSelectionModel().getSelectedItem().equals("US Dollar")){
            tot/=f;
            lblCurrencysymble.setText("$");
        }
        if(comboCurrency.getSelectionModel().getSelectedItem().equals("Euro")){
            tot/=f2;
            lblCurrencysymble.setText("€");
        }
        if(comboCurrency.getSelectionModel().getSelectedItem().equals("")){
            lblCurrencysymble.setText("SLR");
        }

        txtTotal.setText(String.valueOf(tot));


    }



    @FXML
    void btnCalculatorOnAction(ActionEvent event) {
        CalculatorForm g = new CalculatorForm();
        g.setVisible(true);
    }




    //Submit All Table Data To the DataBase(Table (Guest,Reservation,ReservationDetails))
    @FXML
    void btnCheckInOnAction(ActionEvent event) throws Exception {
        double T = 0;
        double TT = guest.getGestTotal(T, txtGuestId.getText());
        double newVal = Double.parseDouble(txtTotal.getText());
        TT += newVal;
        String defaultCurrency;
        if (comboCurrency.getSelectionModel().getSelectedItem().equals("")) {
            defaultCurrency = "SLR";
        } else {
            defaultCurrency = comboCurrency.getSelectionModel().getSelectedItem();
        }
        guest.submitReserVation2(
                txtGuestId.getText(),
                typeCombo.getSelectionModel().getSelectedItem(),
                txtGuestName.getText(),
                txtGuestEmail.getText(),
                txtGuestAddress.getText(),
                txtPlateNo.getText(),
                txtTotal.getText(),
                lblReservationId.getText(),
                lblCurrentDate.getText(),
                defaultCurrency,
                txtDiscount.getText(),
                txtSubTotal.getText(),
                String.valueOf(TT),
                lblSubmitCheckIn.getText(),
                tblAddGuest.getItems());

        guest.updateGuestTotal(TT, txtGuestId.getText());
        //Add|Update ReservationId
        reset();
        int i=0;
        boolean available = false;
        for(String s3 : flds){
                String sss = flds.get(i++);
                roomBO.updateAvilability(available, sss);
        }
        comboMenu.getSelectionModel().clearSelection();
        typeCombo.getSelectionModel().clearSelection();
        txtAdult.setText("0");
        txtChildren.setText("0");
        txtGuestName.clear();
        txtDiscount.setText("0");
        txtSubTotal.setText("0");
        txtTotal.clear();
        txtGuestAddress.clear();
        txtGuestEmail.clear();
        txtPlateNo.clear();
        txtRatePrice.clear();
        txtGuestId.clear();
        txtroomType.clear();
    }


    //Add|Update ReservationId
    public void reset() throws Exception {

        tblAddGuest.getItems().clear();
        txtTotal.setText("0");

        int maxReserveId = 1;


            //Calling to DAO Find Max Id
            String r = guest.getAll();


            int maxId = 0;
            if (r == null) {
                maxId = 0;
            } else {
                maxId = Integer.parseInt(r.replace("R", ""));
            }
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "R00" + maxId;
            } else if (maxId < 100) {
                id = "R0" + maxId;
            } else {
                id = "R" + maxId;
            }
            lblReservationId.setText(id);

    }


    @FXML
    void btnResetOnAction(ActionEvent event) {
        comboMenu.getSelectionModel().clearSelection();
        typeCombo.getSelectionModel().clearSelection();
        txtAdult.setText("0");
        txtChildren.setText("0");
        txtGuestName.clear();
        txtDiscount.setText("0");
        txtSubTotal.setText("0");
        txtTotal.clear();
        txtGuestAddress.clear();
        txtGuestEmail.clear();
        tblAddGuest.getItems().clear();
        txtPlateNo.clear();
        txtRatePrice.clear();
        txtGuestId.clear();
        txtroomType.clear();
    }

    @FXML
    void btnSelectOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/ijse/deppo/hotelManagement/view/RoomSelect.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("New Form");
        stage.setScene(new Scene(root));
        stage.show();
    }



    @FXML
    void comboRoomNoOnAction(ActionEvent event) throws Exception {

        String type = roomBO.loadAllRoomNO(comboRoomNo.getSelectionModel().getSelectedItem());
        String state = roomBO.loadAllRoomN1(comboRoomNo.getSelectionModel().getSelectedItem());
        String cate = roomBO.loadAllRoomN2(comboRoomNo.getSelectionModel().getSelectedItem());
        String price = roomBO.loadAllRoomN3(comboRoomNo.getSelectionModel().getSelectedItem());
        if(!cate.equals("Clean")){
             btnCheckIn.setStyle("-fx-background-color: RED");
        }
        else {
            btnCheckIn.setStyle("-fx-background-color: navy");
        }
        txtroomType.setText(type);
        txtRoomCondition.setText(state);
        txtState.setText(cate);
        txtRatePrice.setText(price);
//        double t= Double.parseDouble(txtSubTotal.getText());
//        double price2 = Double.parseDouble(price);
//        double enwt = (t-t)+price2;
     //   txtSubTotal.setText(String.valueOf(enwt));
        dateOut.requestFocus();
    }


    @FXML
    void txtGuestIdOnAction(ActionEvent event) throws Exception {
        txtGuestName.requestFocus();
        String del_code = txtGuestId.getText();
        if (del_code.equals("")) {

            new Alert(Alert.AlertType.INFORMATION, "Please Enter a Id Card No").show();
            txtGuestId.requestFocus();
            return;
        }
        //String d= ManageCustomersBusiness.findCustomer(del_code).getId();

        String d1 = null;
        try {
            d1 = guest.findCustomer(del_code).getIdType();
        } catch (Exception e) {
            return;
        }
        String d2 = guest.findCustomer(del_code).getGuestName();
        String d3 = guest.findCustomer(del_code).getCountry();
        String d4 = guest.findCustomer(del_code).getEmail();
        String d5 = guest.findCustomer(del_code).getVehicle();
        String d6 = guest.findCustomer(del_code).getTotal();

        txtGuestEmail.setText(d4);
        txtGuestAddress.setText(d3);
        txtGuestName.setText(d2);
        typeCombo.setValue(d1);
        txtPlateNo.setText(d5);
        txtTotal.setText(d6);

    }

    public void IconNavigate(MouseEvent event) throws IOException {

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
                case "iconFandB":
                    root1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Food&Bev.fxml"));
                    break;
                case "iconClean":
                    root1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/HouseKeeping.fxml"));
                    break;
                case "imgReserVation":
                    root1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/ManageGuest.fxml"));
                    break;
                case "iconStore":
                    root1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Menu.fxml"));
                    break;

            }

            if (root1 != null) {
                Scene subScene = new Scene(root1);
                Stage primaryStage = (Stage) this.root1.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }
    }
    public void IconNavigatex(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/ijse/deppo/hotelManagement/view/EditReservation.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("ManageReservation");
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
        stage.show();
    }

    public void btnStateOnAction2(ActionEvent actionEvent) {
        int x = Integer.parseInt(txtAdult.getText());
        x++;
        txtAdult.setText(String.valueOf(x));
    }

    public void btnStateOnAction1(ActionEvent actionEvent) {
        int x = Integer.parseInt(txtAdult.getText());
        x--;
        if (x < 0) {
            new Alert(Alert.AlertType.INFORMATION, "Something Went Wrong!").show();
            return;
        }
        txtAdult.setText(String.valueOf(x));
    }

    public void btnStateOnAction3(ActionEvent actionEvent) {
        int x = Integer.parseInt(txtChildren.getText());
        x--;
        if (x < 0) {
            new Alert(Alert.AlertType.INFORMATION, "Something Went Wrong!").show();
            return;
        }
        txtChildren.setText(String.valueOf(x));
    }

    @FXML
    void btnStateOnAction(ActionEvent event) {
        int x = Integer.parseInt(txtChildren.getText());
        x++;
        txtChildren.setText(String.valueOf(x));
    }

    @FXML
    public void comboMenuOnAction(ActionEvent actionEvent) throws Exception {
        calculations();

    }

    private void calculations() {
        LocalDate startDate = dateIn.getValue();
        LocalDate endDate = dateOut.getValue();
        int dates = (int) ChronoUnit.DAYS.between(startDate, endDate);
        String selectedItem = (String) comboMenu.getSelectionModel().getSelectedItem();
        double price = 0;
        try {
            price = Double.parseDouble((menuBO.GetMenuPrice(selectedItem)));
        } catch (Exception e) {

        }
        int adultCount = Integer.parseInt(txtAdult.getText());
        int childCount = Integer.parseInt(txtChildren.getText());
        double mealPriceforAllDays = (int) (price * (dates));
        adultCount += childCount;
        mealPriceforAllDays *= adultCount;
        double ratePrice = Double.parseDouble(txtRatePrice.getText()+0);
        double discount = Double.parseDouble(txtDiscount.getText()+0);
        mealPriceforAllDays += ratePrice;
        mealPriceforAllDays -= (mealPriceforAllDays * (discount / 100));
        txtSubTotal.setText(String.valueOf(mealPriceforAllDays));

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        //Observable List To Store temporary Table details
        ObservableList<GuestControllerTM> details = tblAddGuest.getItems();
    }
    @FXML
    void dateInOnAction(ActionEvent event) {

    }

    @FXML
    void dateOutOnAction(ActionEvent event) {

    }


    @FXML
    void searchGuestMouseClick(MouseEvent event) {

    }

    @FXML
    void tblCustomers_OnMouseClicked(MouseEvent event) {
        // btnDelete.setDisable(false);
    }

    @FXML
    void txtAdultOnAction(ActionEvent event) {

    }

    @FXML
    void txtChildrenOnAction(ActionEvent event) {

    }

    @FXML
    void txtDiscountOnAction(ActionEvent event) {

    }

    @FXML
    void txtGuestAddressOnAction(ActionEvent event) {
        txtGuestEmail.requestFocus();
    }
    @FXML
    void txtGuestNameOnAction(ActionEvent event) {
        txtGuestAddress.requestFocus();
    }

    @FXML
    void txtPlateNoOnAction(ActionEvent event) {

    }

    @FXML
    void txtRatePriceOnAction(ActionEvent event) {


    }

    @FXML
    void txtSubTotalOnAction(ActionEvent event) {

    }

    @FXML
    void txtTotalOnAction(ActionEvent event) {

    }

    @FXML
    void typeComboOnAction(ActionEvent event) {
        txtGuestId.requestFocus();

    }
    @FXML
    void txtGuestEmailOnAction(ActionEvent event) {
        txtPlateNo.requestFocus();
    }
    @FXML
    void comboCurrencyOnAction(ActionEvent event) {
    }
    //Regex Method For Validations
    private int formValidations() {

        String roomNo = comboRoomNo.getValue() + "";
        String menu = comboMenu.getValue() + "";
        String id = txtGuestId.getText()+"";
        double discount = Double.parseDouble(txtDiscount.getText()+0);
        double ratePrice = Double.parseDouble(txtRatePrice.getText()+0);
        double subTotal = Double.parseDouble(txtSubTotal.getText()+0);
        if (id.equals(null)) {
            new Alert(Alert.AlertType.ERROR, "Please Enter  ID").show();
            txtGuestId.setStyle("-fx-background-color: #F9A693");
            return 1;
        }
        txtGuestId.setStyle("-fx-background-color: none");

        if (!txtGuestName.getText().matches("[A-Za-z][A-Za-z. ]+")) {
            new Alert(Alert.AlertType.ERROR, "Invalid Name").show();
            txtGuestName.setStyle("-fx-background-color: #F9A693");
            return 1;
        }
        txtGuestName.setStyle("-fx-background-color: none");


        if (!txtGuestAddress.getText().matches("[A-Za-z][A-Za-z. ]+")) {
            new Alert(Alert.AlertType.ERROR, "Invalid Country Name").show();
            txtGuestAddress.setStyle("-fx-background-color: #F9A693");
            return 1;
        }
        txtGuestAddress.setStyle("-fx-background-color: none");

        if (txtAdult.getText().equals("0") && txtChildren.getText().equals("0")) {
            new Alert(Alert.AlertType.ERROR, "Please Enter Members").show();
            txtAdult.setStyle("-fx-background-color: #F9A693");
            txtChildren.setStyle("-fx-background-color: #F9A693");
            return 1;
        }
        txtAdult.setStyle("-fx-background-color: none");
        txtChildren.setStyle("-fx-background-color: none");

        if (!(txtAdult.getText().matches("^\\d+$") && txtChildren.getText().matches("^\\d+$"))) {
            new Alert(Alert.AlertType.ERROR, "Please Check Members values Members").show();
            txtAdult.setStyle("-fx-background-color: #F9A693");
            txtChildren.setStyle("-fx-background-color: #F9A693");
            return 1;
        }
        txtAdult.setStyle("-fx-background-color: none");
        txtChildren.setStyle("-fx-background-color: none");

        if (!txtDiscount.getText().matches("^(\\d+(\\.\\d+)?)$")) {
            new Alert(Alert.AlertType.ERROR, "Please Enter Valid Number").show();
            txtDiscount.setStyle("-fx-background-color: #F9A693");
            return 1;
        }
        txtDiscount.setStyle("-fx-background-color: none");

        if (!(menu.equals("Full Board") | menu.equals("Half Board") | menu.equals("Not a Menu"))) {
            new Alert(Alert.AlertType.ERROR, "Please Select a Menu").show();
            comboMenu.setStyle("-fx-background-color: #F9A693");
            return 1;
        }
        comboMenu.setStyle("-fx-background-color: none");

        if (roomNo.equals("")) {
            new Alert(Alert.AlertType.ERROR, "Please Select a Room").show();
            comboRoomNo.setStyle("-fx-background-color: #F9A693");
            return 1;
        }
        comboRoomNo.setStyle("-fx-background-color: none");
        return 0;
    }//End Regex Method(Validations)

}//End The Class GuestController
