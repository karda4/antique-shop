package ua.kardach.antiqueshop.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.kardach.antiqueshop.model.Order;
import ua.kardach.antiqueshop.model.Product;
import ua.kardach.antiqueshop.service.OrderLineService;
import ua.kardach.antiqueshop.service.ProductService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderLineService orderLineService;
	@Autowired
	private ProductService productService;

	@RequestMapping(value="/order/{productId}/{amount}", method=RequestMethod.POST)
	public String addOrderLineToOrder(@PathVariable long productId, @PathVariable int amount, HttpSession session, Model model){
		Product product = productService.getProductById(productId);
		Order order = (Order) session.getAttribute("order");
		orderLineService.addOrderLine(order, product, amount);
		return "redirect:/main";
	}
	
	@RequestMapping(value="/order/{productId}", method=RequestMethod.POST)
	public String addOrderLineToOrder(@PathVariable long productId, HttpSession session, Model model){
		int amount = 1;
		return addOrderLineToOrder(productId, amount, session, model);
	}
		
	@RequestMapping("/order")
	public String showOrderPage(){
		return "order";
	}
}
