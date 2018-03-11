package ua.kardach.antiqueshop.dao;

import java.util.List;

public interface AbstractDao <Model, ID>{

	//create
	public Model insert(Model model);
	//read
	public List<Model> findAll();
	public Model findById(ID id);
	//update
	public void update(Model model);
	//delete
	public void delete(Model model);
	
}
