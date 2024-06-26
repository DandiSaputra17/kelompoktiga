/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelompoktiga;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Lenovo
 */
public class mainFormController implements Initializable {

    @FXML
    private Button customers_btn;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Button inventory_addBtn;

    @FXML
    private Button inventory_btn;

    @FXML
    private Button inventory_clearBtn;

    @FXML
    private TableColumn<productData, String> inventory_col_date;

    @FXML
    private TableColumn<productData, String> inventory_col_price;

    @FXML
    private TableColumn<productData, String> inventory_col_productID;

    @FXML
    private TableColumn<productData, String> inventory_col_productName;

    @FXML
    private TableColumn<productData, String> inventory_col_status;

    @FXML
    private TableColumn<productData, String> inventory_col_stock;

    @FXML
    private TableColumn<productData, String> inventory_col_type;

    @FXML
    private Button inventory_deleteBtn;

    @FXML
    private AnchorPane inventory_form;

    @FXML
    private ImageView inventory_imageView;

    @FXML
    private Button inventory_importBtn;

    @FXML
    private TableView<productData> inventory_tableView;

    @FXML
    private Button inventory_updateBtn;

    @FXML
    private Button logout_btn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button menu_btn;

    @FXML
    private Label username;

    @FXML
    private TextField inventory_price;

    @FXML
    private TextField inventory_productID;

    @FXML
    private TextField inventory_productName;

    @FXML
    private TextField inventory_stock;

    @FXML
    private ComboBox<?> inventory_status;

    @FXML
    private ComboBox<?> inventory_type;

    @FXML
    private TextField menu_amount;

    @FXML
    private TextField menu_customer;

    @FXML
    private Label menu_change;

    @FXML
    private TableColumn<productData, String> menu_col_price;

    @FXML
    private TableColumn<productData, String> menu_col_productName;

    @FXML
    private TableColumn<productData, String> menu_col_quantity;

    @FXML
    private AnchorPane menu_form;

    @FXML
    private GridPane menu_gridPane;

    @FXML
    private Button menu_payBtn;

    @FXML
    private Button menu_receiptBtn;

    @FXML
    private Button menu_removeBtn;

    @FXML
    private ScrollPane menu_scrollPane;

    @FXML
    private TableView<productData> menu_tableView;

    @FXML
    private Label menu_total;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private TableColumn<customersData, String> customers_col_cashier;

    @FXML
    private TableColumn<customersData, String> customers_col_customerID;

    @FXML
    private TableColumn<customersData, String> customers_col_date;

    @FXML
    private TableColumn<customersData, String> customers_col_total;

    @FXML
    private TableColumn<customersData, String> customers_col_customer;

    @FXML
    private AnchorPane customers_form;

    @FXML
    private TableView<customersData> customers_tableView;

    @FXML
    private BarChart<?, ?> dashboard_CustomerChart;

    @FXML
    private Label dashboard_NC;

    @FXML
    private Label dashboard_NSP;

    @FXML
    private Label dashboard_TI;

    @FXML
    private AreaChart<?, ?> dashboard_incomeChart;

    @FXML
    private Label dashboard_totalI;

    @FXML
    private Button daily_report_btn;

    @FXML
    private AnchorPane daily_report_form;

    @FXML
    private TableColumn<customersData, String> daily_report_col_cashier;

    @FXML
    private TableColumn<customersData, String> daily_report_col_customer;

    @FXML
    private TableColumn<customersData, String> daily_report_col_customerID;

    @FXML
    private TableColumn<customersData, String> daily_report_col_date;

    @FXML
    private TableColumn<customersData, String> daily_report_col_total;

    @FXML
    private TableView<customersData> daily_report_customer_tableView;

    @FXML
    private Button removeCustomerBtn;

    @FXML
    private Button addProducts_addBtn;

    @FXML
    private TextField addProducts_brand;

    @FXML
    private Button addProducts_btn;

    @FXML
    private TableColumn<supplierData, String> addProducts_col_brand;

    @FXML
    private TableColumn<supplierData, String> addProducts_col_price;

    @FXML
    private TableColumn<supplierData, String> addProducts_col_supplierId;

    @FXML
    private TableColumn<supplierData, String> addProducts_col_productName;

    @FXML
    private TableColumn<supplierData, String> addProducts_col_status;

    @FXML
    private TableColumn<supplierData, String> addProducts_col_supplierName;

    @FXML
    private TableColumn<supplierData, String> addProducts_col_type;

    @FXML
    private Button addProducts_deleteBtn;

    @FXML
    private AnchorPane addProducts_form;

    @FXML
    private ImageView addSuppliersProducts_imageView;

    @FXML
    private Button addProducts_importBtn;

    @FXML
    private TextField addProducts_price;

    @FXML
    private TextField addProducts_productId;

    @FXML
    private TextField addProducts_productName;

    @FXML
    private TextField addProducts_supplierName;

    @FXML
    private ComboBox<?> addProducts_productType;

    @FXML
    private Button addProducts_resetBtn;

    @FXML
    private TextField addProducts_search;

    @FXML
    private ComboBox<?> addProducts_status;

    @FXML
    private TableView<supplierData> addProducts_tableView;

    @FXML
    private AnchorPane addProducts_imageView;

    @FXML
    private Button addProducts_updateBtn;

    @FXML
    private TextField orders_amount;

    @FXML
    private Label orders_balance;

    @FXML
    private ComboBox<?> orders_brand;

    @FXML
    private Button orders_btn;

    @FXML
    private TableColumn<ordersData, String> orders_col_brand;

    @FXML
    private TableColumn<ordersData, String> orders_col_price;

    @FXML
    private TableColumn<ordersData, String> orders_col_productName;

    @FXML
    private TableColumn<ordersData, String> orders_col_quantity;

    @FXML
    private TableColumn<ordersData, String> orders_col_type;

    @FXML
    private AnchorPane orders_form;

    @FXML
    private Button orders_payBtn;

    @FXML
    private ComboBox<?> orders_productName;

    @FXML
    private ComboBox<?> orders_productsType;

    @FXML
    private Spinner<Integer> orders_quantity;

    @FXML
    private Button orders_receiptBtn;

    @FXML
    private Button orders_resetBtn;

    @FXML
    private TableView<ordersData> orders_tableView;

    @FXML
    private Label orders_total;

    @FXML
    private Button orders_addBtn;

    private Alert alert;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    private Image image;

    private ObservableList<productData> cardListData = FXCollections.observableArrayList();

    public void dashboardDisplayNC() {

        String sql = "SELECT COUNT(id) FROM receipt";

        connect = database.connectDB();

        try {
            int nc = 0;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                nc = result.getInt("COUNT(id)");
            }
            dashboard_NC.setText(String.valueOf(nc));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dashboardDisplayTI() {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "SELECT SUM(total) FROM receipt WHERE date = '"
                + sqlDate + "'";

        connect = database.connectDB();

        try {
            double ti = 0;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                ti = result.getDouble("SUM(total)");
            }

            dashboard_TI.setText("RP" + ti);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dashboardTotalI() {
        String sql = "SELECT SUM(total) FROM receipt";

        connect = database.connectDB();

        try {
            float ti = 0;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                ti = result.getFloat("SUM(total)");
            }
            dashboard_totalI.setText("RP" + ti);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dashboardNSP() {
        String sql = "SELECT COUNT(quantity) FROM customer";

        connect = database.connectDB();

        try {
            int q = 0;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                q = result.getInt("COUNT(quantity)");
            }
            dashboard_NSP.setText(String.valueOf(q));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dashboardIncomeChart() {

        dashboard_incomeChart.getData().clear();

        String sql = "SELECT date, SUM(total) FROM receipt GROUP BY date ORDER BY TIMESTAMP(date)";
        connect = database.connectDB();
        XYChart.Series chart = new XYChart.Series();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getFloat(2)));
            }

            dashboard_incomeChart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dashboardCustomerChart() {

        dashboard_CustomerChart.getData().clear();

        String sql = "SELECT date, COUNT(id) FROM receipt GROUP BY date ORDER BY TIMESTAMP(date)";
        connect = database.connectDB();
        XYChart.Series chart = new XYChart.Series();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
            }

            dashboard_CustomerChart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // add a menu in the table list 
    public void inventoryAddBtn() {

        if (inventory_productID.getText().isEmpty()
                || inventory_productName.getText().isEmpty()
                || inventory_type.getSelectionModel().getSelectedItem() == null
                || inventory_stock.getText().isEmpty()
                || inventory_price.getText().isEmpty()
                || inventory_status.getSelectionModel().getSelectedItem() == null
                || data.path == null) {

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {
            // Check Product ID
            String checkProdID = "SELECT prod_id FROM product WHERE prod_id = '"
                    + inventory_productID.getText() + "'";

            connect = database.connectDB();

            try {

                statement = connect.createStatement();
                result = statement.executeQuery(checkProdID);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(inventory_productID.getText() + " is already taken");
                    alert.showAndWait();
                } else {

                    String insertData = "INSERT INTO Product "
                            + "(prod_id, prod_name, type, stock, price, status, image, date)"
                            + "VALUES(?,?,?,?,?,?,?,?)";

                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, inventory_productID.getText());
                    prepare.setString(2, inventory_productName.getText());
                    prepare.setString(3, (String) inventory_type.getSelectionModel().getSelectedItem());
                    prepare.setString(4, inventory_stock.getText());
                    prepare.setString(5, inventory_price.getText());
                    prepare.setString(6, (String) inventory_status.getSelectionModel().getSelectedItem());

                    String path = data.path;
                    path = path.replace("\\", "\\\\");

                    prepare.setString(7, path);

                    // To get current date
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    prepare.setString(8, String.valueOf(sqlDate));

                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    InventoryShowData();
                    inventoryClearBtn();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    // Action update menu for table
    public void inventoryUpdateBtn() {

        if (inventory_productID.getText().isEmpty()
                || inventory_productName.getText().isEmpty()
                || inventory_type.getSelectionModel().getSelectedItem() == null
                || inventory_stock.getText().isEmpty()
                || inventory_price.getText().isEmpty()
                || inventory_status.getSelectionModel().getSelectedItem() == null
                || data.path == null || data.id == 0) {

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {

            String path = data.path;
            path = path.replace("\\", "\\\\");

            String updateData = "UPDATE product SET "
                    + "prod_id = '" + inventory_productID.getText() + "', prod_name = '"
                    + inventory_productName.getText() + "', type = '"
                    + inventory_type.getSelectionModel().getSelectedItem() + "', stock = '"
                    + inventory_stock.getText() + "', price = '"
                    + inventory_price.getText() + "', status = '"
                    + inventory_status.getSelectionModel().getSelectedItem() + "', image = '"
                    + path + "', date = '"
                    + data.date + "' WHERE id = " + data.id;

            connect = database.connectDB();

            try {

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to Update Product ID: " + inventory_productID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(updateData);
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Update!");
                    alert.showAndWait();

                    // To update your table views
                    InventoryShowData();
                    // to clear your fields
                    inventoryClearBtn();
                } else {

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled");
                    alert.showAndWait();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    // Action delete menu for table 
    public void inventoryDeleteBtn() {
        if (data.id == 0) {

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure want to Delete Product ID: " + inventory_productID.getText() + "?");
            Optional<ButtonType> optional = alert.showAndWait();

            if (optional.get().equals(ButtonType.OK)) {
                String deleteData = "DELETE FROM product WHERE id = " + data.id;
                try {

                    prepare = connect.prepareStatement(deleteData);
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Delete Product");
                    alert.showAndWait();

                    // To update your table views
                    InventoryShowData();
                    // to clear your fields
                    inventoryClearBtn();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Cancelled");
                alert.showAndWait();

            }

        }
    }

    // provides an action to clear the textfield
    public void inventoryClearBtn() {

        inventory_productID.setText("");
        inventory_productName.setText("");
        inventory_type.getSelectionModel().clearSelection();
        inventory_stock.setText("");
        inventory_price.setText("");
        inventory_status.getSelectionModel().clearSelection();
        data.path = "";
        data.id = 0;
        inventory_imageView.setImage(null);
    }

    // Lets make a behavior for import bin first
    // Add an image to the menu in PNG or JPG format
    public void inventoryImportBtn() {
        FileChooser openFile = new FileChooser();
        openFile.getExtensionFilters().add(new FileChooser.ExtensionFilter("Open Image File", "*png", "*jpg"));

        File file = openFile.showOpenDialog(main_form.getScene().getWindow());

        if (file != null) {

            data.path = file.getAbsolutePath();
            image = new Image(file.toURI().toString(), 120, 151, false, true);

            inventory_imageView.setImage(image);
        }
    }

    // Merge all data
    public ObservableList<productData> inventoryDataList() {

        ObservableList<productData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM product";

        connect = database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            productData prodData;

            while (result.next()) {

                prodData = new productData(result.getInt("id"),
                        result.getString("prod_id"),
                        result.getString("prod_name"),
                        result.getString("type"),
                        result.getInt("stock"),
                        result.getDouble("price"),
                        result.getString("status"),
                        result.getString("image"),
                        result.getDate("date"));

                listData.add(prodData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    // Show data in table
    private ObservableList<productData> inventoryListData;

    public void InventoryShowData() {
        inventoryListData = inventoryDataList();

        inventory_col_productID.setCellValueFactory(new PropertyValueFactory<>("productId"));
        inventory_col_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        inventory_col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        inventory_col_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        inventory_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        inventory_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        inventory_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        inventory_tableView.setItems(inventoryListData);

    }

    public void inventorySelectData() {

        productData prodData = inventory_tableView.getSelectionModel().getSelectedItem();
        int num = inventory_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        inventory_productID.setText(prodData.getProductId());
        inventory_productName.setText(prodData.getProductName());
        inventory_stock.setText(String.valueOf(prodData.getStock()));
        inventory_price.setText(String.valueOf(prodData.getPrice()));

        data.path = prodData.getImage();

        String path = "File:" + prodData.getImage();
        data.date = String.valueOf(prodData.getDate());
        data.id = prodData.getId();

        image = new Image(path, 120, 151, false, true);
        inventory_imageView.setImage(image);

    }
    // Dropdown list type 
    private String[] typeList = {"Meals", "Drinks", "Car"};

    public void inventoryTypeList() {
        List<String> typeL = new ArrayList<>();

        for (String data : typeList) {
            typeL.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(typeL);
        inventory_type.setItems(listData);
    }

    private String[] statusList = {"Available", "Unavailable", "Indent"};

    public void inventoryStatusList() {
        List<String> statusL = new ArrayList<>();

        for (String data : statusList) {
            statusL.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(statusL);
        inventory_status.setItems(listData);
    }

    public ObservableList<productData> menuGetData() {

        String sql = "SELECT * FROM product";

        ObservableList<productData> listData = FXCollections.observableArrayList();
        connect = database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            productData prod;

            while (result.next()) {
                prod = new productData(result.getInt("id"),
                        result.getString("prod_id"),
                        result.getString("prod_name"),
                        result.getString("type"),
                        result.getInt("stock"),
                        result.getDouble("price"),
                        result.getString("image"),
                        result.getDate("date"));

                listData.add(prod);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }

    public void menuDisplayCard() {

        cardListData.clear();
        cardListData.addAll(menuGetData());

        int row = 0;
        int column = 0;

        menu_gridPane.getChildren().clear();
        menu_gridPane.getRowConstraints().clear();
        menu_gridPane.getColumnConstraints().clear();

        for (int q = 0; q < cardListData.size(); q++) {

            try {
                FXMLLoader load = new FXMLLoader();
                load.setLocation(getClass().getResource("cardProduct.fxml"));
                AnchorPane pane = load.load();
                cardProductController cardC = load.getController();
                cardC.setData(cardListData.get(q));

                if (column == 3) {
                    column = 0;
                    row += 1;
                }

                menu_gridPane.add(pane, column++, row);

                GridPane.setMargin(pane, new Insets(8));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public ObservableList<productData> menuGetOrder() {
        customerID();
        ObservableList<productData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM customer WHERE customer_id = " + cID;

        connect = database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            productData prod;

            while (result.next()) {
                prod = new productData(result.getInt("id"),
                        result.getString("prod_id"),
                        result.getString("prod_name"),
                        result.getString("type"),
                        result.getInt("quantity"),
                        result.getDouble("price"),
                        result.getString("image"),
                        result.getDate("date"));
                listData.add(prod);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;

    }

    private ObservableList<productData> menuOrderListData;

    public void menuShowOrderData() {
        menuOrderListData = menuGetOrder();

        menu_col_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        menu_col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        menu_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));

        menu_tableView.setItems(menuOrderListData);

    }
    private int getid;

    public void menuSelectOrder() {
        productData prod = menu_tableView.getSelectionModel().getSelectedItem();
        int num = menu_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < - 1) {
            return;
        }
        // To get the pre order
        getid = prod.getId();
    }

    private double totalP;

    public void menuGetTotal() {
        customerID();
        String total = "SELECT SUM(price) FROM customer WHERE customer_id = " + cID;

        connect = database.connectDB();

        try {

            prepare = connect.prepareStatement(total);
            result = prepare.executeQuery();

            if (result.next()) {
                totalP = result.getDouble("SUM(price)");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void menuDisplayTotal() {
        menuGetTotal();
        menu_total.setText("Rp." + totalP);
    }

    private double amount;
    private double change;

    public void menuAmount() {
        menuGetTotal();
        if (menu_amount.getText().isEmpty() || totalP == 0) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid!");
            alert.showAndWait();
        } else {
            amount = Double.parseDouble(menu_amount.getText());
            if (amount < totalP) {
                menu_amount.setText("");
            } else {
                change = (amount - totalP);
                menu_change.setText("Rp." + change);
            }
        }
    }

    public void menuPayBtn() {

        if (totalP == 0) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please choose your order first!");
            alert.showAndWait();
        } else {

            menuGetTotal();
            String insertPay = "INSERT INTO receipt (customer_id, total, amount, changes, date, em_username, customer_name)"
                    + "VALUES(?,?,?,?,?,?,?)";

            connect = database.connectDB();

            try {

                if (amount == 0) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Something wrong!");
                    alert.showAndWait();
                } else {
                    alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Are you sure?");
                    Optional<ButtonType> option = alert.showAndWait();

                    if (option.get().equals(ButtonType.OK)) {

                        customerID();
                        menuGetTotal();
                        prepare = connect.prepareStatement(insertPay);
                        prepare.setString(1, String.valueOf(cID));
                        prepare.setString(2, String.valueOf(totalP));
                        prepare.setString(3, String.valueOf(amount));
                        prepare.setString(4, String.valueOf(change));

                        Date date = new Date();
                        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                        prepare.setString(5, String.valueOf(sqlDate));
                        prepare.setString(6, data.username);
                        prepare.setString(7, String.valueOf(menu_customer.getText()));

                        prepare.executeUpdate();

                        alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully");
                        alert.showAndWait();

                        menuShowOrderData();

                    } else {
                        alert = new Alert(AlertType.WARNING);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Cancelled");
                        alert.showAndWait();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void menuRemoveBtn() {

        if (getid == 0) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the order you want to remove");
            alert.showAndWait();
        } else {
            String deleteData = "DELETE FROM customer WHERE id = " + getid;
            connect = database.connectDB();
            try {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete this order?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(deleteData);
                    prepare.executeUpdate();
                }

                menuShowOrderData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void menuReceiptBtn() {

        if (totalP == 0 || menu_amount.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please order first");
            alert.showAndWait();
        } else {
            HashMap map = new HashMap();
            map.put("getReceipt", (cID - 1));
            try {
                JasperDesign jDesign = JRXmlLoader.load("C:\\Users\\Lenovo\\OneDrive\\Dokumen\\NetBeansProjects\\kelompokTiga\\src\\kelompoktiga\\report.jrxml");
                JasperReport jReport = JasperCompileManager.compileReport(jDesign);
                JasperPrint jPrint = JasperFillManager.fillReport(jReport, map, connect);

                JasperViewer.viewReport(jPrint, false);

                menuRestart();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public void menuRestart() {
        totalP = 0;
        change = 0;
        amount = 0;
        menu_total.setText("Rp.00");
        menu_amount.setText("");
        menu_change.setText("Rp.00");
    }

    private int cID;

    public void customerID() {

        String sql = "SELECT MAX(customer_id) FROM customer";
        connect = database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                cID = result.getInt("MAX(customer_id)");

            }

            String checkCID = "SELECT MAX(customer_id) FROM receipt";
            prepare = connect.prepareStatement(checkCID);
            result = prepare.executeQuery();
            int checkID = 0;
            if (result.next()) {
                checkID = result.getInt("MAX(customer_id)");
            }

            if (cID == 0) {
                cID += 1;
            } else if (cID == checkID) {
                cID += 1;
            }

            data.cID = cID;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ObservableList<customersData> customersDataList() {
        ObservableList<customersData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM receipt";
        connect = database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            customersData cData;

            while (result.next()) {
                cData = new customersData(result.getInt("id"),
                        result.getInt("customer_id"),
                        result.getDouble("total"),
                        result.getDate("date"),
                        result.getString("em_username"),
                        result.getString("customer_name"));

                listData.add(cData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<customersData> customersListData;

    public void customersShowData() {
        customersListData = customersDataList();

        customers_col_customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        customers_col_total.setCellValueFactory(new PropertyValueFactory<>("total"));
        customers_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        customers_col_cashier.setCellValueFactory(new PropertyValueFactory<>("emUsername"));
        customers_col_customer.setCellValueFactory(new PropertyValueFactory<>("customerName"));

        customers_tableView.setItems(customersListData);

    }

    private int getidcustomer;

    public void menuSelectCustomer() {
        customersData cData = daily_report_customer_tableView.getSelectionModel().getSelectedItem();
        int numCus = daily_report_customer_tableView.getSelectionModel().getSelectedIndex();

        if ((numCus - 1) < - 1) {
            return;
        }
        // To get the pre order
        getidcustomer = cData.getId();
    }

    public void dailyReportShowData() {

        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "SELECT * FROM receipt WHERE date = '"
                + sqlDate + "'";

        connect = database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            // Mendapatkan data pelanggan
            customersListData = customersDataList();

            // Menetapkan nilai properti dari tabel
            daily_report_col_customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
            daily_report_col_total.setCellValueFactory(new PropertyValueFactory<>("total"));
            daily_report_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
            daily_report_col_cashier.setCellValueFactory(new PropertyValueFactory<>("emUsername"));
            daily_report_col_customer.setCellValueFactory(new PropertyValueFactory<>("customerName"));

            // Menetapkan data pelanggan ke dalam tabel
            daily_report_customer_tableView.setItems(customersListData);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void menuRemoveCustomerBtn() {

        if (cID == 0) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the order you want to remove");
            alert.showAndWait();
        } else {
            String deleteData = "DELETE FROM receipt WHERE customer_id = " + cID;
            connect = database.connectDB();
            try {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete this Customer?" + cID);
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(deleteData);
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Delete");
                    alert.showAndWait();

                    dailyReportShowData();
                    menuShowOrderData();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    // Add supplier to database
    public void addProductsAdd() {

        String sql = "INSERT INTO supplier (supplier_id, supplierName, type, brand, productName, price, status, image, date) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";

        connect = database.connectDB();

        try {

            Alert alert;

            if (addProducts_productId.getText().isEmpty()
                    || addProducts_supplierName.getText().isEmpty()
                    || addProducts_productType.getSelectionModel().getSelectedItem() == null
                    || addProducts_brand.getText().isEmpty()
                    || addProducts_productName.getText().isEmpty()
                    || addProducts_price.getText().isEmpty()
                    || addProducts_status.getSelectionModel().getSelectedItem() == null
                    || getData.path == "") {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                // Check If Supplier ID already exist
                String checkData = "SELECT supplier_id FROM supplier WHERE supplier_id = '"
                        + addProducts_productId.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Supplier ID: " + addProducts_productId.getText() + " already exist!");
                    alert.showAndWait();
                } else {

                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, addProducts_productId.getText());
                    prepare.setString(2, addProducts_supplierName.getText());
                    prepare.setString(3, (String) addProducts_productType.getSelectionModel().getSelectedItem());
                    prepare.setString(4, addProducts_brand.getText());
                    prepare.setString(5, addProducts_productName.getText());
                    prepare.setString(6, addProducts_price.getText());
                    prepare.setString(7, (String) addProducts_status.getSelectionModel().getSelectedItem());

                    String uri = getData.path;
                    uri = uri.replace("\\", "\\\\");
                    prepare.setString(8, uri);

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    prepare.setString(9, String.valueOf(sqlDate));

                    prepare.executeUpdate();

                    // To become update your tableview
                    addSuppliersShowListData();

                    // Clear the fields
                    addProductReset();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSuppliersUpdate() {
        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");

        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        String sql = "UPDATE supplier SET supplierName = '"
                + addProducts_supplierName.getText()
                + "', type = '" + addProducts_productType.getSelectionModel().getSelectedItem()
                + "', brand = '" + addProducts_brand.getText()
                + "', productName = '" + addProducts_productName.getText()
                + "', price = '" + addProducts_price.getText()
                + "', status = '" + addProducts_status.getSelectionModel().getSelectedItem()
                + "', image = '" + uri + "', date = '" + sqlDate + "' WHERE supplier_id = '"
                + addProducts_productId.getText() + "'";
        connect = database.connectDB();
        try {
            Alert alert;

            if (addProducts_productId.getText().isEmpty()
                    || addProducts_supplierName.getText().isEmpty()
                    || addProducts_productType.getSelectionModel().getSelectedItem() == null
                    || addProducts_brand.getText().isEmpty()
                    || addProducts_productName.getText().isEmpty()
                    || addProducts_price.getText().isEmpty()
                    || addProducts_status.getSelectionModel().getSelectedItem() == null
                    || getData.path == "") {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure want to Update Supplier ID" + addProducts_productId.getText() + "?");

                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Update");
                    alert.showAndWait();

                    addSuppliersShowListData();
                    addProductReset();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSuppliersDelete() {

        String sql = "DELETE FROM supplier WHERE supplier_id = '"
                + addProducts_productId.getText() + "'";

        connect = database.connectDB();

        try {
            Alert alert;

            if (addProducts_productId.getText().isEmpty()
                    || addProducts_supplierName.getText().isEmpty()
                    || addProducts_productType.getSelectionModel().getSelectedItem() == null
                    || addProducts_brand.getText().isEmpty()
                    || addProducts_productName.getText().isEmpty()
                    || addProducts_price.getText().isEmpty()
                    || addProducts_status.getSelectionModel().getSelectedItem() == null
                    || getData.path == "") {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure want to Delete Supplier ID" + addProducts_productId.getText() + "?");

                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Delete");
                    alert.showAndWait();

                    addSuppliersShowListData();
                    addProductReset();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addProductReset() {
        addProducts_productId.setText("");
        addProducts_supplierName.setText("");
        addProducts_productType.getSelectionModel().clearSelection();
        addProducts_brand.setText("");
        addProducts_productName.setText("");
        addProducts_price.setText("");
        addProducts_status.getSelectionModel().clearSelection();
        addSuppliersProducts_imageView.setImage(null);

        getData.path = "";

    }

    public void addSuppliersProductsImportImage() {

        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image File", "*jpg", "*png"));

        File file = open.showOpenDialog(main_form.getScene().getWindow());

        if (file != null) {
            getData.path = file.getAbsolutePath();
            image = new Image(file.toURI().toString(), 115, 127, false, true);
            addSuppliersProducts_imageView.setImage(image);
        }

    }

    private String[] listType = {"Foods", "Drinks", "Snacks", "Others"};

    public void addSuppliersListType() {
        List<String> listT = new ArrayList<>();

        for (String data : listType) {
            listT.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listT);
        addProducts_productType.setItems(listData);
    }

    private String[] listStatus = {"Available", "Unavailable"};

    public void addSuppliersListStatus() {
        List<String> listS = new ArrayList<>();

        for (String data : listStatus) {
            listS.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listS);
        addProducts_status.setItems(listData);
    }

    public void addSuppliersSearch() {
        FilteredList<supplierData> filter = new FilteredList<>(addSupplierList, e -> true);
        addProducts_search.textProperty().addListener((Observable, oldValue, newValue) -> {
            filter.setPredicate(predicateSupplierData -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String searchKey = newValue.toLowerCase();
                if (predicateSupplierData.getSupplierId().toString().contains(searchKey)) {
                    return true;
                } else if (predicateSupplierData.getSupplierName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateSupplierData.getType().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateSupplierData.getBrand().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateSupplierData.getProductName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateSupplierData.getPrice().toString().contains(searchKey)) {
                    return true;
                } else if (predicateSupplierData.getStatus().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<supplierData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(addProducts_tableView.comparatorProperty());
        addProducts_tableView.setItems(sortList);
    }

    public ObservableList<supplierData> addSupplierListData() {
        ObservableList<supplierData> supplierList = FXCollections.observableArrayList();

        String sql = "SELECT * FROM supplier";
        connect = database.connectDB();
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            supplierData suppD;
            while (result.next()) {
                suppD = new supplierData(result.getInt("supplier_id"),
                        result.getString("supplierName"),
                        result.getString("type"),
                        result.getString("brand"),
                        result.getString("productName"),
                        result.getDouble("price"),
                        result.getString("status"),
                        result.getString("image"),
                        result.getDate("date"));

                supplierList.add(suppD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return supplierList;
    }

    private ObservableList<supplierData> addSupplierList;

    public void addSuppliersShowListData() {
        addSupplierList = addSupplierListData();

        addProducts_col_supplierId.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        addProducts_col_supplierName.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        addProducts_col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        addProducts_col_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        addProducts_col_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        addProducts_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        addProducts_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        addProducts_tableView.setItems(addSupplierList);

    }

    public void addSuppliersSelect() {
        supplierData suppD = addProducts_tableView.getSelectionModel().getSelectedItem();
        int num = addProducts_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < - 1) {
            return;
        }

        addProducts_productId.setText(String.valueOf(suppD.getSupplierId()));
        addProducts_supplierName.setText(suppD.getSupplierName());
        addProducts_brand.setText(suppD.getBrand());
        addProducts_productName.setText(suppD.getProductName());
        addProducts_price.setText(String.valueOf(suppD.getPrice()));

        String uri = "File:" + suppD.getImage();

        image = new Image(uri, 115, 127, false, true);
        addSuppliersProducts_imageView.setImage(image);
        getData.path = suppD.getImage();
    }

    public void ordersAdd() {
        customerId();
        String sql = "INSERT INTO orders (customer_id, type, brand, productName, quantity, price, date)"
                + "VALUES(?,?,?,?,?,?,?)";

        connect = database.connectDB();

        try {

            String checkData = "SELECT * FROM supplier WHERE productName = '"
                    + orders_productName.getSelectionModel().getSelectedItem() + "'";

            double priceData = 0;

            statement = connect.createStatement();
            result = statement.executeQuery(checkData);

            if (result.next()) {
                priceData = result.getDouble("price");
            }

            double totalPData = (priceData * qty);

            Alert alert;
            if (orders_productsType.getSelectionModel().getSelectedItem() == null
                    || (String) orders_brand.getSelectionModel().getSelectedItem() == null
                    || (String) orders_productName.getSelectionModel().getSelectedItem() == null
                    || totalPData == 0) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please choose product first");
                alert.showAndWait();
            } else {

                prepare = connect.prepareStatement(sql);
                prepare.setString(1, String.valueOf(customerid));
                prepare.setString(2, (String) orders_productsType.getSelectionModel().getSelectedItem());
                prepare.setString(3, (String) orders_brand.getSelectionModel().getSelectedItem());
                prepare.setString(4, (String) orders_productName.getSelectionModel().getSelectedItem());
                prepare.setString(5, String.valueOf(qty));

                prepare.setString(6, String.valueOf(totalPData));

                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                prepare.setString(7, String.valueOf(sqlDate));

                prepare.executeUpdate();

                ordersShowListData();
                ordersDisplayTotal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ordersPay() {
        customerId();
        String sql = "INSERT INTO supplier_receipt (total,date) WHERE supplier_id = '" + customerid + "'";

        connect = database.connectDB();

        try {
            Alert alert;
            if (totalO > 0) {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, String.valueOf(totalO));

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(2, String.valueOf(sqlDate));
                    
                    prepare.executeUpdate();
                }

            } else {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid!");
                alert.showAndWait();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double totalO;

    public void ordersDisplayTotal() {
        customerId();
        String sql = "SELECT SUM(price) FROM orders WHERE customer_id = '" + customerid + "'";

        connect = database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                totalO = result.getDouble("SUM(price)");
            }

            orders_total.setText("    Rp. " + String.valueOf(totalO));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String[] orderListType = {"Foods", "Drinks", "Snacks", "Others"};

    public void ordersListType() {
        List<String> listT = new ArrayList<>();

        for (String data : orderListType) {
            listT.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listT);
        orders_productsType.setItems(listData);

        ordersListBrand();
    }

    public void ordersListBrand() {
        String sql = "SELECT brand FROM supplier WHERE type = '"
                + orders_productsType.getSelectionModel().getSelectedItem()
                + "' and status = 'Available'";

        connect = database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ObservableList listData = FXCollections.observableArrayList();

            while (result.next()) {
                listData.add(result.getString("brand"));
            }
            orders_brand.setItems(listData);

            ordersListProductName();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ordersListProductName() {
        String sql = "SELECT productName FROM supplier WHERE brand = '"
                + orders_brand.getSelectionModel().getSelectedItem() + "'";

        connect = database.connectDB();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ObservableList listData = FXCollections.observableArrayList();

            while (result.next()) {
                listData.add(result.getString("productName"));
            }
            orders_productName.setItems(listData);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private SpinnerValueFactory<Integer> spinner;

    public void ordersSpinner() {

        spinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);

        orders_quantity.setValueFactory(spinner);

    }
    private int qty;

    public void ordersShowSpinnerValue() {
        qty = orders_quantity.getValue();
    }

    public ObservableList<ordersData> ordersListData() {
        customerId();
        ObservableList<ordersData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM orders WHERE customer_id = '"
                + customerid + "'";

        connect = database.connectDB();

        try {
            ordersData ordersD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                ordersD = new ordersData(result.getInt("customer_id"),
                        result.getString("type"),
                        result.getString("brand"),
                        result.getString("productName"),
                        result.getInt("quantity"),
                        result.getDouble("price"),
                        result.getDate("date"));
                listData.add(ordersD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<ordersData> ordersList;

    public void ordersShowListData() {
        ordersList = ordersListData();

        orders_col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        orders_col_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        orders_col_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        orders_col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        orders_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));

        orders_tableView.setItems(ordersList);
        ordersDisplayTotal();
    }

    private int customerid;

    public void customerId() {

        String customId = "";

        connect = database.connectDB();

        try {
            prepare = connect.prepareStatement(customId);
            result = prepare.executeQuery();

            int checkId = 0;

            while (result.next()) {
                // Get last customer Id
                customerid = result.getInt("customer_id");
            }

            String checkData = "SELECT * FROM supplier_receipt";

            statement = connect.createStatement();
            result = statement.executeQuery(checkData);

            while (result.next()) {
                checkId = result.getInt("customer_id");
            }

            if (customerid == 0) {
                customerid += 1;
            } else if (checkId == customerid) {
                customerid += 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Switch Form
    public void switchForm(ActionEvent event) {

        if (event.getSource() == dashboard_btn) {
            dashboard_form.setVisible(true);
            inventory_form.setVisible(false);
            menu_form.setVisible(false);
            customers_form.setVisible(false);
            daily_report_form.setVisible(false);
            addProducts_form.setVisible(false);
            orders_form.setVisible(false);

            dashboardDisplayNC();
            dashboardDisplayTI();
            dashboardTotalI();
            dashboardNSP();
            dashboardIncomeChart();
            dashboardCustomerChart();

        } else if (event.getSource() == inventory_btn) {
            dashboard_form.setVisible(false);
            inventory_form.setVisible(true);
            menu_form.setVisible(false);
            customers_form.setVisible(false);
            daily_report_form.setVisible(false);
            addProducts_form.setVisible(false);
            orders_form.setVisible(false);

            inventoryTypeList();
            inventoryStatusList();
            InventoryShowData();
        } else if (event.getSource() == menu_btn) {
            dashboard_form.setVisible(false);
            inventory_form.setVisible(false);
            menu_form.setVisible(true);
            customers_form.setVisible(false);
            daily_report_form.setVisible(false);
            addProducts_form.setVisible(false);
            orders_form.setVisible(false);

            menuDisplayCard();
            menuDisplayTotal();
            menuShowOrderData();
        } else if (event.getSource() == customers_btn) {
            dashboard_form.setVisible(false);
            inventory_form.setVisible(false);
            menu_form.setVisible(false);
            customers_form.setVisible(true);
            daily_report_form.setVisible(false);
            addProducts_form.setVisible(false);
            orders_form.setVisible(false);
            customersShowData();
        } else if (event.getSource() == daily_report_btn) {
            dashboard_form.setVisible(false);
            inventory_form.setVisible(false);
            menu_form.setVisible(false);
            customers_form.setVisible(false);
            daily_report_form.setVisible(true);
            addProducts_form.setVisible(false);
            orders_form.setVisible(false);

        } else if (event.getSource() == addProducts_btn) {
            dashboard_form.setVisible(false);
            inventory_form.setVisible(false);
            menu_form.setVisible(false);
            customers_form.setVisible(false);
            daily_report_form.setVisible(false);
            addProducts_form.setVisible(true);
            orders_form.setVisible(false);

            addSuppliersShowListData();
            addSuppliersListType();
            addSuppliersListStatus();
            addSuppliersSearch();

        } else if (event.getSource() == orders_btn) {
            dashboard_form.setVisible(false);
            inventory_form.setVisible(false);
            menu_form.setVisible(false);
            customers_form.setVisible(false);
            daily_report_form.setVisible(false);
            addProducts_form.setVisible(false);
            orders_form.setVisible(true);

            ordersShowListData();
            ordersListType();
            ordersListBrand();
            ordersListProductName();
            ordersSpinner();
            ordersDisplayTotal();
        }
    }

    // Exit the app
    public void logout() {

        try {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                // To Hide Main Form
                logout_btn.getScene().getWindow().hide();

                // Link Your Login Form and Show It
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setTitle("Coffe Shop Management System");

                stage.setScene(scene);
                stage.show();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayUsername() {
        String user = data.username;
        user = user.substring(0, 1).toUpperCase() + "" + user.substring(1);

        username.setText(user);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        displayUsername();

        dashboardDisplayNC();
        dashboardDisplayTI();
        dashboardTotalI();
        dashboardNSP();
        dashboardIncomeChart();
        dashboardCustomerChart();

        inventoryTypeList();
        inventoryStatusList();
        InventoryShowData();

        menuDisplayCard();
        menuGetOrder();
        menuDisplayTotal();
        menuShowOrderData();

        customersShowData();

        dailyReportShowData();

        addSuppliersShowListData();
        addSuppliersListType();
        addSuppliersListStatus();

        ordersShowListData();
        ordersListType();
        ordersListBrand();
        ordersListProductName();
        ordersSpinner();
        ordersDisplayTotal();
    }

}
