package org.example;

import java.util.Random;

public class Product {
    private int productId;
    private double price;
    private String name;
    private Category category;
    private int quantity;

    public Product(double price, String name, Category category, int quantity) {
        this.productId = generateProductId();
        this.setPrice(price);
        this.setName(name);
        this.setCategory(category);
        this.setQuantity(quantity);
    }

    private int generateProductId() {

        Random random = new Random();
        return random.nextInt(1000);
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0.");
        }
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be null or empty.");
        }
        if (name.length() < 1 || name.length() > 50) {
            throw new IllegalArgumentException("Name length must be between 1 and 50 characters.");
        }
        if (!name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Name must contain only characters.");
        }
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Category must not be null.");
        }
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0.");
        }
        this.quantity = quantity;
    }
}
