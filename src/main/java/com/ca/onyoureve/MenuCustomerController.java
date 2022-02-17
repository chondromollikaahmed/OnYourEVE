/*
 * *
 *  * Created by JehadurRE on 2/17/22, 5:36 AM
 *  *chondromollikaahmed@gmail.com
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 2/17/22, 5:36 AM
 *  *Current Path E:/OnYourEVE/src/main/java/com/ca/onyoureve/MenuCustomerController.java
 *  *OnYourEVE
 *
 */

package com.ca.onyoureve;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class MenuCustomerController {
    @javafx.fxml.FXML
    private JFXButton signout_btn;
    @javafx.fxml.FXML
    private JFXButton viewEvent_btn;
    @javafx.fxml.FXML
    private JFXButton edit_btn;
    @javafx.fxml.FXML
    private Label welcome;
    @javafx.fxml.FXML
    private JFXButton bookEvent_btn;




    // display name of user
    public void setWelcome(String str) {
        String first_name = str.contains(" ") ? str.split(" ")[0] : str;
        welcome.setText("Welcome, " + first_name);
    }

    public void setEventBookedStatus(String cust_id) {
        Event event = new Event();
        event = event.getEvent(cust_id,1);

        // no event against that cust_id
        if (event.getName().isEmpty())
            hasCustBookedEvent = false;
        else
            hasCustBookedEvent = true;
    }


    @javafx.fxml.FXML
    public void handleViewButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSignOutButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleEditButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBookButton(ActionEvent actionEvent) {
    }
}
