package com.wp.climateedu.ecowisdom.Controllers.Admin;

import com.wp.climateedu.ecowisdom.Models.Model;
import com.wp.climateedu.ecowisdom.Views.AdminMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Button dashboard_btn;
    public Button userslist_btn;
    public Button eventslist_btn;
    public Button donationlist_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        dashboard_btn.setOnAction(actionEvent -> onDashboard());
        userslist_btn.setOnAction(actionEvent -> onUsersList());
        eventslist_btn.setOnAction(actionEvent -> onEventsList());
        donationlist_btn.setOnAction(actionEvent -> onDonationList());
        logout_btn.setOnAction(actionEvent -> onLogout());
    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItemProperty().set(AdminMenuOptions.DASHBOARD);
    }

    private void onUsersList() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItemProperty().set(AdminMenuOptions.USERS_LIST);
    }

    private void onEventsList() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItemProperty().set(AdminMenuOptions.EVENTS_LIST);
    }

    private void onDonationList() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItemProperty().set(AdminMenuOptions.DONATION_LIST);
    }

    private void onLogout() {
        // Get stage
        Stage stage = (Stage) logout_btn.getScene().getWindow();
        // Close the admin window
        Model.getInstance().getViewFactory().closeStage(stage);
        // Show login window
        Model.getInstance().getViewFactory().showLoginWindow();
        // Set adminLoginSuccessFlag to false again to deny access
        Model.getInstance().setAdminLoginSuccessFlag(false);
    }
}
