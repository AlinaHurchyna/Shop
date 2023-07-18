package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    private List<Order> orders;

    public OrderService() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        // Dodaj walidację zamówienia
        orders.add(order);
    }

    public void removeOrder(int orderId) {
        // Znajdź zamówienie po ID i usuń je z listy
        Order orderToRemove = null;
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                orderToRemove = order;
                break;
            }
        }
        if (orderToRemove != null) {
            orders.remove(orderToRemove);
        }
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order getOrderById(int orderId) {
        // Znajdź zamówienie po ID
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    // Inne metody dotyczące zarządzania zamówieniami

    public void displayAllOrders() {
        System.out.println("Lista zamówień:");
        for (Order order : orders) {
            System.out.println("ID: " + order.getOrderId() + ", Numer zamówienia: " + order.getOrderNumber());
        }
    }

    public void displayOrderDetails(int orderId) {
        Order order = getOrderById(orderId);
        if (order != null) {
            System.out.println("Szczegóły zamówienia:");
            System.out.println("ID: " + order.getOrderId());
            System.out.println("Numer zamówienia: " + order.getOrderNumber());
            System.out.println("Suma zamówienia: " + order.getOrderSum());
            System.out.println("Imię klienta: " + order.getClientName());
            System.out.println("Nazwisko klienta: " + order.getClientSurname());
            System.out.println("Adres klienta: " + order.getClientAddress());
            System.out.println("Status zamówienia: " + order.getOrderStatus());
        } else {
            System.out.println("Zamówienie o podanym ID nie istnieje.");
        }
    }

    public void displayOrderStatus(int orderId) {
        Order order = getOrderById(orderId);
        if (order != null) {
            System.out.println("Status zamówienia:");
            System.out.println("ID: " + order.getOrderId());
            System.out.println("Numer zamówienia: " + order.getOrderNumber());
            System.out.println("Status zamówienia: " + order.getOrderStatus());
        } else {
            System.out.println("Zamówienie o podanym ID nie istnieje.");
        }
    }

    public void changeOrderStatus(int orderId, OrderStatus newStatus) {
        Order order = getOrderById(orderId);
        if (order != null) {
            order.setOrderStatus(newStatus);
            System.out.println("Zmieniono status zamówienia o ID " + orderId + " na " + newStatus);
        } else {
            System.out.println("Zamówienie o podanym ID nie istnieje.");
        }
    }
}