package com.ca.onyoureve;
import javafx.scene.web.WebView;


public class WebViewController {
    @javafx.fxml.FXML
    private WebView wview;

    public void setWebView(String url) {
        wview.getEngine().load(url);
    }


}
