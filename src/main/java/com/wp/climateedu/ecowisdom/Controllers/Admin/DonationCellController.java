package com.wp.climateedu.ecowisdom.Controllers.Admin;

import com.wp.climateedu.ecowisdom.Models.Donation;
import javafx.beans.binding.Bindings;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DonationCellController implements Initializable {
    public Label sender_lbl;
    public Label amount_lbl;
    public Label date_lbl;

    private final Donation donation;

    public DonationCellController(Donation donation) {
        this.donation = donation;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sender_lbl.textProperty().bind(donation.donationSenderProperty());
        amount_lbl.textProperty().bind(Bindings.concat("RM ").concat(Bindings.format("%.2f", donation.donationAmountProperty())));
        date_lbl.textProperty().bind(donation.donationDateProperty().asString());
    }
}
