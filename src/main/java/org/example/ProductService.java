package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    static Scanner scanner =new Scanner(System.in);
    public static final List<Product> products = generateProducts();

    public static List<Product> generateProducts() {
        List<Product> productList = new ArrayList<>();

        Product product1 = new Product(12.2, "arbuz", 1);
        Product product2 = new Product(2.5, "banan", 1);
        Product product3 = new Product(11.4, "winogrona", 15);
        Product product4 = new Product(5.2, "melon", 1);
        Product product5 = new Product(15.2, "maliny", 20);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);

        return productList;
    }

    /*public static void addProduct(Product product) {
        products.add(product);
    }*/


    public List<Product> getAllProducts() {
        return products;
    }

    public static Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    public static void printAllProducts() {
        System.out.println("Lista produktów:");
        for (Product product : products) {
            System.out.println("ID: "
                    + product.getProductId()
                    + ", Nazwa: " + product.getName()
                    + ", Cena: " + product.getPrice() + " zł");
        }
    }

    public static void printProductDetails(int productId) {
        Product product = getProductById(productId);
        if (product != null) {
            System.out.println("Szczegóły produktu:");
            System.out.println("ID: " + product.getProductId());
            System.out.println("Nazwa: " + product.getName());
            System.out.println("Cena: " + product.getPrice() + " zł");
            System.out.println("Ilość: " + product.getQuantity());
        } else {
            System.out.println("Produkt o podanym ID nie istnieje.");
        }
    }

    public static void printSpecificProduct() {
        System.out.print("Podaj ID produktu: ");

        int productId = scanner.nextInt();
        scanner.nextLine();

        Product product = ProductService.getProductById(productId);
        if (product != null) {
            printProductDetails(productId);
        } else {
            System.out.println("Produkt o podanym ID nie istnieje.");
        }
    }

    /*public static void addProduct() {
        System.out.print("Podaj cenę: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Podaj nazwę: ");
        String name = scanner.nextLine();

        System.out.print("Podaj ilość: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        ProductService.addProduct();

        System.out.println("Produkt został dodany.");
    }*/
}
