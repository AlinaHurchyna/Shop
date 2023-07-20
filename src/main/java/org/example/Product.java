package org.example;

public class Product {
    private final int productId;
    private static int newProductId = 1;
    private Double price;
    private String name;
    private Category category;
    private int quantity;


    public Product(Double price, String name, int quantity) {
        this.productId = newProductId++;
        setPrice(price);
        setName(name);
        setCategory(category);
        setQuantity(quantity);
    }

    public int getProductId() {
        return productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null
                && !name.isBlank()
                && name.length() > 0 && name.length() < 50
                && name.matches("^[a-zA-Z]*$")) {
            this.name = name;
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if (category != null) {
            this.category = category;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }
}
