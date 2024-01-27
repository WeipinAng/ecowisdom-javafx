package com.wp.climateedu.ecowisdom.Controllers.Admin;

import com.wp.climateedu.ecowisdom.Models.Events;
import com.wp.climateedu.ecowisdom.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EventsTableController implements Initializable {
    public TableView<Events> events_listview;
    public TextField eventname_fld;
    public DatePicker eventdate_fld;
    public TextArea eventdetail_fld;
    public Button addevent_btn;

    private Events events;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
        events_listview.setItems(Model.getInstance().getAllEvents());

        events_listview.getColumns().addAll(
                Events.getEventNameColumn(),
                Events.getEventDateColumn(),
                Events.getEventDetailColumn(),
                Events.getDeleteEventsColumn()
        );
        events_listview.getSelectionModel().selectFirst();
        events_listview.setEditable(true);

        addevent_btn.setOnAction(event -> addEvent());
    }

    private void initData() {
        if (Model.getInstance().getAllEvents().isEmpty()) {
            Model.getInstance().setAllEvents();
        }
    }

    private void addEvent() {
        String eventName = eventname_fld.getText();
        LocalDate eventDate = eventdate_fld.getValue();
        String eventDetail = eventdetail_fld.getText();
        Model.getInstance().addEvent(eventName, eventDate, eventDetail);
        emptyFields();
    }

    private void emptyFields() {
        eventname_fld.setText("");
        eventdate_fld.setValue(null);
        eventdetail_fld.setText("");
    }
}
