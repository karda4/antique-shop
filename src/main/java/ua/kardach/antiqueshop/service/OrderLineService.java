package ua.kardach.antiqueshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kardach.antiqueshop.dao.OrderLineDao;
import ua.kardach.antiqueshop.model.Order;
import ua.kardach.antiqueshop.model.OrderLine;
import ua.kardach.antiqueshop.model.Product;

/**
 * @author Yura Kardach
 */
@Service
public class OrderLineService {

	@Autowired
	private OrderLineDao orderLineDao;
	
	public boolean saveOrderLine(OrderLine orderLine){
		return orderLineDao.addOrderLine(orderLine);
	}
	
	public boolean addOrderLine(Order order, Product product, int amount){
		if(order == null) return false;
		OrderLine orderLine = createOrderLine(order, product, amount);
		if(saveOrderLine(orderLine)){
			order.addOrderLine(orderLine);
			return true;
		}
		return false;
	}
	
	private OrderLine createOrderLine(Order order, Product product, int amount){
		OrderLine orderLine = new OrderLine();
		orderLine.setOrder(order);
		orderLine.setProduct(product);
		orderLine.setAmount(amount);
		return orderLine;
	}

	public OrderLine getOrderLineById(long id){
		return orderLineDao.getOrderLineById(id);
	}
	
	public List<OrderLine> getOrderLines(Order order){
		return orderLineDao.getOrderLinesByOrderId(order.getId());
	}

	public boolean updateOrderLine(OrderLine orderLine){
		return orderLineDao.updateOrderLine(orderLine);
	}

	public boolean deleteOrderLine(Order order, OrderLine orderLine){		
		if(orderLineDao.deleteOrderLine(orderLine)){
			order.removeOrderLine(orderLine);
			return true;
		}
		return false;
	}
}
