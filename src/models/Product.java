package models;

import java.util.List;

public class Product {
    private String id; // Unique identifier for the product
    private String name; // Name of the product
    private String description; // Description of the product
    private String SKU; // Stock Keeping Unit, unique product identifier
    private double price; // Price per unit of the product
    private int quantity; // Quantity available in stock
    private List<String> pictures; // List of image URLs or file paths for the product

    // Constructor
    public Product(String id, String name, String description, String SKU, double price, int quantity, List<String> pictures) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.SKU = SKU;
        this.price = price;
        this.quantity = quantity;
        this.pictures = pictures;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    // Method to add a single picture
    public void addPicture(String picture) {
        this.pictures.add(picture);
    }

    // Method to remove a picture
    public void removePicture(String picture) {
        this.pictures.remove(picture);
    }

    // Method to get the number of pictures
    public int getNumberOfPictures() {
        return this.pictures.size();
    }
}
