package ua.kardach.antiqueshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kardach.antiqueshop.dao.OrderDao;
import ua.kardach.antiqueshop.model.Order;
import ua.kardach.antiqueshop.model.OrderLine;
import ua.kardach.antiqueshop.model.User;

/**
 * @author Yura Kardach
 */
@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderLineService orderLineService;
	
	public boolean saveOrder(Order order){
		if(order == null) return false;
		if(order.getOrderLines() != null){
			for(OrderLine orderLine : order.getOrderLines()){
				orderLineService.saveOrderLine(orderLine);
			}
		}
		return orderDao.addOrder(order);
	}
	
	public Order addOrder(User user){
		Order order = createOrder(user);
		if(saveOrder(order)){
			return order;
		}
		return null;
	}
	
	private Order createOrder(User user){
		Order order = new Order();
		user.setOrder(order);
		return order;
	}

	public Order getOrderById(long orderId){
		Order order = orderDao.getOrderById(orderId);
		order.setOrderLines(orderLineService.getOrderLines(order));
		return order;
	}
	
	public Order getOrderByUserId(long userId) {
		Order order = orderDao.getOrderByUserId(userId);
		if(order != null){
			order.setOrderLines(orderLineService.getOrderLines(order));
		}
		return order;
	}

	public boolean updateOrder(Order order){
		return orderDao.updateOrder(order);
	}

	public boolean deleteOrder(Order order){
		if(order == null){
			return false;
		}
		//order.getOrderLines().forEach(line -> orderLineService.deleteOrderLine(order, line));
		for(OrderLine orderLine : order.getOrderLines()){
			orderLineService.deleteOrderLine(order, orderLine);
		}
		return orderDao.deleteOrder(order);
	}

	public Order cloneOrder(Order order){
		return new Order(order);
	}
}
