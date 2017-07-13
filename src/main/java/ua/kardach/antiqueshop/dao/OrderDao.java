package ua.kardach.antiqueshop.dao;

import ua.kardach.antiqueshop.model.Order;

public interface OrderDao {

	// create
	public boolean addOrder(Order order);

	// read
	public Order getOrderById(long orderId);
	public Order getOrderByUserId(long userId);

	// update
	public boolean updateOrder(Order order);

	// delete
	public boolean deleteOrder(Order order);

	
}
