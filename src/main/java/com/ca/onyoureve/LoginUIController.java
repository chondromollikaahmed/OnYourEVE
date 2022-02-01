package com.ca.onyoureve;

import com.ca.onyoureve.trialClass.UserInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginUIController implements Initializable {

    @FXML
    private Button buttonBuy;

    @FXML
    private AnchorPane pnl_buy;

    @FXML
    private AnchorPane pnl_login;

    @FXML
    private AnchorPane pnl_logo;

    @FXML
    private Button button_toshow;

    @FXML
    private Button sinidbtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
     //   pnl_logo.setVisible(false);
        pnl_login.setVisible(false);
        pnl_buy.setVisible(false);

    }


    @FXML
    void ShowBuyNow(ActionEvent event) {
        pnl_logo.setVisible(false);
        pnl_login.setVisible(false);
        pnl_buy.setVisible(true);
        System.out.println("tab");

    }

    @FXML
    void showLogUI(ActionEvent event) {
        System.out.println("aa");
        pnl_logo.setVisible(false);
        pnl_buy.setVisible(false);
        pnl_login.setVisible(true);

    }


    void gohto()
    {
        new UserInterface();
    }





}
