package ua.kardach.antiqueshop.dao;

import java.util.List;

import ua.kardach.antiqueshop.model.OrderLine;

/**
 * @author Yura Kardach
 */
public interface OrderLineDao extends AbstractDao<OrderLine, Long>{

	public List<OrderLine> getOrderLinesByOrderId(long orderId);

}
