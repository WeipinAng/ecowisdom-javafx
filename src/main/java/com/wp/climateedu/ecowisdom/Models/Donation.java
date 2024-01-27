package com.wp.climateedu.ecowisdom.Models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Donation {
    private final StringProperty donationSender;
    private final DoubleProperty donationAmount;
    private final ObjectProperty<LocalDate> donationDate;

    public Donation(String donationSender, Double donationAmount, LocalDate donationDate) {
        this.donationSender = new SimpleStringProperty(this, "DonationSender", donationSender);
        this.donationAmount = new SimpleDoubleProperty(this, "DonationAmount", donationAmount);
        this.donationDate = new SimpleObjectProperty<>(this, "DonationDate", donationDate);
    }

    public String getDonationSender() {
        return donationSender.get();
    }

    public StringProperty donationSenderProperty() {
        return donationSender;
    }

    public double getDonationAmount() {
        return donationAmount.get();
    }

    public DoubleProperty donationAmountProperty() {
        return donationAmount;
    }

    public LocalDate getDonationDate() {
        return donationDate.get();
    }

    public ObjectProperty<LocalDate> donationDateProperty() {
        return donationDate;
    }
}
