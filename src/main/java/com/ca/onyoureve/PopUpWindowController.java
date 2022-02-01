package com.ca.onyoureve;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class PopUpWindowController {
    @javafx.fxml.FXML
    private JFXButton exit_btn;
    @javafx.fxml.FXML
    private JFXTextField heading;
    @javafx.fxml.FXML
    private JFXButton accept_btn;
    @javafx.fxml.FXML
    private JFXTextArea text;
    @javafx.fxml.FXML
    private JFXButton btn_web;

    private  String url;

    public void setContent(String heading, String text, String url) {
        this.heading.setText(heading);
        this.text.setText(text);

        this.heading.setEditable(false);
        this.text.setEditable(false);

        if (url==null) {
            btn_web.setVisible(false);
        }
        else {
            btn_web.setVisible(true);
        }
        this.url = url;



    }

    public void setContent(String heading, String text) {
        setContent(heading, text, null);
    }




    @javafx.fxml.FXML
    public void closeWindow(ActionEvent actionEvent) {
        if (exit_btn != null) {
            Stage window = (Stage) exit_btn.getScene().getWindow();
            window.close();
        }

        else if (accept_btn != null) {
            Stage window = (Stage) accept_btn.getScene().getWindow();
            window.close();
        }
    }

    @javafx.fxml.FXML
    public void webAction(ActionEvent actionEvent) throws IOException, UnsupportedAudioFileException, LineUnavailableException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("WebView.fxml"));
        Parent root =loader.load();
        WebViewController controller = loader.getController();
        controller.setWebView(url);

        Stage window = new Stage();
        window.setScene(new Scene(root));
        window.setTitle("OnYourEVE©CA,Terms of Use");
        window.getIcons().add(new javafx.scene.image.Image("file:src/main/resources/com/ca/onyoureve/images/logo.jpeg"));
        window.show();
        PlayAudio.play();
    }
}
