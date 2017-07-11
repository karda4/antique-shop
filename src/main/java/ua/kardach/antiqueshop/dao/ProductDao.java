package ua.kardach.antiqueshop.dao;

import java.util.List;

import ua.kardach.antiqueshop.model.Product;

public interface ProductDao {

	// create
	public Product addProduct(Product product);

	// read
	public Product getProductById(long id);
	public List<Product> getAllProducts();

	// update
	public boolean updateProduct(Product product);

	// delete
	public boolean deleteProduct(Product product);
}
