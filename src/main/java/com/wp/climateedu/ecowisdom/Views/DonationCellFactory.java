package com.wp.climateedu.ecowisdom.Views;

import com.wp.climateedu.ecowisdom.Controllers.Admin.DonationCellController;
import com.wp.climateedu.ecowisdom.Models.Donation;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class DonationCellFactory extends ListCell<Donation> {
    @Override
    protected void updateItem(Donation donation, boolean empty) {
        super.updateItem(donation, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/DonationCell.fxml"));
            DonationCellController controller = new DonationCellController(donation);
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
