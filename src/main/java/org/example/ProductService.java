package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int productId) {
        Product productToRemove = null;
        for (Product product : products) {
            if (product.getProductId() == productId) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            products.remove(productToRemove);
        }
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    public void displayAllProducts() {
        System.out.println("Lista produktów:");
        for (Product product : products) {
            System.out.println("ID: " 
                    + product.getProductId()
                    + ", Nazwa: " + product.getName()
                    + ", Cena: " + product.getPrice());
        }
    }

    public void displayProductDetails(int productId) {
        Product product = getProductById(productId);
        if (product != null) {
            System.out.println("Szczegóły produktu:");
            System.out.println("ID: " + product.getProductId());
            System.out.println("Nazwa: " + product.getName());
            System.out.println("Cena: " + product.getPrice());
            System.out.println("Ilość: " + product.getQuantity());
        } else {
            System.out.println("Produkt o podanym ID nie istnieje.");
        }
    }
}
