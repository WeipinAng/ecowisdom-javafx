package com.wp.climateedu.ecowisdom.Controllers.User;

import com.wp.climateedu.ecowisdom.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {
    public BorderPane user_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getUserSelectedMenuItemProperty().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal) {
                case EVENTS -> user_parent.setCenter(Model.getInstance().getViewFactory().getEventsView());
                case DONATION -> user_parent.setCenter(Model.getInstance().getViewFactory().getDonationView());
                case LIVESTREAM -> user_parent.setCenter(Model.getInstance().getViewFactory().getLiveStreamView());
                default -> user_parent.setCenter(Model.getInstance().getViewFactory().getUserDashboardView());
            }
        });
    }
}
