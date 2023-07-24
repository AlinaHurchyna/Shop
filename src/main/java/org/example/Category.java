package org.example;

public class Category {
    private final int categoryId;
    private static int newCategoryId = 1;
    private String name;

    public Category(String name) {
        this.categoryId = newCategoryId++;
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null
                && !name.isBlank()
                && name.length() > 0 && name.length() < 50
                && name.matches("^[a-zA-Z]+")) {
            this.name = name;
        }
    }
}
