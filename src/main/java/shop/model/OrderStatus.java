package shop.model;

public enum OrderStatus {
	CREATED,
	PAID,
	CANCELLED,
	SHIPPED,
	PROCESSING
	@Override
	public String toString() {
		switch (this) {
			case PAID:
				return "Opłacone";
			case CANCELLED:
				return "Anulowane";
			case SHIPPED:
				return "Wysłane";
			case PROCESSING:
				return "W przygotowaniu";
			default:
				return "Nieznany status";
		}
	}
}
