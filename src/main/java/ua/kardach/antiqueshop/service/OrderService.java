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
	
	public Order insert(Order order){
		if(order == null) {
			return null;
		}
		if(order.getOrderLines() != null){
			for(OrderLine orderLine : order.getOrderLines()){
				orderLineService.insert(orderLine);
			}
		}
		return orderDao.insert(order);
	}
	
	public Order addOrder(User user){
		Order order = createOrder(user);
		return insert(order);
	}
	
	private Order createOrder(User user){
		Order order = new Order();
		user.setOrder(order);
		return order;
	}

	public Order getOrderById(long orderId){
		Order order = orderDao.findById(orderId);
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

	public void update(Order order){
		orderDao.update(order);
	}

	public void delete(Order order){
		if(order == null){
			return;
		}
		for(OrderLine orderLine : order.getOrderLines()){
			orderLineService.delete(order, orderLine);
		}
		orderDao.delete(order);
	}

	public Order cloneOrder(Order order){
		return new Order(order);
	}
}
