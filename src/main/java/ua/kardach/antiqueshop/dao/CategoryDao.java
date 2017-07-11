package ua.kardach.antiqueshop.dao;

import ua.kardach.antiqueshop.model.Category;

public interface CategoryDao {

	//create
	public Category addCategory(Category category);
	//read
	public Category getCategoryById(long id);
	//update
	public boolean updateCategory(Category category);
	//delete
	public boolean deleteCategory(Category category);
}
