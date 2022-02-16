
/*
 * *
 *  * Created by Chondromollika Ahmed on 2/14/22, 6:11 PM
 *  *chondromollikaahmed@gmail.com
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 2/1/22, 8:20 AM
 *  *Current Path E:/OnYourEVE/src/main/java/com/ca/onyoureve/WebViewController.java
 *  *OnYourEVE
 *
 */

package com.ca.onyoureve;

import javafx.scene.web.WebView;

public class WebViewController {
    @javafx.fxml.FXML
    private WebView wview;

    public void setWebView(String url) {
        wview.getEngine().load(url);
    }
}
