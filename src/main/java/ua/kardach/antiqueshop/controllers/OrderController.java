package ua.kardach.antiqueshop.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.kardach.antiqueshop.model.Order;
import ua.kardach.antiqueshop.model.OrderLine;
import ua.kardach.antiqueshop.model.Product;
import ua.kardach.antiqueshop.model.User;
import ua.kardach.antiqueshop.service.OrderLineService;
import ua.kardach.antiqueshop.service.ProductService;
import ua.kardach.antiqueshop.service.UserService;

/**
 * @author Yura Kardach
 */
@Controller
public class OrderController {
	
	@Autowired
	private OrderLineService orderLineService;
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;

	@RequestMapping(value="/order/{productId}/{amount}", method=RequestMethod.POST)
	public String addOrderLineToOrder(@PathVariable long productId, @PathVariable int amount, HttpSession session){
		Product product = productService.findById(productId);
		
		userService.createIfNotExistSessionUser(session);
		User user = (User) session.getAttribute("user");
		OrderLine orderLine = orderLineService.addOrderLine(product, amount);
		user.getOrder().addOrderLine(orderLine);
		return "redirect:/main";
	}
	
	@RequestMapping(value="/order/{productId}", method=RequestMethod.POST)
	public String addOrderLineToOrder(@PathVariable long productId, HttpSession session){
		int amount = 1;
		return addOrderLineToOrder(productId, amount, session);
	}
	
	@RequestMapping(value="/cart", method=RequestMethod.GET)
	public String showOrderPage(){
		return "cart";
	}
	
	@RequestMapping(value="/order/{orderLineId}/delete", method=RequestMethod.GET)
	public String deleteOrderLineFromOrder(@PathVariable long orderLineId, HttpSession session){
		OrderLine orderLine = orderLineService.findById(orderLineId);
		User user = (User) session.getAttribute("user");
		orderLineService.delete(user.getOrder(), orderLine);
		return "cart";
	}
	
	@RequestMapping(value="/order/buy", method=RequestMethod.GET)
	public String buyForOrder(@PathVariable long orderId, HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user.isRegistered()){
			Order order = user.getOrder();
			return "cart";
		}
		else{
			return "registration";
		}
	}
	
}
