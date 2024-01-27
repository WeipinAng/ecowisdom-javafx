package com.wp.climateedu.ecowisdom.Views;

import com.wp.climateedu.ecowisdom.Controllers.User.EventsCellController;
import com.wp.climateedu.ecowisdom.Models.Events;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class EventsCellFactory extends ListCell<Events> {
    @Override
    protected void updateItem(Events event, boolean empty) {
        super.updateItem(event, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/User/EventsCell.fxml"));
            EventsCellController controller = new EventsCellController(event);
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
