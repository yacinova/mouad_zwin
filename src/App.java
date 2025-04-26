// App.java
import controllers.LoginController;
import models.User;
import views.LoginView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Initialize users (predefined accounts)
        List<User> users = new ArrayList<>();
        users.add(new User("admin", "admin123", "Admin"));
        users.add(new User("user1", "user123", "Normal User"));
        users.add(new User("user2", "user123", "Normal User"));

        // Initialize the login view
        LoginView loginView = new LoginView();

        // Initialize the login controller and pass the view and users list
        LoginController loginController = new LoginController(loginView, users);

        // Show the login window
        loginView.setVisible(true);
    }
}
