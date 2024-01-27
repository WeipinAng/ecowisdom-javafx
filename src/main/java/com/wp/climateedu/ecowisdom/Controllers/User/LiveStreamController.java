package com.wp.climateedu.ecowisdom.Controllers.User;

import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class LiveStreamController implements Initializable {
    public WebView livestream_web;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        livestream_web.getEngine().load("https://thetvapp.to/tv/the-weather-channel-live-stream/");
    }
}
