package shop.services;


import shop.model.Order;
import shop.model.OrderStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {
	private static List<Order> orders;
	private static Scanner scanner;

	public OrderService() {
		orders = generateOrders();
		scanner = new Scanner(System.in);
	}

	public List<Order> generateOrders() {
		List<Order> orderList = new ArrayList<>();
		Order order1 = new Order("Jan", "Kowalski", "Nowa 1", 1222.9);
		Order order2 = new Order("Anna", "Nowak", "Wyzwolenia 12", 999.9);
		Order order3 = new Order("Piotr", "Wilewski", "Ratuszowy 8", 838);
		Order order4 = new Order("Alicja", "Wilk", "Kamienna 3", 342);
		Order order5 = new Order("Krzysztof", "Adamczyk", "Ogrodowa 9", 4543);

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

	public static void printOrderDetails() {
		System.out.println("Podaj Id zamówienia: ");
		int orderId = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character left by nextInt()
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

	public static void printOrderStatus() {
		System.out.print("Podaj Id zamówienia: ");
		int orderId = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character left by nextInt()
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
		String firstName = scanner.nextLine();
		System.out.print("Podaj nazwisko: ");
		String lastName = scanner.nextLine();
		System.out.print("Podaj adres: ");
		String address = scanner.nextLine();
		System.out.print("Podaj sumę zamówienia: ");
		double orderSum = scanner.nextDouble();
		scanner.nextLine(); // Consume the newline character left by nextDouble()

		Order newOrder = new Order(firstName, lastName, address, orderSum);
		orders.add(newOrder);
		System.out.println("Zamówienie zostało dodane.");
	}

	public void deleteOrder() {
		System.out.print("Podaj Id zamówienia, które chcesz usunąć: ");
		int orderId = scanner.nextInt();
		boolean deleted = false;
		for (int i = 0; i < orders.size(); i++) {
			Order order = orders.get(i);
			if (order.getOrderId() == orderId) {
				orders.remove(i);
				deleted = true;
				System.out.println("Zamówienie zostało usunięte.");
				break;
			}
		}
		if (!deleted) {
			System.out.println("Nie znaleziono zamówienia o podanym ID.");
		}
	}

	public static void changeOrderStatus() {
		System.out.print("Podaj ID zamówienia, dla którego chcesz zmienić status: ");
		int orderId = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character left by nextInt()
		Order order = getOrderById(orderId);
		if (order != null) {
			System.out.print("Wprowadź nowy status: ");
			String newStatus = scanner.nextLine();
			order.setOrderStatus(OrderStatus.valueOf(newStatus));
			System.out.println("Zmieniono status zamówienia o ID " + orderId + " na " + newStatus);
		} else {
			System.out.println("Zamówienie o podanym ID nie istnieje.");
		}
	}
}
