package com.ca.onyoureve;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class TableCustomerController implements Initializable {
    ObservableList<MCustomer> list;
    ObservableList<MCustomer> filteredlist;
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    @FXML
    private TableView<MCustomer> elist;
    @FXML
    private AnchorPane pnl;
    @FXML
    private AnchorPane table_events;
    @FXML
    private ImageView chchch;
    @FXML
    private TextField txt_search;
    @FXML
    private TextField phone_no;
    @FXML
    private TextField address;
    @FXML
    private TextField nid;
    @FXML
    private TableColumn<MCustomer, String> c_address;
    @FXML
    private TableColumn<MCustomer, String> c_email;
    @FXML
    private TableColumn<MCustomer, String> c_ms;
    @FXML
    private TableColumn<MCustomer, Integer> c_acc_no;
    @FXML
    private TableColumn<MCustomer, String> c_phone_no;
    @FXML
    private TableColumn<MCustomer, String> c_nid;
    @FXML
    private TextField name;
    @FXML
    private TextField acc_no;
    @FXML
    private TableColumn<MCustomer, Integer> c_id;
    @FXML
    private TableColumn<MCustomer, String> c_name;
    @FXML
    private TextField customer_id;
    @FXML
    private TableColumn<MCustomer, Double> c_age;
    @FXML
    private TextField email;
    @FXML
    private TextField age;
    @FXML
    private TextField membership_status;

    @FXML
    public void Add_users() {
        conn = ConnectDB.ConnectDb(1);
        String sql = "insert into events values(?,?,?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, customer_id.getText());
            pst.setString(2, name.getText());
            pst.setString(3, email.getText());
            pst.setString(4, phone_no.getText());
            pst.setString(5, age.getText());
            pst.setString(6, address.getText());
            pst.setString(7, nid.getText());
            pst.setString(8, membership_status.getText());
            pst.setString(9, acc_no.getText());
            pst.execute();
            UpdateTable();
            search();
            // UpdateTable();
            //search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static ObservableList<MCustomer> getDataEvents() {
        Connection conn = ConnectDB.ConnectDb(1);
        ObservableList<MCustomer> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from customer");
            //    Statement st = conn.createStatement();
            ResultSet rs = ps.executeQuery();
            //   ResultSet rs = st.executeQuery("select * from events");
            while (rs.next()) {
                System.out.println("rs found");
                list.add(new MCustomer(rs.getInt("customer_id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("phone_no"),
                        rs.getDouble("age"), rs.getString("address"),
                        rs.getString("nid"), rs.getString("membership_status"),
                        rs.getString("acc_no")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void UpdateTable() {
        c_id.setCellValueFactory(new PropertyValueFactory<MCustomer, Integer>("customer_id"));
        c_name.setCellValueFactory(new PropertyValueFactory<MCustomer, String>("name"));
        c_email.setCellValueFactory(new PropertyValueFactory<MCustomer, String>("email"));
        c_phone_no.setCellValueFactory(new PropertyValueFactory<MCustomer, String>("phone_no"));
        c_age.setCellValueFactory(new PropertyValueFactory<MCustomer, Double>("age"));
        c_address.setCellValueFactory(new PropertyValueFactory<MCustomer, String>("address"));
        c_nid.setCellValueFactory(new PropertyValueFactory<MCustomer, String>("nid"));
        c_ms.setCellValueFactory(new PropertyValueFactory<MCustomer, String>("membership_status"));
        c_acc_no.setCellValueFactory(new PropertyValueFactory<MCustomer, Integer>("acc_no"));
        list = getDataEvents();
        elist.setItems(list);
    }

    @FXML
    public void Delete() {
        conn = ConnectDB.ConnectDb(1);
        String sql = "delete from customer where customer_id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, customer_id.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");
            UpdateTable();
            search();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    public void Edit() {
        try {
            conn = ConnectDB.ConnectDb(1);
            String value1 = customer_id.getText();
            String value2 = name.getText();
            String value3 = email.getText();
            String value4 = phone_no.getText();
            String value5 = age.getText();
            String value6 = address.getText();
            String value7 = nid.getText();
            String value8 = membership_status.getText();
            String value9 = acc_no.getText();
            String sql = "update customer set name = ?, email = ?, phone_no = ?, age = ?, address = ?, nid = ?, membership_status = ?, acc_no = ? where customer_id = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, value2);
            pst.setString(2, value3);
            pst.setString(3, value4);
            pst.setString(4, value5);
            pst.setString(5, value6);
            pst.setString(6, value7);
            pst.setString(7, value8);
            pst.setString(8, value9);
            pst.setString(9, value1);
            pst.execute();
            UpdateTable();
            search();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Deprecated
    public void search() {
        c_id.setCellValueFactory(new PropertyValueFactory<MCustomer, Integer>("customer_id"));
        c_name.setCellValueFactory(new PropertyValueFactory<MCustomer, String>("name"));
        c_email.setCellValueFactory(new PropertyValueFactory<MCustomer, String>("email"));
        c_phone_no.setCellValueFactory(new PropertyValueFactory<MCustomer, String>("phone_no"));
        c_age.setCellValueFactory(new PropertyValueFactory<MCustomer, Double>("age"));
        c_address.setCellValueFactory(new PropertyValueFactory<MCustomer, String>("address"));
        c_nid.setCellValueFactory(new PropertyValueFactory<MCustomer, String>("nid"));
        c_ms.setCellValueFactory(new PropertyValueFactory<MCustomer, String>("membership_status"));
        c_acc_no.setCellValueFactory(new PropertyValueFactory<MCustomer, Integer>("acc_no"));
        filteredlist = getDataEvents();
        elist.setItems(filteredlist);
        FilteredList<MCustomer> filteredData = new FilteredList<>(filteredlist, p -> true);
        txt_search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(customer -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (customer.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(customer.getCustomer_id()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(customer.getEmail()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(customer.getPhone_no()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(customer.getAddress()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(customer.getAge()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(customer.getNid()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(customer.getMembership_status()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(customer.getAcc_no()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else
                    return false;
            });
        });
        SortedList<MCustomer> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(elist.comparatorProperty());
        elist.setItems(sortedData);
    }

    public void initialize(URL url, ResourceBundle rb) {
        UpdateTable();
        search();
    }

    @FXML
    public void updateTextField(Event event) {
        int index = elist.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        customer_id.setText(c_id.getCellData(index).toString());
        name.setText(c_name.getCellData(index).toString());
        email.setText(c_email.getCellData(index).toString());
        phone_no.setText(c_phone_no.getCellData(index).toString());
        address.setText(c_address.getCellData(index).toString());
        nid.setText(c_nid.getCellData(index).toString());
        age.setText(c_age.getCellData(index).toString());
        membership_status.setText(c_ms.getCellData(index).toString());
        acc_no.setText(c_acc_no.getCellData(index).toString());
    }

    @FXML
    public void OpenVenue(ActionEvent actionEvent) {
    }

    @FXML
    public void OpenCustomer(ActionEvent actionEvent) {
    }

    @FXML
    public void OpenEmployee(ActionEvent actionEvent) {
    }

    @FXML
    public void OpenEventTable(ActionEvent actionEvent) {
    }

    @FXML
    public void OpenMediaRequire(ActionEvent actionEvent) {
    }

    @FXML
    public void OpenCatering(ActionEvent actionEvent) {
    }

    @FXML
    public void OpenStudio(ActionEvent actionEvent) {
    }

    @FXML
    public void OpenMenu(ActionEvent actionEvent) {
    }
}
