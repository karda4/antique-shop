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
	@Autowired
	private ProductService productService;
	
	public OrderLine insert(OrderLine orderLine){
		return orderLineDao.insert(orderLine);
	}
	
	public OrderLine addOrderLine(Product product, int amount){
		OrderLine orderLine = createOrderLine(product, amount);
		return insert(orderLine);
	}
	
	private OrderLine createOrderLine(Product product, int amount){
		OrderLine orderLine = new OrderLine();
		orderLine.setProduct(product);
		orderLine.setAmount(amount);
		return orderLine;
	}

	public OrderLine findById(long id){
		OrderLine orderLine = orderLineDao.findById(id);
		setProductFor(orderLine);
		return orderLine;
	}
	
	public List<OrderLine> getOrderLines(Order order){
		List<OrderLine> orderLines = orderLineDao.getOrderLinesByOrderId(order.getId());
		for(OrderLine orderLine : orderLines){
			setProductFor(orderLine);
		}
		return orderLines;
	}

	public void update(OrderLine orderLine){
		orderLineDao.update(orderLine);
	}

	public void delete(Order order, OrderLine orderLine){		
		orderLineDao.delete(orderLine);
	}
	
	private void setProductFor(OrderLine orderLine){
		orderLine.setProduct(productService.findById(orderLine.getProduct().getId()));
	}
}
