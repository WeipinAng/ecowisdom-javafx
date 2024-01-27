package com.wp.climateedu.ecowisdom.Controllers.Admin;

import com.wp.climateedu.ecowisdom.Models.Donation;
import com.wp.climateedu.ecowisdom.Models.Events;
import com.wp.climateedu.ecowisdom.Models.Model;
import com.wp.climateedu.ecowisdom.Views.EventsCellFactory;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public Label login_date;
    public Label user_count;
    public Label events_count;
    public Label donation_amount;
    public TextField events_fld;
    public Button search_btn;
    public ListView<Events> events_listview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double total_donation = 0;
        for (Donation donation : Model.getInstance().getAllDonations()) {
            total_donation += donation.getDonationAmount();
        }

        login_date.setText("Today, " + LocalDate.now());
        user_count.setText(String.valueOf(Model.getInstance().getUsers().size()));
        events_count.setText(String.valueOf(Model.getInstance().getAllEvents().size()));
        donation_amount.setText(String.format("RM %.2f", total_donation));
        search_btn.setOnAction(event -> onEventSearch());
    }

    private void onEventSearch() {
        String searchTerm;
        boolean isValidSearch = false;

        do {
            searchTerm = events_fld.getText().toLowerCase();
            if (searchTerm.isEmpty()) {
                // Inform the user that the search term is empty and prompt again
                isValidSearch = showAlert();
            } else {
                isValidSearch = true;
                ObservableList<Events> searchResult = Model.getInstance().searchEvent(searchTerm);
                events_listview.setItems(searchResult);
                events_listview.setCellFactory(e -> new EventsCellFactory());
            }
        } while (!isValidSearch);
    }

    private boolean showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Search Term Empty");
        alert.setHeaderText(null);
        alert.setContentText("Please enter a search term.");
        // Show the alert and wait for the user to close it
        alert.showAndWait();
        // Return true if the user clicks OK, false otherwise
        return alert.getResult() == ButtonType.OK;
    }
}
