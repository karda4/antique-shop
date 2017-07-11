package ua.kardach.antiqueshop.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.kardach.antiqueshop.model.Product;
import ua.kardach.antiqueshop.service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	private ProductService productService; 

	@RequestMapping("/")
	public String redirectToMainPage() {
		return "redirect:/main";
	}

	@RequestMapping("/main")
	public String showMainPage(HttpSession session, Model model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		
		return "main";
	}
}
