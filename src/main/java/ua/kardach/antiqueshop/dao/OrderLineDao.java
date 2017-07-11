package ua.kardach.antiqueshop.dao;

import java.util.List;

import ua.kardach.antiqueshop.model.OrderLine;

public interface OrderLineDao {

	// create
	public boolean addOrderLine(OrderLine orderLine);

	// read
	public OrderLine getOrderLineById(long id);
	public List<OrderLine> getOrderLinesByOrderId(long orderId);

	// update
	public boolean updateOrderLine(OrderLine orderLine);

	// delete
	public boolean deleteOrderLine(OrderLine orderLine);
}
