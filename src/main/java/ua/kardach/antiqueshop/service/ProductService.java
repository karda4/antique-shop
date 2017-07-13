package ua.kardach.antiqueshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kardach.antiqueshop.dao.ProductDao;
import ua.kardach.antiqueshop.model.Product;

/**
 * @author Yura Kardach
 */
@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private ImageService imageService;
	@Autowired
	private CategoryService categoryService;
	
	public Product addProduct(Product product){
		return productDao.addProduct(product);
	}

	public Product getProductById(long id){
		Product product = productDao.getProductById(id);
		product.setImage(imageService.getImage(product));
		product.setCategory(categoryService.getCategory(product));
		return product;
	}
	
	public List<Product> getAllProducts(){
		List<Product> products = productDao.getAllProducts();
		products.forEach(product -> product.setImage(imageService.getImage(product)));
		products.forEach(product -> product.setCategory(categoryService.getCategory(product)));
		return products;
	}

	public boolean updateProduct(Product product){
		return productDao.updateProduct(product);
	}

	public boolean deleteProduct(Product product){
		return productDao.deleteProduct(product);
	}
	
	
}
