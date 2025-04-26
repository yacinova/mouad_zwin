package views;

import controllers.ProductController;
import models.Product;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ProductDetailsView extends JFrame {
    private JLabel lblName;
    private JLabel lblDescription;
    private JLabel lblSKU;
    private JLabel lblPrice;
    private JLabel lblQuantity;
    private JTextField txtQuantity;
    private JButton btnUpdateQuantity;
    private JButton btnAddToInventory;
    private JPanel pnlPictures;
    
    private ProductController productController;
    private Product product;

    // Constructor
    public ProductDetailsView(ProductController productController) {
        this.productController = productController;
        setupUI();
    }

    // Method to setup UI components
    private void setupUI() {
        setTitle("Product Details");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);  // Center the window

        // Panel for displaying product details
        JPanel pnlDetails = new JPanel();
        pnlDetails.setLayout(new GridLayout(6, 2, 10, 10));

        lblName = new JLabel("Name:");
        lblDescription = new JLabel("Description:");
        lblSKU = new JLabel("SKU:");
        lblPrice = new JLabel("Price:");
        lblQuantity = new JLabel("Quantity:");
        txtQuantity = new JTextField();
        
        btnUpdateQuantity = new JButton("Update Quantity");
        btnUpdateQuantity.addActionListener(e -> updateQuantity());

        btnAddToInventory = new JButton("Add to Inventory");
        btnAddToInventory.addActionListener(e -> addToInventory());

        pnlDetails.add(lblName);
        pnlDetails.add(new JLabel("")); // Placeholder for name
        pnlDetails.add(lblDescription);
        pnlDetails.add(new JLabel("")); // Placeholder for description
        pnlDetails.add(lblSKU);
        pnlDetails.add(new JLabel("")); // Placeholder for SKU
        pnlDetails.add(lblPrice);
        pnlDetails.add(new JLabel("")); // Placeholder for price
        pnlDetails.add(lblQuantity);
        pnlDetails.add(txtQuantity);
        pnlDetails.add(btnUpdateQuantity);
        pnlDetails.add(btnAddToInventory);

        add(pnlDetails, BorderLayout.CENTER);

        // Panel for displaying pictures (if any)
        pnlPictures = new JPanel();
        pnlPictures.setLayout(new FlowLayout());
        add(pnlPictures, BorderLayout.SOUTH);
    }

    // Method to update the displayed product data
    public void displayProductDetails(Product product) {
        this.product = product;
        
        lblName.setText("Name: " + product.getName());
        lblDescription.setText("Description: " + product.getDescription());
        lblSKU.setText("SKU: " + product.getSKU());
        lblPrice.setText("Price: " + product.getPrice());
        lblQuantity.setText("Quantity: " + product.getQuantity());

        txtQuantity.setText(String.valueOf(product.getQuantity()));

        // Display product pictures if available
        pnlPictures.removeAll();
        List<String> pictures = product.getPictures();
        for (String picture : pictures) {
            ImageIcon imageIcon = new ImageIcon(picture);  // Assuming picture is a path to image
            JLabel picLabel = new JLabel(imageIcon);
            pnlPictures.add(picLabel);
        }
        pnlPictures.revalidate();
        pnlPictures.repaint();
    }

    // Method to update the product quantity
    private void updateQuantity() {
        int newQuantity = Integer.parseInt(txtQuantity.getText());
        if (product != null) {
            productController.updateProductQuantity(product.getId(), newQuantity);
            displayProductDetails(product); // Refresh the details
        }
    }

    // Method to add the product to the inventory (for admin)
    private void addToInventory() {
        if (product != null) {
            // You could extend this by showing a dialog for inventory addition
            JOptionPane.showMessageDialog(this, "Product added to inventory successfully!");
        }
    }
}
