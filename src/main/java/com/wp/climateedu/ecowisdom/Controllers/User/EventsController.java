package com.wp.climateedu.ecowisdom.Controllers.User;

import com.wp.climateedu.ecowisdom.Models.Events;
import com.wp.climateedu.ecowisdom.Models.Model;
import com.wp.climateedu.ecowisdom.Views.EventsCellFactory;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class EventsController implements Initializable {
    public ListView<Events> events_listview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
        events_listview.setItems(Model.getInstance().getAllEvents());
        events_listview.setCellFactory(e -> new EventsCellFactory());
    }

    private void initData() {
        if (Model.getInstance().getAllEvents().isEmpty()) {
            Model.getInstance().setAllEvents();
        }
    }
}
