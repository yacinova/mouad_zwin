package controllers;

import models.Product;
import views.ProductListView;
import views.ProductDetailsView;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class ProductController {
    private List<Product> products;  // List of products, can be replaced with database calls
    private ProductListView productListView;
    private ProductDetailsView productDetailsView;

    // Constructor
    public ProductController(ProductListView productListView, ProductDetailsView productDetailsView) {
        this.products = new ArrayList<>();
        this.productListView = productListView;
        this.productDetailsView = productDetailsView;

        // Populate the list with some sample products (or fetch from the database)
        this.products.add(new Product("1", "Laptop", "High performance laptop", "SKU123", 999.99, 50, new ArrayList<>()));
        this.products.add(new Product("2", "Smartphone", "Latest model smartphone", "SKU124", 499.99, 100, new ArrayList<>()));

        // Pass the products list to the view
        this.productListView.displayProducts(this.products);
    }

    // Method to get all products
    public List<Product> getAllProducts() {
        return this.products;
    }

    // Method to get a single product by ID
    public Product getProductById(String id) {
        Optional<Product> product = this.products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        return product.orElse(null);  // Return null if not found
    }

    // Method to add a new product
    public void addProduct(String id, String name, String description, String SKU, double price, int quantity, List<String> pictures) {
        Product newProduct = new Product(id, name, description, SKU, price, quantity, pictures);
        this.products.add(newProduct);
        productListView.updateProductList(this.products);  // Update the list in the view
    }

    // Method to edit a product's details
    public void editProduct(String id, String name, String description, String SKU, double price, int quantity, List<String> pictures) {
        Product product = getProductById(id);
        if (product != null) {
            product.setName(name);
            product.setDescription(description);
            product.setSKU(SKU);
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setPictures(pictures);
            productListView.updateProductList(this.products);  // Update the list in the view
        }
    }

    // Method to delete a product
    public void deleteProduct(String id) {
        Product product = getProductById(id);
        if (product != null) {
            this.products.remove(product);
            productListView.updateProductList(this.products);  // Update the list in the view
        }
    }

    // Method to update the quantity of a product
    public void updateProductQuantity(String id, int newQuantity) {
        Product product = getProductById(id);
        if (product != null) {
            product.setQuantity(newQuantity);
            productListView.updateProductList(this.products);  // Update the list in the view
        }
    }
}
