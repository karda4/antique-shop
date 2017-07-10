package ua.kardach.antiqueshop.dao;

import ua.kardach.antiqueshop.model.User;

public interface UserDao {

	//create
	User addUser(User user);
	//read
	User getUserByName(String name);
	//update
	boolean updateUser(User user);
	//delete
	boolean deleteUser(User user);
}
