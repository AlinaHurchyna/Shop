package shop.services;

import shop.model.Order;
import shop.model.OrderStatus;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;


public class OrderService {
	private final List<Order> orders = new ArrayList<>();

	private  List<Order> generateOrders() {
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




	private Order getOrderById(int orderId) {
		Optional<Order> orderOptional = orders.stream()
				.filter(order -> order.getOrderId() == orderId)
				.findFirst();

		return orderOptional.orElse(null);
	}




	private void addOrder(Order order) {
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

	public void changeOrderStatus(int orderId, OrderStatus newStatus) {
		Order order = getOrderById(orderId);
		if (order != null) order.setOrderStatus(newStatus);
	}

	public void setOrderById(int orderById) {
	}
}











