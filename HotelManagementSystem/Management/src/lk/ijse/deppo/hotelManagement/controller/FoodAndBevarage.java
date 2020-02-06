package lk.ijse.deppo.hotelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import lk.ijse.deppo.hotelManagement.business.custom.FoodAndBevBO;
import lk.ijse.deppo.hotelManagement.business.custom.GuestBO;
import lk.ijse.deppo.hotelManagement.business.custom.MenuBO;
import lk.ijse.deppo.hotelManagement.db.DBConnection;
import lk.ijse.deppo.hotelManagement.util.EditReservationTM;
import lk.ijse.deppo.hotelManagement.util.FoodAndBrvTM;
import lk.ijse.deppo.hotelManagement.util.MenuTM;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class FoodAndBevarage implements Initializable {

    public AnchorPane root;
    public TableView<MenuTM> tblItem;
    public TableView<FoodAndBrvTM> tblOrder;
    public TableView<EditReservationTM> tblCustomer;
    @FXML
    private JFXTextField txtOrderId;

    @FXML
    private Label lblNoOfRooms;

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
    private JFXTextField txtItemCode;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXDatePicker date;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtItemDes;

    @FXML
    private JFXTextField txtUnitePrice;

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private JFXTextField txtUnitePrice1;

    private boolean readOnly = false;
    private MenuBO menuBO = BOFactory.getInstance().getBO(BOTypes.MENU);
    private FoodAndBevBO foodAndBevBO = BOFactory.getInstance().getBO(BOTypes.FOODANDBEV);
    private GuestBO guest = BOFactory.getInstance().getBO(BOTypes.GUEST);

    //    private CustomerBO customerBO = BOFactory.getInstance().getBO(BOTypes.GUEST);
//    private BanquetBOImpl itemBO = BOFactory.getInstance().getBO(BOTypes.ITEM);
//    private OrderBO orderBO = BOFactory.getInstance().getBO(BOTypes.ORDER);
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Fade Style
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2500), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        //Lets Map The Table table
        tblItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        tblItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("price"));


        tblOrder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("itmCode"));
        tblOrder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblOrder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblOrder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitePrice"));
        tblOrder.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));

        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("guestId"));
        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("guestName"));

        date.setDisable(true);
        txtOrderId.setDisable(true);
        date.setValue(LocalDate.now());
        txtCustomerId.requestFocus();
        txtCustomerId.setDisable(true);
        txtCustomerName.setDisable(true);

        //Get All MenuController Description
        try {
            menuBO.loadAllMenu(tblItem.getItems());
            guest.loadFandBCustomers(tblCustomer.getItems());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // When a table row is selected
        tblOrder.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<FoodAndBrvTM>() {
            @Override
            public void changed(ObservableValue<? extends FoodAndBrvTM> observable, FoodAndBrvTM oldValue, FoodAndBrvTM newValue) {

                FoodAndBrvTM selectedOrderDetail = tblOrder.getSelectionModel().getSelectedItem();
                if (selectedOrderDetail == null) {
                    if (!readOnly) {
                        btnAdd.setText("Add");
                    }
                    return;
                }

                txtQty.setText(selectedOrderDetail.getQty() + "");
                // Don't think about this now...!
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        txtQty.requestFocus();
                        txtQty.selectAll();
                    }
                });
                if (!readOnly) {
                    btnAdd.setText("Update");
                }
            }
        });
        try {
            reset();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//End Initialized

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
                case "iconClean":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/HouseKeeping.fxml"));
                    break;
                case "iconStore":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/BanquetManagement.fxml"));
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
        int x = regexValidations();
        if (x == 1) {
            return;
        }
        int qty = Integer.parseInt(txtQty.getText());
        int qtyOnHand = Integer.parseInt(txtQtyOnHand.getText());
        double unitPrice = Double.parseDouble(txtUnitePrice.getText());

        // Let's validate the qty.
        if (qty <= 0 || qty > qtyOnHand) {
            new Alert(Alert.AlertType.ERROR, "Invalid Qty", ButtonType.OK).show();
            txtQty.requestFocus();
            txtQty.selectAll();
            return;
        }


        ObservableList<FoodAndBrvTM> details = tblOrder.getItems();

        boolean isExists = false;
        for (FoodAndBrvTM detail : tblOrder.getItems()) {
            if (detail.getItmCode().equals(txtItemCode.getText())) {
                isExists = true;

                if (btnAdd.getText().equals("Update")) {
                    detail.setQty(qty);
                } else {
                    detail.setQty(detail.getQty() + qty);
                    updateQty(txtItemCode.getText(), qty);
                }
                detail.setTotal(detail.getQty() * detail.getUnitePrice());
                tblOrder.refresh();

                break;
            }
        }
        Date d = Date.valueOf(date.getValue());
        if (!isExists) {
            FoodAndBrvTM detailTM = new FoodAndBrvTM(
                    txtItemCode.getText(),
                    txtItemDes.getText(),
                    qty,
                    d,
                    unitPrice,
                    qty * unitPrice
            );
            updateQty(txtItemCode.getText(), qty);
            details.add(detailTM);
        }


        // Calculate the grand total
        calculateTotal();
        enablePlaceOrderButton();
        tblOrder.getSelectionModel().clearSelection();
    }

    private int regexValidations() {

        if (!(txtQty.getText().matches("^\\d+$"))) {
            new Alert(Alert.AlertType.ERROR, "Please Check Qty values").show();
            txtQty.setStyle("-fx-background-color: #F9A693");
            return 1;
        }
        txtQty.setStyle("-fx-background-color: none");
        return 0;
    }

    private void updateQty(String selectedItemCode, int qty) {
        ObservableList<MenuTM> details = tblItem.getItems();
        double total = 0;
        for (MenuTM detail : details) {
            if (detail.getId().equals(selectedItemCode)) {
                detail.setQtyOnHand(detail.getQtyOnHand() - qty);
                tblItem.refresh();
                break;
            }
        }

    }

    private void enablePlaceOrderButton() {
    }

    private void calculateTotal() {
        ObservableList<FoodAndBrvTM> details = tblOrder.getItems();

        double total = 0;
        for (FoodAndBrvTM detail : details) {
            total += detail.getTotal();
        }

        // Let's format the total
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        nf.setGroupingUsed(false);

        txtUnitePrice1.setText("Total : " + nf.format(total));
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) throws Exception {
        double dd = 0;
        double d = guest.getGuestTota(dd, txtCustomerId.getText());
        ObservableList<FoodAndBrvTM> details = tblOrder.getItems();


        double total = 0,j=0;
        for (FoodAndBrvTM detail : details) {
        int qty =detail.getQty();

        String itemCode = detail.getDescription();
         int x= Integer.parseInt(menuBO.getmenuQty(itemCode));

            x-=qty;
         menuBO.updateMenuQty(itemCode,x);

            total += detail.getTotal();
        }

        String e = String.valueOf(total);
        total += d;
       String t = txtCustomerId.getText();
        if(t.equals("")){
            new Alert(Alert.AlertType.ERROR,"Please Add Customers").show();
            return;
        }

        foodAndBevBO.placeOrder(e,txtOrderId.getText(), txtCustomerId.getText(), tblOrder.getItems());


        guest.updateGuestTotal(total, txtCustomerId.getText());


        tblOrder.getItems().clear();
        txtCustomerId.clear();
        txtUnitePrice.clear();
        txtCustomerName.clear();
        txtQty.clear();
        txtItemDes.clear();
        txtQtyOnHand.clear();
        txtItemCode.clear();
        String Id= txtOrderId.getText();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/lk/ijse/deppo/hotelManagement/report/mainForm2.jasper"));
        Map<String, Object> params = new HashMap<>();
        params.put("id", Id);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, DBConnection.getInstance().getConnection());
        JasperViewer.viewReport(jasperPrint, false);
        reset();
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {

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
    void txtCustomerNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtItemCodeOnAction(ActionEvent event) {

    }

    @FXML
    void txtItemDesOnAction(ActionEvent event) {

    }

    @FXML
    void txtOrderIdOnAction(ActionEvent event) {

    }

    @FXML
    void txtQtyOnAction(ActionEvent event) {

    }

    @FXML
    void txtQtyOnHandOnAction(ActionEvent event) {

    }

    @FXML
    void txtUnitePriceOnAction(ActionEvent event) {

    }

    private void reset() throws Exception {
//        lblDate.setText(LocalDate.now() + "");
//
//        btnPlaceOrder.setDisable(true);
//        btnSave.setDisable(true);
//        txtCustomerName.setEditable(false);
//        txtCustomerName.clear();
//        txtDescription.setEditable(false);
//        txtUnitPrice.setEditable(false);
//        txtQtyOnHand.setEditable(false);
//        txtQty.setEditable(false);
//        tblOrderDetails.getItems().clear();
//        lblTotal.setText("Total : 0.00");

        int maxReserveId = 1;


        //Calling to DAO Find Max Id
        String r = foodAndBevBO.getAll();


        int maxId = 0;
        if (r == null) {
            maxId = 0;
        } else {
            maxId = Integer.parseInt(r.replace("OR", ""));
        }
        maxId = maxId + 1;
        String id = "";
        if (maxId < 10) {
            id = "OR00" + maxId;
        } else if (maxId < 100) {
            id = "OR0" + maxId;
        } else {
            id = "OR" + maxId;
        }
        txtOrderId.setText(id);

    }


    public void tblrder_OnMouseClicked(MouseEvent mouseEvent) {
    }

    @FXML
    void tblCustomers_OnMouseClicked(MouseEvent mouseEvent) {
        String iD = "", name = "";
        if (mouseEvent.getClickCount() == 1) {

            try {//For Get Selection Item Is Null
                if (!tblCustomer.getSelectionModel().getSelectedItem().getGuestId().equals("")) {
                    //Getting Selected Cell Price
                    iD = tblCustomer.getSelectionModel().getSelectedItem().getGuestId();
                    name = tblCustomer.getSelectionModel().getSelectedItem().getGuestName();
                }
            } catch (Exception c) {
                c.printStackTrace();
            }
            txtCustomerName.setText(name);
            txtCustomerId.setText(iD);
        }

    }

    public void tblMenu_OnMouseClicked(MouseEvent mouseEvent) {
        String iD = "";
        String name = "";
        String pr = "";
        String qty = "";
        if (mouseEvent.getClickCount() == 1) {

            try {//For Get Selection Item Is Null
                if (!tblItem.getSelectionModel().getSelectedItem().getId().equals("")) {
                    //Getting Selected Cell Price
                    iD = tblItem.getSelectionModel().getSelectedItem().getId();
                    name = tblItem.getSelectionModel().getSelectedItem().getDescription();
                    pr = String.valueOf(tblItem.getSelectionModel().getSelectedItem().getPrice());
                    qty = String.valueOf(tblItem.getSelectionModel().getSelectedItem().getQtyOnHand());

                }
            } catch (Exception c) {
                return;
            }


            txtItemCode.setText(iD);
            txtItemDes.setText(name);
            txtQtyOnHand.setText(qty);
            txtUnitePrice.setText(pr);
        }

    }
}
