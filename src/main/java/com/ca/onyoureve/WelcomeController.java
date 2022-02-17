package com.ca.onyoureve;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {
    @javafx.fxml.FXML
    private JFXButton termC;
    @javafx.fxml.FXML
    private JFXButton about;
    @FXML
    private AnchorPane pnl_off;
    @FXML
    private AnchorPane pnl_man;
    @FXML
    private JFXRadioButton mgr_btn;
    @FXML
    private AnchorPane pnl_cus;
    @FXML
    private Label lbl_reg;
    @FXML
    private JFXButton customer_sin;
    @FXML
    private JFXButton manager_sin;
    @FXML
    private JFXButton officer_sin;
    @FXML
    private JFXTextField man_id;
    @FXML
    private JFXTextField cus_id;
    @FXML
    private JFXTextField cus_pass;
    @FXML
    private JFXTextField man_pass;
    @FXML
    private JFXTextField off_pass;
    @FXML
    private JFXTextField off_id;
    @FXML
    private JFXButton tableview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //loginUI.setVisible(false);
        pnl_cus.setVisible(false);
        pnl_off.setVisible(false);
        pnl_man.setVisible(false);
        lbl_reg.setVisible(false);
    }

    @javafx.fxml.FXML
    public void aboutAction(ActionEvent actionEvent) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        toPopUp("About OnYourEVE", "Author: OnYourEVE\nVersion: 1.0\nCopyright: Copyright © 2022 OnYourEVE. All rights reserved.\n\n" +
                "This program is free software: you can redistribute it and/or modify\n" +
                "it under the terms of the GNU General Public License as published by\n" +
                "public repository link: https://github.com/chondromollikaahmed/OnYourEVE");
    }

    private void toPopUp(String about_us, String s, String url) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PopUpWindow.fxml"));
        Parent root = loader.load();
        PopUpWindowController controller = loader.getController();
        controller.setContent(about_us, s, url);
        Stage window = new Stage();
        window.setScene(new Scene(root));
        window.initStyle(StageStyle.UNDECORATED);
        window.show();
        PlayAudio.play();
    }

    public void toPopUp(String about_us, String s) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        toPopUp(about_us, s, null);
    }

    @FXML
    public void termCAction(ActionEvent actionEvent) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        toPopUp("OnYourEVE", "Terms and Conditions\n" +
                "Last updated: February 01, 2022\n" +
                "Please read these terms and conditions carefully before using Our Service.\n" +
                "Interpretation and Definitions\n" +
                "Interpretation\n" +
                "The words of which the initial letter is capitalized have meanings defined under the following conditions. The following definitions shall have the same meaning regardless of whether they appear in singular or in plural.\n" +
                "Definitions\n" +
                "For the purposes of these Terms and Conditions:\n" +
                "\n" +
                "\n" +
                "Application means the software program provided by the Company downloaded by You on any electronic device, named OnYourEVE\n" +
                "\n" +
                "\n" +
                "Application Store means the digital distribution service operated and developed by Apple Inc. (Apple App Store) or Google Inc. (Google Play Store) in which the Application has been downloaded.\n" +
                "\n" +
                "\n" +
                "Affiliate means an entity that controls, is controlled by or is under common control with a party, where \"control\" means ownership of 50% or more of the shares, equity interest or other securities entitled to vote for election of directors or other managing authority.\n" +
                "\n" +
                "\n" +
                "Country refers to:  Bangladesh\n" +
                "\n" +
                "\n" +
                "Company (referred to as either \"the Company\", \"We\", \"Us\" or \"Our\" in this Agreement) refers to Event Management, east shewrapara.\n" +
                "\n" +
                "\n" +
                "Device means any device that can access the Service such as a computer, a cellphone or a digital tablet.\n" +
                "\n" +
                "\n" +
                "Service refers to the Application.\n" +
                "\n" +
                "\n" +
                "Terms and Conditions (also referred as \"Terms\") mean these Terms and Conditions that form the entire agreement between You and the Company regarding the use of the Service. This Terms and Conditions agreement has been created with the help of the Terms and Conditions Generator.\n" +
                "\n" +
                "\n" +
                "Third-party Social Media Service means any services or content (including data, information, products or services) provided by a third-party that may be displayed, included or made available by the Service.\n" +
                "\n" +
                "\n" +
                "You means the individual accessing or using the Service, or the company, or other legal entity on behalf of which such individual is accessing or using the Service, as applicable.\n" +
                "\n" +
                "\n" +
                "Acknowledgment\n" +
                "These are the Terms and Conditions governing the use of this Service and the agreement that operates between You and the Company. These Terms and Conditions set out the rights and obligations of all users regarding the use of the Service.\n" +
                "Your access to and use of the Service is conditioned on Your acceptance of and compliance with these Terms and Conditions. These Terms and Conditions apply to all visitors, users and others who access or use the Service.\n" +
                "By accessing or using the Service You agree to be bound by these Terms and Conditions. If You disagree with any part of these Terms and Conditions then You may not access the Service.\n" +
                "You represent that you are over the age of 18. The Company does not permit those under 18 to use the Service.\n" +
                "Your access to and use of the Service is also conditioned on Your acceptance of and compliance with the Privacy Policy of the Company. Our Privacy Policy describes Our policies and procedures on the collection, use and disclosure of Your personal information when You use the Application or the Website and tells You about Your privacy rights and how the law protects You. Please read Our Privacy Policy carefully before using Our Service.\n" +
                "Links to Other Websites\n" +
                "Our Service may contain links to third-party web sites or services that are not owned or controlled by the Company.\n" +
                "The Company has no control over, and assumes no responsibility for, the content, privacy policies, or practices of any third party web sites or services. You further acknowledge and agree that the Company shall not be responsible or liable, directly or indirectly, for any damage or loss caused or alleged to be caused by or in connection with the use of or reliance on any such content, goods or services available on or through any such web sites or services.\n" +
                "We strongly advise You to read the terms and conditions and privacy policies of any third-party web sites or services that You visit.\n" +
                "Termination\n" +
                "We may terminate or suspend Your access immediately, without prior notice or liability, for any reason whatsoever, including without limitation if You breach these Terms and Conditions.\n" +
                "Upon termination, Your right to use the Service will cease immediately.\n" +
                "Limitation of Liability\n" +
                "Notwithstanding any damages that You might incur, the entire liability of the Company and any of its suppliers under any provision of this Terms and Your exclusive remedy for all of the foregoing shall be limited to the amount actually paid by You through the Service or 100 USD if You haven't purchased anything through the Service.\n" +
                "To the maximum extent permitted by applicable law, in no event shall the Company or its suppliers be liable for any special, incidental, indirect, or consequential damages whatsoever (including, but not limited to, damages for loss of profits, loss of data or other information, for business interruption, for personal injury, loss of privacy arising out of or in any way related to the use of or inability to use the Service, third-party software and/or third-party hardware used with the Service, or otherwise in connection with any provision of this Terms), even if the Company or any supplier has been advised of the possibility of such damages and even if the remedy fails of its essential purpose.\n" +
                "Some states do not allow the exclusion of implied warranties or limitation of liability for incidental or consequential damages, which means that some of the above limitations may not apply. In these states, each party's liability will be limited to the greatest extent permitted by law.\n" +
                "\"AS IS\" and \"AS AVAILABLE\" Disclaimer\n" +
                "The Service is provided to You \"AS IS\" and \"AS AVAILABLE\" and with all faults and defects without warranty of any kind. To the maximum extent permitted under applicable law, the Company, on its own behalf and on behalf of its Affiliates and its and their respective licensors and service providers, expressly disclaims all warranties, whether express, implied, statutory or otherwise, with respect to the Service, including all implied warranties of merchantability, fitness for a particular purpose, title and non-infringement, and warranties that may arise out of course of dealing, course of performance, usage or trade practice. Without limitation to the foregoing, the Company provides no warranty or undertaking, and makes no representation of any kind that the Service will meet Your requirements, achieve any intended results, be compatible or work with any other software, applications, systems or services, operate without interruption, meet any performance or reliability standards or be error free or that any errors or defects can or will be corrected.\n" +
                "Without limiting the foregoing, neither the Company nor any of the company's provider makes any representation or warranty of any kind, express or implied: (i) as to the operation or availability of the Service, or the information, content, and materials or products included thereon; (ii) that the Service will be uninterrupted or error-free; (iii) as to the accuracy, reliability, or currency of any information or content provided through the Service; or (iv) that the Service, its servers, the content, or e-mails sent from or on behalf of the Company are free of viruses, scripts, trojan horses, worms, malware, timebombs or other harmful components.\n" +
                "Some jurisdictions do not allow the exclusion of certain types of warranties or limitations on applicable statutory rights of a consumer, so some or all of the above exclusions and limitations may not apply to You. But in such a case the exclusions and limitations set forth in this section shall be applied to the greatest extent enforceable under applicable law.\n" +
                "Governing Law\n" +
                "The laws of the Country, excluding its conflicts of law rules, shall govern this Terms and Your use of the Service. Your use of the Application may also be subject to other local, state, national, or international laws.\n" +
                "Disputes Resolution\n" +
                "If You have any concern or dispute about the Service, You agree to first try to resolve the dispute informally by contacting the Company.\n" +
                "For European Union (EU) Users\n" +
                "If You are a European Union consumer, you will benefit from any mandatory provisions of the law of the country in which you are resident in.\n" +
                "United States Legal Compliance\n" +
                "You represent and warrant that (i) You are not located in a country that is subject to the United States government embargo, or that has been designated by the United States government as a \"terrorist supporting\" country, and (ii) You are not listed on any United States government list of prohibited or restricted parties.\n" +
                "Severability and Waiver\n" +
                "Severability\n" +
                "If any provision of these Terms is held to be unenforceable or invalid, such provision will be changed and interpreted to accomplish the objectives of such provision to the greatest extent possible under applicable law and the remaining provisions will continue in full force and effect.\n" +
                "Waiver\n" +
                "Except as provided herein, the failure to exercise a right or to require performance of an obligation under these Terms shall not effect a party's ability to exercise such right or require such performance at any time thereafter nor shall the waiver of a breach constitute a waiver of any subsequent breach.\n" +
                "Translation Interpretation\n" +
                "These Terms and Conditions may have been translated if We have made them available to You on our Service.\n" +
                "You agree that the original English text shall prevail in the case of a dispute.\n" +
                "Changes to These Terms and Conditions\n" +
                "We reserve the right, at Our sole discretion, to modify or replace these Terms at any time. If a revision is material We will make reasonable efforts to provide at least 30 days' notice prior to any new terms taking effect. What constitutes a material change will be determined at Our sole discretion.\n" +
                "By continuing to access or use Our Service after those revisions become effective, You agree to be bound by the revised terms. If You do not agree to the new terms, in whole or in part, please stop using the website and the Service.\n" +
                "Contact Us\n" +
                "If you have any questions about these Terms and Conditions, You can contact us:\n" +
                "\n" +
                "\n" +
                "By email: chondromollikaahmed@gmail.com\n" +
                "\n" +
                "\n" +
                "By visiting this page on our website: www.onyoureve.cf\n" +
                "\n", "https://www.termsfeed.com/live/f6b3b136-0828-4f77-9a76-4fbea410a85f");
    }

    @FXML
    public void openUrl(ActionEvent actionEvent) throws IOException {
        java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://github.com/chondromollikaahmed"));
    }

    @FXML
    public void btn_man_action(ActionEvent actionEvent) {
        pnl_cus.setVisible(false);
        pnl_off.setVisible(false);
        pnl_man.setVisible(true);
        lbl_reg.setVisible(false);
    }

    @FXML
    public void btn_off_action(ActionEvent actionEvent) {
        pnl_cus.setVisible(false);
        pnl_off.setVisible(true);
        pnl_man.setVisible(false);
        lbl_reg.setVisible(false);
    }

    @FXML
    public void btnCusAction(ActionEvent actionEvent) {
        pnl_cus.setVisible(true);
        pnl_off.setVisible(false);
        pnl_man.setVisible(false);
        lbl_reg.setVisible(true);
    }

    @FXML
    public void clearView(Event event) {
        pnl_cus.setVisible(false);
        pnl_off.setVisible(false);
        pnl_man.setVisible(false);
    }


    public boolean checkInputs(JFXTextField id, JFXTextField pass) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        // null values
        if (id == null || pass == null) {
            toPopUp("Invalid Input", "Please fill all the fields.");
            return false;
        }

        // empty values
        if (id.getText().isEmpty() || pass.getText().isEmpty()) {
            toPopUp("Invalid Input", "Please fill all the fields.");
            return false;
        }

        return true;
    }

    @FXML
    public void btnMSignAction(ActionEvent actionEvent) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        System.out.println("Sign in button pressed (Manager)");

        String id = off_id.getText();
        String password = off_pass.getText();

        Employee emp = new Employee();
        boolean login = emp.employeeLogin(id, password);

        //close login window if login unsuccessful - to be changed
        if (login == false) {
            toPopUp("Login Failed", "Invalid email/ID and password combination.");
            System.out.println("Login unsuccessful");
        }

        // Login successful - go to welcome screen
        else {
            // check if employee is a manager
            if (emp.isManager(id)) {
                System.out.println("Login successful");
                LoggedUser.initEmp(id);

                // send email
                String msg = "You have just signed in to our system. If this was not you, then please contact us at chondromollikaahmed@gmail.com";
                SendMail.sendEmail("Successful Login", msg, LoggedUser.getEmp().getEmail());

                goToMgrMenu();
            }

            else {
                toPopUp("Warning", "No manager exists against the provided ID.");
            }
        }
    }



    public void goToMgrMenu() throws IOException {
        System.out.println("Loading manager menu window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mgr_menu.fxml"));
        Parent root = loader.load();

        //Get controller of manager menu scene
        mgr_menu_Controller controller = loader.getController();
        controller.setName(LoggedUser.getEmp().getName());

        // close current window
        Stage window = (Stage) mgr_btn.getScene().getWindow();
        window.close();

        // start new window for manager scene
        window = new Stage();
        window.setScene(new Scene(root, 900, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);

        window.setTitle("Manager Menu");
        window.show();
    }


    @FXML
    public void btnCSignAction(ActionEvent actionEvent) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        if (checkInputs(cus_id,cus_pass) == false) {
            System.out.println("Input check failed");
            return;
        }

        String c_pass = cus_pass.getText();
        String c_idOrEmail = cus_id.getText();

        Customer obj = new Customer();
        boolean login = obj.customerLogin(c_idOrEmail, c_pass);

        // give error if incorrect login
        if (!login) {
            toPopUp("Login Failed", "Invalid email/ID and password combination.");
        }

        // Login successful - go to welcome screen
        else {
            // store customer info
            LoggedUser.initCust(c_idOrEmail);

            String msg = "You have just signed in to our system. If this was not you, then please contact us at chondromollikaahmed@gmail.com";
            SendMail.sendEmail("Successful Login", msg, LoggedUser.getCust().getEmail());

            goToCustMenu();
        }
    }



    // go to customer background
    public void goToCustMenu() throws IOException {
        System.out.println("Loading customer menu");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuCustomer.fxml"));
        Parent root = loader.load();

        //Get controller of cust menu scene
        MenuCustomerController controller = loader.getController();

        //setting information
        controller.setWelcome(LoggedUser.getCust().getName());
        controller.setEventBookedStatus(LoggedUser.getCustomer_id());

        // close current window
        Stage stage = (Stage) customer_sin.getScene().getWindow();
        stage.close();

        // start new window for next scene
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Welcome");
        stage.show();
    }



    public void goToRegister() throws IOException {
        System.out.println("Loading register window");

        //Load next
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistrationCustomer.fxml"));
        Parent root = loader.load();

        //Get controller of register scene
        RegistrationCustomerController controller = loader.getController();

        // close current window
        Stage window = (Stage) customer_sin.getScene().getWindow();
        window.close();

        // start new window for main scene
        window = new Stage();
        window.setScene(new Scene(root, 400, 600));

        Font.loadFont(getClass().getResourceAsStream("Fonts/Alifiyah.otf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/Honeymoon Avenue Script Demo.ttf"), 10);

        Font.loadFont(getClass().getResourceAsStream("Fonts/ArchivoNarrow-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("Fonts/JuliusSansOne-Regular.ttf"), 10);

        window.setTitle("Register Your Account");
        window.show();
    }
    @FXML
    public void btnOSignAction(ActionEvent actionEvent) {

    }

    @FXML
    public void tableViewAction(ActionEvent actionEvent) throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("TableCustomer.fxml"));
        Parent root = loader.load();

        //Get controller of manager menu scene
        TableCustomerController controller = loader.getController();

        // close current window
        Stage window = (Stage) mgr_btn.getScene().getWindow();

        // start new window for manager scene
        window = new Stage();
        window.setScene(new Scene(root));
        window.show();

    }
}
