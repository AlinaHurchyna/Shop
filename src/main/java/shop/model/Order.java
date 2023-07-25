package shop.model;

import shop.services.OrderStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Order {
    private int orderId;
    private static int newOrderId = 1;
    private String orderNumber;
    private double orderSum;
    private String clientName;
    private String clientSurname;
    private String clientAddress;
    private OrderStatus orderStatus;
    private Map<Product, Integer> products;

    public Order(String clientName, String clientSurname, String clientAddress, double orderSum) {
        this.orderId = newOrderId++;
        this.orderNumber = generateOrderNumber();
        this.clientName = validateName(clientName);
        this.clientSurname = validateName(clientSurname);
        this.setClientAddress(clientAddress);
        this.setOrderSum(orderSum);
        this.orderStatus = OrderStatus.CREATED;
        this.products = new HashMap<>();
    }

    private String generateOrderNumber() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 1; i <= 8; i++) {
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

    public void setClientAddress(String clientAddress) {
        if (clientAddress == null || clientAddress.isBlank()) {
            throw new IllegalArgumentException("Address must not be null or empty.");
        }
        if (clientAddress.length() < 1 || clientAddress.length() > 50) {
            throw new IllegalArgumentException("Address length must be between 1 and 50 characters.");
        }
        this.clientAddress = clientAddress;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
