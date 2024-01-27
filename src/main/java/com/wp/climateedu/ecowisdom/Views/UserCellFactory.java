package com.wp.climateedu.ecowisdom.Views;

import com.wp.climateedu.ecowisdom.Controllers.Admin.UserCellController;
import com.wp.climateedu.ecowisdom.Controllers.Admin.UsersListController;
import com.wp.climateedu.ecowisdom.Models.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class UserCellFactory extends ListCell<User> {
    private final UsersListController usersListController;

    public UserCellFactory(UsersListController usersListController) {
        this.usersListController = usersListController;
    }

    @Override
    protected void updateItem(User user, boolean empty) {
        super.updateItem(user, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/UserCell.fxml"));
            UserCellController controller = new UserCellController(user, usersListController);
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
