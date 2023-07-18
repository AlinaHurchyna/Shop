package org.example;
public class Category {
    public boolean getCategoryId;
    private int categoryId;
    private String name;

    public Category(int categoryId, String name) {
        this.categoryId = categoryId;
        this.setName(name);
    }

    public int getCategoryId() {
        return categoryId;
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
}
