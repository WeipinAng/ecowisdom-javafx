package com.wp.climateedu.ecowisdom.Views;

import com.wp.climateedu.ecowisdom.Controllers.User.UserDonationCellController;
import com.wp.climateedu.ecowisdom.Models.Donation;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class UserDonationCellFactory extends ListCell<Donation> {
    @Override
    protected void updateItem(Donation donation, boolean empty) {
        super.updateItem(donation, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/User/UserDonationCell.fxml"));
            UserDonationCellController controller = new UserDonationCellController(donation);
            loader.setController(controller);

            setText(null);
            try {
                setGraphic(loader.load());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
