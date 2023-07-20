package org.example;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final ProductService productService = new ProductService();

    //private final OrderService orderService = new OrderService();
    //private final CategoryService categoryService = new CategoryService();

    public void showMainMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Zamówienia");
            System.out.println("2. Kategorie produktów");
            System.out.println("3. Produkty");
            System.out.println("4. Wyjdź");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                //case 1 -> ;
                // case 2 -> ;
                case 3 -> showProductSubMenu();
                case 4 -> exit = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
            System.out.println();
        }
    }

    public void showProductSubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("[1] Lista produktów.");
            System.out.println("[2] Konkretny produkt.");
            System.out.println("[3] Dodaj produkt.");
            System.out.println("[4] Cofnij");

            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {
                case 1 -> ProductService.printAllProducts();
                case 2 -> ProductService.printSpecificProduct();
               // case 3 -> ProductService.addProduct();
                case 4 -> back = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }

            System.out.println();
        }
    }
}