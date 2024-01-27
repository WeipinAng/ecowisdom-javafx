package com.wp.climateedu.ecowisdom.Models;

import javafx.beans.property.*;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Events {
    private final StringProperty eventName;
    private final ObjectProperty<LocalDate> eventDate;
    private final StringProperty eventDetail;

    public Events(String eventName, LocalDate eventDate, String eventDetail) {
        this.eventName = new SimpleStringProperty(this, "EventName", eventName);
        this.eventDate = new SimpleObjectProperty<>(this, "EventDate", eventDate);
        this.eventDetail = new SimpleStringProperty(this, "EventDetail", eventDetail);
    }

    public String getEventName() {
        return eventName.get();
    }

    public StringProperty eventNameProperty() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName.set(eventName);
    }

    public LocalDate getEventDate() {
        return eventDate.get();
    }

    public ObjectProperty<LocalDate> eventDateProperty() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate.set(eventDate);
    }

    public String getEventDetail() {
        return eventDetail.get();
    }

    public StringProperty eventDetailProperty() {
        return eventDetail;
    }

    public void setEventDetail(String eventDetail) {
        this.eventDetail.set(eventDetail);
    }

    // for getRowValue()
    @Override
    public String toString() {
        return this.getEventName() + " " + this.getEventDate() + " " + this.getEventDetail();
    }

    public static TableColumn<Events, String> getEventNameColumn() {
        TableColumn<Events, String> eNameCol = new TableColumn<>("Event Name");
        eNameCol.setCellValueFactory(new PropertyValueFactory<>("EventName"));
        eNameCol.setPrefWidth(200.0);

        eNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        eNameCol.setOnEditCommit(e -> {
            e.getRowValue().setEventName(e.getNewValue());
        });

        return eNameCol;
    }

    public static TableColumn<Events, LocalDate> getEventDateColumn() {
        TableColumn<Events, LocalDate> eDateCol = new TableColumn<>("Event Date");
        eDateCol.setCellValueFactory(new PropertyValueFactory<>("EventDate"));
        eDateCol.setPrefWidth(100.0);

        String pattern = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateStringConverter converter = new LocalDateStringConverter(formatter, null);
        eDateCol.setCellFactory(TextFieldTableCell.forTableColumn(converter));
        eDateCol.setOnEditCommit(e -> {
            e.getRowValue().setEventDate(e.getNewValue());
        });
        return eDateCol;
    }

    public static TableColumn<Events, String> getEventDetailColumn() {
        TableColumn<Events, String> eDetailCol = new TableColumn<>("Event Detail");
        eDetailCol.setCellValueFactory(new PropertyValueFactory<>("EventDetail"));
        eDetailCol.setPrefWidth(410.0);

        eDetailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        eDetailCol.setOnEditCommit(e -> {
            e.getRowValue().setEventDetail(e.getNewValue());
        });

        return eDetailCol;
    }

    public static TableColumn<Events, Button> getDeleteEventsColumn() {
        TableColumn<Events, Button> dEventsCol = new TableColumn<>("Delete");
        dEventsCol.setPrefWidth(80.0);
        dEventsCol.setCellFactory(col -> new TableCell<>(){
            @Override
            protected void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);
                // clean the cell in case it's being used once (have clean slate to start with)
                setText(null);
                setGraphic(null);

                if (!empty) {
                    Button button = new Button("Delete");
                    // add event listener
                    button.setOnAction(actionEvent -> {
                        // get index of the row (instance of Cell) to be deleted
                        int rowIndex = this.getTableRow().getIndex();
                        this.getTableView().getItems().remove(rowIndex);
                    });
                    setText(null);
                    setGraphic(button);
                }
            }
        });
        dEventsCol.setSortable(false);
        dEventsCol.setReorderable(false);
        return dEventsCol;
    }
}

