package ua.kardach.antiqueshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kardach.antiqueshop.dao.CategoryDao;
import ua.kardach.antiqueshop.model.Category;
import ua.kardach.antiqueshop.model.Product;

/**
 * @author Yura Kardach
 */
@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public Category insert(Category category){
		return categoryDao.insert(category);
	}

	public Category findById(long id){
		return categoryDao.findById(id);
	}
	
	public Category getCategory(Product product){
		return categoryDao.findById(product.getCategory().getId());
	}

	public void update(Category category){
		categoryDao.update(category);
	}

	public void delete(Category category){
		categoryDao.delete(category);
	}
}
