package lk.ijse.deppo.hotelManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
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
import lk.ijse.deppo.hotelManagement.business.custom.MenuBO;
import lk.ijse.deppo.hotelManagement.dto.MenuDTO;
import lk.ijse.deppo.hotelManagement.util.MenuTM;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuController implements Initializable {

    public JFXTextField txtOrderId;
    public Label lblNoOfRooms;
    public Label total;
    public TableView<MenuTM> tblItems1;
    @FXML
    private AnchorPane root;


    @FXML
    private JFXTextField txtItemCode;

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXTextField txtUnitPrice;

    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXTextField fullCount;

    @FXML
    private JFXTextField fullCount1;

    @FXML
    private JFXTextField fullCount11;

    @FXML
    private JFXTextField fullCount12;

    @FXML
    private JFXTextField fullCount13;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private TableView<MenuTM> tblItems;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXButton btnReport;

    @FXML
    private JFXButton btnAddNew;

    @FXML
    private JFXButton reset;

    private MenuBO menuBO = BOFactory.getInstance().getBO(BOTypes.MENU);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//Fade Style
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2500), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        tblItems.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblItems.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblItems.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        tblItems.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("price"));

        tblItems1.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("guestID"));
        tblItems1.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("fullBoard"));
        tblItems1.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("halfBoard"));


        try {
            menuBO.loadAllMenu(tblItems.getItems());
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            int coutn = menuBO.getDailyList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int countF = 0, countH = 0;

        try {
            List<MenuDTO> allGuest = menuBO.getGuest();
            ObservableList<MenuTM> customers = tblItems1.getItems();
            for (MenuDTO c : allGuest) {
                customers.add(new MenuTM(c.getRessevationId(), c.getGuestId(), c.getMaalID()));
                if (c.getMaalID().equals("M001")) {
                    countF++;
                }
                fullCount.setText(String.valueOf(countF));
                if (c.getMaalID().equals("M002")) {
                    countH++;
                }
                fullCount1.setText(String.valueOf(countH));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int cx = Integer.parseInt(fullCount.getText()+0);
        int cx1 = Integer.parseInt(fullCount1.getText()+0);
        int br = 0, Lu = 0, Di = 0;
        br += cx;
        br += cx1;
        Lu += cx;
//        fullCount12.setText(String.valueOf(br));
//        fullCount13.setText(String.valueOf(Lu));
//        fullCount11.setText(String.valueOf(br));
        tblItems.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MenuTM>() {
            @Override
            public void changed(ObservableValue<? extends MenuTM> observable, MenuTM oldValue, MenuTM newValue) {
                MenuTM selectedItem = tblItems.getSelectionModel().getSelectedItem();

                if (selectedItem != null) {
                    btnAddNew.setDisable(false);
                    btnSave.setDisable(true);
                    btnDelete.setDisable(true);
                    btnDelete.setDisable(false);
                    txtItemCode.setDisable(true);
                    txtQty.setDisable(false);
                    txtItemCode.setText(selectedItem.getId());
                    txtDescription.setText(selectedItem.getDescription());
                    txtUnitPrice.setText(String.valueOf(selectedItem.getPrice()));
                    txtQty.setText(String.valueOf(selectedItem.getQtyOnHand()));
                }
                btnAddNew.setDisable(true);
                btnSave.setDisable(false);
                btnDelete.setDisable(false);
            }
        });
        txtItemCode.setDisable(true);
        try {
            maxMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
        totalMenu();
    }

    private void totalMenu() {
        ObservableList<MenuTM> menu = tblItems.getItems();
        int i = 0;
        for (MenuTM m : menu) {
            i++;
            total.setText(String.valueOf(i));
        }
    }

    private void maxMenu() throws Exception {
        int maxMenuId = 1;


        //Calling to DAO Find Max Id
        String r = menuBO.getMax();

        int maxId = 0;
        if (r == null) {
            maxId = 0;
        } else {
            maxId = Integer.parseInt(r.replace("M", ""));
        }
        maxId = maxId + 1;
        String id = "";
        if (maxId < 10) {
            id = "M00" + maxId;
        } else if (maxId < 100) {
            id = "M0" + maxId;
        } else {
            id = "M" + maxId;
        }
        txtItemCode.setText(id);
    }

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
                case "iconFandB":
                    root1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Food&Bev.fxml"));
                    break;
                case "iconClean":
                    root1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/Food&Bev.fxml"));
                    break;
                case "imgReserVation":
                    root1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/ManageGuest.fxml"));
                    break;
                case "iconStore":
                    root1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/deppo/hotelManagement/view/HouseKeeping.fxml"));
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
    }

    @FXML
    void SearchGuest(MouseEvent event) {

    }

    @FXML
    void btnAddNew_OnAction(ActionEvent event) {
        if (!txtDescription.getText().matches("[A-Za-z][A-Za-z. ]+")) {
            new Alert(Alert.AlertType.ERROR, "Invalid Name").show();
            return;
        }

        int qtyOnHand = Integer.parseInt(txtQty.getText());
        double unitePrice = Double.parseDouble(txtUnitPrice.getText());
        if (btnAddNew.getText().equals("Add New")) {
            ObservableList<MenuTM> menu = tblItems.getItems();

            MenuDTO newMenu = new MenuDTO(
                    txtItemCode.getText(),
                    unitePrice,
                    txtDescription.getText(),
                    qtyOnHand
            );
            try {

                menuBO.saveMenu(newMenu);
                menu.add(new MenuTM(newMenu.getId(), newMenu.getPrice(), newMenu.getDescription(), newMenu.getQty()));
                btnAddNew_OnAction(event);

            } catch (Exception e) {
            }
        }
//        if (btnAddNew.getText().equals("Update")) {
//            MenuTM selectedMenu = tblItems.getSelectionModel().getSelectedItem();
//            try {
//                MenuBOImpl.updateMenu(new MenuTM(selectedMenu.getId(),
//                        unitePrice,
//                        txtDescription.getText(),
//                        qtyOnHand
//                        ));
//                selectedMenu.setDescription(txtDescription.getText());
//                selectedMenu.setPrice(unitePrice);
//                selectedMenu.setQtyOnHand(qtyOnHand);
//                tblItems.refresh();
//                btnAddNew_OnAction(event);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }


    @FXML
    void btnDelete_OnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Are you sure whether you want to delete this customer?",
                ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get() == ButtonType.YES) {
            MenuTM selectedItem = tblItems.getSelectionModel().getSelectedItem();
            try {
                menuBO.deleteCustomer(selectedItem.getId());
                tblItems.getItems().remove(selectedItem);
            } catch (Exception e) {
                new Alert(Alert.AlertType.INFORMATION,"Something went wrong").show();
            }

        }
    }

    @FXML
    void btnReport_OnAction(ActionEvent event) {

    }

    @FXML
    void btnSave_OnAction(ActionEvent event) throws Exception {


        String price = "";

        try {//For Get Selection Item Is Null

            //Getting Selected Cell Price
            String itemCode = txtItemCode.getText();
            String description = txtDescription.getText();
            double unitePrice = Double.parseDouble(txtUnitPrice.getText());
            int qty = Integer.parseInt(txtQty.getText());
            menuBO.updateItem(itemCode, description, unitePrice, qty);
            menuBO.loadAllMenu(tblItems.getItems());
            tblItems.refresh();
            btnSave.setDisable(true);
            btnDelete.setDisable(true);
            btnAddNew.setDisable(false);
            txtQty.clear();
            txtUnitPrice.clear();
            txtDescription.clear();
            maxMenu();
        } catch (Exception c) {
            new Alert(Alert.AlertType.ERROR, "Somting went wrong in Update").show();
        }
        // txtOrderId11.setText(price);
    }//End Of The If Condition


    @FXML
    void ssaction(ActionEvent event) {

    }

    @FXML
    void tblItems_OnMouseClicked(MouseEvent event) {
        String empty = "";
        if (tblItems.getSelectionModel().getSelectedItem().getId().equals(empty)) {
            btnAddNew.setDisable(false);
            btnSave.setDisable(true);
        }
    }

    @FXML
    void txtOrderIdOnAction(ActionEvent event) {

    }

}
