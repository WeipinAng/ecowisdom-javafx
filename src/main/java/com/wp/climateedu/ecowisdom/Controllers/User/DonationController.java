package com.wp.climateedu.ecowisdom.Controllers.User;

import com.wp.climateedu.ecowisdom.Models.Donation;
import com.wp.climateedu.ecowisdom.Models.Model;
import com.wp.climateedu.ecowisdom.Views.UserDonationCellFactory;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DonationController implements Initializable {
    public Label username_lbl;
    public TextField amount_fld;
    public Label date_lbl;
    public Button donate_btn;
    public ListView<Donation> donation_listview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username_lbl.textProperty().bind(Model.getInstance().getUser().usernameProperty());
        date_lbl.setText(LocalDate.now().toString());
        donate_btn.setOnAction(event -> createDonation());

        initData();
        donation_listview.setItems(Model.getInstance().getUserDonations());
        donation_listview.setCellFactory(e -> new UserDonationCellFactory());
    }

    private void createDonation() {
        String username = username_lbl.getText();
        String amount = amount_fld.getText();

        Model.getInstance().addDonation(username, Double.parseDouble(amount));
        donation_listview.setItems(Model.getInstance().getUserDonations());
        emptyFields();
    }

    private void initData() {
        if (Model.getInstance().getAllDonations().isEmpty()) {
            Model.getInstance().setAllDonations();
        }
    }

    private void emptyFields() {
        amount_fld.setText("");
    }
}
