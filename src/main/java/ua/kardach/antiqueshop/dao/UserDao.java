package ua.kardach.antiqueshop.dao;

import ua.kardach.antiqueshop.model.User;

/**
 * @author Yura Kardach
 */
public interface UserDao {

	// create
	public boolean addUser(User user);

	// read
	public User getUserByName(String name);

	// update
	public boolean updateUser(User user);

	// delete
	public boolean deleteUser(User user);
}
