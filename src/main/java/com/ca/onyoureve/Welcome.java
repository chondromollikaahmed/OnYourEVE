/*
 * *
 *  * Created by Chondromollika Ahmed on 2/14/22, 5:51 PM
 *  *chondromollikaahmed@gmail.com
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 2/2/22, 9:53 PM
 *  *Current Path E:/OnYourEVE/src/main/java/com/ca/onyoureve/Welcome.java
 *  *OnYourEVE
 *
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
