package com.wp.climateedu.ecowisdom.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class User {
    private final StringProperty fullName;
    private final StringProperty username;
    private final StringProperty password;
    private final ObjectProperty<LocalDate> dateCreated;
    private final boolean isAdmin;

    public User(String fullName, String username, String password, LocalDate dateCreated, boolean isAdmin) {
        this.fullName = new SimpleStringProperty(this, "FullName", fullName);
        this.username = new SimpleStringProperty(this, "Username", username);
        this.password = new SimpleStringProperty(this, "Password", password);
        this.dateCreated = new SimpleObjectProperty<>(this, "DateCreated", dateCreated);
        this.isAdmin = isAdmin;
    }

    public String getFullName() {
        return fullName.get();
    }

    public StringProperty fullNameProperty() {
        return fullName;
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public LocalDate getDateCreated() {
        return dateCreated.get();
    }

    public ObjectProperty<LocalDate> dateCreatedProperty() {
        return dateCreated;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
