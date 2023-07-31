package shop.services;

import shop.model.Order;
import shop.model.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
	private final List<Order> orders = new ArrayList<>();

	public List<Order> generateOrders() {
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
		return orders;
	}

	public Order getOrderById(int orderId) {
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

	public void addOrder(Order order) {
		orders.add(order);
	}

	public void deleteOrder(int orderId) {
		Order orderToDelete = getOrderById(orderId);
		if (orderToDelete != null) {
			orders.remove(orderToDelete);
		}
	}

	public List<Order> getAllOrders() {
		return orders;
	}

	public OrderStatus getOrderStatus(int orderId) {
		Order order = getOrderById(orderId);
		return order != null ? order.getOrderStatus() : null;
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










