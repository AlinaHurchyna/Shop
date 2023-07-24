package org.example;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public void showMainMenu() {
        boolean exit = false;
        while (!exit) {

            System.out.println("Wybierz z listy: ");

            System.out.println("1. Zamówienia");
            System.out.println("2. Kategorie produktów");
            System.out.println("3. Produkty");
            System.out.println("4. Wyjdź");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showOrderSubMenu();
                case 2 -> showCategorySubMenu();
                case 3 -> showProductSubMenu();
                case 4 -> exit = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
            System.out.println();
        }
    }

    public void showOrderSubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("[1] Lista zamówień.");
            System.out.println("[2] Konkretne zamówienie.");
            System.out.println("[3] Dodaj zamówienie.");
            System.out.println("[4] Usuń zamówienie.");
            //System.out.println("[5] Edytuj zamówienie.");
            System.out.println("[6] Zmień status zamówienia.");
            System.out.println("[7] Pokaż status zamówienia.");
            //System.out.println("[8] Dodaj produkt do zamówienia.");
            System.out.println("[9] Cofnij");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> OrderService.printAllOrders();
                case 2 -> OrderService.displayOrderDetails();
                case 3 -> OrderService.addOrder();
                case 4 -> OrderService.deleteOrder();
                //case 5 ->
                case 6 -> OrderService.changeOrderStatus();
                case 7 -> OrderService.displayOrderStatus();
                //case 8 ->
                case 9 -> back = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
            System.out.println();
        }
    }

    public void showCategorySubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("[1] Lista kategorii.");
            System.out.println("[2] Konkretna kategoria.");
            System.out.println("[3] Dodaj kategorie.");
            System.out.println("[4] Usuń kategorie.");
            System.out.println("[5] Cofnij");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> CategoryService.printAllCategory();
                case 2 -> CategoryService.printSpecificCategory();
                case 3 -> CategoryService.addCategory();
                case 4 -> CategoryService.deleteCategory();
                case 5 -> back = true;
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
            System.out.println("[4] Usuń produkt.");
            System.out.println("[5] Cofnij");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> ProductService.printAllProducts();
                case 2 -> ProductService.printSpecificProduct();
                case 3 -> ProductService.addProduct();
                case 4 -> ProductService.deleteProduct();
                case 5 -> back = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
            System.out.println();
        }
    }
}