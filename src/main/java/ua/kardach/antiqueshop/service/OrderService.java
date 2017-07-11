package ua.kardach.antiqueshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kardach.antiqueshop.dao.OrderDao;
import ua.kardach.antiqueshop.model.Order;
import ua.kardach.antiqueshop.model.User;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderLineService orderLineService;
	
	public boolean saveOrder(Order order){
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
		order.setUser(user);
		return order;
	}

	public Order getOrderById(long id){
		Order order = orderDao.getOrderById(id);
		order.setOrderLines(orderLineService.getOrderLines(order));
		return order;
	}

	public boolean updateOrder(Order order){
		return orderDao.updateOrder(order);
	}

	public boolean deleteOrder(Order order){
		return orderDao.deleteOrder(order);
	}
}
