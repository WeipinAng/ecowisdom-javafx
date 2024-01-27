package com.wp.climateedu.ecowisdom.Controllers.User;

import com.wp.climateedu.ecowisdom.Models.Donation;
import com.wp.climateedu.ecowisdom.Models.Events;
import com.wp.climateedu.ecowisdom.Models.Model;
import javafx.beans.binding.Bindings;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public Text full_name;
    public Label login_date;
    public Text event_title;
    public Label event_detail;
    public Label event_date;
    public Label total_donation_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bindData();
    }

    private void bindData() {
        full_name.textProperty().bind(Bindings.concat("Hi, ").concat(Model.getInstance().getUser().fullNameProperty()));
        login_date.setText("Today, " + LocalDate.now());

        Events latestEvent = Model.getInstance().getLatestEvent();
        event_title.textProperty().bind(latestEvent.eventNameProperty());
        event_detail.textProperty().bind(latestEvent.eventDetailProperty());
        event_date.textProperty().bind(latestEvent.eventDateProperty().asString());

        double total_donation = 0;
        for (Donation donation : Model.getInstance().getUserDonations()) {
            total_donation += donation.getDonationAmount();
        }
        total_donation_lbl.setText(String.format("RM %.2f", total_donation));
    }
}
