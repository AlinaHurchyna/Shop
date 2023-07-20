package org.example;

public class Category {
    private final int categoryId;
    private static int newCategoryId = 1;
    private String name;

    public Category(String name) {
        this.categoryId = newCategoryId++;
        this.name = name;
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

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
