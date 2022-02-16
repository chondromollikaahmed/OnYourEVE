package com.ca.onyoureve.trialClass;

import com.ca.onyoureve.ConnectDB;
import com.ca.onyoureve.Events;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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

public class UIController implements Initializable {


    ObservableList<Events> list;
    ObservableList<Events> filteredlist;
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    @FXML
    private TableView<Events> elist;
    @FXML
    private TableColumn<Events, Integer> col_cid;
    @FXML
    private TableColumn<Events, Integer> col_id;
    @FXML
    private TableColumn<Events, Integer> col_mid;
    @FXML
    private TableColumn<Events, String> col_name;
    @FXML
    private TableColumn<Events, Double> col_tcost;
    @FXML
    private TableColumn<Events, Integer> col_vid;
    @FXML
    private AnchorPane pnl;
    @FXML
    private AnchorPane table_events;
    @FXML
    private TextField text_catid;
    @FXML
    private TextField text_mid;
    @FXML
    private TextField text_cost;
    @FXML
    private TextField text_eid;
    @FXML
    private TextField text_ename;
    @FXML
    private TextField text_vid;
    @FXML
    private ImageView chchch;
    @FXML
    private TextField txt_search;

    @FXML
    public void Add_users() {
        conn = ConnectDB.ConnectDb(1);
        String sql = "insert into events (eventID,eventName,venueID,mediaID,cateringID,cost)values(?,?,?,?,?,? )";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, text_eid.getText());
            pst.setString(2, text_ename.getText());
            pst.setString(3, text_vid.getText());
            pst.setString(4, text_mid.getText());
            pst.setString(5, text_catid.getText());
            pst.setString(6, text_cost.getText());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Users Add succes");
            UpdateTable();
            search();
            // UpdateTable();
            //search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void UpdateTable() {
        col_id.setCellValueFactory(new PropertyValueFactory<Events, Integer>("eventId"));
        col_name.setCellValueFactory(new PropertyValueFactory<Events, String>("eventName"));
        col_vid.setCellValueFactory(new PropertyValueFactory<Events, Integer>("venueId"));
        col_mid.setCellValueFactory(new PropertyValueFactory<Events, Integer>("mediaId"));
        col_cid.setCellValueFactory(new PropertyValueFactory<Events, Integer>("cateringID"));
        col_tcost.setCellValueFactory(new PropertyValueFactory<Events, Double>("cost"));

        list = ConnectDB.getDataEvents();
        elist.setItems(list);
    }

    @FXML
    public void Delete() {
        conn = ConnectDB.ConnectDb(1);
        String sql = "delete from events where eventID = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, text_eid.getText());
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
            String value1 = text_eid.getText();
            String value2 = text_ename.getText();
            String value3 = text_vid.getText();
            String value4 = text_mid.getText();
            String value5 = text_catid.getText();
            String value6 = text_cost.getText();
            String sql = "update events set eventName= '" + value2 + "',venueID= '" +
                    value3 + "',mediaID= '" + value4 + "',cateringID= '" + value5 + "',cost= '" + value6 + "' where eventID='" + value1 + "' ";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update");
            UpdateTable();
            search();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @Deprecated
    public void search() {

        col_id.setCellValueFactory(new PropertyValueFactory<Events, Integer>("eventId"));
        col_name.setCellValueFactory(new PropertyValueFactory<Events, String>("eventName"));
        col_vid.setCellValueFactory(new PropertyValueFactory<Events, Integer>("venueId"));
        col_mid.setCellValueFactory(new PropertyValueFactory<Events, Integer>("mediaId"));
        col_cid.setCellValueFactory(new PropertyValueFactory<Events, Integer>("cateringID"));
        col_tcost.setCellValueFactory(new PropertyValueFactory<Events, Double>("cost"));

        filteredlist = ConnectDB.getDataEvents();
        elist.setItems(filteredlist);

        FilteredList<Events> filteredData = new FilteredList<>(filteredlist, p -> true);

        txt_search.textProperty().addListener((observable, oldValue, newValue) -> {

            filteredData.setPredicate(event -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;

                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (event.getEventName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(event.getEventId()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(event.getVenueId()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(event.getMediaId()).indexOf(lowerCaseFilter) != -1) {
                    return true;

                } else if (String.valueOf(event.getCateringID()).indexOf(lowerCaseFilter) != -1) {
                    return true;

                } else if (String.valueOf(event.getCost()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else
                    return false;
            });
        });
        SortedList<Events> sortedData = new SortedList<>(filteredData);
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
        text_eid.setText(col_id.getCellData(index).toString());
        text_ename.setText(col_name.getCellData(index).toString());
        text_vid.setText(col_vid.getCellData(index).toString());
        text_mid.setText(col_mid.getCellData(index).toString());
        text_catid.setText(col_cid.getCellData(index).toString());
        text_cost.setText(col_tcost.getCellData(index).toString());
    }
}
