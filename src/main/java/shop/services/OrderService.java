package shop.services;

import shop.model.Order;
import shop.model.OrderStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {
	static Scanner scanner = new Scanner(System.in);
	public static final List<Order> orders = generateOrders();

	public static List<Order> generateOrders() {
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

	private boolean isValidOrderStatus(String status) {
		for (OrderStatus validStatus : OrderStatus.values()) {
			if (validStatus.name().equalsIgnoreCase(status)) {
				return true;
			}
		}
		return false;
	}

	private void deleteCategory() {
	}

	private void addCategory() {

	}

	private void printSpecificCategory() {

	}

	private void printAllCategory() {

	}

	private static Order getOrderById() {
		return getOrderById(0);
	}


	private void showProductSubMenu() {
	}
}










