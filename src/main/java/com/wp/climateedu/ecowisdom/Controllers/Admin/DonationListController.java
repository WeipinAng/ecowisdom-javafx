package com.wp.climateedu.ecowisdom.Controllers.Admin;

import com.wp.climateedu.ecowisdom.Models.Donation;
import com.wp.climateedu.ecowisdom.Models.Model;
import com.wp.climateedu.ecowisdom.Views.DonationCellFactory;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class DonationListController implements Initializable {
    public ListView<Donation> donation_listview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
        donation_listview.setItems(Model.getInstance().getAllDonations());
        donation_listview.setCellFactory(e -> new DonationCellFactory());
    }

    private void initData() {
        if (Model.getInstance().getAllDonations().isEmpty()) {
            Model.getInstance().setAllDonations();
        }
    }
}
