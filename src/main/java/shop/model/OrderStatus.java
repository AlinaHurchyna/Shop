package shop.model;

public enum OrderStatus {
	CREATED,
	PAID,
	CANCELLED,
	SHIPPED,
	PROCESSING;
	private boolean isValidOrderStatus(String status) {
		for (OrderStatus validStatus : OrderStatus.values()) {
			if (validStatus.name().equalsIgnoreCase(status)) {
				return true;
			}
		}
		return false;
	}
}
