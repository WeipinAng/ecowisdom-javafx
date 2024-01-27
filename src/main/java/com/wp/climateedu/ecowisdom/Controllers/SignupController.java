package com.wp.climateedu.ecowisdom.Controllers;

import com.wp.climateedu.ecowisdom.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable {
    public TextField fullname_fld;
    public TextField username_fld;
    public PasswordField password_fld;
    public Button signup_btn;
    public Label error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        signup_btn.setOnAction(event -> createUser());
    }

    private void createUser() {
        String fullName = fullname_fld.getText();
        String username = username_fld.getText();
        String password = password_fld.getText();
        Model.getInstance().addUser(fullName, username, password);
        error_lbl.setStyle("-fx-text-fill: #0E7490; -fx-font-size: 1.3em; -fx-font-weight: bold");
        error_lbl.setText("User Created Successfully!");
        emptyFields();
    }

    private void emptyFields() {
        fullname_fld.setText("");
        username_fld.setText("");
        password_fld.setText("");
    }
}
