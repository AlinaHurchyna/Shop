package org.example;

public class Product {
    private int productId;
    private static int newId = 1;
    private Double price;
    private String name;
    private int quantity;

    public Product(Double price, String name, int quantity) {
        this.productId = newId++;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }


    public boolean validateName(String name) {
        if (name == null || name.isBlank() || name.length() > 0 && name.length() < 50) {
            return false;
        }

        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
        this.name = name;
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
