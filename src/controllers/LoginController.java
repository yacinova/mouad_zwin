package controllers;

import models.User;
import views.DashboardView;
import views.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.SwingUtilities;

public class LoginController {
    private LoginView view;
    private List<User> users;

    public LoginController(LoginView view, List<User> users) {
        this.view = view;
        this.users = users;

        this.view.addLoginListener(new LoginAction());
    }

    class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();

            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    view.setStatus("Login successful!");

                    // Open Dashboard view and close login
                    SwingUtilities.invokeLater(() -> {
                        view.dispose(); // Close the login window
                        new DashboardView(user.getUsername(), user.getRole()); // Show dashboard
                    });

                    return;
                }
            }

            view.setStatus("Invalid username or password.");
        }
    }
}
