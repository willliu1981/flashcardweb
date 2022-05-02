package idv.psi.service;

import idv.psi.model.Order;

public class Client {
	private Order[] orders = new Order[100];
	private int orderPointer = 0;

	public void addOrder(Order order) {
		orders[this.orderPointer] = order;

	}
	
	

}
