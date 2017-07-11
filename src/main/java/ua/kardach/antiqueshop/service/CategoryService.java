package ua.kardach.antiqueshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kardach.antiqueshop.dao.CategoryDao;
import ua.kardach.antiqueshop.model.Category;
import ua.kardach.antiqueshop.model.Product;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public Category addCategory(Category category){
		return categoryDao.addCategory(category);
	}

	public Category getCategoryById(long id){
		return categoryDao.getCategoryById(id);
	}
	
	public Category getCategory(Product product){
		return categoryDao.getCategoryById(product.getCategoryId());
	}

	public boolean updateCategory(Category category){
		return categoryDao.updateCategory(category);
	}

	public boolean deleteCategory(Category category){
		return categoryDao.deleteCategory(category);
	}
}
