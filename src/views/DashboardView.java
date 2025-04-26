// views/DashboardView.java
package views;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JFrame {
    private JLabel welcomeLabel;
    private JPanel summaryPanel;
    private JPanel recentPanel;

    public DashboardView(String username, String role) {
        setTitle("Dashboard - Stock Management");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- Top Bar with Logo & Welcome Message ---
        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel logoLabel = new JLabel("🛒 Stock Manager", SwingConstants.LEFT);
        logoLabel.setFont(new Font("Arial", Font.BOLD, 22));
        logoLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));

        welcomeLabel = new JLabel("Welcome, " + username + " (" + role + ")", SwingConstants.RIGHT);
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));

        topPanel.add(logoLabel, BorderLayout.WEST);
        topPanel.add(welcomeLabel, BorderLayout.EAST);

        // --- Summary Cards Panel ---
        summaryPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        summaryPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        summaryPanel.add(createSummaryCard("Total Products", "52"));
        summaryPanel.add(createSummaryCard("Inventory Items", "234"));
        summaryPanel.add(createSummaryCard("Users", "3"));

        // --- Recent Products Panel ---
        recentPanel = new JPanel();
        recentPanel.setLayout(new BoxLayout(recentPanel, BoxLayout.Y_AXIS));
        recentPanel.setBorder(BorderFactory.createTitledBorder("Recently Added Products"));

        for (int i = 1; i <= 5; i++) {
            recentPanel.add(new JLabel("📦 Product #" + i + " - Sample product name"));
        }

        // --- Add All Panels to Frame Layout ---
        add(topPanel, BorderLayout.NORTH);
        add(summaryPanel, BorderLayout.CENTER);
        add(new JScrollPane(recentPanel), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createSummaryCard(String title, String value) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(new Color(245, 245, 245));
        card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        card.setPreferredSize(new Dimension(100, 100));

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel valueLabel = new JLabel(value, SwingConstants.CENTER);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 24));

        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);

        return card;
    }
}
