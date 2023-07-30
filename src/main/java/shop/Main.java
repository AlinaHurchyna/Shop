package shop;
import shop.services.OrderService;

public class Main {
	public  void main(String[] args) {
		OrderService orderService = new OrderService();
		orderService.printAllOrders();
		orderService.printOrderDetails();
		orderService.printOrderStatus();
		orderService.addOrder();
		orderService.deleteOrder();
		orderService.changeOrderStatus();
	}
}
