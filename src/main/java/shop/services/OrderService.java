package shop.services;

import shop.model.Order;
import shop.model.OrderStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class OrderService {
	final Scanner scanner = new Scanner(System.in);
	private List<Order> orders;
	public final List<Order> categories;
	private String status;

	public OrderService(List<Order> orders, List<Order> categories) {
		this.orders = orders;
		this.categories = categories;
	}

	public List<Order> generateOrders() {
		List<Order> orderList = new ArrayList<>();
		Order order1 = new Order("Jan", "Kowalski", "Nowa 1", 1222.9);
		Order order2 = new Order("Anna", "Nowak", "Wyzwolenia 12", 999.9);
		Order order3 = new Order("Piotr", "Wilewski", "Ratuszowy 8", 838);
		Order order4 = new Order("Alicja", "Wilk", "Kamienna 3", 342);
		Order order5 = new Order("Krzysztof", "Adamczyk", "Ogrodowa 9", 4543);
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		orders.add(order4);
		orders.add(order5);
		return orderList;
	}

	public void isValidOrderStatus(String status) {
		this.status = status;
		for (OrderStatus validStatus : OrderStatus.values()) {
			if (validStatus.name().equalsIgnoreCase(status)) {
				return;
			}
		}
	}

	public void printSpecificCategory() { System.out.println("Podaj nazwę kategorii, którą chcesz wyświetlić: ");
		String categoryName = scanner.nextLine();


		System.out.println("Zamówienia w kategorii \"" + categoryName + "\":");
		for (Order order : orders) {
			if (order.getOrderNumber().equalsIgnoreCase(categoryName)) {
				System.out.println("ID: " + order.getOrderId() + ", Numer zamówienia: " + order.getOrderNumber());

			}
		}

	}

	public void printAllCategory() {
		System.out.println("Lista wszystkich kategorii:");

		for (Order category : categories) {
			System.out.println(category.getClass());
		}

	}

	public void getOrderById() {
		for (Order order : orders) {
			int orderId;
			orderId = 0;
			if (order.getOrderId() == orderId) {
				break;
			}
		}
	}
}










