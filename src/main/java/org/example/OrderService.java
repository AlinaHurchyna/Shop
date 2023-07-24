package org.example;

import java.util.*;

public class OrderService {

    static Scanner scanner = new Scanner(System.in);
    public static final List<Order> orders = generateOrders();

    public static List<Order> generateOrders() {
        List<Order> orderList = new ArrayList<>();

        Order order1 = new Order("Jan", "Kowalski", "Nowa 1");
        Order order2 = new Order("Anna", "Nowak", "Wyzwolenia 12");
        Order order3 = new Order("Piotr", "Wilewski", "Ratuszowy 8");
        Order order4 = new Order("Alicja", "Wilk", "Kamienna 3");
        Order order5 = new Order("Krzysztof", "Adamczyk", "Ogrodowa 9");

        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);
        orderList.add(order5);

        return orderList;
    }

    public static Order getOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public static void printAllOrders() {
        System.out.println("Lista zamówień:");
        for (Order order : orders) {
            System.out.println("ID: " + order.getOrderId()
                    + ", Numer zamówienia: " + order.getOrderNumber());
        }
    }

    public static void displayOrderDetails() {
        System.out.println("Podaj Id zamówienia: ");

        int orderId = scanner.nextInt();

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

    public static void displayOrderStatus() {
        System.out.print("Podaj Id zamówienia: ");

        int orderId = scanner.nextInt();

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

    public static void addOrder() {
        System.out.println("Dodawanie zamówienia: ");
        System.out.println();

        System.out.print("Podaj imię: ");
        String name = scanner.nextLine();

        System.out.print("Podaj nazwisko: ");
        String surname = scanner.nextLine();

        System.out.print("Podaj adres: ");
        String address = scanner.nextLine();

        Order newOrder = new Order(name, surname, address);
        orders.add(newOrder);

        System.out.println("Zamówienie zostało dodane.");
    }

    public static void deleteOrder() {
        System.out.print("Podaj Id zamówienia, które chcesz usunąć: ");
        int orderId = scanner.nextInt();

        boolean removed = false;
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            if (order.getOrderId() == orderId) {
                orders.remove(i);
                removed = true;
                System.out.println("Zamówienie zostało usunięte.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Nie znaleziono zamówienia o podanym ID.");
        }
    }

    public static void changeOrderStatus() {
        System.out.print("Wprowadź nowy status: ");
        int orderId = scanner.nextInt();
        String newStatus = scanner.nextLine();

        Order order = getOrderById(orderId);
        if (order != null) {
            order.setOrderStatus(OrderStatus.valueOf(newStatus));
            System.out.println("Zmieniono status zamówienia o ID "
                    + orderId + " na " + newStatus);
        } else {
            System.out.println("Zamówienie o podanym ID nie istnieje.");
        }
    }
}