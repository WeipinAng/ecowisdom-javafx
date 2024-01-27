package com.wp.climateedu.ecowisdom.Controllers;

import com.wp.climateedu.ecowisdom.Models.Model;
import com.wp.climateedu.ecowisdom.Views.AccountType;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox<AccountType> acc_selector;
    public TextField username_fld;
    public PasswordField password_fld;
    public Button login_btn;
    public Label error_lbl;
    public Button sign_up_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acc_selector.setItems(FXCollections.observableArrayList(AccountType.USER, AccountType.ADMIN));
        acc_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        acc_selector.valueProperty().addListener(observable -> setAcc_selector());
        login_btn.setOnAction(event -> onLogin());
        sign_up_btn.setOnAction(event -> Model.getInstance().getViewFactory().showSignUpWindow());
    }

    private void onLogin() {
        Stage stage = (Stage) error_lbl.getScene().getWindow();

        // 1. Evaluate User Login Credentials
        if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.USER) {
            Model.getInstance().evaluateUserCred(username_fld.getText(), password_fld.getText());
            if (Model.getInstance().getUserLoginSuccessFlag()) {
                Model.getInstance().getViewFactory().showUserWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
            } else {
                username_fld.setText("");
                password_fld.setText("");
                error_lbl.setText("No Such Login Credentials.");
            }
        // 2. Evaluate Admin Login Credentials
        } else {
            Model.getInstance().evaluateAdminCred(username_fld.getText(), password_fld.getText());
            if (Model.getInstance().getAdminLoginSuccessFlag()) {
                Model.getInstance().getViewFactory().showAdminWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
            } else {
                username_fld.setText("");
                password_fld.setText("");
                error_lbl.setText("No Such Login Credentials.");
            }
        }
    }

    private void setAcc_selector() {
        Model.getInstance().getViewFactory().setLoginAccountType(acc_selector.getValue());
    }
}
