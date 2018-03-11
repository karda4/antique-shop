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
	
	public Product insert(Product product){
		return productDao.insert(product);
	}

	public Product findById(Long id){
		Product product = productDao.findById(id);
		product.setImage(imageService.getImage(product));
		product.setCategory(categoryService.getCategory(product));
		return product;
	}
	
	public List<Product> findAll(){
		List<Product> products = productDao.findAll();
		products.forEach(product -> product.setImage(imageService.getImage(product)));
		products.forEach(product -> product.setCategory(categoryService.getCategory(product)));
		return products;
	}

	public void update(Product product){
		productDao.update(product);
	}

	public void delete(Product product){
		productDao.delete(product);
	}
	
	
}
