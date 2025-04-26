package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProductListView extends JFrame {
    private JTable productTable;
    private JTextField searchField;
    private JButton logoutButton;
    private DefaultTableModel tableModel;
    private JLabel logoLabel;

    public ProductListView() {
        setTitle("Stock Manager - Product List");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Top Panel (logo + search + logout)
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topPanel.setBackground(new Color(245, 245, 245));

        // Logo
        logoLabel = new JLabel();
        try {
            ImageIcon logoIcon = new ImageIcon("assets/logo.png");
            Image logo = logoIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            logoLabel.setIcon(new ImageIcon(logo));
        } catch (Exception e) {
            logoLabel.setText("[Logo]");
        }
        topPanel.add(logoLabel, BorderLayout.WEST);

        // Search Field
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200, 40));
        searchField.setFont(new Font("Arial", Font.PLAIN, 16));
        searchField.setBorder(BorderFactory.createTitledBorder("Search"));
        topPanel.add(searchField, BorderLayout.CENTER);

        // Logout Button
        logoutButton = new JButton("Logout");
        logoutButton.setBackground(new Color(220, 53, 69));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusPainted(false);
        topPanel.add(logoutButton, BorderLayout.EAST);

        // Product Table
        String[] columns = {"Name", "SKU", "Available Qty", "Price", "Edit"};
        tableModel = new DefaultTableModel(columns, 0);
        productTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(productTable);

        // Main Layout
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Public methods for the Controller
    public void addLogoutListener(ActionListener listener) {
        logoutButton.addActionListener(listener);
    }

    public void addSearchListener(ActionListener listener) {
        searchField.addActionListener(listener);
    }

    public String getSearchText() {
        return searchField.getText();
    }

    public void setProductTableData(Object[][] data) {
        tableModel.setRowCount(0); // Clear old data
        for (Object[] row : data) {
            tableModel.addRow(row);
        }
    }
}
