// views/LoginView.java
package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;
    private JLabel logoImageLabel;

    public LoginView() {
        setTitle("🛒 Stock Manager - Login");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        panel.setBackground(new Color(245, 245, 245));

        // Logo Image
        logoImageLabel = new JLabel();
        logoImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        try {
            ImageIcon logoIcon = new ImageIcon("assets/logo.png");
            Image logo = logoIcon.getImage().getScaledInstance(200, 200,6);
            logoImageLabel.setIcon(new ImageIcon(logo));
        } catch (Exception e) {
            logoImageLabel.setText("[Logo]");
        }
        panel.add(logoImageLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Title Logo
        JLabel titleLabel = new JLabel("Stock Manager", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Username Field
        usernameField = new JTextField(20);
        usernameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        usernameField.setFont(new Font("Arial", Font.PLAIN, 16));
        usernameField.setBorder(BorderFactory.createTitledBorder("Username"));
        panel.add(usernameField);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Password Field
        passwordField = new JPasswordField(20);
        passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
        panel.add(passwordField);

        panel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        loginButton.setBackground(new Color(0, 123, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(loginButton);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Status Label
        statusLabel = new JLabel("", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        statusLabel.setForeground(Color.RED);
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(statusLabel);

        add(panel);
    }

    // Public methods for the controller
    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void setStatus(String status) {
        statusLabel.setText(status);
    }

    public void addLoginListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }
}
