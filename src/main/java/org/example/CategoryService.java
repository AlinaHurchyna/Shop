package org.example;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private final List<String> categories;

    public CategoryService() {
        categories = new ArrayList<>();
    }

    public void addCategory(String category) {
        categories.add(category);
    }

    public void removeCategory(String category) {
        categories.remove(category);
    }

    public List<String> getAllCategories() {
        List<String> Categories = new ArrayList<>();
        for (String category : categories) {

        }
        return Categories;
    }

    public String getCategory(String category) {
        for (String cat : categories) {
            if (cat.equals(category)) {
                return cat;
            }
        }
        return null;
    }
}

