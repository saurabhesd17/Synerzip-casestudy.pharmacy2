package com.example.services;

import java.util.List;

import com.example.entities.Order;

public interface OrderService {
	/**
	 * @return number of rows affected by default order status will be PENDING you
	 *         have to manually complete the order you can go to option 3->3 to
	 *         complete the order specify the id of order in Test file option 3->3
	 */
	public int makeOrder(Order order);

	/**
	 * @return list of all pending orders
	 */
	public List<Order> pendingOrders();

	/**
	 * @param status sets the status as COMPLETE in order table accepts id of order
	 */
	public int completeOrder(int id);
}
