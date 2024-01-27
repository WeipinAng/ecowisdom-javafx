package com.wp.climateedu.ecowisdom.Controllers.User;

import com.wp.climateedu.ecowisdom.Models.Model;
import com.wp.climateedu.ecowisdom.Views.UserMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UserMenuController implements Initializable {
    public Button dashboard_btn;
    public Button event_btn;
    public Button donation_btn;
    public Button livestream_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        dashboard_btn.setOnAction(actionEvent -> onDashboard());
        event_btn.setOnAction(actionEvent -> onEvent());
        donation_btn.setOnAction(actionEvent -> onDonation());
        livestream_btn.setOnAction(actionEvent -> onLiveStream());
        logout_btn.setOnAction(actionEvent -> onLogout());
    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getUserSelectedMenuItemProperty().set(UserMenuOptions.DASHBOARD);
    }

    private void onEvent() {
        Model.getInstance().getViewFactory().getUserSelectedMenuItemProperty().set(UserMenuOptions.EVENTS);
    }

    private void onDonation() {
        Model.getInstance().getViewFactory().getUserSelectedMenuItemProperty().set(UserMenuOptions.DONATION);
    }

    private void onLiveStream() {
        Model.getInstance().getViewFactory().getUserSelectedMenuItemProperty().set(UserMenuOptions.LIVESTREAM);
    }

    private void onLogout() {
        // Get stage
        Stage stage = (Stage) logout_btn.getScene().getWindow();
        // Close the user window
        Model.getInstance().getViewFactory().closeStage(stage);
        // Show login window
        Model.getInstance().getViewFactory().showLoginWindow();

        // Set adminLoginSuccessFlag to false again to deny access
        Model.getInstance().setUserLoginSuccessFlag(false);
    }
}
