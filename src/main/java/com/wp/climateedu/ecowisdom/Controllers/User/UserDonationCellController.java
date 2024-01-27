package com.wp.climateedu.ecowisdom.Controllers.User;

import com.wp.climateedu.ecowisdom.Models.Donation;
import javafx.beans.binding.Bindings;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class UserDonationCellController implements Initializable {
    public Label amount_lbl;
    public Label date_lbl;

    private final Donation donation;

    public UserDonationCellController(Donation donation) {
        this.donation = donation;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        amount_lbl.textProperty().bind(Bindings.concat("RM ").concat(Bindings.format("%.2f", donation.donationAmountProperty())));
        date_lbl.textProperty().bind(donation.donationDateProperty().asString());
    }
}
