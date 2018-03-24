package ua.kardach.antiqueshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kardach.antiqueshop.model.Product;
import ua.kardach.antiqueshop.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> result = productService.findAll();
		return ResponseEntity.ok(result);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Product result = productService.findById(id);
		return ResponseEntity.ok(result);
	}
}
