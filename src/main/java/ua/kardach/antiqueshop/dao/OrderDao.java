package ua.kardach.antiqueshop.dao;

import ua.kardach.antiqueshop.model.Order;

/**
 * @author Yura Kardach
 */
public interface OrderDao extends AbstractDao<Order, Long> {

	public Order getOrderByUserId(long userId);
	
}
