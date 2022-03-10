package com.ca.onyoureve;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class cust_edit_Controller {

    ////////// VARIABLES FROM FXML /////////////////

    @FXML private JFXTextField nid;
    @FXML private JFXTextField fname;
    @FXML private JFXTextField lname;
    @FXML private JFXTextField cur_pass;
    @FXML private JFXTextField new_pass;
    @FXML private JFXTextField email;
    @FXML private JFXTextField account;
    @FXML private JFXTextField age;

    @FXML private JFXButton exit_btn;
    @FXML private JFXButton edit_btn;

    //////////////////////////////////////////////

    public void init() {
        System.out.println("Initialising customer edit variables");

        Customer cust = LoggedUser.getCust();

        // set values
        String firstName, lastName;
        String fullName = cust.getName();
        String[] tokens = fullName.split(" ", 2);
        firstName = tokens[0];
        lastName = tokens[1];

        fname.setText(firstName);
        lname.setText(lastName);
        nid.setText(cust.getnid());
        age.setText(Integer.toString(cust.getAge()));
        account.setText(cust.getAccount_number());
        email.setText(cust.getEmail_address());

        // disable editing
        age.setEditable(false);
        email.setEditable(false);
        nid.setEditable(false);
        fname.setEditable(false);
        lname.setEditable(false);
    }

    public boolean checkInputs() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        // null values
        if (account == null || account.getText().isEmpty()) {
            openPopup("Missing Input", "Account number should not be blank.");
            return false;
        }

        // account no has letters
        if (account.getText().matches(".*[a-zA-Z]+.*")) {
            openPopup("Invalid Input", "Account number should only contain numbers.");
            return false;
        }

        // account no is negative
        if (Integer.parseInt(account.getText()) < 0) {
            openPopup("Invalid Input", "Account number cannot be negative.");
            return false;
        }

        return true;
    }

    //////////////////////////////////////////////////////

    // called when "save changes" button pressed
    public void handleEditButtonAction(ActionEvent actionEvent) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        System.out.println("Edit button pressed");

        if (checkInputs() == false) {
            System.out.println("Input check failed");
            return;
        }

        String c_nid = "", c_fname = "", c_lname = "", c_newpass = "", c_curpass = "", c_email = "", c_account = "";

        // get non-empty values
        if (nid != null) {
            c_nid = nid.getText();
        }
        if (fname != null) {
            c_fname = fname.getText();
        }
        if (lname != null) {
            c_lname = lname.getText();
        }
        if (new_pass != null) {
            c_newpass = new_pass.getText();
        }
        if (cur_pass != null) {
            c_curpass = cur_pass.getText();
        }
        if (email != null) {
            c_email = email.getText();
        }
        if (account != null) {
            c_account = account.getText();
        }

        int c_age = Integer.parseInt(age.getText());

        // editing customer
        Customer cust = new Customer();
        cust.setName(c_fname + " " + c_lname);
        cust.setEmail_address(c_email);
        cust.setAccount_number(c_account);
        cust.setAge(c_age);
        cust.setnid(c_nid);

        // getting id
        String id = LoggedUser.getCust_id();
        System.out.println("id = " + id);

        // updating values in database and in logged in user state
        if (!cust.getnid().isEmpty()) {
            cust.editCustomerAccountField(id,"nid", cust.getnid());
            LoggedUser.getCust().setnid(cust.getnid());
        }

        if (!cust.getName().isEmpty()) {
            cust.editCustomerAccountField(id,"name", cust.getName());
            LoggedUser.getCust().setName(cust.getName());
        }

        if (!cust.getAccount_number().isEmpty()) {
            cust.editCustomerAccountField(id,"account_number", cust.getAccount_number());
            LoggedUser.getCust().setAccount_number(cust.getAccount_number());
        }

        if (!c_curpass.isEmpty() && !c_newpass.isEmpty()) {
            if(cust.changePassword(id, c_curpass, c_newpass)) {
                SendMail.sendEmail("Password Changed","Your password has been changed successfully. If this was not done by you, immediately contact us at asheventshelp@gmail.com", LoggedUser.getCust().getEmail_address());
            }
            else {
                openPopup("Warning","Password not changed.");
            }
        }

        // refresh data
        LoggedUser.setCust(cust);

        // notify customer account was edited
        String msg = "Your account details have been changed successfully. If this was not done by you, then please contact us at asheventshelp@gmail.com";
        SendMail.sendEmail("Account Info Updated", msg, c_email);

        // refresh screen
        goToEditScreen();
    }

    // called when exit X button pressed
    public void handleExitButton(ActionEvent actionEvent) throws IOException {
        System.out.println("Exit button pressed");
        goToCustMenu();
    }

    ///////////////////// SCENE SWITCHING  //////////////////////////

    /// switches to another window (sign in window)
    public void goToSignIn() throws IOException {
        System.out.println("Loading sign in window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cust_signin.fxml"));
        Parent root = loader.load();

        //Get controller of sign in scene
        cust_signin_Controller controller = loader.getController();

        // close current window
        Stage window = (Stage) exit_btn.getScene().getWindow();
        window.close();

        // start new window for sign in scene
        window = new Stage();
        window.setScene(new Scene(root, 900, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);

        window.setTitle("Sign In");
        window.show();
    }

    public void goToCustMenu() throws IOException {
        System.out.println("Loading customer menu window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cust_menu.fxml"));
        Parent root = loader.load();

        //Get controller of menu scene
        cust_menu_Controller controller = loader.getController();

        //setting information
        controller.setWelcome(LoggedUser.getCust().getName());
        controller.setEventBookedStatus(LoggedUser.getCust_id());

        // close current window
        Stage window = (Stage) exit_btn.getScene().getWindow();
        window.close();

        // start new window for menu scene
        window = new Stage();
        window.setScene(new Scene(root, 900, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);

        window.setTitle("Welcome");
        window.show();
    }

    public void goToEditScreen() throws IOException {
        System.out.println("Loading edit window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cust_edit.fxml"));
        Parent root = loader.load();

        //Get controller of edit scene
        cust_edit_Controller controller = loader.getController();
        controller.init();

        // close current window
        Stage window = (Stage) edit_btn.getScene().getWindow();
        window.close();

        // start new window for edit scene
        window = new Stage();
        window.setScene(new Scene(root, 900, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);

        window.setTitle("Editing Your Account");
        window.show();
    }

    // open popup
    // open popup
    public void openPopup(String heading, String text) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        //Load next
        new WelcomeController().toPopUp(heading, text);
    }
}
