

/*
 * Copyright (c) 2022. Chondromollika Ahmed ,All Right Reserved consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.ca.onyoureve;



import com.ca.onyoureve.Welcome;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Welcome extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Welcome.class.getResource("Welcome.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("OnYourEve");
        Image image = new Image("file:src/main/resources/com/ca/onyoureve/images/logo.jpeg");
        primaryStage.getIcons().add(image);
        //  primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
