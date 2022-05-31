package br.com.foursys.fourcamp.fourstore.enums;

public enum OrderStatus {
	WAITING_PAYMENT(11 , "Esperando Pagamento"), 
	PAID(22 , "Pago"), 
	SHIPPED(33, "Enviado"), 
	DELIVERED(44, "Entregue"), 
	CANCELED(55, "Cancelado");


	private int key;
	private String description;
	
	OrderStatus(int key, String description) {
		this.key = key;
		this.description = description;
	}
	
	public int getKey() {
		return key;
	}

	public String getDescription() {
		return description;
	}
	
	public static OrderStatus valueOf(int key) {
		for (OrderStatus value  : OrderStatus.values()) {
			if(value.getKey() == key) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid order status code");
	}

}
