package com.wp.climateedu.ecowisdom.Controllers.Admin;

import com.wp.climateedu.ecowisdom.Models.Model;
import com.wp.climateedu.ecowisdom.Models.User;
import com.wp.climateedu.ecowisdom.Views.UserCellFactory;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class UsersListController implements Initializable {
    public ListView<User> users_listview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
        users_listview.setItems(Model.getInstance().getUsers());
        users_listview.setCellFactory(e -> new UserCellFactory(this));
    }

    private void initData() {
        if (Model.getInstance().getUsers().isEmpty()) {
            Model.getInstance().setUsers();
        }
    }

    public void deleteUser(User user) {
        Model.getInstance().filteredUsers.getSource().remove(user);
    }
}
