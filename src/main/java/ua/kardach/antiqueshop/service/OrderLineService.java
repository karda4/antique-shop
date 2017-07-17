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
	
	public boolean saveOrderLine(OrderLine orderLine){
		return orderLineDao.addOrderLine(orderLine);
	}
	
	public OrderLine addOrderLine(Product product, int amount){
		OrderLine orderLine = createOrderLine(product, amount);
		if(saveOrderLine(orderLine)){
			return orderLine;
		}
		return null;
	}
	
	private OrderLine createOrderLine(Product product, int amount){
		OrderLine orderLine = new OrderLine();
		orderLine.setProduct(product);
		orderLine.setAmount(amount);
		return orderLine;
	}

	public OrderLine getOrderLineById(long id){
		OrderLine orderLine = orderLineDao.getOrderLineById(id);
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

	public boolean updateOrderLine(OrderLine orderLine){
		return orderLineDao.updateOrderLine(orderLine);
	}

	public boolean deleteOrderLine(Order order, OrderLine orderLine){		
		return orderLineDao.deleteOrderLine(orderLine);
	}
	
	private void setProductFor(OrderLine orderLine){
		orderLine.setProduct(productService.getProductById(orderLine.getProductId()));
	}
}
