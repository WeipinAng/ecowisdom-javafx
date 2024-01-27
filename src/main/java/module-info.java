module com.wp.climateedu.ecowisdom {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires javafx.web;


    opens com.wp.climateedu.ecowisdom to javafx.fxml;
    exports com.wp.climateedu.ecowisdom;
    exports com.wp.climateedu.ecowisdom.Controllers;
    exports com.wp.climateedu.ecowisdom.Controllers.Admin;
    exports com.wp.climateedu.ecowisdom.Controllers.User;
    exports com.wp.climateedu.ecowisdom.Models;
    exports com.wp.climateedu.ecowisdom.Views;
}