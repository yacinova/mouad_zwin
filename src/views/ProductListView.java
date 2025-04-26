package views;

import java.awt.*;
import java.net.URL; // Import URL
import java.util.List;
import javax.swing.*;
import models.Product;

public class ProductListView extends JFrame {
    private JPanel containerPanel;
    private JTable productTable;
    private JTextField searchField;

    public ProductListView() {
        setTitle("Product List");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        containerPanel = new JPanel(new BorderLayout());
        containerPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        containerPanel.setBackground(Color.WHITE);

        // Logo
        JLabel logoLabel = new JLabel(); // Initialize label first
        try {
            // Correct the path if necessary, e.g., "/assets/logo.png"
            // Ensure the 'resources' or 'assets' folder is on the classpath
            URL logoUrl = getClass().getResource("/assets/logo.png"); // Or "/assets/logo.png" if that's correct

            if (logoUrl != null) {
                ImageIcon logoIcon = new ImageIcon(logoUrl);
                Image img = logoIcon.getImage().getScaledInstance(60, 60, 10);
                logoLabel.setIcon(new ImageIcon(img));
            } else {
                // Handle case where resource is not found
                System.err.println("Error: Logo resource not found at /resources/logo.png");
                logoLabel.setText("[Logo Not Found]"); // Set placeholder text
            }
        } catch (Exception e) {
            // Catch potential exceptions during resource loading/processing
            System.err.println("Error loading logo: " + e.getMessage());
            e.printStackTrace();
            logoLabel.setText("[Logo Error]");
        }
        containerPanel.add(logoLabel, BorderLayout.NORTH);


        // Top panel for search and logo (adjust layout)
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE); // Match container background
        topPanel.add(logoLabel, BorderLayout.WEST); // Logo on the left

        searchField = new JTextField("Search products...");
        searchField.setPreferredSize(new Dimension(300, 30)); // Give search field a size
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Panel to hold search
        searchPanel.setBackground(Color.WHITE);
        searchPanel.add(searchField);
        topPanel.add(searchPanel, BorderLayout.CENTER); // Search field in the center/right

        containerPanel.add(topPanel, BorderLayout.NORTH); // Add the combined top panel


        // Table to display products
        productTable = new JTable();  // You will fill it with data dynamically
        containerPanel.add(new JScrollPane(productTable), BorderLayout.CENTER);

        setContentPane(containerPanel);
        // setVisible(true); // Make the frame visible upon creation - Moved to controller after login
    }

    public void displayProducts(List<Product> products) {
        // Convert the list of products to a format suitable for the JTable
        String[] columnNames = {"ID", "Name", "Description", "SKU", "Price", "Quantity"};
        Object[][] data = new Object[products.size()][columnNames.length];

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            data[i][0] = product.getId();
            data[i][1] = product.getName();
            data[i][2] = product.getDescription();
            data[i][3] = product.getSKU();
            data[i][4] = product.getPrice();
            data[i][5] = product.getQuantity();
        }

        productTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
    public void updateProductList(List<Product> products) {
        displayProducts(products);  // Refresh the product list in the table
    }

    public String getSearchText() {
        return searchField.getText();
    }
    public void clearSearchField() {
        searchField.setText("");
    }
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void showSuccess(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    public void showInfo(String message) {
        JOptionPane.showMessageDialog(this, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    public void showWarning(String message) {
        JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }
    public void showConfirmation(String message) {
        int response = JOptionPane.showConfirmDialog(this, message, "Confirmation", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            // User clicked Yes
        } else {
            // User clicked No
        }
    }
}
