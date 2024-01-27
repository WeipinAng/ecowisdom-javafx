package com.wp.climateedu.ecowisdom.Models;

import com.wp.climateedu.ecowisdom.Views.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import java.time.LocalDate;
import java.util.Comparator;

public class Model {
    private final ViewFactory viewFactory;
    private static Model model;

    private final User user;
    private boolean userLoginSuccessFlag;
    private boolean adminLoginSuccessFlag;

    private final ObservableList<User> users;
    public final FilteredList<User> filteredUsers;

    private final ObservableList<Events> allEvents;
    private final ObservableList<Events> latestEvents;
    private final ObservableList<Donation> allDonations;

    private Model() {
        this.viewFactory = new ViewFactory();
        this.user = new User("", "", "", null, false);
        this.userLoginSuccessFlag = false;
        this.adminLoginSuccessFlag = false;

        this.users = FXCollections.observableArrayList();
        this.filteredUsers = new FilteredList<>(users, user -> !user.isAdmin());
        initializeUsers(); // populate sample users
        this.allEvents = FXCollections.observableArrayList();
        this.latestEvents = FXCollections.observableArrayList();
        initializeEvents(); // populate sample events
        this.allDonations = FXCollections.observableArrayList();
        initializeDonations(); // populate sample donations
    }

    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }


    private void initializeUsers() {
        users.add(new User("Admin", "admin", "admin123", LocalDate.of(2023, 1, 1), true));
        users.add(new User("Rick Novak", "ricknovak1", "ricknovak123", LocalDate.of(2023, 3, 17), false));
        users.add(new User("Ronald Barr", "ronaldbarr2", "ronaldbarr123", LocalDate.of(2023, 5, 20), false));
        users.add(new User("Marie Lum", "marielum3", "marielum123", LocalDate.of(2023, 8, 30), false));
    }

    private void initializeEvents() {
        allEvents.add(new Events("Coastal Conservation Volunteering in Madagascar", LocalDate.of(2023, 9, 23), "This program offers three amazing opportunities. First, the chance to explore island and coastal biodiversity – including snorkelling in beautiful marine habitats. Second, the chance to contribute to conservation projects. And third, the opportunity to embrace the unique life found on remote research stations – exposure to new languages and insights, and access to beautiful natural parks."));
        allEvents.add(new Events("Plastic Pollution and Conservation In Thailand", LocalDate.of(2023, 10, 11), "Get involved in regular beach cleans and conduct environmental education workshops at local schools and within the wider local community, aiming to promote effective plastic waste disposal practices in Phang Nga, Thailand."));
        allEvents.add(new Events("Island Nations Climate Change and Biodiversity Volunteer in Seychelles", LocalDate.of(2023, 11, 7), "Travel to scenic Seychelles to live and work on the tropical island of Mahe and assist the Seychelles Parks and Gardens Authority with collecting data that drives sustainable management and conservation strategies. Gain practical experience in sustainable development, witnessing climate change impacts on islands like Seychelles, while learning how to mitigate these effects."));
        allEvents.add(new Events("Climate Change and Coral Bleaching in Seychelles", LocalDate.of(2023, 11, 27), "Travel to the warm, crystal clear waters of the Indian Ocean to contribute to coral reef recovery research and coral rehabilitation. Learn about how climate change is causing coral bleaching, what is being done to limit the damage, and encourage recovery."));
        allEvents.add(new Events("Climate Change and Coral Bleaching in Fiji", LocalDate.of(2023, 12, 16), "Learn about threats facing corals worldwide and specifically in Fiji. Assist with marine conservation initiatives, like surveying corals for recovery after previous coral bleaching events and tropical storms, assisting with beach or ocean floor plastic pollution clean ups, and environmental education with the local community."));
        latestEvents.setAll(allEvents); // Set latestEvents to allEvents initially
        // Sort events by eventDate in descending orders
        allEvents.sort(Comparator.comparing(Events::getEventDate).reversed());
    }

    private void initializeDonations() {
        allDonations.add(new Donation("ricknovak1", 300.00, LocalDate.of(2023, 3, 28)));
        allDonations.add(new Donation("ronaldbarr2", 150.00, LocalDate.of(2023, 6, 4)));
        allDonations.add(new Donation("ricknovak1", 250.00, LocalDate.of(2023, 5, 30)));
        allDonations.add(new Donation("marielum3", 600.00, LocalDate.of(2023, 9, 11)));
        // Sort user donations by donationDate in descending order
        allDonations.sort(Comparator.comparing(Donation::getDonationDate).reversed());
    }

    // User Method Section
    public void addUser(String fullName, String username, String password) {
        users.add(new User(fullName, username, password, LocalDate.now(), false));
    }

    public User getUser() {
        return user;
    }

    public boolean getUserLoginSuccessFlag() {
        return userLoginSuccessFlag;
    }

    public void setUserLoginSuccessFlag(boolean flag) {
        this.userLoginSuccessFlag = flag;
    }

    public void evaluateUserCred(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password) && !user.isAdmin()) {
                this.user.fullNameProperty().set(user.getFullName());
                this.user.usernameProperty().set(user.getUsername());
                this.user.passwordProperty().set(user.getPassword());
                this.user.dateCreatedProperty().set(user.getDateCreated());
                this.userLoginSuccessFlag = true;
            }
        }
    }

    // Admin Method Section
    public boolean getAdminLoginSuccessFlag() {
        return adminLoginSuccessFlag;
    }

    public void setAdminLoginSuccessFlag(boolean flag) {
        this.adminLoginSuccessFlag = flag;
    }

    public void evaluateAdminCred(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password) && user.isAdmin()) {
                this.user.fullNameProperty().set(user.getFullName());
                this.user.usernameProperty().set(user.getUsername());
                this.user.passwordProperty().set(user.getPassword());
                this.user.dateCreatedProperty().set(user.getDateCreated());
                this.adminLoginSuccessFlag = true;
            }
        }
    }

    public ObservableList<User> getUsers() {
        return new SortedList<>(filteredUsers);
    }

    public void setUsers() {
        initializeUsers();
    }

    public ObservableList<Events> searchEvent(String searchTerm) {
        String lowerCaseSearchTerm = searchTerm.toLowerCase();
        ObservableList<Events> searchResults = FXCollections.observableArrayList();

        for (Events event : allEvents) {
            if (event.getEventName().toLowerCase().contains(lowerCaseSearchTerm) ||
                    event.getEventDetail().toLowerCase().contains(lowerCaseSearchTerm)) {
                searchResults.add(event);
            }
        }

        return searchResults;
    }

    // General Section
    public Events getLatestEvent() {
        Events latestEvent = null;

        for (Events event : allEvents) {
            if (latestEvent == null || event.getEventDate().isAfter(latestEvent.getEventDate())) {
                latestEvent = event;
            }
        }
        // Return the latest event if found, otherwise return null
        return latestEvent;
    }

    public void addEvent(String eventName, LocalDate eventDate, String eventDetail) {
        allEvents.add(new Events(eventName, eventDate, eventDetail));
        // Sort user donations by donation_date in descending order
        allEvents.sort(Comparator.comparing(Events::getEventDate).reversed());
    }

    public ObservableList<Events> getAllEvents() {
        return allEvents;
    }

    public void setAllEvents() {
        initializeEvents();
    }

    public ObservableList<Donation> getUserDonations() {
        ObservableList<Donation> userDonations = FXCollections.observableArrayList();

        for (Donation donation : allDonations) {
            if (donation.getDonationSender().equals(Model.getInstance().getUser().getUsername())) {
                userDonations.add(donation);
            }
        }
        // Sort user donations by donation_date in descending order
        userDonations.sort(Comparator.comparing(Donation::getDonationDate).reversed());
        // Return the latest donation if found, otherwise return an empty list
        return FXCollections.unmodifiableObservableList(userDonations);
    }

    public void addDonation(String sender, double amount) {
        Donation newDonation = new Donation(sender, amount, LocalDate.now());
        allDonations.add(newDonation);
        // Sort user donations by donation_date in descending order
        allDonations.sort(Comparator.comparing(Donation::getDonationDate).reversed());
    }

    public ObservableList<Donation> getAllDonations() {
        return allDonations;
    }

    public void setAllDonations() {
        initializeDonations();
    }
}
