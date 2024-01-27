package com.wp.climateedu.ecowisdom.Controllers.User;

import com.wp.climateedu.ecowisdom.Models.Events;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class EventsCellController implements Initializable {
    public Label name_lbl;
    public Label date_lbl;
    public Text detail_lbl;

    private final Events event;

    public EventsCellController(Events event) {
        this.event = event;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name_lbl.textProperty().bind(event.eventNameProperty());
        date_lbl.textProperty().bind(event.eventDateProperty().asString());
        detail_lbl.textProperty().bind(event.eventDetailProperty());
    }
}
