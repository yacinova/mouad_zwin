package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.SwingUtilities;
import models.User;
import views.LoginView;
import views.ProductListView;

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
                        // Create and show the ProductListView
                        ProductListView productListView = new ProductListView();
                        // The ProductListView constructor should handle making the frame visible.
                        // If not, uncomment the following line:
                        productListView.setVisible(true); // Make the new window visible
                    });

                    return;
                }
            }

            view.setStatus("Invalid username or password.");
        }
    }
}
