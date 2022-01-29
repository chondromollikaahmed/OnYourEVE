package com.ca.onyoureve;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {
    @javafx.fxml.FXML
    private JFXButton termC;
    @javafx.fxml.FXML
    private JFXButton about;
    @javafx.fxml.FXML
    private AnchorPane loginUI;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //loginUI.setVisible(false);

    }
}
