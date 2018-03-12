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
	
	public Product insert(Product product){
		return productDao.insert(product);
	}

	public Product findById(Long id){
		return productDao.findById(id);
	}
	
	public List<Product> findAll(){
		return productDao.findAll();
	}

	public void update(Product product){
		productDao.update(product);
	}

	public void delete(Product product){
		productDao.delete(product);
	}
	
	
}
