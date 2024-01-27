package com.wp.climateedu.ecowisdom.Controllers.Admin;

import com.wp.climateedu.ecowisdom.Models.User;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class UserCellController implements Initializable {
    public Label fullName_lbl;
    public Label username_lbl;
    public Label date_lbl;
    public Button delete_btn;

    private final User user;
    private final UsersListController usersListController;

    public UserCellController(User user, UsersListController usersListController) {
        this.user = user;
        this.usersListController = usersListController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fullName_lbl.textProperty().bind(user.fullNameProperty());
        username_lbl.textProperty().bind(user.usernameProperty());
        date_lbl.textProperty().bind(user.dateCreatedProperty().asString());

        delete_btn.setOnAction(event -> usersListController.deleteUser(user));
    }
}
