package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Order {
    private int orderId;
    private String orderNumber;
    private double orderSum;
    private String clientName;
    private String clientSurname;
    private String clientAddress;
    private OrderStatus orderStatus;
    private Map<Product, Integer> products;

    public Order(String clientName, String clientSurname, String clientAddress) {
        this.orderId = generateOrderId();
        this.orderNumber = generateOrderNumber();
        this.clientName = validateName(clientName);
        this.clientSurname = validateName(clientSurname);
        this.clientAddress = validateAddress(clientAddress);
        this.orderStatus = OrderStatus.CREATED;
        this.products = new HashMap<>();
    }

    private int generateOrderId() {

        Random random = new Random();
        return random.nextInt(1000); // Przykładowa implementacja - wygenerowanie losowej liczby do celów demonstracyjnych
    }

    private String generateOrderNumber() {
        // Implementacja generowania unikalnego numeru zamówienia
        // Można wykorzystać różne metody generacji, na przykład UUID, algorytmy hashujące itp.
        // W tym przypadku wygenerujmy losowy ciąg 8 znaków
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    private String validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be null or empty.");
        }
        if (name.length() < 1 || name.length() > 50) {
            throw new IllegalArgumentException("Name length must be between 1 and 50 characters.");
        }
        if (!name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Name must contain only characters.");
        }
        return name;
    }

    private String validateAddress(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address must not be null or empty.");
        }
        if (address.length() < 1 || address.length() > 50) {
            throw new IllegalArgumentException("Address length must be between 1 and 50 characters.");
        }
        return address;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public double getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(double orderSum) {
        if (orderSum <= 0) {
            throw new IllegalArgumentException("Order sum must be greater than 0.");
        }
        this.orderSum = orderSum;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0.");
        }
        products.put(product, quantity);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void displayOrderProducts() {
        System.out.println("Order Products:");
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("Product: " + product.getName() + ", Quantity: " + quantity);
        }
    }
}
