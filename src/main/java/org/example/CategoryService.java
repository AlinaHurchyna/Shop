package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CategoryService {
    private List<Locale.Category> categories;

    public CategoryService() {
        categories = new ArrayList<>();
    }

    public void addCategory(Category category) {

        categories.add(category);
    }

    public void removeCategory(int CategoryId) {
        Category categoryToRemove = null;
        for (Category category : categories) {
            if (category.getCategoryId == categoryId) {
                categoryToRemove = category;
                break;;
            }

        }
        if (categoryToRemove != null) {
            categories.remove(categoryToRemove);
        }

    }
    public List<Category> getAllCategories() {
        return categories;
}
    public Category getCategoryById(int categoryId) {
        // Znajdź kategorię po ID
        for (Category category : categories) {
            if (category.getCategoryId() == categoryId) {
                return category;
            }
        }
        return null;
    }
    public void displayAllCategories() {
        System.out.println("Lista kategorii:");
        for (Category category : categories) {
            System.out.println("ID: " + category.getCategoryId() + ", Nazwa: " + category.getName());
        }
    }
    public void displayCategoryDetails(int categoryId) {
        Category category = getCategoryById(categoryId);
        if (category != null) {
            System.out.println("Szczegóły kategorii:");
            System.out.println("ID: " + category.getCategoryId());
            System.out.println("Nazwa: " + category.getName());
        } else {
            System.out.println("Kategoria o podanym ID nie istnieje.");
        }
    }
}
