package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.ProductService.getProductById;
import static org.example.ProductService.products;

public class CategoryService {

    static Scanner scanner = new Scanner(System.in);
    public static final List<Category> categories = generateCategories();

    public static List<Category> generateCategories() {
        List<Category> categoryList = new ArrayList<>();

        Category category1 = new Category("owoce");
        Category category2 = new Category("warzywa");
        Category category3 = new Category("inne");

        categoryList.add(category1);
        categoryList.add(category2);
        categoryList.add(category3);

        return  categoryList;
    }

    public static Category getCategoryById(int categoryId) {
        for (Category category : categories) {
            if (category.getCategoryId() == categoryId) {
                return category;
            }
        }
        return null;
    }

    public static void printAllCategory() {
        System.out.println("Lista kategorii:");
        for (Category category : categories) {
            System.out.println("ID: " + category.getCategoryId()
                    + ", Nazwa: " + category.getName());
        }
    }

    public static void printCategoryDetails(int categoryId) {
        Category category = getCategoryById(categoryId);
        if (category != null) {
            System.out.println("Szczegóły produktu:");
            System.out.println("ID: " + category.getCategoryId());
            System.out.println("Nazwa: " + category.getName());

        } else {
            System.out.println("Produkt o podanym ID nie istnieje.");
        }
    }

    public static void printSpecificCategory() {
        System.out.print("Podaj ID kategorii: ");

        int categoryId = scanner.nextInt();
        scanner.nextLine();

        Category category = getCategoryById(categoryId);
        if (category != null) {
            printCategoryDetails(categoryId);
        } else {
            System.out.println("Kategoria o podanym ID nie istnieje.");
        }
    }

    public static void addCategory() {
        System.out.println("Dodawanie kategorii: ");
        System.out.println();

        System.out.print("Podaj nazwę: ");
        String name = scanner.nextLine();


        Category newCategory = new Category(name);
        categories.add(newCategory);

        System.out.println("Kategoria została dodana.");
    }

    public static void deleteCategory() {
        System.out.print("Podaj Id kategorii, którą chcesz usunąć: ");
        int categoryId = scanner.nextInt();

        boolean removed = false;
        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);
            if (category.getCategoryId() == categoryId) {
                categories.remove(i);
                removed = true;
                System.out.println("Kategoria została usunięta.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Nie znaleziono kategorii o podanym ID.");
        }
    }
}

