package com.wp.climateedu.ecowisdom.Controllers.Admin;

import com.wp.climateedu.ecowisdom.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    public BorderPane admin_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItemProperty().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal) {
                case USERS_LIST -> admin_parent.setCenter(Model.getInstance().getViewFactory().getUsersListView());
                case EVENTS_LIST -> admin_parent.setCenter(Model.getInstance().getViewFactory().getEventsListView());
                case DONATION_LIST -> admin_parent.setCenter(Model.getInstance().getViewFactory().getDonationListView());
                default -> admin_parent.setCenter(Model.getInstance().getViewFactory().getAdminDashBoardView());
            }
        });
    }
}
