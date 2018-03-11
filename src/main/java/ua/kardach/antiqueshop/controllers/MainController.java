package ua.kardach.antiqueshop.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.kardach.antiqueshop.model.Product;
import ua.kardach.antiqueshop.service.ProductService;


/**
 * @author Yura Kardach
 */
@RestController
public class MainController {

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public List<Product> showMainPage(HttpSession session, Model model) {
		List<Product> products = productService.findAll();

		return products;
	}
}
