/*
 * *
 *  * Created by JehadurRE on 2/16/22, 11:37 PM
 *  *chondromollikaahmed@gmail.com
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 2/16/22, 11:37 PM
 *  *Current Path E:/OnYourEVE/src/main/java/com/ca/onyoureve/BookEventController.java
 *  *OnYourEVE
 *
 */

package com.ca.onyoureve;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.DatePicker;

public class BookEventController {
    @javafx.fxml.FXML
    private JFXTextField caterer1_specialty;
    @javafx.fxml.FXML
    private JFXTextField caterer1_contact;
    @javafx.fxml.FXML
    private JFXCheckBox media_album;
    @javafx.fxml.FXML
    private JFXButton book_btn;
    @javafx.fxml.FXML
    private JFXCheckBox menu_extra_icecream;
    @javafx.fxml.FXML
    private JFXCheckBox menu_extra_dryfruit;
    @javafx.fxml.FXML
    private JFXTextField venue3_loc;
    @javafx.fxml.FXML
    private JFXTextField caterer3_days;
    @javafx.fxml.FXML
    private JFXTextField venue2_price;
    @javafx.fxml.FXML
    private JFXTextField venue3_cat;
    @javafx.fxml.FXML
    private JFXTextField event_type;
    @javafx.fxml.FXML
    private JFXTextField caterer3_contact;
    @javafx.fxml.FXML
    private JFXCheckBox menu_extra_sugarfree;
    @javafx.fxml.FXML
    private DatePicker event_date;
    @javafx.fxml.FXML
    private JFXTextField contact;
    @javafx.fxml.FXML
    private JFXCheckBox media_video;
    @javafx.fxml.FXML
    private JFXCheckBox menu_rice_biryani;
    @javafx.fxml.FXML
    private JFXTextField studio3_contact;
    @javafx.fxml.FXML
    private JFXTextField caterer2_days;
    @javafx.fxml.FXML
    private JFXTextField caterer2_price;
    @javafx.fxml.FXML
    private JFXTextField venue1_name;
    @javafx.fxml.FXML
    private JFXTextField venue3_cap;
    @javafx.fxml.FXML
    private JFXCheckBox media_crane;
    @javafx.fxml.FXML
    private JFXCheckBox caterer3_btn;
    @javafx.fxml.FXML
    private JFXTextField studio1_contact;
    @javafx.fxml.FXML
    private JFXTextField venue2_cat;
    @javafx.fxml.FXML
    private JFXTextField venue1_contact;
    @javafx.fxml.FXML
    private JFXCheckBox menu_rice_eggfried;
    @javafx.fxml.FXML
    private JFXTextField caterer2_specialty;
    @javafx.fxml.FXML
    private JFXCheckBox studio3_btn;
    @javafx.fxml.FXML
    private JFXTextField venue3_contact;
    @javafx.fxml.FXML
    private JFXTextField venue2_cap;
    @javafx.fxml.FXML
    private JFXTextField venue1_loc;
    @javafx.fxml.FXML
    private JFXCheckBox menu_bread_tandoori;
    @javafx.fxml.FXML
    private JFXCheckBox menu_protein_beef;
    @javafx.fxml.FXML
    private JFXTextField event_start;
    @javafx.fxml.FXML
    private JFXCheckBox venue1_btn;
    @javafx.fxml.FXML
    private JFXCheckBox media_photo;
    @javafx.fxml.FXML
    private JFXTextField studio3_name;
    @javafx.fxml.FXML
    private JFXCheckBox menu_extra_cake;
    @javafx.fxml.FXML
    private JFXTextField venue1_cat;
    @javafx.fxml.FXML
    private JFXCheckBox menu_rice_plain;
    @javafx.fxml.FXML
    private JFXTextField event_name;
    @javafx.fxml.FXML
    private JFXTextField venue1_cap;
    @javafx.fxml.FXML
    private JFXTextField venue3_name;
    @javafx.fxml.FXML
    private JFXCheckBox menu_protein_mutton;
    @javafx.fxml.FXML
    private JFXTextField venue1_price;
    @javafx.fxml.FXML
    private JFXTextField caterer3_price;
    @javafx.fxml.FXML
    private JFXCheckBox menu_rice_kabuli;
    @javafx.fxml.FXML
    private JFXCheckBox studio2_btn;
    @javafx.fxml.FXML
    private JFXTextField caterer1_name;
    @javafx.fxml.FXML
    private JFXCheckBox menu_drink_sprite;
    @javafx.fxml.FXML
    private JFXTextField venue2_loc;
    @javafx.fxml.FXML
    private JFXTextField caterer2_name;
    @javafx.fxml.FXML
    private JFXButton exit_btn;
    @javafx.fxml.FXML
    private JFXTextField venue2_addr;
    @javafx.fxml.FXML
    private JFXTextField venue3_price;
    @javafx.fxml.FXML
    private JFXTextField caterer3_specialty;
    @javafx.fxml.FXML
    private JFXTextField caterer2_contact;
    @javafx.fxml.FXML
    private JFXCheckBox studio1_btn;
    @javafx.fxml.FXML
    private JFXTextField event_end;
    @javafx.fxml.FXML
    private JFXCheckBox menu_protein_seafood;
    @javafx.fxml.FXML
    private JFXCheckBox menu_bread_lebanese;
    @javafx.fxml.FXML
    private JFXTextField venue3_addr;
    @javafx.fxml.FXML
    private JFXCheckBox menu_drink_coke;
    @javafx.fxml.FXML
    private JFXTextField studio1_name;
    @javafx.fxml.FXML
    private JFXCheckBox venue2_btn;
    @javafx.fxml.FXML
    private JFXTextField event_guests;
    @javafx.fxml.FXML
    private JFXTextField studio2_contact;
    @javafx.fxml.FXML
    private JFXTextField caterer1_price;
    @javafx.fxml.FXML
    private JFXTextField venue2_contact;
    @javafx.fxml.FXML
    private JFXCheckBox menu_bread_naan;
    @javafx.fxml.FXML
    private JFXCheckBox menu_drink_miranda;
    @javafx.fxml.FXML
    private JFXTextField caterer1_days;
    @javafx.fxml.FXML
    private JFXTextField caterer3_name;
    @javafx.fxml.FXML
    private JFXCheckBox menu_drink_water;
    @javafx.fxml.FXML
    private JFXTextField studio2_name;
    @javafx.fxml.FXML
    private JFXCheckBox venue3_btn;
    @javafx.fxml.FXML
    private JFXTextField venue2_name;
    @javafx.fxml.FXML
    private JFXCheckBox caterer2_btn;
    @javafx.fxml.FXML
    private JFXCheckBox menu_protein_chicken;
    @javafx.fxml.FXML
    private JFXCheckBox caterer1_btn;
    @javafx.fxml.FXML
    private JFXCheckBox media_drone;
    @javafx.fxml.FXML
    private JFXTextField venue1_addr;

    @javafx.fxml.FXML
    public void handleVenue3Button(Event event) {
    }

    @javafx.fxml.FXML
    public void handleCaterer3Button(Event event) {
    }

    @javafx.fxml.FXML
    public void handleStudio1Button(Event event) {
    }

    @javafx.fxml.FXML
    public void handleVenue2Button(Event event) {
    }

    @javafx.fxml.FXML
    public void handleCaterer1Button(Event event) {
    }

    @javafx.fxml.FXML
    public void handleStudio3Button(Event event) {
    }

    @javafx.fxml.FXML
    public void handleExitButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleCaterer2Button(Event event) {
    }

    @javafx.fxml.FXML
    public void handleStudio2Button(Event event) {
    }

    @javafx.fxml.FXML
    public void handleVenue1Button(Event event) {
    }

    @javafx.fxml.FXML
    public void handleBookButton(ActionEvent actionEvent) {
    }
}
