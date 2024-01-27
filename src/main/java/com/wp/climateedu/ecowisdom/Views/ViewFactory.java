package com.wp.climateedu.ecowisdom.Views;

import com.wp.climateedu.ecowisdom.Controllers.Admin.AdminController;
import com.wp.climateedu.ecowisdom.Controllers.User.UserController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewFactory {
    private AccountType loginAccountType;
    private final ObjectProperty<UserMenuOptions> userSelectedMenuItem;
    private AnchorPane userDashboardView;
    private AnchorPane eventsView;
    private AnchorPane donationView;
    private AnchorPane liveStreamView;

    private final ObjectProperty<AdminMenuOptions> adminSelectedMenuItem;
    private AnchorPane adminDashBoardView;
    private AnchorPane usersListView;
    private AnchorPane eventsListView;
    private AnchorPane donationListView;

    public ViewFactory() {
        this.loginAccountType = AccountType.USER; // set to User by default
        this.userSelectedMenuItem = new SimpleObjectProperty<>();
        this.adminSelectedMenuItem = new SimpleObjectProperty<>();
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    // USER VIEWS SECTION

    public ObjectProperty<UserMenuOptions> getUserSelectedMenuItemProperty() {
        return userSelectedMenuItem;
    }

    public AnchorPane getUserDashboardView() {
        if (userDashboardView == null) {
            try {
                userDashboardView = new FXMLLoader(getClass().getResource("/Fxml/User/Dashboard.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userDashboardView;
    }

    public AnchorPane getEventsView() {
        if (eventsView == null) {
            try {
                eventsView = new FXMLLoader(getClass().getResource("/Fxml/User/Events.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return eventsView;
    }

    public AnchorPane getDonationView() {
        if (donationView == null) {
            try {
                donationView = new FXMLLoader(getClass().getResource("/Fxml/User/Donation.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return donationView;
    }

    public AnchorPane getLiveStreamView() {
        if (liveStreamView == null) {
            try {
                liveStreamView = new FXMLLoader(getClass().getResource("/Fxml/User/LiveStream.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return liveStreamView;
    }

    public void showUserWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/User/User.fxml"));
        UserController userController = new UserController();
        loader.setController(userController);

        createStage(loader);
    }

    // ADMIN VIEWS SECTION

    public ObjectProperty<AdminMenuOptions> getAdminSelectedMenuItemProperty() {
        return adminSelectedMenuItem;
    }

    public AnchorPane getAdminDashBoardView() {
        if (adminDashBoardView == null) {
            try {
                adminDashBoardView = new FXMLLoader(getClass().getResource("/Fxml/Admin/Dashboard.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return adminDashBoardView;
    }

    public AnchorPane getUsersListView() {
        if (usersListView == null) {
            try {
                usersListView = new FXMLLoader(getClass().getResource("/Fxml/Admin/UsersList.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return usersListView;
    }

    public AnchorPane getEventsListView() {
        if (eventsListView == null) {
            try {
                eventsListView = new FXMLLoader(getClass().getResource("/Fxml/Admin/EventsTable.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return eventsListView;
    }

    public AnchorPane getDonationListView() {
        if (donationListView == null) {
            try {
                donationListView = new FXMLLoader(getClass().getResource("/Fxml/Admin/DonationList.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return donationListView;
    }

    public void showAdminWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/Admin.fxml"));
        AdminController adminController = new AdminController();
        loader.setController(adminController);

        createStage(loader);
    }

    // GENERAL SECTION

    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }

    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/app-logo.png"))));
        stage.setResizable(false);
        stage.setTitle("EcoWisdom");
        stage.show();
    }

    // utility method to close a stage
    public void closeStage(Stage stage) {
        stage.close();
    }

    public void showSignUpWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Signup.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/app-logo.png"))));
        stage.setResizable(false);
        stage.setTitle("EcoWisdom Sign Up");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
